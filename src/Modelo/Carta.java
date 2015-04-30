/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author x
 */
public class Carta {
    int id;
    
    boolean estaVolteada;

    public Carta(int num_veces, boolean b) {
         this.id=num_veces;
        this.estaVolteada=b;
    }

    
    public int getId() {
        return id;
    }

  
    public String getUrlCarta() {
            String urlCarta="src/images/"+this.id+".jpg";
        return urlCarta;
    }

  

    public boolean isEstaBolteada() {
        return estaVolteada;
    }

    public void setEstaBolteada(boolean estaBolteada) {
        this.estaVolteada = estaBolteada;
    }
    
    
}
