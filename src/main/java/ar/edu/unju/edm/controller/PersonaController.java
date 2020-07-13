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
		model.addAttribute("personaF", new Persona());
		return "Fpersona";
	}
	
	@PostMapping("/guardarPersona")
	public String guardarP(@ModelAttribute Persona persona, Model model) {
		personaService.guardar(persona);
		model.addAttribute("personaF", new Persona());
		return "redirect:/cargarPersona"; 
	}
	//Listar usuarios
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
}