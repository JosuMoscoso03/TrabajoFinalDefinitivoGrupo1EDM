package ar.edu.unju.edm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.ValidarCondicionSanitaria;
import ar.edu.unju.edm.repository.ICondicionRepository;

@Service
public class ICondicionServiceImp implements ICondicionService {
	@Autowired
	ICondicionRepository iCondicion;
	
	private List<ValidarCondicionSanitaria> condaux = new ArrayList<>();
    
	@Override
	public List<ValidarCondicionSanitaria> obtenerCondiciones(){
		return condaux;
	}
	
    @Override
	public List<ValidarCondicionSanitaria> listarCondicion() {
		// TODO Auto-generated method stub
		return iCondicion.listarCondiciones();
	}
	@Override
	public void guardar(ValidarCondicionSanitaria condicion) {
		// TODO Auto-generated method stub
		iCondicion.save(condicion);
	}

	@Override
	public List<ValidarCondicionSanitaria> MostarCondiciones() {
		// TODO Auto-generated method stub
		return iCondicion.listarCondiciones();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		iCondicion.deleteById(id);
	}
	
	@Override
	public ValidarCondicionSanitaria modificar(ValidarCondicionSanitaria condicion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ValidarCondicionSanitaria encontrarValidacion(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
