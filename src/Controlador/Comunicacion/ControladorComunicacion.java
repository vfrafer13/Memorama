/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Comunicacion;

import Controlador.ControladorJugador.Reglas;
import Modelo.Carta;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author x
 */
public class ControladorComunicacion extends Observable {
    ClientSocket clientSocket;
    
    /*
    reglasJuego   se debe setiar despues de avisarle al servidor
    */
     Reglas reglasJuego=new Reglas();
    public boolean notificarServidor(String host){
        
    return true;
    }
    
    public void checarMensaje(){
        this.notifyObservers();
    }
    
     
    
    
    public ArrayList<Carta> obtenerReglasJuego(){
       return  this.reglasJuego.getOrdenCartas();
    }

   
   

    public void notificarCartasVolteadas(ArrayList<Integer> posicionCartasVolteadas) {
        
    }

   
}
