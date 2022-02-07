package es.redmetro.dam2.modelo.dao;

import java.util.List;

import es.redmetro.dam2.modelo.excepciones.RedMetroException;
import es.redmetro.dam2.modelo.vo.Color;

public interface IColorDao {
	
	public void crear(Color entidad) throws RedMetroException;
	public void borrar(Color entidad) throws RedMetroException;
	public void actualizar(Color entidad) throws RedMetroException;
	public Color getEntirdadPorID(int idEntidad) throws RedMetroException;
	public List<Color> getListaEntidades() throws RedMetroException;

}
