package ar.com.CuadernosIndigo.servicios;

import java.util.Collection;

import ar.com.CuadernosIndigo.entidades.Cuaderno;
import ar.com.CuadernosIndigo.servicios.exceptions.ServicesException;

public interface CuadernoServices {
	
	public Cuaderno save(Cuaderno cuaderno) throws ServicesException;
	
	public Cuaderno update(Cuaderno cuaderno) throws ServicesException;
	
	public void delete(int id) throws ServicesException;
	
	public Collection<Cuaderno> findCuadernos() throws ServicesException;
	
	public Cuaderno getCuaderno(int id) throws ServicesException;

}
