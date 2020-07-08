package ar.edu.unju.edm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.edm.model.Persona;
import ar.edu.unju.edm.repository.IPersonaRepository;

public class IPersonaServiceImp implements IPersonaService {
	
	@Autowired
	IPersonaRepository ipersona;

	@Override
	public void guardar(Persona unaPersona) {
		// TODO Auto-generated method stub
		ipersona.save(unaPersona);
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Persona modificar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Persona> ListarPersona() {
		// TODO Auto-generated method stub
		return ipersona.findAll();
	}

	@Override
	public Optional<Persona> encontrarUsuario(Long id) {
		// TODO Auto-generated method stub
		Optional<Persona> PersonaEncontrada = ipersona.findById(id);
		return PersonaEncontrada;
	}
	

}
