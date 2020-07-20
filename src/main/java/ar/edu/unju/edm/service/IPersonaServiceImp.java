package ar.edu.unju.edm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Persona;
import ar.edu.unju.edm.repository.IPersonaRepository;

@Service
public class IPersonaServiceImp implements IPersonaService {
	
	@Autowired
	IPersonaRepository ipersona;
	private List<Persona> perAux = new ArrayList<>();
	@Override
	public void guardar(Persona unaPersona) {
		// TODO Auto-generated method stub
		ipersona.save (unaPersona);
		perAux.add (unaPersona);
	}
	@Override
	public Persona encontrarPersona(Long id) throws Exception {
		// TODO Auto-generated method stub
		return ipersona.findById(id).orElseThrow(() -> new Exception("Error"));

	}
	
	@Override
	public List<Persona> listarPersona() {
		return ipersona.listarPersonas();
	}

	@Override
	public void eliminar(Long id) {
		ipersona.deleteById(id);
	}
	
	@Override
	public void eliminarPersonas() {
		perAux = new ArrayList<>();
	}
	
	@Override
	public Persona modificar(Persona unaPersona) throws Exception {
		Persona personaB = encontrarPersona(unaPersona.getId());
		mapearPersona(unaPersona, personaB);
		return ipersona.save(personaB);
	}

	public void mapearPersona(Persona desde, Persona hacia) {
		hacia.setNombres(desde.getNombres());
		hacia.setApellido(desde.getApellido());
		hacia.setDocumento(desde.getDocumento());
		hacia.setNacionalidad(desde.getNacionalidad());
	}
	@Override
	public List<Persona> obtenerPersonas() {
		return perAux;
	}
	@Override
	public Persona buscarPersona(String documento) throws Exception {
		return ipersona.findByDocumento(documento).orElseThrow(()-> new Exception("La persona no existe en la base de datos")) ;
	}
}
