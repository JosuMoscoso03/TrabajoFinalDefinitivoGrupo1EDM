package ar.edu.unju.edm.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ConsultaAux1 {
	
	String barrio;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	LocalDateTime fechaHD;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	LocalDateTime fechaHH; 
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
	public LocalDateTime getFechaHD() {
		return fechaHD;
	}
	public void setFechaHD(LocalDateTime fechaHD) {
		this.fechaHD = fechaHD;
	}
	public LocalDateTime getFechaHH() {
		return fechaHH;
	}
	public void setFechaHH(LocalDateTime fechaHH) {
		this.fechaHH = fechaHH;
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
		result = prime * result + ((fechaHD == null) ? 0 : fechaHD.hashCode());
		result = prime * result + ((fechaHH == null) ? 0 : fechaHH.hashCode());
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
		if (fechaHD == null) {
			if (other.fechaHD != null)
				return false;
		} else if (!fechaHD.equals(other.fechaHD))
			return false;
		if (fechaHH == null) {
			if (other.fechaHH != null)
				return false;
		} else if (!fechaHH.equals(other.fechaHH))
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
		this.fechaHD = fechaHD;
		this.fechaHH = fechaHH;
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