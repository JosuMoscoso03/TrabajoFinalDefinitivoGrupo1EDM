package ar.edu.unju.edm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AplicacionController {

	@GetMapping({"/login" , "/"})
	public String obtenerLogin(Model model) {
		
		return "login";
	}

	@GetMapping("/indexConsultor")
	public String obtenerC(Model model) {
		return "indexConsultor";
	}
	
	@GetMapping("/indexBD")
	public String obtenerB(Model model) {
		return "indexbd";
	}
	
	@GetMapping("/logout")
    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
          
        return "redirect:/login?logout";
    }
}
