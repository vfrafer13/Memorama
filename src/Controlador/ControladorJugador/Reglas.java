/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorJugador;

import Modelo.Carta;
import Modelo.Jugador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author x
 */
public class Reglas {
    ArrayList<Carta> ordenCartas;
    Jugador  jugador;
    Random r = new Random();
    int NUM_IMAGENES=25;
    int NUM_VECES_IMAGEN=4;
    
    public ArrayList<Carta> getOrdenCartas() {
       
        ArrayList<Carta> posicionCartas=new ArrayList<Carta>(); 
        Carta cartaNueva;
        boolean volteada=false;
        
       for (int idCarta=1;idCarta<=NUM_IMAGENES;idCarta++){
           for (int num_veces=1;num_veces<=NUM_VECES_IMAGEN;num_veces++ ){
               
              cartaNueva=new Carta(idCarta,volteada);
               posicionCartas.add(cartaNueva);             
               
           }         
           
        }
       
       Collections.shuffle(posicionCartas);
       ordenCartas=posicionCartas;
       
    return ordenCartas;
    }

    public Jugador getJugador() {
        return jugador;
    }
     
    public static void main(String[] args) {
        Reglas reglas=new Reglas();
        ArrayList<Carta> ordenCartas=reglas.getOrdenCartas();
        for(int i=0;i<100;i++){
            System.out.println(ordenCartas.get(i).getId());
            
        }
        
    }
}
