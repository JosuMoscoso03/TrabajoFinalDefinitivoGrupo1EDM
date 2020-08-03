package ar.edu.unju.edm.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	@Column 
	@DateTimeFormat(pattern="dd/MM/yyyy")
	LocalDateTime fechaHora;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "idbarrios")
	Barrio barrios;
	@ManyToMany (fetch = FetchType.LAZY)
	@JoinTable (name = "RegistroTracking_ValidarCondicion", 
	joinColumns = @JoinColumn(name = "IdRegistroTracking"), 
	inverseJoinColumns = @JoinColumn(name = "IdTesteos"))
	List<ValidarCondicionSanitaria> testeosDeCondSant;
	@Column
	String detalleLugarRegistro;
	
	public RegistroTracking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistroTracking(Long id, LocalDateTime fechaHora, Barrio barrios,
			List<ValidarCondicionSanitaria> testeosDeCondSant, String detalleLugarRegistro) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.barrios = barrios;
		this.testeosDeCondSant = testeosDeCondSant;
		this.detalleLugarRegistro = detalleLugarRegistro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Barrio getBarrios() {
		return barrios;
	}

	public void setBarrios(Barrio barrios) {
		this.barrios = barrios;
	}

	public List<ValidarCondicionSanitaria> getTesteosDeCondSant() {
		return testeosDeCondSant;
	}

	public void setTesteosDeCondSant(List<ValidarCondicionSanitaria> testeosDeCondSant) {
		this.testeosDeCondSant = testeosDeCondSant;
	}

	public String getDetalleLugarRegistro() {
		return detalleLugarRegistro;
	}

	public void setDetalleLugarRegistro(String detalleLugarRegistro) {
		this.detalleLugarRegistro = detalleLugarRegistro;
	}

	@Override
	public String toString() {
		return "RegistroTracking [id=" + id + ", fechaHora=" + fechaHora + ", barrios=" + barrios
				+ ", testeosDeCondSant=" + testeosDeCondSant + ", detalleLugarRegistro=" + detalleLugarRegistro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barrios == null) ? 0 : barrios.hashCode());
		result = prime * result + ((detalleLugarRegistro == null) ? 0 : detalleLugarRegistro.hashCode());
		result = prime * result + ((fechaHora == null) ? 0 : fechaHora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((testeosDeCondSant == null) ? 0 : testeosDeCondSant.hashCode());
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
		if (barrios == null) {
			if (other.barrios != null)
				return false;
		} else if (!barrios.equals(other.barrios))
			return false;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (testeosDeCondSant == null) {
			if (other.testeosDeCondSant != null)
				return false;
		} else if (!testeosDeCondSant.equals(other.testeosDeCondSant))
			return false;
		return true;
	}

	
}
