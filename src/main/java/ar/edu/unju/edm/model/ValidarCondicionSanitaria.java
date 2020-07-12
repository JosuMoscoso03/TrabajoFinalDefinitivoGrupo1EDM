package ar.edu.unju.edm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
public class ValidarCondicionSanitaria implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9002047256638366756L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;
	@ManyToOne
	@JoinColumn (name = "personaId")
	Persona persona;
	@Column
	boolean usaTapaBoca;
	@Column
	boolean cumpleTerminacionDNI;
	@Column
	boolean poseePermisoCirculacion;
	@Column
	boolean estaAcompañado;
	@ManyToOne
	@JoinColumn (name = "RegistroID")
	RegistroTracking registro;
	
	public ValidarCondicionSanitaria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ValidarCondicionSanitaria(Long id, Persona persona, boolean usaTapaBoca, boolean cumpleTerminacionDNI,
			boolean poseePermisoCirculacion, boolean estaAcompañado, RegistroTracking registro) {
		super();
		this.id = id;
		this.persona = persona;
		this.usaTapaBoca = usaTapaBoca;
		this.cumpleTerminacionDNI = cumpleTerminacionDNI;
		this.poseePermisoCirculacion = poseePermisoCirculacion;
		this.estaAcompañado = estaAcompañado;
		this.registro = registro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public boolean isUsaTapaBoca() {
		return usaTapaBoca;
	}
	public void setUsaTapaBoca(boolean usaTapaBoca) {
		this.usaTapaBoca = usaTapaBoca;
	}
	public boolean isCumpleTerminacionDNI() {
		return cumpleTerminacionDNI;
	}
	public void setCumpleTerminacionDNI(boolean cumpleTerminacionDNI) {
		this.cumpleTerminacionDNI = cumpleTerminacionDNI;
	}
	public boolean isPoseePermisoCirculacion() {
		return poseePermisoCirculacion;
	}
	public void setPoseePermisoCirculacion(boolean poseePermisoCirculacion) {
		this.poseePermisoCirculacion = poseePermisoCirculacion;
	}
	public boolean isEstaAcompañado() {
		return estaAcompañado;
	}
	public void setEstaAcompañado(boolean estaAcompañado) {
		this.estaAcompañado = estaAcompañado;
	}

	@Override
	public String toString() {
		return "ValidarCondicionSanitaria [id=" + id + ", persona=" + persona + ", usaTapaBoca=" + usaTapaBoca
				+ ", cumpleTerminacionDNI=" + cumpleTerminacionDNI + ", poseePermisoCirculacion="
				+ poseePermisoCirculacion + ", estaAcompañado=" + estaAcompañado + ", registro=" + registro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (cumpleTerminacionDNI ? 1231 : 1237);
		result = prime * result + (estaAcompañado ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		result = prime * result + (poseePermisoCirculacion ? 1231 : 1237);
		result = prime * result + ((registro == null) ? 0 : registro.hashCode());
		result = prime * result + (usaTapaBoca ? 1231 : 1237);
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
		ValidarCondicionSanitaria other = (ValidarCondicionSanitaria) obj;
		if (cumpleTerminacionDNI != other.cumpleTerminacionDNI)
			return false;
		if (estaAcompañado != other.estaAcompañado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		if (poseePermisoCirculacion != other.poseePermisoCirculacion)
			return false;
		if (registro == null) {
			if (other.registro != null)
				return false;
		} else if (!registro.equals(other.registro))
			return false;
		if (usaTapaBoca != other.usaTapaBoca)
			return false;
		return true;
	}
	
}
