package ar.edu.unju.edm.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity

public class RegistroTracking implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 811119566591507661L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;
	@OneToMany (mappedBy = "registro")
	List<ValidarCondicionSanitaria> validadores;
	@Column 
	@DateTimeFormat(pattern="dd/MM/yyyy")
	LocalDateTime fechaHora;
	@ManyToOne 
	@JoinColumn (name = "idlocalidad")
	Barrio localidad;
	@Column
	String detalleLugarRegistro;
	
	//@OneToMany(mappedBy = "registro")
	//private List<ValidarCondicionSanitaria> registrostracking = new ArrayList<RegistroTracking>();
	
	public RegistroTracking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegistroTracking(Long id, LocalDateTime fechaHora, Barrio localidad, List<ValidarCondicionSanitaria> validadores,
			String detalleLugarRegistro) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.localidad = localidad;
		this.validadores = validadores;
		this.detalleLugarRegistro = detalleLugarRegistro;
	}
	@Override
	public String toString() {
		return "RegistroTraking [fechaHora=" + fechaHora + ", localidad=" + localidad + ", validadores=" + validadores
				+ ", detalleLugarRegistro=" + detalleLugarRegistro + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detalleLugarRegistro == null) ? 0 : detalleLugarRegistro.hashCode());
		result = prime * result + ((fechaHora == null) ? 0 : fechaHora.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((validadores == null) ? 0 : validadores.hashCode());
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
		RegistroTracking other = (RegistroTracking) obj;
		if (detalleLugarRegistro == null) {
			if (other.detalleLugarRegistro != null)
				return false;
		} else if (!detalleLugarRegistro.equals(other.detalleLugarRegistro))
			return false;
		if (fechaHora == null) {
			if (other.fechaHora != null)
				return false;
		} else if (!fechaHora.equals(other.fechaHora))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (validadores == null) {
			if (other.validadores != null)
				return false;
		} else if (!validadores.equals(other.validadores))
			return false;
		return true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setValidadores(List<ValidarCondicionSanitaria> validadores) {
		this.validadores = validadores;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Barrio getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Barrio localidad) {
		this.localidad = localidad;
	}
	public List<ValidarCondicionSanitaria> getValidadores(){
		return validadores;
	}
	public String getDetalleLugarRegistro() {
		return detalleLugarRegistro;
	}
	public void setDetalleLugarRegistro(String detalleLugarRegistro) {
		this.detalleLugarRegistro = detalleLugarRegistro;
	}
	
	
}
