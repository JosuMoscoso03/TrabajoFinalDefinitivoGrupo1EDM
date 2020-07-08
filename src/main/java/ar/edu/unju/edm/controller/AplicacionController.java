package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AplicacionController {

	@GetMapping("/login")
	public String obtenerLogin(Model model) {
		
		return "login";
	}

	@GetMapping("/consultor")
	public String obtenerConsultor(Model model) {
		return "consultor";
	}
	
	@GetMapping({"/registrador"})
	public String obtenerRegistrador(Model model) {
		return "registrador";
	}
	
	@GetMapping({"/usuarioBDr"})
	public String obtenerBD(Model model) {
		return "usuarioBD";
	}
	
}
