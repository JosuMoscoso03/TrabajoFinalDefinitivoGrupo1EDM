package ar.edu.unju.edm.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.model.Persona;
import ar.edu.unju.edm.service.IPersonaService;

@Controller
@RequestMapping
public class PersonaController {
	@Autowired
	IPersonaService personaService;
	
	@GetMapping("/cargarPersona")
	public String agregarP(Model model) {
		model.addAttribute("Personaf", new Persona());
		return "Fpersona";
	}
	
	@PostMapping("/guardarPersona")
	public String guardarP(@ModelAttribute Persona persona, Model model) {
		personaService.guardar(persona);
		model.addAttribute("Personaf", new Persona());
		return "redirect:/cargarPersona"; 
	}
	//Listar usuarios
	@GetMapping("/Lpersonas")
	public String mostrarPersonas(Model model){
		model.addAttribute ("persona",personaService.listarPersona());
		return "personas";	
	}	
	
	//modificar persona	 
	@GetMapping("/editarPersona/{id}")
	public String EditarPersona(Model model,@ModelAttribute Persona persona){
		Optional<Persona> personaEncontrada = personaService.encontrarPersona(persona.getNombres());
		model.addAttribute("personaD", personaEncontrada);
		model.addAttribute("editMode","true");
		return "Fpersona";
	}
	
	@PostMapping("/editarPersona")
	public String postEditarPersona( @ModelAttribute("personaD") Persona persona, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {			
			model.addAttribute("personaD", persona);
			model.addAttribute("editMode", "true");
		}else {
			try {
				System.out.println(persona.getId());

				personaService.modificar();
				model.addAttribute("usuarioD", persona);
				model.addAttribute("editMode", "false");
			} catch (Exception e) {

				model.addAttribute("formPersonaErrorMessage", e.getMessage());
				model.addAttribute("userForm", persona);
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("personas",personaService.listarPersona());
		return "redirect:/Lpersonas";
	}
	
	//eliminar persona
	@GetMapping("/eliminarPersona/{id}")
	public String eliminarP(Model model,@ModelAttribute Persona persona ) {
		try {
			personaService.eliminar(persona);
			
		}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		
		return mostrarPersonas(model);
		
	}	

	@GetMapping("/encontrarPersona/{id}")
	public String EncontrarUsuario(Model model, @ModelAttribute Persona persona) {
		Optional<Persona> personaEncontrada = personaService.encontrarPersona(persona.getApellido());
		model.addAttribute("personaD", personaEncontrada);
		model.addAttribute("editMode","true");
		return "Fpersona";
	}
	
	@GetMapping("/cancelarPersona")
	public String cancelarEditarPersona(ModelMap model) {
		return "redirect:/personas";	
	}
}
