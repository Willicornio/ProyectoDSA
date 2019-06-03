package juego;

import java.sql.SQLException;
import java.util.List;

public interface Juego {

   //Usuario
    public boolean login(String nombre, String pass) throws Exception;
    public boolean logout(String nombre, String pass);
    public void eliminarUsuario(String idUser);


    public Usuario crearUsuario(String nombre, String pass) throws Exception;
    public List<UsuarioTO> dameUsuariosTO() throws Exception;
    public List<Usuario> dameUsuarios() throws Exception;
    public UsuarioTO dameUsuarioTOById(String id) throws Exception;



    public Usuario dameUsuarioById(String id) throws Exception;

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

    public void crearInventario(String idUser, List<Objeto> listaObjetos) throws Exception;

    public void activarmeObjeto(String idObjeto, String idUser);
    public void desactivarmeObjeto(String idObjecto, String idUser);

    //public void destruirInventario(String idUser); SE ELIMINA YA AL ELIMINAR UN USER


    //Objeto :




    public void crearObjetoNuevo(Objeto objeto);
    public void eliminarObjeto(String idObjeto);
    public List<Objeto> dameObjetos();


 void clear();
}
