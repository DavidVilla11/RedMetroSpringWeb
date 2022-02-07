package es.redmetro.dam2;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.redmetro.dam2.modelo.dao.ILineaDao;
import es.redmetro.dam2.modelo.dao.jpa.LineaDaoJPA;
import es.redmetro.dam2.modelo.excepciones.RedMetroException;
import es.redmetro.dam2.modelo.vo.Linea;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
