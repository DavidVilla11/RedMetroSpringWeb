package es.redmetro.dam2.controlador;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioControlador {
	@Value("${saludo}")
	private String saludo;
	
	@RequestMapping("/")
	public String inicio(Model modelo) {
		
		modelo.addAttribute("saludoDavid", saludo);
		
		return "Inicio/inicio";
	}
	
}
