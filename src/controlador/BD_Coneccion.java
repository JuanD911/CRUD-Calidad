package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class BD_Coneccion {
    private static Connection db = null ;
    private String driver = "jdbc:mysql";
    private String url = "db-prog-avanzada-g81.cq73qyc2lysx.us-east-1.rds.amazonaws.com";
    private int puerto = 5432;
    private String bd = "CRUD_DAPS";

    public BD_Coneccion() {
    	
        if (db == null) {
            try {
            	Class.forName("com.mysql.jdbc.Driver");
                db = DriverManager.getConnection(driver + "://" + url + ":" + puerto + "/" + bd, "prog_avanzada", "jddr0911");
            } catch (SQLException ex) {
            	System.out.println("error con el driver 0");
                Logger.getLogger(BD_Coneccion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException e) {
				System.out.println("error con el driver");
				e.printStackTrace();
			}
        }
    }

    public static Connection devolverConexion() {
    	
        if (db == null) {
            new BD_Coneccion();
        }
        return db;
    }
    
    public static void cerrarConexion(){
        if(db!=null){
            try {
                db.close();
            } catch (SQLException ex) {
                Logger.getLogger(BD_Coneccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	
}