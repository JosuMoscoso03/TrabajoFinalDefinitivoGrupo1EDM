package ar.edu.unju.edm.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Persona;


@Service
public interface IPersonaService {

	public void guardar( Persona unaPersona);
	public Iterable<Persona> listarPersona();
	public void eliminar(Persona unaPersona);
	public Persona modificar();
	public Optional<Persona> encontrarPersona(String apellidoPersona);


}
