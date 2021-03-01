package ar.com.CuadernosIndigo.cuadernoDao;

import java.util.Collection;

import ar.com.CuadernosIndigo.entidades.Cuaderno;
import ar.com.CuadernosIndigo.exceptions.DuplicatedException;
import ar.com.CuadernosIndigo.exceptions.GenericException;

public interface CuadernoDao {
	
	public Cuaderno insertar(Cuaderno cuaderno) throws DuplicatedException, GenericException;
	
	public Cuaderno actualizar(Cuaderno cuaderno) throws GenericException;
	
	public void eliminar(int id) throws GenericException;
	
	public Collection<Cuaderno> obtenerCuadernos() throws GenericException;
	
	public Cuaderno obtenerCuaderno(int id) throws GenericException;

}
