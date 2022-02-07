package es.redmetro.dam2.controlador;

import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.redmetro.dam2.modelo.dao.ILineaDao;
import es.redmetro.dam2.modelo.dao.jpa.LineaDaoJPA;
import es.redmetro.dam2.modelo.excepciones.RedMetroException;
import es.redmetro.dam2.modelo.vo.Linea;

@Controller
public class LineaControlador {
	
 	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/lineas")
	public String listarLineas(Model modelo) {
		
		try {
			ILineaDao lineas = new LineaDaoJPA();
			List<Linea> listaLineas = lineas.getListaEntidades();
			
			modelo.addAttribute("lineas", listaLineas);

		} catch (RedMetroException e) {
			e.printStackTrace();
		}
		
		return "Lineas/listalineas";
	}

}
