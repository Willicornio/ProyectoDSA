package juego;
import java.util.LinkedList;

public class Partida {

    String id;
    String idUser;
    Usuario user;
    Mapa m;
    LinkedList<Objetos> inventario;
    int puntuacionPartida;
    int vida;


    public Partida (Usuario u, String id, Mapa m){

        this.id = id;
        this.idUser = u.getIdUser();
    }

}
