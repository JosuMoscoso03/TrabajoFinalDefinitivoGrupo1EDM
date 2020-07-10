package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class UsuarioController {
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	Usuario unUsuario;
	//Agregar usuarios
	@GetMapping("/nuevoUsuario")
	public String agregarL(Model model) {
		model.addAttribute("UsuarioD", unUsuario);
		return "UsuarioForm";
	}
	
	@PostMapping("/saveUsuario")
	public String guardarL(@ModelAttribute Usuario usuario, Model model) {
		usuarioService.guardar(usuario);
		model.addAttribute("UsuarioD", unUsuario);
		return "redirect:/usuario"; 
	}
	//Listar usuarios
	@GetMapping("/usuario")
	public String mostrarUsuarios(Model model){
		model.addAttribute("usuario",usuarioService.listarUsuario());
		return "usuario";	
	}
	
	//modificar usuarios
	
	@GetMapping("/editarUsuario/{id}")
	public String EditarUsuario(Model model, @PathVariable(name="id") Long id) throws Exception {
		Optional<Usuario> usuarioEncontrado = usuarioService.encontrarUsuario(id);
		model.addAttribute("usuarioD", usuarioEncontrado);
		model.addAttribute("editMode","true");
		return "usuarioForm";
	}
	
	@GetMapping("/encontrarUsuario/{id}")
	public String EncontrarUsuario(Model model, @PathVariable(name="id") Long id) throws Exception {
		Optional<Usuario> usuarioEncontrado = usuarioService.encontrarUsuario(id);
		model.addAttribute("usuarioD", usuarioEncontrado);
		model.addAttribute("editMode","true");
		return "usuarioForm";
	}
	
	@PostMapping("/editarUsuario")
	public String postEditarUsuario( @ModelAttribute("usuarioD") Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			
			model.addAttribute("usuarioD", usuario);
			model.addAttribute("editMode", "true");
		}else {
			try {
				System.out.println(unUsuario.getId());

				usuarioService.modificar(usuario);
				model.addAttribute("usuarioD", unUsuario);
				model.addAttribute("editMode", "false");
			} catch (Exception e) {

				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("userForm", usuario);
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("usuarios", usuarioService.listarUsuario());
		return "redirect:/usuario";
	}
	
	//eliminar usuario 
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name="id") Long id) {
		try {
			usuarioService.eliminar(id);
			
		}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		
		return mostrarUsuarios(model);
		
	}	
	
	@GetMapping("/cancelar")
	public String cancelarEditarUsuario(ModelMap model) {
		return "redirect:/usuario";	
	}
}
