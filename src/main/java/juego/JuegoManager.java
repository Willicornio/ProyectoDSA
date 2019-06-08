package juego;

import Dao.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mysql.jdbc.ExportControlled;
import io.swagger.models.auth.In;


import javax.swing.tree.ExpandVetoException;
import java.security.spec.ECParameterSpec;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

public class JuegoManager  implements Juego {
    private Logger log = Logger.getLogger(JuegoManager.class.getName());

    private HashMap<String, Usuario> usuarios;
    private List<Objeto> inventario;
    private List<Inventario> listainventarios;
    private List<Mapa> listaMapas;
    private Usuario userActivo;



    private JuegoManager() throws Exception {
        this.usuarios = new HashMap<>();

        this.inventario = new LinkedList<>();



        this.inventario = new LinkedList<>();




    }

    private static Juego instance;
    public static Juego getInstance() throws Exception {
        if (instance == null) instance = new JuegoManager();
        return instance;
    }



    @Override
    public boolean login(String nombre, String pass) throws Exception {

        List<Usuario> u = this.dameUsuarios();
        boolean check = false;

        for (Usuario user : u) {

            if (user.getId().equals("id" + nombre) && user.getPass().equals(pass)) {

                check = true;
                break;
            }
        }
        return check;
    }


    @Override
    public boolean logout(String idUser, String pass) {
        return false;
    }

    @Override
    public void eliminarUsuario(String idUser) {

        this.usuarios.remove(idUser); //LO EQUIVALENTE EN DAO AL DELETE

    }

    @Override
    public Usuario crearUsuario(String nombre, String pass) throws Exception {

        Usuario user = dameUsuarioById("id"+nombre);

        if(user == null){
            Usuario u = new Usuario(nombre,pass);
            //this.usuarios.put(u.idUser,u); //LO EQUIVALENTE EN DAO AL SAVE
            UsersDAOImpl.addUser(new Usuario(nombre,pass));
            this.crearInventario(u.getId(), ObjetoDAOImpl.dameTodosObjetos());
            return u;
        }else{

            return null;
        }

    }


    @Override
    public LinkedList<Usuario> dameUsuarios() throws Exception {

      return UsersDAOImpl.dameListUsuarios1();
    }

    @Override

    public List<UsuarioTO> dameUsuariosTO() throws Exception {

        List<Usuario> u = this.dameUsuarios();

        List<UsuarioTO> list = new ArrayList<>();

        for(Usuario g: u){
            list.add(new UsuarioTO(g.getId(),g.getNombre(),g.getDinero(),g.getPuntuacion()));

        }

        return list;
    }

   // @Override
  public Usuario dameUsuarioById(String id) throws Exception {

        LinkedList<Usuario> list = UsersDAOImpl.dameListUsuarios1();
        Usuario u = null;

        for (Usuario usuario : list) {
            if (usuario.getId().equals(id)) {

                u = usuario;
                break;
            }

        }


        return u;


    }

    public UsuarioTO dameUsuarioTOById(String id) throws Exception {

        LinkedList<Usuario> list = UsersDAOImpl.dameListUsuarios1();
        UsuarioTO u = null;

        for (Usuario usuario : list) {
            if (usuario.getId().equals(id)) {

                u = new UsuarioTO(usuario.getId(),usuario.getNombre(),usuario.getDinero(),usuario.getPuntuacion());
                break;
            }

        }


        return u;


    }




    @Override
    public void modificarDinero(String idUser, int cantidad) throws Exception{

        UsersDAO dao =  new UsersDAOImpl();
        dao.modificarDinero(idUser, cantidad);


    }


    @Override
    public void sumarPuntuacionFinal(String idUser, int puntuacion) throws Exception{

        UsersDAO dao =  new UsersDAOImpl();
        dao.modificarPuntuacion(idUser, puntuacion);
    }

   /* @Override
    public void iniciarPartida(String idUser) {

    }

    @Override
    public void finalizarPartida(String idUser) {

    }
*/
    @Override
    public void construirMapa(Mapa mapa, String idUser) {

    }
/*
    @Override
    public void guardarPartida(String idUser) {

    }

    @Override
    public void moodificarVida(String idUser){

    }
*/


   /* @Override
    public void añadirUsuario(String idUser, String pass) {

    }
*/
    @Override
    public LinkedList<Objeto> dameObjetos() throws Exception{

        LinkedList<Objeto> list = ObjetoDAOImpl.dameTodosObjetos();

        return list;
    }



    @Override
    public void activarmeObjeto(String idObjeto, String idUser) throws Exception {

        InventarioDAO dao = new InventarioDAOImpl();
        dao.cambiarActivado(idUser, idObjeto);
    }

    @Override
    public void desactivarmeObjetos(String idUser) throws Exception{

        InventarioDAO dao = new InventarioDAOImpl();
        dao.desactivarObjetos(idUser);

    }

    @Override
    public void crearInventario(String idUser, List<Objeto> listaObjetos) throws Exception {

        //SELECT * FROM objeto --> pasarlo a una lista de objetos
         //simulo el select


        for(Objeto o: listaObjetos){
            Inventario i = new Inventario(idUser,o.getId());
            InventarioDAOImpl.addInventario(i);

        }



    }


    @Override
    public void crearObjetoNuevo(Objeto objeto) throws Exception{
        ObjetoDAO dao = new ObjetoDAOImpl();

        Objeto o = objeto;


        dao.addObjeto(o.getId(),o.getNombre(),o.getPuntos(),o.getDinero());

    }

    @Override
    public void eliminarObjeto(String idObjeto) {

    }

    @Override
    public void clear() {

        this.usuarios.clear();
        this.inventario.clear();

    }


    public void comprarObjeto (String idUser, String idObjeto) throws Exception {

        UsersDAO dao = new UsersDAOImpl();

        ((UsersDAOImpl) dao).comprarObjeto(idUser, idObjeto);

    }



    public LinkedList<Inventario> dameInventarioPorID(String idUser) throws Exception{

        InventarioDAO dao = new InventarioDAOImpl();
        LinkedList<Inventario> lista = dao.dameInventario(idUser);
        return lista;
    }




    public void addMapa(String id, String mapatodo) throws Exception{

        MapaDAO dao = new MapaDAOImpl();

        dao.addMapa(id, mapatodo);
    }
    public String getMapa(String id) throws Exception{


        MapaDAO dao = new MapaDAOImpl();
        Mapa mapa = dao.getMapa(id);
        String mapatodo = mapa.getMapatodo();

        return mapatodo;

    }
    public void borrarMapa (String idMapa) throws Exception{

        MapaDAO dao = new MapaDAOImpl();
        dao.borrarMapa(idMapa);


    }
}
