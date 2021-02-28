package ar.com.CuadernosIndigo.cuadernoDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.CuadernosIndigo.entidades.Cuaderno;
import ar.com.CuadernosIndigo.enums.Interiores;
import ar.com.CuadernosIndigo.exceptions.DuplicatedException;
import ar.com.CuadernosIndigo.exceptions.GenericException;
import ar.com.CuadernosIndigo.jdbc.AdministradorDeConexiones;

public class CuadernoDaoJdbcImpl implements CuadernoDao {

	@Override
	public Cuaderno insertar(Cuaderno cuaderno) throws DuplicatedException, GenericException {
		
		Connection con = null;
		
		Statement st = null;
		
			try {
			      con = AdministradorDeConexiones.obtenerConexion();
			      
			      con.setAutoCommit(false);
			      
			      st = con.createStatement();
			      
			      st.executeUpdate
			      ("insert into cuaderno (tapas, interiores) values ("+cuaderno.getTapas()+", '"+cuaderno.getInteriores().toString()+"')", Statement.RETURN_GENERATED_KEYS);
			      
			      ResultSet rs=st.getGeneratedKeys();
					
			      if(rs.next()) cuaderno.setId(rs.getInt(1));
			      
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
		return cuaderno;
	}

	@Override
	public Cuaderno actualizar(Cuaderno cuaderno) throws GenericException {
		
		Connection connection = null;
		Statement st = null;
		try {
			
			connection = AdministradorDeConexiones.obtenerConexion();
			
			connection.setAutoCommit(false);
			
			st = connection.createStatement();
			
			int rows = st.executeUpdate("UPDATE cuaderno SET tapas="+ cuaderno.getTapas()+" , interiores='"+ cuaderno.getInteriores().toString()+"'  WHERE id="+cuaderno.getId()+"" );
			
			connection.commit();
			
		} catch (Exception e) {	
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new GenericException(e1.getMessage(), e1);
			}
		} finally {
			try {
				st.close();
				connection.close();
			} catch (SQLException e) {
				throw new GenericException(e.getMessage(), e);
			}
		}
		return cuaderno;
	}

	@Override
	public void eliminar(int id) throws GenericException {
		
		Connection connection = null;
		
		Statement st = null;
		try {
			
			connection = AdministradorDeConexiones.obtenerConexion();
			
			connection.setAutoCommit(false);
			
			st = connection.createStatement();
			
			int rows = st.executeUpdate("DELETE FROM cuaderno where id = " + id);
			
			if(rows > 0) {
			
				connection.commit();
			} else {
				throw new GenericException("No existe el cuaderno con id= " + id);
			}
		} catch (Exception e) {	
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new GenericException(e1.getMessage(), e1);
			}
		} finally {
			try {
				st.close();
				connection.close();
			} catch (SQLException e) {
				throw new GenericException(e.getMessage(), e);
			}
		}
		
	}

	@Override
	public Collection<Cuaderno> obtenerCuadernos() throws GenericException {
		
		Collection<Cuaderno> cuadernos = new ArrayList<Cuaderno>();
		
		try {
			Connection conection = AdministradorDeConexiones.obtenerConexion();
			
			Statement st = conection.createStatement();
						
			//volver a consultar pero ahora todos los cuadernos
			ResultSet rs = st.executeQuery("SELECT * FROM cuaderno");
			
			Cuaderno cuaderno = null;
			
			while(rs.next()) {
				//obtener los datos desde el rs
				int id = rs.getInt(1);
				int tapas = rs.getInt(2);
				String interiores = rs.getString(3);
				
				cuaderno = new Cuaderno(id, tapas, Interiores.valueOf(interiores));
				cuadernos.add(cuaderno);		
			}
			conection.close();
			return cuadernos;
		} catch (Exception e) {			
			e.printStackTrace();
			throw new GenericException(e.getMessage());
		}
	}

	@Override
	public Cuaderno obtenerCuaderno(int id) throws GenericException {
		
		Connection con = null;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		Cuaderno cuaderno = null;
		
		try {
			con = AdministradorDeConexiones.obtenerConexion();
			
			st = con.createStatement();
			
			rs = st.executeQuery("Select * From cuaderno where Id = " + id);
			
			if(rs.next()) {
				int idAux = rs.getInt(1);
				int tapas = rs.getInt(2);
				String interiores = rs.getNString(3);
				
			 cuaderno = new Cuaderno(idAux, tapas, Interiores.valueOf(interiores));
			}
		} catch (Exception e) {
			
			try {
				con.rollback();
			}catch(SQLException e1) {
				throw new GenericException(e1.getMessage(), e1);
			}
		}finally {
			try {
				con.close();
				st.close();
			}catch(SQLException e) {
				throw new GenericException(e.getMessage(), e);
			}
		}
		
		return cuaderno;
	}

}
