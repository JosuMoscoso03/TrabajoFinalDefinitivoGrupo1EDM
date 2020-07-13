package ar.edu.unju.edm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository <Persona,Long>{
	@Query("from Persona e order by e.id")
	public Optional <Persona> findByApellidoPersona(String apellidoPersona);

}
