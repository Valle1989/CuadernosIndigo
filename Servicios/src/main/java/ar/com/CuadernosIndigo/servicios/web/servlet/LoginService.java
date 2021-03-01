package ar.com.CuadernosIndigo.servicios.web.servlet;

import ar.com.CuadernosIndigo.dto.LoginDto;
import ar.com.CuadernosIndigo.servicios.exceptions.ServicesException;

public interface LoginService {
	
	boolean login(LoginDto loginDto) throws ServicesException;
	
	public LoginDto ingresar(LoginDto loginDto) throws ServicesException;

}
