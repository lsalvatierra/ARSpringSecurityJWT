package edu.pe.idat.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.pe.idat.model.Alumno;
import edu.pe.idat.model.Usuario;
import edu.pe.idat.service.AlumnoService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {
	
    @Autowired
    AlumnoService alumnoService;


	
	@PostMapping("login")
	public Usuario login(@RequestParam("usuario") String usuario, 
			@RequestParam("password") String password) {
		
		Alumno objAlumno = alumnoService.autenticarAlumno(usuario);
		if(objAlumno != null) {
			if(password.equals("idat2021")) {
				String token = getJWTToken(usuario);
				Usuario objUsuario = new Usuario(
						objAlumno.getIdalumno(),
						objAlumno.getApealumno(),
						objAlumno.getNomalumno(),
						token);				
				
				return objUsuario;
			}
		}		
		return null;		
	}
	

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		//AuthorityUtils.commaSeparatedStringToAuthorityList 
		//Método de utilidad para manipular colecciones GrantedAuthority
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("@idatJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))			
				.setIssuedAt(new Date(System.currentTimeMillis())) //fecha de creación
				.setExpiration(new Date(System.currentTimeMillis() + 600000)) //fecha de caducación
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
		return "Bearer " + token;
	}
	
}
