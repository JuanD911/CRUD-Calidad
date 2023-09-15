package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import controlador.BD_Conexion;
import modelo.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class grupoDAO {

    private Grupo g;
    private Connection connection;
    private PreparedStatement query;
	private List<Grupo> listaGrupos;
    
	private final String[] QUERIES = {
		"INSERT INTO grupos (monitor, instructor, nombre) VALUES (?,?,?)",
		"SELECT * FROM grupos",
		"UPDATE grupos SET monitor = ?, instructor = ?, nombre = ? WHERE (id = ?)",
		"DELETE FROM grupos WHERE (id = ?)",
		"SELECT * FROM grupos WHERE id = ?"
	};

    public grupoDAO() {
    	connection = BD_Conexion.getInstance().getConnection();
    	listaGrupos = new ArrayList();
    	g = new Grupo();
    }
	
    public void agregarGrupo(int monitor, int instructor, String nombre) {
		try {
	
		query = connection.prepareStatement(QUERIES[0]);
		query.setInt(1, monitor);
		query.setInt(2, instructor);
		query.setString(3, nombre);
		
		System.out.println(query);
		
		query.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al actualizar");
			e.printStackTrace();
		}
	}
    
    public List<Grupo> consultarGrupos(){
    	try {
    		
    		query = connection.prepareStatement(QUERIES[1]);
    		ResultSet response = query.executeQuery();
    		
    		while(response.next()) {
    			listaGrupos.add(new Grupo(response.getInt("id"), response.getString("nombre"), response.getInt("monitor"), response.getInt("instructor")));
    		}
    	}catch (SQLException e) {
			System.out.println("Error al actualizar");
			e.printStackTrace();
    	}
    	System.out.println("si");
    	return listaGrupos;
    	  
   }
    
    public void eliminarGrupo(int id) {
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
    
    public void actualizarGrupo(int id, int monitor, int instructor, String nombre) {
    	
    	try {
    		
    		query = connection.prepareStatement(QUERIES[2]);
    		query.setInt(1, monitor);
    		query.setInt(2, instructor);
    		query.setString(3, nombre);
    		query.setInt(4, id);
    		
    		System.out.println(query);
    		
    		query.executeUpdate();
    		} catch (SQLException e) {
    			System.out.println("Error al actualizar");
    			e.printStackTrace();
    		}
    }
    
    public Grupo ponerGrupoEnTextFields(int id) {
    	
    	try {
    		
    		query = connection.prepareStatement(QUERIES[4]);
    		query.setInt(1, id);
    		
    		ResultSet response = query.executeQuery();
    		
    		if(response.next()) {
    			g.setId(response.getInt("id"));
    			g.setNombre(response.getString("nombre"));
    		}
    		
    		System.out.println(query);
    		
    		query.executeUpdate();
    		} catch (SQLException e) {
    			System.out.println("Error al actualizar");
    			e.printStackTrace();
    		}
    	
    	return g;
    }
}
