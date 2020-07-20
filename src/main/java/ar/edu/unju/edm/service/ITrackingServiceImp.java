package ar.edu.unju.edm.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.edm.model.RegistroTracking;
import ar.edu.unju.edm.repository.IRegistroRepository;

public class ITrackingServiceImp implements ITrackingService {
	
	@Autowired
	IRegistroRepository iRegistro;

	@Override
	public void guardar(RegistroTracking unRegistro) {
		// TODO Auto-generated method stub
		unRegistro.setFechaHora(LocalDateTime.now());
		iRegistro.save(unRegistro);
	}
	@Override
	public Optional<RegistroTracking> encontrarRegistro(Long id) {
		// TODO Auto-generated method stub
		Optional<RegistroTracking> registroEncontrado = iRegistro.findById(id);
		return registroEncontrado;
	}
	
	//Consulta2
		@Override
		public List<RegistroTracking> obtenerRecorridoFechaOrdenado(){
			List<RegistroTracking> registros = iRegistro.findAllByOrderByfechaHoraAsc();
			return registros;
		}
		@Override
		public List<RegistroTracking> obtenerRecorridoRango(LocalDateTime t1,LocalDateTime t2) {
			// TODO Auto-generated method stub
			List<RegistroTracking> rangos=iRegistro.findByfechaHoraBetween(t1,t2);
			return rangos;
		}
}
