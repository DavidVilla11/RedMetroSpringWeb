package es.redmetro.dam2.controlador;

import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.redmetro.dam2.modelo.dao.ILineaDao;
import es.redmetro.dam2.modelo.dao.jpa.LineaDaoJPA;
import es.redmetro.dam2.modelo.excepciones.RedMetroException;
import es.redmetro.dam2.modelo.vo.Linea;

@RestController
public class LineaControladorRest {
	
 	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/rest/lineas")
	public List<Linea> listarLineas() {
		List<Linea> listaLineas = null;
		try {
			ILineaDao lineas = new LineaDaoJPA();
			listaLineas = lineas.getListaEntidades();
			

		} catch (RedMetroException e) {
			e.printStackTrace();
		}
		
		return listaLineas;
	}

}
