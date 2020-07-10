package ar.edu.unju.edm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Persona;
import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IPersonaService;

@Controller
public class PersonaController {
	@Autowired
	IPersonaService personaService;
	@Autowired 
	Persona unaPersona;
	
	@GetMapping("/nuevaPersona")
	public String agregarPersona(Model model) {
		model.addAttribute("PersonaD", unaPersona);
		return "PersonaForm";
	}
	
	@PostMapping("/savePersona")
	public String guardarL(@ModelAttribute Persona persona, Model model) {
		personaService.guardar(persona);
		model.addAttribute("PersonaD", unaPersona);
		return "redirect:/persona"; 
	}
	//Listar usuarios
	@GetMapping("/usuario")
	public String mostrarPersonas(Model model){
		model.addAttribute("persona",personaService.ListarPersona());
		return "persona";	
	}
	
	//modificar persona
	
	@GetMapping("/editarPersona/{id}")
	public String EditarPersona(Model model, @PathVariable(name="id") Long id) throws Exception {
		Optional<Persona> personaEncontrada = personaService.encontrarUsuario(id);
		model.addAttribute("personaD", personaEncontrada);
		model.addAttribute("editMode","true");
		return "personaForm";
	}
	
	@PostMapping("/editarPersona")
	public String postEditarUsuario( @ModelAttribute("personaD") Persona persona, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {			
			model.addAttribute("personaD", persona);
			model.addAttribute("editMode", "true");
		}else {
			try {
				System.out.println(unaPersona.getId());

				personaService.modificar(persona);
				model.addAttribute("usuarioD", unaPersona);
				model.addAttribute("editMode", "false");
			} catch (Exception e) {

				model.addAttribute("formPersonaErrorMessage", e.getMessage());
				model.addAttribute("userForm", persona);
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("personas",personaService.ListarPersona());
		return "redirect:/persona";
	}
	
	//eliminar persona
	@GetMapping("/eliminarPersona/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name="id") Long id) {
		try {
			personaService.eliminar(id);
			
		}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		
		return mostrarPersonas(model);
		
	}	

	@GetMapping("/encontrarPersona/{id}")
	public String EncontrarUsuario(Model model, @PathVariable(name="id") Long id) throws Exception {
		Optional<Persona> personaEncontrada = personaService.encontrarUsuario(id);
		model.addAttribute("personaD", personaEncontrada);
		model.addAttribute("editMode","true");
		return "personaForm";
	}
	
	@GetMapping("/cancelar")
	public String cancelarEditarUsuario(ModelMap model) {
		return "redirect:/persona";	
	}
}
