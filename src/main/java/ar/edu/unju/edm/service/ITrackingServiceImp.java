package ar.edu.unju.edm.service;

import java.time.LocalDateTime;
import java.util.List;
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
	public Iterable<RegistroTracking> ListarRegistros() {
		// TODO Auto-generated method stub
		return iRegistro.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		iRegistro.deleteById(id);
	}

	@Override
	public RegistroTracking modificar(RegistroTracking registro) throws Exception {
		// TODO Auto-generated method stub
		RegistroTracking unregistro = encontrarRegistro (registro.getId());
		mapearRegistro(registro,unregistro);
		return iRegistro.save(unregistro);
	}
	
	public void mapearRegistro(RegistroTracking desde, RegistroTracking hacia) {
		hacia.setDetalleLugarRegistro(desde.getDetalleLugarRegistro());
		hacia.setFechaHora(desde.getFechaHora());
		hacia.setBarrios(desde.getBarrios());
		hacia.setTesteosDeCondSant(desde.getTesteosDeCondSant());
	
	}
	@Override
	public RegistroTracking encontrarRegistro(Long id) throws Exception {
		// TODO Auto-generated method stub
		return iRegistro.findById(id).orElseThrow(() -> new Exception("Error"));
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
