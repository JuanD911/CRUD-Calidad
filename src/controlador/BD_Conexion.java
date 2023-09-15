package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BD_Conexion {

    private static BD_Conexion connectInstance;
    private Connection connection;
    private final String URL = "jdbc:postgresql://localhost:5432/CRUD_DAPS";
    private final   String USER = "postgres";
    private final String PASSWORD = "jddr0911";
    
    private BD_Conexion() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado!");
        } catch (SQLException ex) {
            Logger.getLogger(BD_Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            System.out.println("OK ");
        }
    }

    public static BD_Conexion getInstance(){
        if (connectInstance == null ){
            connectInstance = new BD_Conexion();
        }
        return connectInstance;
    }
       
    public Connection getConnection(){
        return connection;
    }

}