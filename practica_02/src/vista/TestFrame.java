package vista;

import control.ManejaDatosEst;
import datos.ModeloTabla;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;


/**
 *
 * @author emman
 */


public class Interfaz extends JFrame {

     //ModeloTabla modTabla;
     private  static ModeloTabla modTabla = new ModeloTabla();
     private  static ManejaDatosEst baseDatos;
     //ModeloTabla mt=modTabla;
    //ManipulaDatos MD;

 
    public Interfaz( ModeloTabla modTabla ) throws ClassNotFoundException {
       
       setTitle("REGISTRO ACADEMICO");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       JPanel panelContenido = new JPanel(new FlowLayout(FlowLayout.CENTER));
       //JPanel panelContenido = new JPanel(new BoxLayout());
       panelContenido.setBackground(Color.WHITE);
      
       //añadiendo el panel al frame
    
       add(panelContenido );
       
       //contentPane.setBackground(Color.yellow);
        JLabel title= new JLabel("                                        "
                + "               AGREGA , VISUALIZA Y MODIFICA DATOS DE ESTUDIANTES:              "
                + "                                             ");
        title.setBounds(50,50,0,0);
        JLabel numC= new JLabel("Num de Control:");
        JLabel credits= new JLabel("200");
        JLabel name= new JLabel("Nombre:");
        JTextField nametxt = new JTextField(15);
        JLabel sexo= new JLabel("Sexo:");
        JRadioButton rbtn1=new JRadioButton("Mujer",true);
        JRadioButton rbtn2=new JRadioButton("Hombre",false);
        JLabel edad= new JLabel("Edad:");
        JSpinner edadS = new JSpinner();
		 edadS.setValue(18);
        JLabel semestre= new JLabel("Semestre:");
        JSpinner SemestreS = new JSpinner();
		 SemestreS.setValue(1);
        JLabel creditos= new JLabel("Creditos:");
        JSpinner creditosS = new JSpinner();
		 creditosS.setValue(1);
         JLabel carrera= new JLabel("Carrera:");
         JComboBox CarreraC= new JComboBox();
         CarreraC.addItem("CARRERAS");
         CarreraC.addItem("SISTEMAS");
         CarreraC.addItem("CIVIL");
         CarreraC.addItem("GESTION");
         CarreraC.addItem("ADMINISTRACION");
         CarreraC.addItem("ELECTRONICA");
         CarreraC.addItem("ELECTRICIDAD");
        JButton registrar = new JButton("Registrar");
        JButton terminar = new JButton("Terminar");
        
        String consulta = "SELECT *FROM ADMINISTRADOR.ESTUDIANTE";
        ModeloTabla mt=modTabla;
        ManejaDatosEst baseDatos = new ManejaDatosEst();
        mt.setDatos(baseDatos.consultaDatos(consulta),baseDatos);
        JTable tabla1= new JTable();
        tabla1.setModel(mt);
 
        
        panelContenido.add(title);
        panelContenido.add(numC);
        panelContenido.add(credits);
        panelContenido.add(name);
        panelContenido.add(nametxt);
        panelContenido.add(sexo);
        panelContenido.add(rbtn1);
        panelContenido.add(rbtn2);
        panelContenido.add(edad);
        panelContenido.add(edadS);
        panelContenido.add(semestre);
        panelContenido.add(SemestreS);
        panelContenido.add(creditos);
        panelContenido.add(creditosS);
        panelContenido.add(carrera);
        panelContenido.add(CarreraC);
        panelContenido.add(registrar);
        panelContenido.add(terminar);
        panelContenido.add(tabla1);   
        
        
    terminar.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
	 if(baseDatos.cerrarSesion()){
                   System.exit(0);
         }else{
               dispose();
         }
           }});




        }

    
     
    
       public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                   // 
                 // new TestFrame().setVisible(true);
                 //ModeloTabla tb = new ModeloTabla();
                  
                  Interfaz tf=new Interfaz(modTabla);
                  tf.setVisible(true);
                  tf.setSize(725, 500);
                   
                   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
