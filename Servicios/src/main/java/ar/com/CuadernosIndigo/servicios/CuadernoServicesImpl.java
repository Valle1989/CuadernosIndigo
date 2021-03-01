package ar.com.CuadernosIndigo.servicios;

import java.util.Collection;

import ar.com.CuadernosIndigo.cuadernoDao.CuadernoDao;
import ar.com.CuadernosIndigo.cuadernoDao.CuadernoDaoJdbcImpl;
import ar.com.CuadernosIndigo.entidades.Cuaderno;
import ar.com.CuadernosIndigo.exceptions.DuplicatedException;
import ar.com.CuadernosIndigo.exceptions.GenericException;
import ar.com.CuadernosIndigo.servicios.exceptions.ServicesException;

public class CuadernoServicesImpl implements CuadernoServices {
	
	private CuadernoDao cuadernoDao;

	public CuadernoServicesImpl(CuadernoDao cuadernoDao) {
		super();
		this.cuadernoDao = new CuadernoDaoJdbcImpl();
	}

	@Override
	public Cuaderno save(Cuaderno cuaderno) throws ServicesException {
		
		try {
			return this.cuadernoDao.insertar(cuaderno);
		} catch (DuplicatedException | GenericException e) {
			e.printStackTrace();
			throw new ServicesException(e.getMessage(), e);
		}
	}

	@Override
	public Cuaderno update(Cuaderno cuaderno) throws ServicesException {
		
		try {
			return this.cuadernoDao.actualizar(cuaderno);
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServicesException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(int id) throws ServicesException {
		try {
			this.cuadernoDao.eliminar(id);
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServicesException(e.getMessage(), e);
		}
		
	}

	@Override
	public Collection<Cuaderno> findCuadernos() throws ServicesException {

		try {
			return this.cuadernoDao.obtenerCuadernos();
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServicesException(e.getMessage(), e);
		}
	}

	@Override
	public Cuaderno getCuaderno(int id) throws ServicesException {
		
		try {
			return this.cuadernoDao.obtenerCuaderno(id);
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServicesException(e.getMessage(), e);
		}
	}

}
