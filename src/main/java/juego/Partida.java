package juego;
import java.util.LinkedList;

public class Partida {
    String idPartida;
    String idUser;
    int mapaActual;
    int vida;

    public Partida(String idPartida, String idUser, int mapaActual, int vida) {
        this.idPartida = idPartida;
        this.idUser = idUser;
        this.mapaActual = mapaActual;
        this.vida = vida;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getMapaActual() {
        return mapaActual;
    }

    public void setMapaActual(int mapaActual) {
        this.mapaActual = mapaActual;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
