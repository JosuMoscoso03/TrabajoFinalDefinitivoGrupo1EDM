package ar.edu.unju.edm.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.ValidarCondicionSanitaria;

@Service
public interface ICondicionService {
	public void guardar(ValidarCondicionSanitaria condicion);
	public Iterable <ValidarCondicionSanitaria > MostarCondiciones();
	public void eliminar();
	public ValidarCondicionSanitaria modificar();
	public Optional<ValidarCondicionSanitaria > encontrarValidacion(Long codValidacion);
}
