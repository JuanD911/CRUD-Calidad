package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import controlador.BD_Conexion;
import modelo.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class instructorDAO {

    private Instructor i;
    private Connection connection;
    private PreparedStatement query;
	private List<Instructor> listaInstructores;
    
	private final String[] QUERIES = {
		"INSERT INTO instructores (nombre, telefono, direccion, correo, fecha_nacimiento) VALUES (?,?,?,?,?)",
		"SELECT * FROM instructores",
		"UPDATE instructores SET nombre = ?, telefono = ?, direccion = ?, correo = ?, fecha_nacimiento = ? WHERE (id = ?)",
		"DELETE FROM instructores WHERE (id = ?)",
		"SELECT * FROM instructores WHERE id = ?"
	};

    public instructorDAO() {
    	connection = BD_Conexion.getInstance().getConnection();
    	listaInstructores = new ArrayList();
    	i = new Instructor();
    }
	
    public void agregarInstructor(String nombre, String telefono, String direccion, String correo, String f_nacimiento) {
		try {
	
		query = connection.prepareStatement(QUERIES[0]);
		query.setString(1, nombre);
		query.setString(2, telefono);
		query.setString(3, direccion);
		query.setString(4, correo);
		query.setString(5, f_nacimiento);
		
		System.out.println(query);
		
		query.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al actualizar");
			e.printStackTrace();
		}
	}
    
    public List<Instructor> consultarInstructores(){
    	try {
    		
    		query = connection.prepareStatement(QUERIES[1]);
    		ResultSet response = query.executeQuery();
    		
    		while(response.next()) {
    			listaInstructores.add(new Instructor(response.getInt("id"), response.getString("nombre"), response.getString("telefono"), response.getString("direccion"), response.getString("correo"), response.getString("fecha_nacimiento")));
    		}
    	}catch (SQLException e) {
			System.out.println("Error al actualizar");
			e.printStackTrace();
    	}
    	System.out.println("si");
    	return listaInstructores;
    	  
   }
    
    public void eliminarInstructor(int id) {
    	try {
    		
    		query = connection.prepareStatement(QUERIES[3]);
    		query.setInt(1, id);
    		
    		System.out.println(query);
    		
    		query.executeUpdate();
    		} catch (SQLException e) {
    			System.out.println("Error al actualizar");
    			e.printStackTrace();
    		}
    }
    
    public void actualizarInstructor(int id, String nombre, String telefono, String direccion, String correo, String f_nacimiento) {
    	
    	try {
    		
    		query = connection.prepareStatement(QUERIES[2]);
    		query.setString(1, nombre);
    		query.setString(2, telefono);
    		query.setString(3, direccion);
    		query.setString(4, correo);
    		query.setString(5, f_nacimiento);
    		query.setInt(6, id);
    		
    		System.out.println(query);
    		
    		query.executeUpdate();
    		} catch (SQLException e) {
    			System.out.println("Error al actualizar");
    			e.printStackTrace();
    		}
    }
    
    public Instructor ponerInstructorEnTextFields(int id) {
    	
    	try {
    		
    		query = connection.prepareStatement(QUERIES[4]);
    		query.setInt(1, id);
    		
    		ResultSet response = query.executeQuery();
    		
    		if(response.next()) {
    			i.setId(response.getInt("id"));
    			i.setNombre(response.getString("nombre"));
    			i.setTelefono(response.getString("telefono"));
    			i.setDireccion(response.getString("direccion"));
    			i.setC_electronico(response.getString("correo"));
    			i.setF_nacimiento(response.getString("fecha_nacimiento"));
    		}
    		
    		System.out.println(query);
    		
    		query.executeUpdate();
    		} catch (SQLException e) {
    			System.out.println("Error al actualizar");
    			e.printStackTrace();
    		}
    	
    	return i;
    }
}