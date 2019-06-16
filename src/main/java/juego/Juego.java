package juego;




import io.swagger.models.auth.In;


import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public interface Juego {

   //Usuario
    public boolean login(String nombre, String pass) throws Exception;
    public boolean logout(String nombre, String pass);
    public void eliminarUsuario(String idUser);
    public UsuarioTO crearUsuario(Auth a) throws Exception;
    public List<UsuarioTO> dameUsuariosTO() throws Exception;
    public List<Usuario> dameUsuarios() throws Exception;
    public UsuarioTO dameUsuarioTOById(String id) throws Exception;
    public Usuario dameUsuarioById(String id) throws Exception;
    public void modificarDinero(String idUser, int cantidad) throws Exception;
    public void sumarPuntuacionFinal(String idUser,int puntuacion) throws Exception;
    public boolean borrarUsuaio (String id) throws Exception;




    //Inventario :

    public void crearInventario(String idUser, List<Objeto> listaObjetos) throws Exception;
    public LinkedList<Inventario> dameInventarioPorID(String idUser) throws Exception;
    public void activarmeObjeto(String idObjeto, String idUser) throws Exception;
    public void desactivarmeObjetos(String idUser) throws Exception;
    public String consultaActivado(String idUser, String idObjeto) throws Exception;




    //Objeto :

    public void crearObjetoNuevo(Objeto objeto) throws Exception;
    public void eliminarObjeto(String idObjeto);
    public LinkedList<Objeto> dameObjetos() throws Exception;
    public String comprarObjeto (String idUser, String idObjeto) throws Exception;
    public Objeto dameObjetoPorId(String id) throws Exception;


    //Mapa:

    public void addMapa(String id, String mapatodo) throws Exception;
    public Mapa getMapa(String id) throws Exception;
    public LinkedList<Mapa> dameMapas() throws Exception;


 void clear();
}
