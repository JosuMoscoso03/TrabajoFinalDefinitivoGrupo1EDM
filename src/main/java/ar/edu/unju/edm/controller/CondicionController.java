package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.ValidarCondicionSanitaria;
import ar.edu.unju.edm.service.ICondicionService;

@Controller
public class CondicionController {
	@Autowired
	ICondicionService icondicion;


	@GetMapping("/cargarCondicion/{id}")
	public String agregarC(Model model) {
		model.addAttribute("validarF", new ValidarCondicionSanitaria());
		return "redirect:/cargarRegistro";
	}
	
	@PostMapping("/guardarCondicion")
	public String guardarC(@ModelAttribute ValidarCondicionSanitaria condicion, Model model) {
		icondicion.guardar(condicion);
		model.addAttribute("validarF", new ValidarCondicionSanitaria());
		return "redirect:/cargarRegistro"; 
	}

}

