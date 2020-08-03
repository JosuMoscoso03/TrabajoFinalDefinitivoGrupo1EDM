package ar.edu.unju.edm.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;


@Component
public class ConsultaAux {
	
	String documento;
	String nombre;
	String apellido;
	String localidad; 
	LocalDateTime fechayhora;
	Long  idCondicion;
	
	public ConsultaAux() {
		// TODO Auto-generated constructor stub
	}
	public Long getIdCondicion() {
		return idCondicion;
	}



	public void setIdCondicion(Long idCondicion) {
		this.idCondicion = idCondicion;
	}



	public ConsultaAux(String documento, String nombre, String apellido, String localidad, LocalDateTime fechayhora) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.localidad = localidad;
		this.fechayhora = fechayhora;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public LocalDateTime getFechayhora() {
		return fechayhora;
	}

	public void setFechayhora(LocalDateTime fechayhora) {
		this.fechayhora = fechayhora;
	}

	@Override
	public String toString() {
		return "ConsultaAux2 [documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", localidad="
				+ localidad + ", fechayhora=" + fechayhora + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((fechayhora == null) ? 0 : fechayhora.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		ConsultaAux other = (ConsultaAux) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (fechayhora == null) {
			if (other.fechayhora != null)
				return false;
		} else if (!fechayhora.equals(other.fechayhora))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
