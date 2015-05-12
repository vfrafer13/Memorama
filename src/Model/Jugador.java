/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.net.Socket;

/**
 *
 * @author Vanessa
 */
public class Jugador {
    int id;
    int score;
    Socket clientSocket;
    boolean isPlaying;

    public Jugador(int id, int score, Socket cs, boolean isPlaying) {
        this.id = id;
        this.score = score;
        this.clientSocket = cs;
        this.isPlaying = isPlaying;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public boolean isIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }
    
    
    
}
