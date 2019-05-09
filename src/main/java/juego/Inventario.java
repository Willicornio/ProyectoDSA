package juego;
import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Inventario {

    String id;
    String idUser;
    Objetos[] objetos;


    public Inventario(List<Objetos> listaObjetos, String idUser) {

        this.objetos = new Objetos[listaObjetos.size()];
        int contador = 0;

        for(Objetos o: listaObjetos){
            objetos[contador] = o;
            contador++;
        }

        this.idUser = idUser;
        this.id = "inv"+ idUser;


    }

    public Objetos[] getObjetos() {
        return objetos;
    }

    public void setObjetos(Objetos[] inventario) {
        this.objetos = inventario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}





