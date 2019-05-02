package juego;

import java.util.LinkedList;
import java.util.List;

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



 public void añadirUsuario(String idUser, String pass);



    //Inventario :
    public List<Objetos> dameObjetos(String idUser) throws Exception;
    public void activarmeObjeto(String idObjeto);
    public void desactivarmeObjeto(String idObjecto);
    public void crearInventario(String idUser);
    public void destruirInventario(String idUser);


    //Objetos :

    public void crearObjetoNuevo(String nombre, String idObjeto, String puntos, String dinero);
    public void eliminarObjeto(String idObjeto);









}
