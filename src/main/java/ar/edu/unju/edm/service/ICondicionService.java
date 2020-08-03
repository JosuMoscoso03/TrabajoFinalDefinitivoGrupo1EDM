package ar.edu.unju.edm.service;

import java.util.List;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.ValidarCondicionSanitaria;

@Service
public interface ICondicionService {
	
	public void guardar(ValidarCondicionSanitaria condicion);
	public List <ValidarCondicionSanitaria > MostarCondiciones();
	public void eliminar(Long id);
	public ValidarCondicionSanitaria modificar(ValidarCondicionSanitaria condicion) throws Exception;
	public ValidarCondicionSanitaria encontrarValidacion(Long id) throws Exception;
	public List<ValidarCondicionSanitaria> listarCondicion();
	public List<ValidarCondicionSanitaria> obtenerCondiciones();
}
