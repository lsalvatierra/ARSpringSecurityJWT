package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.pe.idat.model.AlumnoCursoNota;

public interface AlumnoCursoNotaRepository extends CrudRepository<AlumnoCursoNota, String> {

	@Query(value = "{call dbo.sp_ObtenerNotasAlumno(:idalumno)}", nativeQuery = true)
	public List<AlumnoCursoNota> obtenerAlumnoCursoNota(@Param("idalumno")String idalumno);

}
