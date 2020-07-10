package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
@RequestMapping
public class UsuarioController {
	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping("/cargarUsuario")
	public String agregarU(Model model) {
		model.addAttribute("usuarioF",new Usuario());
		return "Fusuario";
	}
	@PostMapping("/guardarUsuario")
	public String guardarU(@ModelAttribute Usuario usuario, Model model) {
		usuarioService.guardar(usuario);
		model.addAttribute("usuarioF", usuario);
		return "redirect:/cargarUsuario";
	} 

	
	@GetMapping("/Lusuarios")
	public String mostrarUsuarios(Model model){
		model.addAttribute("usuario", usuarioService.listarUsuario());
		return "usuarios";	
	}
}
