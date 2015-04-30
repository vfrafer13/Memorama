/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Comunicacion;

import java.util.Observable;

/**
 *
 * @author x
 */
public class ControladorComunicacion extends Observable {
    ClientSocket clientSocket;
    
    public boolean notificarServidor(String host){
    return true;
    }
    
    public void checarMensaje(){
        this.notifyObservers();
    }
}
