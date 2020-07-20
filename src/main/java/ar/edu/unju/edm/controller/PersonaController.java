package ar.edu.unju.edm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ar.edu.unju.edm.model.Barrio;
import ar.edu.unju.edm.model.ConsultaAux;
import ar.edu.unju.edm.model.ConsultaAux1;
import ar.edu.unju.edm.model.Persona;
import ar.edu.unju.edm.model.RegistroTracking;
import ar.edu.unju.edm.model.ValidarCondicionSanitaria;
import ar.edu.unju.edm.service.IBarrioService;
import ar.edu.unju.edm.service.ICondicionService;
import ar.edu.unju.edm.service.IPersonaService;
import ar.edu.unju.edm.service.ITrackingService;

@Controller
@RequestMapping
public class PersonaController {
	@Autowired
	IPersonaService personaService;
	@Autowired
	ITrackingService registroService;
	@Autowired
	ICondicionService condicionService;
	@Autowired
	IBarrioService barrioService;
	@GetMapping("/cargarPersona")
	public String agregarP(Model model) {
		model.addAttribute("personaF", new Persona());
		return "Fpersona";
	}
	
	@PostMapping("/guardarPersona")
	public String guardarP(@ModelAttribute Persona persona, Model model) {
		personaService.guardar(persona);
		model.addAttribute("personaF", new Persona());
		return "redirect:/cargarRegistro"; 
	}
	//Listar personas
	@GetMapping("/Lpersonas")
	public String mostrarPersonas(Model model){
		model.addAttribute ("personas",personaService.listarPersona());
		return "Vpersonas";	
	}	
	
	//modificar persona	 
	@GetMapping("/EDpersona/{id}")
	public String EditarPersona(Model model,@PathVariable(name="id") Long id) throws Exception{
		Persona personaEncontrada = personaService.encontrarPersona(id);
		model.addAttribute("personaF", personaEncontrada);
		model.addAttribute("editMode","true");
		return "Fpersona";
	}
	
	@PostMapping("/Mpersona")
	public String postEditarPersona( @ModelAttribute("personaF") Persona persona, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {			
			model.addAttribute("personaF", persona);
			model.addAttribute("editMode", "true");
		}else {
			try {
				System.out.println(persona.getId());

				personaService.modificar(persona);
				model.addAttribute("personaF", persona);
				model.addAttribute("editMode", "false");
			} catch (Exception e) {

				model.addAttribute("formPersonaErrorMessage", e.getMessage());
				model.addAttribute("personaForm", persona);
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("personas",personaService.listarPersona());
		return "redirect:/Lpersonas";
	}
	
	//eliminar persona
	@GetMapping("/Elpersona/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
			personaService.eliminar(id);
			return "redirect:/Lpersonas";
		}
			
	
	@GetMapping("/cancelarPersona")
	public String cancelarEditarPersona(ModelMap model) {
		return "redirect:/Vpersonas";	
	}
	
	//consultas
	
	//Consulta 1 
	
	 @GetMapping("/consultaUno")
	 public String consultar(Model model){
		model.addAttribute("consulta", new ConsultaAux1());
		model.addAttribute("barrio", barrioService.listarBarrio());	
		model.addAttribute("registroTrackingF", new RegistroTracking());
		return "consultaBarrio";
	 }
	 
	 @PostMapping("/consultaUno")
		public String buscarPBarrio(@ModelAttribute Barrio barrio, Model model) throws Exception {
			//variables_locales 
		
		 try {
			ConsultaAux1 consulta1 = new ConsultaAux1();
			List<RegistroTracking> todosRegistros = registroService.obtenerRecorridoRango(consulta1.getFechaHD(),consulta1.getFechaHH());	
			List<ConsultaAux1> listadoPersona1 = new ArrayList<>();	
			List<ValidarCondicionSanitaria> condiciones = new ArrayList<>();
			
			 //recorrer los registros en el rango de fecha y hora
			   for(RegistroTracking registro : todosRegistros) {
				   //recorrer las condiciones sanitarias por si hay una coind¿cidencia con el barrio agregar la condicion al listado condiciones
				   for(ValidarCondicionSanitaria condicion : registro.getTesteosDeCondSant()) {
					   if(registro.getBarrios().getBarrio().equals(barrio.getBarrio())) {
					   condiciones.add(condicion);
					   consulta1.setBarrio(barrio.getBarrio());
					   consulta1.setApellido(condicion.getPersona().getApellido());
					   consulta1.setNombres(condicion.getPersona().getNombres());
					   consulta1.setDocumento(condicion.getPersona().getDocumento());
					   consulta1.setId_testeos(condicion.getId());
					   //consulta1 = new ConsultaAux1();
					   }
				   } 	   
			   
				   listadoPersona1.add(consulta1);
				   
				   model.addAttribute("personaConsulta", listadoPersona1);
				   model.addAttribute("condiciones", condiciones); 
				  
			}
		 } catch(Exception e){
			model.addAttribute("formPersonaErrorMessage", e.getMessage());
			}
		 	return "consultaBarrio";
		}
			

	//Consulta2
	 @GetMapping("/consultaDos")
		public String personaD(Model model) {
			try {
				model.addAttribute("persona",new Persona());
				
			}catch(Exception e) {
				model.addAttribute("listErrorMessage", e.getMessage());
			}
			
			return "consultaRecorrido";
			
		}
		@PostMapping("/consultaDos")
		public String buscarPFecha(@ModelAttribute Persona persona,  Model model) {
			//variables locales 
			Persona personaEncontrada = new Persona();
			ConsultaAux consulta = new ConsultaAux();
			try {
				personaEncontrada = personaService.buscarPersona(persona.getDocumento());
			}catch(Exception e) {
				model.addAttribute("fromPersonaErrorMessage", e.getMessage());
			}
			List<RegistroTracking> todosRegistros = registroService.obtenerRecorridoFechaOrdenado();
			List<ConsultaAux> listadoPersona = new ArrayList<>();
			//recorro los registros
			   for(RegistroTracking registro : todosRegistros) {
				   //recorro la lista de condiciones 
				  for(ValidarCondicionSanitaria condicion : registro.getTesteosDeCondSant() ) {
					  if (condicion.getPersona().getDocumento().equals(personaEncontrada.getDocumento())) { 
						 consulta.setFechayhora(registro.getFechaHora());
						 consulta.setLocalidad(registro.getBarrios().getBarrio());
						 consulta.setIdCondicion(registro.getId());
						 consulta.setApellido(personaEncontrada.getApellido());
						 consulta.setNombre(personaEncontrada.getNombres());
						 consulta.setDocumento(persona.getDocumento());
						 consulta = new ConsultaAux();
					  }
				  }
				  listadoPersona.add(consulta);
			   } 
			   
			   model.addAttribute("personaEncontrada", personaEncontrada);
			   model.addAttribute("personaConsulta", listadoPersona);
			   
			   return "consultaRecorrido";
		}
	

	
	
}