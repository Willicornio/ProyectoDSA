package juego;

import Dao.Factoria;
import Dao.InventarioDAOImpl;
import Dao.ObjetoDAOImpl;
import Dao.UsersDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
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

            if (user.getIdUser().equals("id" + nombre)) {

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
            this.crearInventario(u.getIdUser(), ObjetoDAOImpl.dameTodosObjetos());
            return u;
        }else{

            return null;
        }

    }


    @Override
    public LinkedList<Usuario> dameUsuarios() throws Exception {






      return UsersDAOImpl.dameListUsuarios();
    }

    @Override

    public List<UsuarioTO> dameUsuariosTO() throws Exception {

        List<Usuario> u = this.dameUsuarios();

        List<UsuarioTO> list = new ArrayList<>();

        for(Usuario g: u){
            list.add(new UsuarioTO(g.getIdUser(),g.getNombre(),g.getDinero(),g.getPuntuacionTotal()));

        }

        return list;
    }

   // @Override
  public Usuario dameUsuarioById(String id) throws Exception {

        LinkedList<Usuario> list = UsersDAOImpl.dameListUsuarios();
        Usuario u = null;

        for (Usuario usuario : list) {
            if (usuario.getIdUser().equals(id)) {

                u = usuario;
                break;
            }

        }


        return u;


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
    public void moodificarVida(String idUser){

    }



    @Override
    public void añadirUsuario(String idUser, String pass) {

    }

    @Override
    public List<Objeto> dameObjetos(){

        List<Objeto> list = new LinkedList<>();

        list.add(new Objeto("1","Linterna",3,5));
        list.add(new Objeto("2","Ganzua",3,5));

        return list;
    }



    @Override
    public void activarmeObjeto(String idObjeto, String idUser) {


    }

    @Override
    public void desactivarmeObjeto(String idObjecto, String idUser) {

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
    public void crearObjetoNuevo(Objeto objeto) {
        this.inventario.add(objeto);

    }

    @Override
    public void eliminarObjeto(String idObjeto) {

    }

    @Override
    public void clear() {

        this.usuarios.clear();
        this.inventario.clear();

    }

 
}
