package ar.edu.unju.edm.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.RegistroTracking;

@Service
public interface ITrackingService {
	public void guardar(RegistroTracking unRegistro);
	public Iterable <RegistroTracking> ListarRegistros();
	public void eliminar(Long id);
	public RegistroTracking modificar(RegistroTracking unRegistro) throws Exception;
	public RegistroTracking encontrarRegistro(Long id) throws Exception;
	//Consulta2
	public List<RegistroTracking> obtenerRecorridoFechaOrdenado();
	//Consulta1
	public List<RegistroTracking> obtenerRecorridoRango(LocalDateTime t1,LocalDateTime t2);
}
