package ar.edu.unju.edm.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.RegistroTracking;

@Service
public interface ITrackingService {
	public void guardar(RegistroTracking unRegistro);
	public Optional<RegistroTracking> encontrarRegistro(Long id);
	public List<RegistroTracking> obtenerRecorridoFechaOrdenado();
	public List<RegistroTracking> obtenerRecorridoRango(LocalDateTime t1,LocalDateTime t2);	
}
