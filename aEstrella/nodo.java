package aEstrella;

import java.util.*;

public class nodo {

    public int x;
    public int y;
    public int g;
    public int f;
    public int h;
    public type tipo;
    public enum type{
        OBS, REG, I, G, CAMINO
    }
    public boolean visto;
    public nodo padre;
    List<nodo> vecinos = new ArrayList<>();

    // constructor de la clase nodo (necesita la fila, la columna y el estado que tiene el nodo)
    public nodo(int x, int y ,nodo.type tipo) {

        this.x = x;
        this.y = y;
        this.tipo = tipo;
        
        visto = false;
        g = f = h = -1;
        padre = null;
        vecinos = null;

    }

    public void nodoVisitado() {
        visto = true;
    }

    // Calcula la distancia de Manhattan desde el nodo actual al nodo que se
    //le pasa como parametro( nodo objetivo)

    public void calcularDistManh(nodo obj) {

        h = Math.abs(x - obj.x) + Math.abs(y - obj.y);
    }

    //Muestra el nodo actual por su fila y columna
    public void mostrar() {
        System.out.println(" ("+x+" , "+y+")");
    }
}