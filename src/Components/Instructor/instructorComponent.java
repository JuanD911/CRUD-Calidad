package Components.Instructor;

import java.awt.event.ActionListener;

import Components.Instructor.instructorComponent;

import java.awt.event.ActionEvent;


public class instructorComponent implements ActionListener{
    private instructorTemplate instructorTemplate;
    public instructorComponent(){
        instructorTemplate= new instructorTemplate(this);
    }
    public instructorTemplate getinstructorTemplate(){
        return instructorTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(instructorTemplate.getEditar())){
            //Código de los DAOS
        }
        if(e.getSource().equals(instructorTemplate.getCrear())){
          //Código de los DAOS
        }
        if(e.getSource().equals(instructorTemplate.getEliminar())){
         //Código de los DAOS
        }
        if(e.getSource().equals(instructorTemplate.getConsultar())){
         //Código de los DAOS
        }
    }
   
    
}
