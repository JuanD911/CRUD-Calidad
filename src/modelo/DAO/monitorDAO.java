package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import controlador.BD_Conexion;
import modelo.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class monitorDAO {

    private Monitor m;
    private Connection connection;
    private PreparedStatement query;
	private List<Monitor> listaMonitores;
    
	private final String[] QUERIES = {
		"INSERT INTO monitores (nombre, telefono, direccion, correo, fecha_nacimiento) VALUES (?,?,?,?,?)",
		"SELECT * FROM monitores",
		"UPDATE monitores SET nombre = ?, telefono = ?, direccion = ?, correo = ?, fecha_nacimiento = ? WHERE (id = ?)",
		"DELETE FROM monitores WHERE (id = ?)",
		"SELECT * FROM monitores WHERE id = ?"
	};

    public monitorDAO() {
    	connection = BD_Conexion.getInstance().getConnection();
    	listaMonitores = new ArrayList();
    	m = new Monitor();
    }
	
    public void agregarMonitor(String nombre, String telefono, String direccion, String correo, String f_nacimiento) {
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
    
    public List<Monitor> consultarMonitores(){
    	try {
    		
    		query = connection.prepareStatement(QUERIES[1]);
    		ResultSet response = query.executeQuery();
    		
    		while(response.next()) {
    			listaMonitores.add(new Monitor(response.getInt("id"), response.getString("nombre"), response.getString("telefono"), response.getString("direccion"), response.getString("correo"), response.getString("fecha_nacimiento")));
    		}
    	}catch (SQLException e) {
			System.out.println("Error al actualizar");
			e.printStackTrace();
    	}
    	System.out.println("si");
    	return listaMonitores;
    	  
   }
    
    public void eliminarMonitor(int id) {
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
    
    public void actualizarMonitor(int id, String nombre, String telefono, String direccion, String correo, String f_nacimiento) {
    	
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
    
    public Monitor ponerMonitorEnTextFields(int id) {
    	
    	try {
    		
    		query = connection.prepareStatement(QUERIES[4]);
    		query.setInt(1, id);
    		
    		ResultSet response = query.executeQuery();
    		
    		if(response.next()) {
    			m.setId(response.getInt("id"));
    			m.setNombre(response.getString("nombre"));
    			m.setTelefono(response.getString("telefono"));
    			m.setDireccion(response.getString("direccion"));
    			m.setC_electronico(response.getString("correo"));
    			m.setF_nacimiento(response.getString("fecha_nacimiento"));
    		}
    		
    		System.out.println(query);
    		
    		query.executeUpdate();
    		} catch (SQLException e) {
    			System.out.println("Error al actualizar");
    			e.printStackTrace();
    		}
    	
    	return m;
    }
}
