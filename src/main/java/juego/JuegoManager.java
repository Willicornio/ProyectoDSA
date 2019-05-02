package juego;

import java.util.LinkedList;
import java.util.List;

public class JuegoManager  implements  Interfazcutre{

    private static Interfazcutre instance;
    public static Interfazcutre getInstance(){
        return instance;
    }


    @Override
    public boolean login(String idUser, String pass) {
        return false;
    }

    @Override
    public boolean logout(String idUser, String pass) {
        return false;
    }

    @Override
    public void eliminarUsuario(String idUser, String pass) {

    }

    @Override
    public void crearUsuario(String idUser, String pass, String nombre) {

    }

    @Override
    public void modificarDinero(String idUser, int cantidad) {

    }

    @Override
    public boolean checkPartidaEnCurso(String idUser) {
        return false;
    }

    @Override
    public void guardarPartidaEnCurso(String idUsuario, String idPartida, Partida p) {

    }

    @Override
    public void eliminarPartidaEnCurso(String idUsuario, String idPartida) {

    }

    @Override
    public void sumarPuntuacionFinal(String idUser, int puntuacion) {

    }

    @Override
    public void iniciarPartida(String idUser) {

    }

    @Override
    public void finalizarPartida(String idUser) {

    }

    @Override
    public void construirMapa(Mapa mapa, String idUser) {

    }

    @Override
    public void guardarPartida(String idUser) {

    }

    @Override
    public void moodificarVida(String idUser) {

    }

    @Override
    public LinkedList<Usuario> dameListaUsuarios() {
        return null;
    }

    @Override
    public void añadirUsuario(String idUser, String pass) {

    }

    @Override
    public List<Objetos> dameObjetos(String objeto) {
        return null;
    }

    @Override
    public void activarmeObjeto(String idObjeto) {

    }

    @Override
    public void desactivarmeObjeto(String idObjecto) {

    }

    @Override
    public void crearInventario(String idUser) {

    }

    @Override
    public void destruirInventario(String idUser) {

    }

    @Override
    public void crearObjetoNuevo(String nombre, String idObjeto, String puntos, String dinero) {

    }

    @Override
    public void eliminarObjeto(String idObjeto) {

    }
}
