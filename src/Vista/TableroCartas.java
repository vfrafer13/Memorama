/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Carta;
import Modelo.Jugador;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author x
 */
public class TableroCartas implements ActionListener {
public int NUM_INTENTOS=2;
public boolean esMiTurno=false;
private int NUM_CARTAS=100;
int HEIGHT;
int WIDTH;

public ArrayList<Carta> ordenImagenes;
JButton []arregloCartas = new JButton[NUM_CARTAS];//arreglo de botones
JPanel contenedorCartas;
JFrame ventanaCartas;
Jugador jugadorMemorama;



    public TableroCartas(boolean turno, ArrayList<Carta> ordenImagenes) {
        this.ventanaCartas=new JFrame("Memorama");
        this.ventanaCartas.setLayout(new BorderLayout(10, 20));
        
        MostrarCartas(ordenImagenes);
        
        ventanaCartas.add(this.contenedorCartas, BorderLayout.NORTH);
        ventanaCartas.setSize(1400, 600);
        ventanaCartas.setLocation(0, 0);
        ventanaCartas.setVisible(true);
        ventanaCartas.setResizable(true);
        ventanaCartas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
        public void IniciarJuego(){
             /*
            Setear Cartas
            MostrarBotones
            */
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        int idImage=Integer.parseInt(e.getActionCommand());
        
        File file=new File("src/images/"+0+".jpg");
        ImageIcon imagen=new ImageIcon(file.getAbsolutePath());
        arregloCartas[idImage-1].setIcon(imagen);
        System.out.println(arregloCartas[idImage-1].getIcon());
      
    }
    
    private void MostrarCartas(ArrayList <Carta> cartasVolteadas){
        this.contenedorCartas = new JPanel(new GridLayout(10, 10, 2, 2));
        this.contenedorCartas.removeAll();
        int idImage=25;
        File file=new File("src/images/"+idImage+".jpg");
       ImageIcon imagen=new ImageIcon(file.getAbsolutePath());
       
        for(int i=arregloCartas.length-1; i>=0; i--){//ciclo para crear, añadir, establecer propiedades a los botones
            arregloCartas[i] = new JButton(""+(i+1), imagen);
            arregloCartas[i].setSize(50, 50);
            
           
            
            
            
           this.contenedorCartas.add(arregloCartas[i]);
            arregloCartas[i].setMargin(new Insets(0, 0, 0, 0));
            arregloCartas[i].addActionListener(this);
            
            
        }
    }
    
    
    private void MostrarGanador(){
    
    }

 
    
}
