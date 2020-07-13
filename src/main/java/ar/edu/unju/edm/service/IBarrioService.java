package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Barrio;

@Service
public interface IBarrioService {
	
	public void guardar(Barrio barrio);
	public List<Barrio> obtenerBarrios();
	public Barrio obtenerBarrio(List<Barrio> localidad);

}
