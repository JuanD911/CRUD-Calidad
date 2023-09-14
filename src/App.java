import javax.swing.SwingUtilities;

import Components.Principal.principalComponent;

public class App {
	public static void main(String[] args){		
		Runnable run = new Runnable(){
			public void run() {
				principalComponent lig = new principalComponent();
				lig.getClass();
			}
		};
		SwingUtilities.invokeLater(run);
	}
}
