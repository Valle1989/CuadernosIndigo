package ar.com.CuadernosIndigo.web.servlet;

import ar.com.CuadernosIndigo.dto.LoginDto;
import ar.com.CuadernosIndigo.exceptions.DuplicatedException;
import ar.com.CuadernosIndigo.exceptions.GenericException;

public interface LoginDAO {
	
	boolean loguear(LoginDto loginDto) throws GenericException;
	
	public LoginDto registrarse(LoginDto loginDto) throws GenericException, DuplicatedException;

}
