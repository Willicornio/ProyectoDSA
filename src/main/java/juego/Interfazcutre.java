package juego;

import java.util.LinkedList;

public interface Interfazcutre {


    public boolean verificarLogin(String idUser);
    public void añadirDinero(String idUser, int cantidad);
    public void quitarDinero(String idUser, int cantidad);
    public boolean checkPartidaEnCurso(String idUser);
    public boolean checkCantidadDinero(String idUsuario, int cantidad);
    public  void añadirPartidaEnCurso(String idUsuario, String idPartida, Partida p);
    public void eliminarPartidaEnCurso(String idUsuario, String idPartida);
    public void sumarPuntuacionFinal(String idUser,int puntuacion);



    public LinkedList<Usuario> dameListaUsuarios ();


    public void añadirUsuario(String idUser, String pass);


    public void habilitarObjeto(String objeto);
    public void añadirVida(int vida);
    public int dameVida(String userId, String partidaId);



    public Partida damePartidaEnCurso (String idUser, String idPartida);
    public void IniciarPartida (String idUser);
    public void finalizarPartida (String iduser);
    public void construirMapa (Mapa mapa, String idPartida);
    public void pararPartida(String idusuario);
    public void mirarPartidaParada(String idUser);




}
