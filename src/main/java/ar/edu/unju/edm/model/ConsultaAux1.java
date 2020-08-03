package ar.edu.unju.edm.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component

public class ConsultaAux1 {
	
	String barrio;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	 LocalDateTime fechaDesde;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	 LocalDateTime fechaHacia; 
	String apellido;
	String documento; 
	String nombres; 
	Long id_testeos;
	
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	
	public LocalDateTime getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(LocalDateTime fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public LocalDateTime getFechaHacia() {
		return fechaHacia;
	}
	public void setFechaHacia(LocalDateTime fechaHacia) {
		this.fechaHacia = fechaHacia;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Long getId_testeos() {
		return id_testeos;
	}
	public void setId_testeos(Long id_testeos) {
		this.id_testeos = id_testeos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((barrio == null) ? 0 : barrio.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((fechaDesde == null) ? 0 : fechaDesde.hashCode());
		result = prime * result + ((fechaHacia == null) ? 0 : fechaHacia.hashCode());
		result = prime * result + ((id_testeos == null) ? 0 : id_testeos.hashCode());
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
		ConsultaAux1 other = (ConsultaAux1) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (barrio == null) {
			if (other.barrio != null)
				return false;
		} else if (!barrio.equals(other.barrio))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (fechaDesde == null) {
			if (other.fechaDesde != null)
				return false;
		} else if (!fechaDesde.equals(other.fechaDesde))
			return false;
		if (fechaHacia == null) {
			if (other.fechaHacia != null)
				return false;
		} else if (!fechaHacia.equals(other.fechaHacia))
			return false;
		if (id_testeos == null) {
			if (other.id_testeos != null)
				return false;
		} else if (!id_testeos.equals(other.id_testeos))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		return true;
	}
	public ConsultaAux1(String barrio, LocalDateTime fechaHD, LocalDateTime fechaHH, String apellido, String documento,
			String nombres, Long id_testeos) {
		super();
		this.barrio = barrio;
		this.fechaDesde = fechaHD;
		this.fechaHacia = fechaHH;
		this.apellido = apellido;
		this.documento = documento;
		this.nombres = nombres;
		this.id_testeos = id_testeos;
	}
	public ConsultaAux1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
