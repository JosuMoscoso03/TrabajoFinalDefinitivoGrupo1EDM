package ar.edu.unju.edm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Persona;


@Service
public interface IPersonaService {

	public void guardar( Persona unaPersona);
	public List<Persona> listarPersona();
	public List<Persona> obtenerPersonas();
	public void eliminar(Long id);
	public Persona modificar(Persona unaPersona) throws Exception;
	public Persona encontrarPersona(Long id) throws Exception;

}
