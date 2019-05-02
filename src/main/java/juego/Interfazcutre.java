package juego;

import java.util.LinkedList;
import java.util.List;

public interface Interfazcutre {


    public boolean login(String idUser, String pass);
    public boolean logout(String idUser, String pass);

    public void añadirDinero(String idUser, int cantidad);
    public void quitarDinero(String idUser, int cantidad);
    public boolean checkPartidaEnCurso(String idUser);
    public boolean checkCantidadDinero(String idUsuario, int cantidad);
    public  void añadirPartidaEnCurso(String idUsuario, String idPartida, Partida p);
    public void eliminarPartidaEnCurso(String idUsuario, String idPartida);
    public void sumarPuntuacionFinal(String idUser,int puntuacion);






    public LinkedList<Usuario> dameListaUsuarios ();


    public void añadirUsuario(String idUser, String pass);



    //Inventario :
    public List<Objetos> dameObjetos(String objeto);
    public void activarmeObjeto(String idObjeto);
    public void desactivarmeObjeto(String idObjecto);
    public void crearInventario(String idUser);
    public void destruirInventario(String idUser);


    //Objetos :

    public void crearObjetoNuevo(String nombre, String idObjeto, String puntos, String dinero);
    public void eliminarObjeto(String idObjeto);




    public Partida damePartidaEnCurso (String idUser, String idPartida);
    public void IniciarPartida (String idUser);
    public void finalizarPartida (String iduser);
    public void construirMapa (Mapa mapa, String idPartida);
    public void pararPartida(String idusuario);
    public void mirarPartidaParada(String idUser);




}
