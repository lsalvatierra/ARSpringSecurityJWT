package edu.pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.pe.idat.model.AlumnoCursoNota;
import edu.pe.idat.service.AlumnoService;


@RestController
@RequestMapping("/alumno")
public class AlumnoCursoNotaController {

    /*Para hacer la prueba en Postman:
     * En Headers agregar una key Authorization 
     * y en el body colocar el dato a enviar como parametro.
     * */
	
    @Autowired
    AlumnoService alumnoService;
	
	@PostMapping("cursonota")
	public List<AlumnoCursoNota> obtenerCursoNota(@RequestParam("idalumno") String idAlumno) {
		return alumnoService.obtenerAlumnoCursoNota(idAlumno);
	}
	
}
