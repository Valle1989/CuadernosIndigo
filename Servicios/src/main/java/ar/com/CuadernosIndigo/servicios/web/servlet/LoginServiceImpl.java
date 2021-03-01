package ar.com.CuadernosIndigo.servicios.web.servlet;

import ar.com.CuadernosIndigo.dto.LoginDto;
import ar.com.CuadernosIndigo.exceptions.DuplicatedException;
import ar.com.CuadernosIndigo.exceptions.GenericException;
import ar.com.CuadernosIndigo.servicios.exceptions.ServicesException;
import ar.com.CuadernosIndigo.web.servlet.LoginDAO;
import ar.com.CuadernosIndigo.web.servlet.LoginDaoJDBCImpl;

public class LoginServiceImpl implements LoginService {

private LoginDAO loginDao;
	
	public LoginServiceImpl() {
		this.loginDao = new LoginDaoJDBCImpl();
	}
	
	@Override
	public boolean login(LoginDto loginDto) throws ServicesException {		
		try {
			return loginDao.loguear(loginDto);
		} catch (GenericException e) {
			throw new ServicesException(e.getMessage(), e);
		}
	}

	@Override
	public LoginDto ingresar(LoginDto loginDto) throws ServicesException {
		
		try {
			return loginDao.registrarse(loginDto);
		} catch (GenericException | DuplicatedException e) {
			e.printStackTrace();
			throw new ServicesException(e.getMessage(), e);
		}
	}

}
