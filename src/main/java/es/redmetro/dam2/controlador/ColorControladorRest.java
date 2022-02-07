package es.redmetro.dam2.controlador;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import es.redmetro.dam2.modelo.dao.IColorDao;
import es.redmetro.dam2.modelo.dao.jpa.ColorDaoJPA;
import es.redmetro.dam2.modelo.excepciones.RedMetroException;
import es.redmetro.dam2.modelo.vo.Color;

@RestController
public class ColorControladorRest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(path = "/rest/colores", produces={"application/json"})
	public List<Color> listarColores() {
		List<Color> listaColores = null;
		try {
		
			IColorDao colores = new ColorDaoJPA();
			listaColores = colores.getListaEntidades();
			
			
		} catch (RedMetroException e) {
			e.printStackTrace();
		}
		
		return listaColores;
	}

}
