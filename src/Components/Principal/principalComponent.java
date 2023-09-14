package Components.Principal;
import java.awt.event.ActionListener;

import Components.Grupo.grupoComponent;
import Components.Instructor.instructorComponent;
import Components.Monitor.monitorComponent;
import java.awt.event.ActionEvent;


public class principalComponent implements ActionListener{
    private principalTemplate principalTemplate;
    public principalComponent(){
        principalTemplate= new principalTemplate(this);
    }
    public principalTemplate getprincipalTemplate(){
        return principalTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(principalTemplate.getMonitor())){
            entrarMonitor();
        }
        if(e.getSource().equals(principalTemplate.getGrupo())){
           entrarGrupo();
        }
        if(e.getSource().equals(principalTemplate.getInstructor())){
           entrarInstructor();
        }
    }
   
    public void entrarGrupo(){
        grupoComponent vc= new grupoComponent();
        vc.getClass();
        principalTemplate.setVisible(false);        
    }
    public void entrarMonitor(){
        monitorComponent x = new monitorComponent();
        x.getClass();
        principalTemplate.setVisible(false);        
    }
    public void entrarInstructor(){
        instructorComponent x = new instructorComponent();
        x.getClass();
        principalTemplate.setVisible(false);        
    }
}
