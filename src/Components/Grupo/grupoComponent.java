package Components.Grupo;

import java.awt.event.ActionListener;

import Components.Grupo.grupoComponent;

import java.awt.event.ActionEvent;


public class grupoComponent implements ActionListener{
    private grupoTemplate grupoTemplate;
    public grupoComponent(){
        grupoTemplate= new grupoTemplate(this);
    }
    public grupoTemplate getgrupoTemplate(){
        return grupoTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(grupoTemplate.getEditar())){
            //Código de los DAOS
        }
        if(e.getSource().equals(grupoTemplate.getCrear())){
          //Código de los DAOS
        }
        if(e.getSource().equals(grupoTemplate.getEliminar())){
         //Código de los DAOS
        }
        if(e.getSource().equals(grupoTemplate.getConsultar())){
            //Código de los DAOS
        }
    }
   
    
}
