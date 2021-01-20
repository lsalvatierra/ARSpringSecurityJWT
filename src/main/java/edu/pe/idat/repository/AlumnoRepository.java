package edu.pe.idat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.pe.idat.model.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, String> {

	
	@Query(value = "{call dbo.sp_AutenticarAlumno(:idalumno)}", nativeQuery = true)
	public Alumno autenticarAlumno(@Param("idalumno")String idalumno);

	
}
