package ar.edu.unju.edm.service;

import java.util.Optional;

import ar.edu.unju.edm.model.Barrio;

public interface IBarrioService {
	public void guardar(Barrio unBarrio);
	public Iterable <Barrio> ListarBarrios();
	public void eliminar();
	public Barrio modificar();
	public Optional<Barrio> encontrarUsuario(Long idBarrio);
}
