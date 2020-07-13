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
	
	@Override
	public List<Barrio> listarBarrio() {
		return iBarrio.listarBarrios();
	}

	@Override
	public void guardar(Barrio barrio) {
		iBarrio.save(barrio);
	}

	@Override
	public void eliminar(Long id){
		iBarrio.deleteById(id);
	}
	
	@Override
	public Barrio modificar(Barrio unBarrio) throws Exception {
		Barrio barrioB = encontrarBarrio(unBarrio.id);
		mapearBarrio(unBarrio, barrioB);
		return iBarrio.save(barrioB);
	}

	public void mapearBarrio(Barrio desde, Barrio hacia) {
		hacia.setBarrio(desde.getBarrio());
	}

	@Override
	public Barrio encontrarBarrio(Long id) throws Exception {
		// TODO Auto-generated method stub
		return iBarrio.findById(id).orElseThrow(() -> new Exception("Error"));
	}
	
	@Override
	public Long devolverIdBarrio (Barrio Barrio) {
		return Barrio.getId();
	}
}
