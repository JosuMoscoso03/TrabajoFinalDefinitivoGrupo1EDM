package ar.edu.unju.edm.service;

import java.util.Optional;

import ar.edu.unju.edm.model.Persona;

public interface IPersonaService {
	public void guardar(Persona unaPersona);
	public Iterable <Persona> ListarPersona();
	public void eliminar(Long id);
	public Persona modificar(Persona unaPersona) throws Exception;
	public Optional<Persona> encontrarUsuario(Long id);


}
