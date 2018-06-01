package test.com.nodos;

import java.util.Arrays;

public class Nodo {
    int nombre;
    Nodo[] hijos;

    public Nodo(int nombre, Nodo[] hijos) {
        this.nombre = nombre;
        this.hijos = hijos;
    }

    int y=0;

    public String toString(int z) {
        String espacio="";
        String cadena="";
            for (int x=0;x<z;x++){
                espacio+="-";
            }
            espacio+=">";
           cadena= nombre +"\n"+espacio+(hijos[0]!=null?hijos[0].toString(z+2):"null")+"\n|\n"+espacio+(hijos[1]!=null?hijos[1].toString(z+2):"null") ;

        return  cadena;
    }
}
