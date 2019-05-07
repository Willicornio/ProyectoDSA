package juego;

import java.util.LinkedList;
import java.util.List;

public interface Interfaz {

   //Usuario
    public boolean login(String nombre, String pass);
    public boolean logout(String nombre, String pass);
    public void eliminarUsuario(String idUser);


    public void crearUsuario(String nombre, String pass, List<Objetos> listaObjetos);

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

    public Inventario crearInventario(List<Objetos> listaObjetos);
    //public List<Objetos> dameObjetos(String idUser) throws Exception;
    public void activarmeObjeto(String idObjeto, String idUser);
    public void desactivarmeObjeto(String idObjecto, String idUser);

    //public void destruirInventario(String idUser); SE ELIMINA YA AL ELIMINAR UN USER


    //Objetos :




    public void crearObjetoNuevo(Objetos objeto);
    public void eliminarObjeto(String idObjeto);









}
