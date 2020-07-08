package ar.edu.unju.edm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.edm.model.RegistroTracking;
import ar.edu.unju.edm.repository.IRegistroRepository;

public class ITrackingServiceImp implements ITrackingService {
	
	@Autowired
	IRegistroRepository iRegistro;

	@Override
	public void guardar(RegistroTracking unRegistro) {
		// TODO Auto-generated method stub
		iRegistro.save(unRegistro);
	}

	@Override
	public Iterable<RegistroTracking> ListarRegistros() {
		// TODO Auto-generated method stub
		return iRegistro.findAll();
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RegistroTracking modificar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<RegistroTracking> encontrarUsuario(Long id) {
		// TODO Auto-generated method stub
		Optional<RegistroTracking> registroEncontrado = iRegistro.findById(id);
		return registroEncontrado;
	}
}
