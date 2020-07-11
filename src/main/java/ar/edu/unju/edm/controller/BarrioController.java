package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.model.Barrio;
import ar.edu.unju.edm.service.IBarrioService;

@Controller
@RequestMapping
public class BarrioController {
	
	@Autowired
	IBarrioService barrioService;
	
	@GetMapping("/nuevoBarrio")
	public String agregarB(Model model) {
		model.addAttribute("barrioF", new Barrio());
		return "Fbarrio";
	}
	
	@PostMapping("/guardarBarrio")
	public String guardarB(@ModelAttribute Barrio barrio, Model model) {
		barrioService.guardar(barrio);
		return "redirect:/nuevoBarrio"; 
	}
	
}
