package juego;
import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Inventario {

    Objetos[] objetos;


    public Inventario(List<Objetos> listaObjetos) {

        this.objetos = new Objetos[listaObjetos.size()];
        int contador = 0;

        for(Objetos o: listaObjetos){
            objetos[contador] = o;
            contador++;
        }


    }

    public Objetos[] getObjetos() {
        return objetos;
    }

    public void setObjetos(Objetos[] inventario) {
        this.objetos = inventario;
    }
}





