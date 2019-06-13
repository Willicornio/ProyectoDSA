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
    public UsuarioTO crearUsuario(Auth a) throws Exception {

        Usuario user = dameUsuarioById("id"+a.getNombre());

        if(user == null){
            Usuario u = new Usuario(a.getNombre(),a.getPass());
            //this.usuarios.put(u.idUser,u); //LO EQUIVALENTE EN DAO AL SAVE
            UsersDAOImpl.addUser(new Usuario(a.getNombre(),a.getPass()));
            this.crearInventario(u.getId(), ObjetoDAOImpl.dameTodosObjetos());


            return dameUsuarioTOById(u.getId());

        }else{

            return null;
        }

    }


    public Objeto dameObjetoPorId(String id) throws Exception{

        ObjetoDAO dao =  new ObjetoDAOImpl();
       return dao.getObjeto(id);


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

    public String consultaActivado(String idUser, String idObjeto) throws Exception{

        InventarioDAO dao = new InventarioDAOImpl();
        List<Inventario> lista = dao.dameInventario(idUser);
        String activado = "false";

        for(Inventario i: lista) {
            if(i.getIdObjeto().equals(idObjeto) && i.getActivado().equals("true")){
                activado = "true";
            }

        }
        return activado;

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


        dao.addObjeto(o.getId(),o.getNombre(),o.getDescripcion(), o.getFoto(), o.getDinero());

    }

    @Override
    public void eliminarObjeto(String idObjeto) {

    }

    @Override
    public void clear() {

        this.usuarios.clear();
        this.inventario.clear();

    }


    public String comprarObjeto (String idUser, String idObjeto) throws Exception {

        UsersDAO dao = new UsersDAOImpl();
        ObjetoDAO odao = new ObjetoDAOImpl();
        InventarioDAO idao = new InventarioDAOImpl();

        String check = null;

        if(consultaActivado(idUser,idObjeto).equals("false")) {

            juego.Usuario user = dao.getUser(idUser);
            juego.Objeto objeto = odao.getObjeto(idObjeto);


            if (user.getDinero() >= objeto.getDinero()) {
                idao.cambiarActivado(idUser, idObjeto);
                dao.modificarDinero(idUser, objeto.getDinero() * (-1));
                check = "ok";

            } else if (user.getId() == null || objeto.getId() == null) {

                check = "null";

            } else {
                check = "Dinero inferior";

            }

            return check;
        }else{

            return "Ya comprado";
        }



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
    public Mapa getMapa(String id) throws Exception{

        MapaDAO dao = new MapaDAOImpl();
        Mapa mapa = dao.getMapa(id);

        return mapa;

    }
    public void borrarMapa (String idMapa) throws Exception{

        MapaDAO dao = new MapaDAOImpl();
        dao.borrarMapa(idMapa);


    }
}
