/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Model.*;
import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yussel,Ramon,Anuar
 */
public class ServerController {
    
    private static ServerController serverController;
    private int session_id=0;
    private Gson gson;
    
    private ServerController(){
        gson = new Gson();
    }
    
    public static ServerController getInstance(){
        if(serverController == null){
            serverController = new ServerController();
            return serverController;
        }
        else{
            return serverController; 
        }
    }
    
   
    public void processMessage(String message,DataOutputStream out){
        try {
            System.out.print("Mensaje process "+message);
            RequestMessage reqMsg = gson.fromJson(message, RequestMessage.class);
            
            switch(reqMsg.getMessageType()){
                
                case RequestMessage.OBTENER_TABLERO:
                {
                    //Reglas tablero = new Reglas();
                    ArrayList<Carta> tableroCartas = Reglas.getOrdenCartas();
                    System.out.println(tableroCartas.get(0).getId());
                    out.writeUTF(gson.toJson(tableroCartas)+'\n');
                    break;
                }
                case RequestMessage.ACTUALIZAR_CARTA_JUGADA:{
                    String data1 = reqMsg.getData1();
                    String data2 = reqMsg.getData2();
                    Carta cartaJugada = gson.fromJson(data1, Carta.class);
                    Jugador player = gson.fromJson(data2, Jugador.class);
                    mostrarCarta(cartaJugada, player);
                    
                }
            
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarCarta(Carta carta, Jugador jugador){
        String card = gson.toJson(carta);
        String player = gson.toJson(jugador);
        RequestMessage rm = new RequestMessage(RequestMessage.ACTUALIZAR_CARTA_JUGADA, card, player);
        
        String jsonMsg = gson.toJson(rm);
        
        //Se obtiene la instancia del MulticasServer
        MulticastServer ms = MulticastServer.getInstance();
        //Se difunde el mensaje a todo el grupo
        ms.sendMulticast(jsonMsg);
    }
    
    
}
