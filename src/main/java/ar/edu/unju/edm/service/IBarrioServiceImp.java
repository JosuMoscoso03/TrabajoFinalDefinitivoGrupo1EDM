package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Barrio;
import ar.edu.unju.edm.repository.IBarrioRepository;

@Service
public class IBarrioServiceImp implements IBarrioService{

	@Autowired
	IBarrioRepository iBarrio;
	private Barrio barrioAuxiliar = new Barrio();
	
	@Override
	public List<Barrio> obtenerBarrios() {
		return iBarrio.obtenerBarrios();
	}

	@Override
	public void guardar(Barrio barrio) {
		iBarrio.save(barrio);
	}

	@Override
	public Barrio obtenerBarrio(List<Barrio> barrio) {
		return barrioAuxiliar;
	}

}
