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

	@GetMapping("/cargarCondicion")
	public String agregarP(Model model) {
		model.addAttribute("ValidarCondicionSanitaria", new ValidarCondicionSanitaria());
		return "condicionSanitaria";
	}
	
	@PostMapping("/guardarCondicion")
	public String guardarP(@ModelAttribute ValidarCondicionSanitaria condicion, Model model) {
		icondicion.guardar(condicion);
		model.addAttribute("ValidarCondicionSanitaria", new ValidarCondicionSanitaria());
		return "redirect:/cargarCondicion"; 
	}

}
