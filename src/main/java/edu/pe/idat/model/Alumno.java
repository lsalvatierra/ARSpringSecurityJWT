package edu.pe.idat.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alumno {
	
	@Id
	private String idalumno;
	private String nomalumno;
	private String apealumno;

	public String getIdalumno() {
		return idalumno;
	}
	public void setIdalumno(String idalumno) {
		this.idalumno = idalumno;
	}
	public String getNomalumno() {
		return nomalumno;
	}
	public void setNomalumno(String nomalumno) {
		this.nomalumno = nomalumno;
	}
	public String getApealumno() {
		return apealumno;
	}
	public void setApealumno(String apealumno) {
		this.apealumno = apealumno;
	}

}
