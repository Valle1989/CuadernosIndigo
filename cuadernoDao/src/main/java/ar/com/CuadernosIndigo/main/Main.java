package ar.com.CuadernosIndigo.main;

import java.util.Collection;

import ar.com.CuadernosIndigo.cuadernoDao.CuadernoDao;
import ar.com.CuadernosIndigo.cuadernoDao.CuadernoDaoJdbcImpl;
import ar.com.CuadernosIndigo.entidades.Cuaderno;
import ar.com.CuadernosIndigo.enums.Interiores;
import ar.com.CuadernosIndigo.exceptions.DuplicatedException;
import ar.com.CuadernosIndigo.exceptions.GenericException;

public class Main {

	public static void main(String[] args) throws DuplicatedException, GenericException {
		
		CuadernoDao cd = new CuadernoDaoJdbcImpl();
		
		Cuaderno cuaderno = new Cuaderno(9, Interiores.CuadernoPediátrico);
		
		cd.insertar(cuaderno);
		
		System.out.println(cuaderno);
		
		//Obtener cuaderno
		//Cuaderno cuaderno = cd.obtenerCuaderno(9);
		//System.out.println(cuaderno);
		
		//Eliminar Cuaderno
//		Collection<Cuaderno> cuadernos = cd.obtenerCuadernos();
//		
//		if(!cuadernos.isEmpty()) {
//			
//			Cuaderno c = cuadernos.iterator().next();
//			
//			cd.eliminar(c.getId());
//		}
		
		//cd.eliminar(15);
		
		//Actualizar cuaderno
		
//		Cuaderno cuaderno = new Cuaderno(10, 5, Interiores.Liso);
//		
//		cd.actualizar(cuaderno);
//		
//		System.out.println(cuaderno);
		
		//Obtener Collection de cuadernos
		
//		Collection<Cuaderno> cuadernos = cd.obtenerCuadernos();
//		
//		System.out.println(cuadernos);
		
		
		  

	}

}
