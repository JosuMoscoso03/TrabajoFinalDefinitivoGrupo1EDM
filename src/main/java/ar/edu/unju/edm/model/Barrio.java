package ar.edu.unju.edm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Barrio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3612824470756797049L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native", strategy="native")
	public Long id;
	
	@Column
	String barrio;
	
	@OneToMany(mappedBy = "barrios")
	private List<RegistroTracking> registrosTracking = new ArrayList<RegistroTracking>();
	
	public Barrio() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public Barrio(Long id, String barrio, List<RegistroTracking> registrosTracking) {
		super();
		this.id = id;
		this.barrio = barrio;
		this.registrosTracking = registrosTracking;
	}

	@Override
	public String toString() {
		return "Barrio [id=" + id + ", barrio=" + barrio + ", registrosTracking=" + registrosTracking + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barrio == null) ? 0 : barrio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((registrosTracking == null) ? 0 : registrosTracking.hashCode());
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
		Barrio other = (Barrio) obj;
		if (barrio == null) {
			if (other.barrio != null)
				return false;
		} else if (!barrio.equals(other.barrio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (registrosTracking == null) {
			if (other.registrosTracking != null)
				return false;
		} else if (!registrosTracking.equals(other.registrosTracking))
			return false;
		return true;
	}

}
