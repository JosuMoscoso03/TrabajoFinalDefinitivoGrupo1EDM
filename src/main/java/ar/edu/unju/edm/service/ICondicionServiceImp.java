package ar.edu.unju.edm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.edm.model.ValidarCondicionSanitaria;
import ar.edu.unju.edm.repository.ICondicionRepository;

public class ICondicionServiceImp implements ICondicionService {
	@Autowired
	ICondicionRepository iCondicion;
		
	@Override
	public void guardar(ValidarCondicionSanitaria condicion) {
		// TODO Auto-generated method stub
		iCondicion.save(condicion);
	}

	@Override
	public Iterable<ValidarCondicionSanitaria> MostarCondiciones() {
		// TODO Auto-generated method stub
		return iCondicion.findAll();
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ValidarCondicionSanitaria modificar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ValidarCondicionSanitaria> encontrarValidacion(Long codValidacion) {
		// TODO Auto-generated method stub
		Optional<ValidarCondicionSanitaria> ValidacionEncontrada = iCondicion.findById(codValidacion);
		return ValidacionEncontrada;
	}

}
