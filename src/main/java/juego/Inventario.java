package juego;
import java.util.List;


public class Inventario {

    String id;
    String idUser;
    Objeto[] objetos;


    public Inventario(List<Objeto> listaObjetos, String idUser) {

        this.objetos = new Objeto[listaObjetos.size()];
        int contador = 0;

        for(Objeto o: listaObjetos){
            objetos[contador] = o;
            contador++;
        }

        this.idUser = idUser;
        this.id = "inv"+ idUser;


    }

    public Objeto[] getObjetos() {
        return objetos;
    }

    public void setObjetos(Objeto[] inventario) {
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





