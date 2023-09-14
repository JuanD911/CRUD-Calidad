package Components.Monitor;

import java.awt.event.ActionListener;
import Components.Monitor.monitorComponent;
import java.awt.event.ActionEvent;


public class monitorComponent implements ActionListener{
    private monitorTemplate monitorTemplate;
    public monitorComponent(){
        monitorTemplate= new monitorTemplate(this);
    }
    public monitorTemplate getmonitorTemplate(){
        return monitorTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(monitorTemplate.getEditar())){
            //Código de los DAOS
        }
        if(e.getSource().equals(monitorTemplate.getCrear())){
          //Código de los DAOS
        }
        if(e.getSource().equals(monitorTemplate.getEliminar())){
            //Código de los DAOS
        }
        if(e.getSource().equals(monitorTemplate.getConsultar())){
            //Código de los DAOS
        }
    }
   
    
}
