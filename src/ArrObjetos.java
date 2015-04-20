
 
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class ArrObjetos implements ActionListener{
 
    JButton []arrBtn = new JButton[100];//arreglo de botones
    JPanel jp1;
    JLabel jl1, jl2;
 boolean estaBloqueado=false;
  JFrame frMain;
    private ArrObjetos (){//constructor de la clase
 
        frMain = new JFrame("Arreglo de Botones");
        frMain.setLayout(new BorderLayout(10, 20));
 
        jl1 = new JLabel();//creacion jlabel que muestra el numero pulsado     
        jl1.setText("Aquí ira el numero que se pulse");
 
        mostrarBot();
 
        frMain.add(jl1, BorderLayout.SOUTH);
        frMain.add(jp1, BorderLayout.NORTH);
 
        frMain.setSize(1200, 600);
        frMain.setLocation(0, 0);
        frMain.setVisible(true);
        frMain.setResizable(true);
        frMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
 
    public void mostrarBot(){//metodo donde se encontrara el jpanel que contiene los botones
        jp1 = new JPanel(new GridLayout(10, 10, 2, 2));
        int idImage=24;
        File file=new File("src/images/"+idImage+".jpg");
       ImageIcon imagen=new ImageIcon(file.getAbsolutePath());
       
        for(int i=arrBtn.length-1; i>=0; i--){//ciclo para crear, añadir, establecer propiedades a los botones
            arrBtn[i] = new JButton(""+(i+1), imagen);
            arrBtn[i].setSize(50, 50);
            
            System.out.println(arrBtn[i].getUIClassID());
            
            System.out.println(file.getAbsolutePath());
            
            jp1.add(arrBtn[i]);
            arrBtn[i].setMargin(new Insets(0, 0, 0, 0));
            arrBtn[i].addActionListener(this);
            
            System.out.println(i);
        }//fin ciclo
    }
 
    public static void main(String[] args) {        
        ArrObjetos trin = new ArrObjetos(); //se invoca el constructor        
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {        
        jl1.setText(e.getActionCommand());//cuando se presione un boton se mostrara el numero en el jlabel
        mostrarBot();
    }
}