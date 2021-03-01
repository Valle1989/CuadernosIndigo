package ar.com.CuadernosIndigo.web.servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ar.com.CuadernosIndigo.dto.LoginDto;
import ar.com.CuadernosIndigo.exceptions.DuplicatedException;
import ar.com.CuadernosIndigo.exceptions.GenericException;
import ar.com.CuadernosIndigo.jdbc.AdministradorDeConexiones;



public class LoginDaoJDBCImpl implements LoginDAO {

	@Override
	public boolean loguear(LoginDto loginDto) throws GenericException {
		
		//select * from usuarios where username='' and password = ''
		
		boolean existeUsuario;
		
		try {
			Connection conection = AdministradorDeConexiones.obtenerConexion();
			
			Statement st = conection.createStatement();
						
			ResultSet rs = 
					st.executeQuery("select * from usuarios where upper(username)='"+loginDto.getUserName().toUpperCase()+"' and upper(password )= '"+loginDto.getPassword().toUpperCase()+"'");
			
			existeUsuario = rs.next();
			
			conection.close();
			
			st.close();
			
			rs.close();
		}catch (Exception e) {
			throw new GenericException(e.getMessage(), e);
		}
		
		return existeUsuario;
	}

	@Override
	public LoginDto registrarse(LoginDto loginDto) throws GenericException , DuplicatedException {
		
		Connection con = null;
		
		Statement st = null;
		
			try {
			      con = AdministradorDeConexiones.obtenerConexion();
			      
			      con.setAutoCommit(false);
			      
			      st = con.createStatement();
			      
			      st.executeUpdate
			      ("insert into usuarios (username, password) values ('"+loginDto.getUserName()+"', '"+loginDto.getPassword()+"')", Statement.RETURN_GENERATED_KEYS);
			      
			      ResultSet rs=st.getGeneratedKeys();
					
			      if(rs.next()) loginDto.setId(rs.getInt(1));
			      
			      con.commit();
			      
			}catch(Exception e){
				e.printStackTrace();
			}
			try {
					con.rollback();
				} catch (SQLException e1) {
					throw new DuplicatedException("El id ingresado se encuentra duplicado");
			}finally{
				try {
					con.close();
					st.close();
				}catch(SQLException e){
					throw new GenericException(e.getMessage(), e);
				} 
		}
		return loginDto;
	}

}
