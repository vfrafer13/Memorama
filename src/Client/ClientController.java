/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Model.Carta;
import Model.Jugador;
import Model.RequestMessage;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author Yussel,Ramon,Anuar
 */
public class ClientController {
    private TCPClient tcpClient;
    private Gson gson = new Gson();
    
    public ClientController(){
        gson = new Gson();
        tcpClient = new TCPClient();
       
    }
    
       public ArrayList<Carta> obtenerTablero(){
        
        RequestMessage rm = new RequestMessage(RequestMessage.OBTENER_TABLERO);

        String jsonMsg = gson.toJson(rm);

        //Envía petición al servidor
        tcpClient.sendMessage(jsonMsg);

        //Recibe respeusta del servidor
        String msg = tcpClient.recieveMessage();

        ArrayList<Carta> arregloCartas = gson.fromJson(msg, ArrayList.class);
        
        ArrayList<Carta> arregloCartasFinal = new ArrayList();
        for (int i = 0; i < arregloCartas.size(); i++) {
           Carta carta1;
           carta1 = gson.fromJson(arregloCartas.get(i)+"", Carta.class);
           arregloCartasFinal.add(i,carta1);
           
       }
           System.out.println(arregloCartasFinal.get(0).getId());
        
        
        return arregloCartasFinal;
    }
       
    public int posicionCartaJugada(Carta carta, Jugador jugador){
        String jsonCard = gson.toJson(carta);
        String jsonPlayer = gson.toJson(jugador);
        
        RequestMessage rm = new RequestMessage(RequestMessage.ACTUALIZAR_CARTA_JUGADA, jsonCard, jsonPlayer);
        
        String jsonMsg = gson.toJson(rm);
        
        //Envía petición al servidor
        tcpClient.sendMessage(jsonMsg);
        
        //Recibe respeusta del servidor
        String msg = tcpClient.recieveMessage();
        
        Carta cartaJugada = gson.fromJson(msg, Carta.class);
        int pos = cartaJugada.getPosicion();
        
        return pos;
    }
    
    public void close(){
        tcpClient.close();
    }
}
