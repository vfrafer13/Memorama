/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorJugador.Reglas;
import Modelo.Carta;
import java.util.ArrayList;


/**
 *
 * @author x
 */
class ControladorReglas {
    Reglas reglasJuego=null;
    
    
    public ArrayList<Carta> obtenerReglasJuego(){
       return  this.reglasJuego.getOrdenCartas();
    }
}
