/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Yussel,Ramon,Anuar
 */
public class RequestMessage {
    public static final int OBTENER_TABLERO = 0;
    public static final int LISTO_PARTIDA = 1;
    public static final int EMPEZAR_TURNO = 2;
    public static final int ACTUALIZAR_CARTA_JUGADA=3;
    public static final int BLOQUEAR_UI=4;
    public static final int FIN_TURNO=5;
    public static final int FIN_JUEGO=6;
    public static final int ANUNCIAR_GANADOR=7;
    
    private int messageType;
    private String data1;
    private String data2;
    
    public RequestMessage(int messageType) {
        this.messageType = messageType;
    }

    public RequestMessage(int messageType, String data1) {
        this.messageType = messageType;
        this.data1 = data1;
    }
    
    public RequestMessage(int messageType, String data1, String data2){
        this.messageType = messageType;
        this.data1 = data1;
        this.data2 = data2;
    }
    
    public String getData1() {
        return data1;
    }

    /**
     * @param data1 the data to set
     */
    public void setData1(String data1) {
        this.data1 = data1;
    }

    /**
     * @return the data2
     */
    public String getData2() {
        return data2;
    }

    /**
     * @param data2 the data2 to set
     */
    public void setData2(String data2) {
        this.data2 = data2;
    }
    
    /**
     * @return the messageType
     */
    public int getMessageType() {
        return messageType;
    }

    /**
     * @param messageType the messageType to set
     */
    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    
}
