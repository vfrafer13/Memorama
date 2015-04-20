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
    public ArrayList<Carta> getOrdenCartas() {
       
    ArrayList<Carta> posicionCartas;  
   
        return ordenCartas;
    }

    public Jugador getJugador() {
        return jugador;
    }
    
public static void main(String args[]) {
      // create array list object       
      ArrayList arrlist = new ArrayList();
      
      // populate the list
      arrlist.add("A");
      arrlist.add("B");
      arrlist.add("C");  
      arrlist.add("C");
      arrlist.add("C");
      arrlist.add("d");
      arrlist.add("e");
      
      System.out.println("Initial collection: "+arrlist);
      
      // shuffle the list
      Collections.shuffle(arrlist);
      
      System.out.println("Final collection after shuffle: "+arrlist);
   }    
    
}
