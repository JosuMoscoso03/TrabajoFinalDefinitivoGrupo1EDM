package ar.edu.unju.edm.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class ConsultaAux3  {
	String nombres;
	String apellidos;
	long id_test;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
 	LocalDate fecha;
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public long getId_test() {
		return id_test;
	}
	public void setId_test(long id_test) {
		this.id_test = id_test;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public ConsultaAux3() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConsultaAux3(String nombres, String apellidos, long id_test, LocalDate fecha) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.id_test = id_test;
		this.fecha = fecha;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (id_test ^ (id_test >>> 32));
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
		
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaAux3 other = (ConsultaAux3) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id_test != other.id_test)
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ConsultaAux3 [nombres=" + nombres + ", apellidos=" + apellidos + ", id_test=" + id_test + ", fecha="
				+ fecha + "]";
	}
	
	
}
