/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Comunicacion.ControladorComunicacion;
import Modelo.Carta;
import Modelo.Jugador;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author x
 */
public class TableroCartas implements ActionListener, Observer {
public int NUM_INTENTOS=2;
private int NUM_CARTAS=100;
int HEIGHT;
int WIDTH;

public ControladorComunicacion ctrlComunicacion;
public boolean esMiTurno=false;
public int numIntechosHechos=0;

public ArrayList<Carta> ordenImagenes;
JButton []arregloCartas = new JButton[NUM_CARTAS];//arreglo de botones
JPanel contenedorCartas;
JFrame ventanaCartas;
Jugador jugadorMemorama;


    public TableroCartas(boolean turno, ArrayList<Carta> ordenImagenes) {
        this.ventanaCartas=new JFrame("Memorama");
        this.ventanaCartas.setLayout(new BorderLayout(10, 20));
        this.ordenImagenes=ordenImagenes;
        this.esMiTurno=turno;
          MostrarCartas(ordenImagenes);
        
        ventanaCartas.add(this.contenedorCartas, BorderLayout.NORTH);
        ventanaCartas.setSize(1400, 600);
        ventanaCartas.setLocation(0, 0);
        ventanaCartas.setVisible(true);
        ventanaCartas.setResizable(true);
        ventanaCartas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
        
    }
    
      
    @Override
    public void actionPerformed(ActionEvent e) {
        if(esMiTurno){
            if(this.numIntechosHechos<2){
            int idImage=Integer.parseInt(e.getActionCommand());
            this.voltearCarta(idImage);
            this.numIntechosHechos++;
            }else{
                JOptionPane.showMessageDialog(ventanaCartas, "No es tu turno.");
            }
        }else{
            JOptionPane.showMessageDialog(ventanaCartas, "No es tu turno.");
        }
        
      
        
    }
    
    private void MostrarCartas(ArrayList <Carta> cartasVolteadas){
        this.contenedorCartas = new JPanel(new GridLayout(10, 10, 2, 2));
        this.contenedorCartas.removeAll();
        int idImage=25;
        File file;
        ImageIcon imagen;
       
        for(int i=arregloCartas.length-1; i>=0; i--){//ciclo para crear, añadir, establecer propiedades a los botones
            file =new File (cartasVolteadas.get(i).getUrlCarta());
            imagen=new ImageIcon(file.getAbsolutePath());  
            arregloCartas[i] = new JButton("" + (i + 1), imagen);
            arregloCartas[i].setSize(50, 50);
            this.contenedorCartas.add(arregloCartas[i]);
            arregloCartas[i].setMargin(new Insets(0, 0, 0, 0));
            arregloCartas[i].addActionListener(this);
            
         
            
        }
    }
    
    
    private void MostrarGanador(){
    
    }

   
private void voltearCarta(int idImage){
        Carta cartaPorVoltear=this.ordenImagenes.get(idImage-1);
        File file=new File(cartaPorVoltear.getUrlCarta());
        ImageIcon imagen=new ImageIcon(file.getAbsolutePath());
        System.out.println(file.getAbsolutePath());
        arregloCartas[idImage-1].setIcon(imagen);
        
}

    @Override
    public void update(Observable o, Object arg) {
        
    }
 
    
}
