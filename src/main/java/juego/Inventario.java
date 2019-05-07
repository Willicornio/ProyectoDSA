package juego;
import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Inventario {

    Objetos[] inventario;


    public Inventario(List<Objetos> listaObjetos) {

        this .inventario = new Objetos[listaObjetos.size()];
        int contador = 0;

        for(Objetos o: listaObjetos){
            inventario[contador] = o;
            contador++;
        }


    }

    public Objetos[] getInventario() {
        return inventario;
    }

    public void setInventario(Objetos[] inventario) {
        this.inventario = inventario;
    }
}





