/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Vanessa
 */
public class Card {
    int posicion;
    int id;
    boolean isFlipped;
    String url;

    public Card(int posicion, int id, boolean isFlipped, String url) {
        this.posicion = posicion;
        this.id = id;
        this.isFlipped = isFlipped;
        this.url = url;
    }
    
    
}
