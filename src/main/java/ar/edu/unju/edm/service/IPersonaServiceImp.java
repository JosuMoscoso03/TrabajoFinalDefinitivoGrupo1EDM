package ar.edu.unju.edm.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Persona;
import ar.edu.unju.edm.repository.IPersonaRepository;

@Service
public class IPersonaServiceImp implements IPersonaService {
	
	@Autowired
	IPersonaRepository ipersona;
	private ArrayList <Persona> aux = new ArrayList<Persona>();
	private Iterator <Persona> listadoP = aux.iterator();
	@Override
	public void guardar(Persona unaPersona) {
		// TODO Auto-generated method stub
		ipersona.save (unaPersona);
		aux.add(unaPersona);
	}
	@Override
	public Optional<Persona> encontrarPersona(String apellidoPersona) {
		// TODO Auto-generated method stub
		Optional<Persona> PersonaEncontrada = ipersona.findByApellidoPersona(apellidoPersona);
		return PersonaEncontrada;
	}
	/*
	 * 
	 
	@Override
	public void ListarPersona(Persona unaPersona) {
		// TODO Auto-generated method stub
		while(listadoP.hasNext()) {
			unaPersona = listadoP.next();
			System.out.print(unaPersona);
		}
	}

	
	**/
	@Override
	public Iterable<Persona> listarPersona() {
		// TODO Auto-generated method stub
		return ipersona.findAll();
	}

	@Override
	public void eliminar(Persona unaPersona) {
		// TODO Auto-generated method stub
		while(listadoP.hasNext()) {
			Persona persona = listadoP.next();
			if(persona.equals(unaPersona)) {
				listadoP.remove();
			}
		}
	}

	@Override
	public Persona modificar() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
