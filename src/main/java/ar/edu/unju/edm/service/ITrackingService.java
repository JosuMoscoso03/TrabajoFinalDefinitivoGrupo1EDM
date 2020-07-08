package ar.edu.unju.edm.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.RegistroTracking;

@Service
public interface ITrackingService {
	public void guardar(RegistroTracking unRegistro);
	public Iterable <RegistroTracking> ListarRegistros();
	public void eliminar();
	public RegistroTracking modificar();
	public Optional<RegistroTracking> encontrarUsuario(Long id);
}
