import java.awt.EventQueue;

import javax.swing.SwingUtilities;

//import Components.Principal.principalComponent;
import controlador.BD_Conexion;
import vista.Principal;

public class App {
	
	public static void main(String[] args) {
		BD_Conexion.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmMonitor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
