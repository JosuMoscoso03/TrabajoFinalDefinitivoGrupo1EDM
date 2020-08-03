package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Barrio;

@Service
public interface IBarrioService {
	
	public void guardar(Barrio barrio);
	public List<Barrio> listarBarrio();
	public Barrio encontrarBarrio(Long id) throws Exception;
	public Barrio modificar(Barrio unBarrio) throws Exception;
	public void eliminar(Long id);
	public Long devolverIdBarrio (Barrio Barrio);
	public Barrio buscarBarrio(String barrio) throws Exception;
	public List<Barrio> obtenerBarrios();
}
