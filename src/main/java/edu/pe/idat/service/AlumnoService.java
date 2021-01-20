package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Alumno;
import edu.pe.idat.model.AlumnoCursoNota;
import edu.pe.idat.repository.AlumnoCursoNotaRepository;
import edu.pe.idat.repository.AlumnoRepository;

@Service
public class AlumnoService {

	/*
	 * @Autowired= Permite resolver o inyectar objetos colaborativos a una clase.
	 * Ejemplo: Inyecta la interfaz CursoRepository a la clase 
	 * CursoService una vez que se crea.
	 * */	
 	@Autowired
 	AlumnoRepository alumnoRepository;
 	
 	@Autowired
    AlumnoCursoNotaRepository alumnoCursoNotaRepository;
	
    public Alumno autenticarAlumno(String idAlumno){
    	return alumnoRepository.autenticarAlumno(idAlumno);
    }
    
    
    public List<AlumnoCursoNota> obtenerAlumnoCursoNota(String idAlumno){
    	return alumnoCursoNotaRepository.obtenerAlumnoCursoNota(idAlumno);
    }
 	
}
