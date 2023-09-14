package Components.Principal;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Services.ObjGraficService;

public class principalTemplate extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //declaracion de objetos graficos
    private JPanel Panel;
    private JLabel lab;
    private JButton bGrupo,bMonitor,bInstructor;

    //declaración de servicios
    private ObjGraficService sObjGrafics;
    //declaración componente
    private principalComponent principalComponent;

    public principalTemplate(principalComponent principalComponent) {
        sObjGrafics= ObjGraficService.getService();
        this.principalComponent= principalComponent;
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
        lab= sObjGrafics.construirJLabel("Seleccione su tipo de usuario", ((Panel.getWidth())/2)-250,30, 500, 100,
        null, null, new Font("arial",Font.BOLD,30), null, Color.white, null, "c");
        Panel.add(lab);
    }
    public void crearJButton(){
        //boton Grupo
        bGrupo= sObjGrafics.construirJButton("Grupos", (((Panel.getWidth()-300)/2)-200),285,200, 50, 
         null, null, new Font("arial",Font.BOLD,16), Color.red, Color.white, null, "", true);
        bGrupo.addActionListener(principalComponent);
        Panel.add(bGrupo);
        
        //botón Monitores
        bMonitor= sObjGrafics.construirJButton("Monitores ",((Panel.getWidth()-120)/2)+235,285,200, 50, 
         null,  null, new Font("arial",Font.BOLD,16),Color.RED ,Color.WHITE, null, "", true);
        bMonitor.addActionListener(principalComponent);
        Panel.add(bMonitor);

        // botón instructor
        bInstructor= sObjGrafics.construirJButton("Instructores ",((Panel.getWidth()-120)/2)-25,285,200, 50, 
        null,  null, new Font("arial",Font.BOLD,16),Color.RED ,Color.WHITE, null, "", true);
        bInstructor.addActionListener(principalComponent);
        Panel.add(bInstructor);
    }
    public JButton getGrupo(){return bGrupo;}
    public JButton getMonitor(){return bMonitor;}
    public JButton getInstructor(){return bInstructor;}
 
    
}
