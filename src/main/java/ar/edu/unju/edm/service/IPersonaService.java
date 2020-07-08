package ar.edu.unju.edm.service;

import java.util.Optional;

import ar.edu.unju.edm.model.Persona;

public interface IPersonaService {
	public void guardar(Persona unaPersona);
	public Iterable <Persona> ListarPersona();
	public void eliminar();
	public Persona modificar();
	public Optional<Persona> encontrarUsuario(Long id);


}
