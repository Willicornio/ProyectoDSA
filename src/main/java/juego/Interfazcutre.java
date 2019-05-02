package juego;

import java.util.LinkedList;

public interface Interfazcutre {

   //Usuario
    public boolean login(String idUser, String pass);
    public boolean logout(String idUser, String pass);
    public void eliminarUsuario(String idUser, String pass);
    public void crearUsuario(String idUser, String pass, String nombre);
    public void modificarDinero(String idUser, int cantidad);
    public boolean checkPartidaEnCurso(String idUser);
    public void guardarPartidaEnCurso(String idUsuario, String idPartida, Partida p);
    public void eliminarPartidaEnCurso(String idUsuario, String idPartida);
    public void sumarPuntuacionFinal(String idUser,int puntuacion);

    //Partida
    public void iniciarPartida (String idUser);
    public void finalizarPartida (String idUser);
    public void construirMapa (Mapa mapa, String idUser);
    public void guardarPartida(String idUser);
    public void moodificarVida(String idUser);


    public LinkedList<Usuario> dameListaUsuarios ();


    public void añadirUsuario(String idUser, String pass);


    public void habilitarObjeto(String objeto);
    public void añadirVida(int vida);
    public int dameVida(String userId, String partidaId);








}
