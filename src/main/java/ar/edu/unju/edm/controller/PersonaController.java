package ar.edu.unju.edm.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
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


import ar.edu.unju.edm.model.ConsultaAux;
import ar.edu.unju.edm.model.ConsultaAux1;
import ar.edu.unju.edm.model.ConsultaAux3;
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
	//agregar persona
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
			
	//cancelar personas
	@GetMapping("/cancelarPersona")
	public String cancelarEditarPersona(ModelMap model) {
		return "redirect:/Vpersonas";	
	}
	
	//consultas
	
	//Consulta 1 	
	 @GetMapping("/consultaUno")
	 public String consultar(Model model){
		 try {
				model.addAttribute("consulta", new ConsultaAux1());
				model.addAttribute("barrios", barrioService.listarBarrio());
				
			}catch(Exception e) {
				model.addAttribute("listErrorMessage", e.getMessage());
			}
		return "consultaBarrio";
	 }	 
	 @PostMapping("/consultaUno")
		public String buscarPBarrio(@ModelAttribute ConsultaAux1 consulta, Model model) throws Exception {
		//variables_locales 
		 LocalDateTime desde = LocalDateTime.now();
		 LocalDateTime hacia = LocalDateTime.now();
		 String Barrio = new String ("");
		 try {
				desde = consulta.getFechaDesde();
				hacia = consulta.getFechaHacia();
				Barrio= consulta.getBarrio();				
		}catch (Exception e) {
				model.addAttribute("fromConsultaErrorMessage", e.getMessage());
		}
		 
			List<RegistroTracking> todosRegistros = registroService.obtenerRecorridoRango(desde,hacia);	
			List<ConsultaAux1> listadoPersona1 = new ArrayList<>();	
			List<ValidarCondicionSanitaria> condiciones = new ArrayList<>();
			 //recorrer los registros en el rango de fecha y hora
			   for(RegistroTracking registro : todosRegistros) {
				   //listadoPersona1.add(consulta);
				  if(registro.getLocalidad().getBarrio().equals(Barrio)){ 
					  //recorrer las condiciones sanitarias por si hay una coincidencia con el barrio agregar la condicion al listado condiciones
					for(ValidarCondicionSanitaria condicion : registro.getValidadores() ) { 
					   consulta.setApellido(condicion.getPersona().getApellido());
					   consulta.setNombres(condicion.getPersona().getNombres());
					   consulta.setDocumento(condicion.getPersona().getDocumento());
					   consulta.setId_testeos(condicion.getId());
					   consulta.setBarrio(registro.getLocalidad().getBarrio());
					   listadoPersona1.add(consulta);
					   condiciones.add(condicion);
					   consulta = new ConsultaAux1();  
					   }

				   } 	   
				   		   				   
			}
			   model.addAttribute("personaConsulta", listadoPersona1);
			   model.addAttribute("condiciones", condiciones); 
			   model.addAttribute("consulta", consulta);

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
	public String buscarPDocumento(@ModelAttribute Persona persona,  Model model) {
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
			  for(ValidarCondicionSanitaria condicion : registro.getValidadores() ) {				  
				  if (condicion.getPersona().getDocumento().equals(personaEncontrada.getDocumento())) {  
					 consulta.setFechayhora(registro.getFechaHora());
					 consulta.setLocalidad(registro.getLocalidad().getBarrio());
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
	
	 
	//Consulta3
	//personas que no cumplieron una condicion sanitarias enlistadas en orden de apellido y fecha
	@GetMapping("/consultaTres")
	public String personaT(Model model) {
		try {
			model.addAttribute("consulta",new ConsultaAux3());
			model.addAttribute("persona",new Persona());
			
		}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		
		return "consultaNormasSanitarias";
	}
	
	@PostMapping("/consultaTres")
	public String buscarPCondicion ( @ModelAttribute ConsultaAux3 consulta,Model model) throws Exception {		
		boolean bandera=true;
		LocalDate fecha = LocalDate.now();
		try {
			fecha = consulta.getFecha();
		}catch(Exception e) {
			model.addAttribute("fromPersonaErrorMessage", e.getMessage());
		}
		List<RegistroTracking> todosRegistros = registroService.obtenerRecorridoFechaOrdenado();
		List<ConsultaAux3> listadoPersona = new ArrayList<>();
		List<ValidarCondicionSanitaria> condiciones = new ArrayList<>();
		ValidarCondicionSanitaria aux= new ValidarCondicionSanitaria();
		
		//recorro los registros
		for(RegistroTracking registro : todosRegistros) {
			   //recorro la lista de condiciones
if(registro.getFechaHora().getDayOfMonth()==fecha.getDayOfMonth()&& registro.getFechaHora().getMonth()==fecha.getMonth()&&registro.getFechaHora().getYear()==fecha.getYear()){
			  for(ValidarCondicionSanitaria condicion : registro.getValidadores()) {				 
				  if (condicion.isCumpleTerminacionDNI()==false) {					  
					  consulta.setApellidos(condicion.getPersona().getApellido());
						 consulta.setId_test(condicion.getId());
						 consulta.setNombres(condicion.getPersona().getNombres());
						 bandera=false;
						 consulta= new ConsultaAux3();
						 aux=condicionService.encontrarValidacion(condicion.getId());
				  }else {
					  if(condicion.isPoseePermisoCirculacion()==false) {
						  consulta.setApellidos(condicion.getPersona().getApellido());
							 consulta.setId_test(condicion.getId());
							 consulta.setNombres(condicion.getPersona().getNombres());;	
							 bandera=false;
							 aux=condicionService.encontrarValidacion(condicion.getId());	
							 consulta = new ConsultaAux3();
					  }else {
						  if(condicion.isUsaTapaBoca()==false) {
							  	consulta.setApellidos(condicion.getPersona().getApellido());
								 consulta.setId_test(condicion.getId());;
								 consulta.setNombres(condicion.getPersona().getNombres());;
								 bandera=false;
								 aux=condicionService.encontrarValidacion(condicion.getId());
								consulta = new ConsultaAux3();
								}}}	
					  if (bandera==false) {
						  listadoPersona.add(consulta);
						  condiciones.add(aux);
						 
					  }
					  condicion= new ValidarCondicionSanitaria();
					  //aux = new ValidarCondicionSanitaria();
				   }
				 // 
			    }	

			  } 
		 model.addAttribute("consulta",consulta);
		 model.addAttribute("personas", listadoPersona);
		 model.addAttribute("condiciones", condiciones);
		
		 return "consultaNormasSanitarias";  
	}
		
		   
}
	

