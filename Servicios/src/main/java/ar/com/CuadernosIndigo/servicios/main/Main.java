package ar.com.CuadernosIndigo.servicios.main;

import ar.com.CuadernosIndigo.dto.LoginDto;
import ar.com.CuadernosIndigo.servicios.exceptions.ServicesException;
import ar.com.CuadernosIndigo.servicios.web.servlet.LoginService;
import ar.com.CuadernosIndigo.servicios.web.servlet.LoginServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		LoginService ls = new LoginServiceImpl();
		
		LoginDto login = new LoginDto("melisa.lieby@gmail.com","kala");
		
		try {
			ls.ingresar(login);
		} catch (ServicesException e) {
			e.printStackTrace();
		}

	}

}
