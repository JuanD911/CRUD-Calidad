package Components.Monitor;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Services.ObjGraficService;

public class monitorTemplate extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //declaracion de objetos graficos
    private JPanel Panel;
    private JLabel lab;
    private JButton bCrear,bEditar,bEliminar,bConsultar;

    //declaración de servicios
    private ObjGraficService sObjGrafics;
    //declaración componente
    private monitorComponent monitorComponent;

    public monitorTemplate(monitorComponent monitorComponent) {
        sObjGrafics= ObjGraficService.getService();
        this.monitorComponent= monitorComponent;
        //ventana
        setTitle("vista de usuario");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setLayout(null);
        setVisible(true);
        //funciones
        crearJPanel();
        crearJButton();
        crearJLabels();
    }
    public void crearJPanel(){
        //panel1
        Panel=sObjGrafics.construirPanel(800, 400,0,0,Color.black);
        this.add(Panel);
    }
    public void crearJLabels(){
       //label 
        lab= sObjGrafics.construirJLabel("Seleccione la acción que desea realizar", ((Panel.getWidth())/2)-350,30, 700, 100,
        null, null, new Font("arial",Font.BOLD,30), null, Color.white, null, "c");
        Panel.add(lab);
    }
    public void crearJButton(){
        //boton Crear
        bCrear= sObjGrafics.construirJButton("Crear Monitor", (((Panel.getWidth()-300)/2)-210),285,150, 50, 
         null, null, new Font("arial",Font.BOLD,16), Color.red, Color.white, null, "", true);
        bCrear.addActionListener(monitorComponent);
        Panel.add(bCrear);
        
        //botón Editar
        bEditar= sObjGrafics.construirJButton("Editar Monitor ",((Panel.getWidth()-120)/2)+270,285,150, 50, 
         null,  null, new Font("arial",Font.BOLD,16),Color.RED ,Color.WHITE, null, "", true);
        bEditar.addActionListener(monitorComponent);
        Panel.add(bEditar);

        // botón Eliminar
        bEliminar= sObjGrafics.construirJButton("Eliminar Monitor",((Panel.getWidth()-120)/2)-120,285,150, 50, 
        null,  null, new Font("arial",Font.BOLD,16),Color.RED ,Color.WHITE, null, "", true);
        bEliminar.addActionListener(monitorComponent);
        Panel.add(bEliminar);

        // botón Consultar
        bConsultar= sObjGrafics.construirJButton("Consultar Monitor",((Panel.getWidth()-120)/2)+60,285,180, 50, 
        null,  null, new Font("arial",Font.BOLD,16),Color.RED ,Color.WHITE, null, "", true);
        bConsultar.addActionListener(monitorComponent);
        Panel.add(bConsultar);
    }
    public JButton getCrear(){return bCrear;}
    public JButton getEditar(){return bEditar;}
    public JButton getEliminar(){return bEliminar;}
    public JButton getConsultar(){return bConsultar;}
}
