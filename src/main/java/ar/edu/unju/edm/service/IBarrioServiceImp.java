package ar.edu.unju.edm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.edm.model.Barrio;
import ar.edu.unju.edm.repository.IBarrioRepository;

public class IBarrioServiceImp implements IBarrioService {
	@Autowired
	IBarrioRepository ibarrio;
	
	@Override
	public void guardar(Barrio unBarrio) {
		// TODO Auto-generated method stub
		ibarrio.save(unBarrio);
	}

	@Override
	public Iterable<Barrio> ListarBarrios() {
		// TODO Auto-generated method stub
		return ibarrio.findAll();
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Barrio modificar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Barrio> encontrarUsuario(Long idBarrio) {
		// TODO Auto-generated method stub
		Optional<Barrio> BarrioEncontrado = ibarrio.findById(idBarrio);
		return BarrioEncontrado;
	}


}
