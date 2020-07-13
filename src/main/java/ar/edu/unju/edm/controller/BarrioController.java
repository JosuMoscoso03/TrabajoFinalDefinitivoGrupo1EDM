package ar.edu.unju.edm.controller;

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

import ar.edu.unju.edm.model.Barrio;
import ar.edu.unju.edm.service.IBarrioService;

@Controller
@RequestMapping
public class BarrioController {
	
	@Autowired
	IBarrioService barrioService;
	
	@Autowired
	Barrio unBarrio;
	
	@GetMapping("/cargarBarrio")
	public String agregarB(Model model) {
		model.addAttribute("barrioF", unBarrio);
		return "Fbarrio";
	}
	
	@PostMapping("/guardarBarrio")
	public String guardarB(@ModelAttribute Barrio barrio, Model model) {
		barrioService.guardar(barrio);
		model.addAttribute("barrioF", unBarrio);
		return "redirect:/cargarBarrio"; 
	}
	
	@GetMapping("/Lbarrios")
	public String mostrarUsuarios(Model model){
		model.addAttribute("barrios", barrioService.listarBarrio());
		return "Vbarrios";	
	}
	
	@GetMapping("/EDbarrio/{id}")
	public String ObtenerFormularioEditarBarrio(Model model, @PathVariable(name="id") Long id) throws Exception {
		Barrio barrioEncontrado = barrioService.encontrarBarrio(id);
		model.addAttribute("barrioF", barrioEncontrado);
		model.addAttribute("editMode","true");
		return "Fbarrio";
	}
	
	@GetMapping("/ELbarrio/{id}")
	public String eliminar(Model model, @PathVariable(name="id") Long id) {
		barrioService.eliminar(id);
		return "redirect:/Lbarrios";
	}
	@PostMapping("/Mbarrio")
	public String postEditarBarrio(@ModelAttribute("barrioF") Barrio barrio, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("barrioF", barrio);
			model.addAttribute("editMode", "true");
		}else {
			try {
				barrioService.modificar(barrio);
				model.addAttribute("barrioF", unBarrio);
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				model.addAttribute("formBarrioErrorMessage", e.getMessage());
				model.addAttribute("barrioForm", barrio);
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("barrios", barrioService.listarBarrio());
		return "redirect:/Lbarrios";
	}
}


