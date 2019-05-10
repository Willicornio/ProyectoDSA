package juego;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

public class JuegoManager  implements Juego {


    private HashMap<String, Usuario> usuarios;
    private List<Objeto> inventario;
    private List<Inventario> listainventarios;
    private List<Mapa> listaMapas;
    private Usuario userActivo;



    private JuegoManager() throws Exception {
        this.usuarios = new HashMap<>();
        this.inventario = new LinkedList<>();



    }

    private static Juego instance;
    public static Juego getInstance() throws Exception {
        if (instance == null) instance = new JuegoManager();
        return instance;
    }


    @Override
    public boolean login(String nombre, String pass) {

        List<Usuario> u = this.dameUsuarios();
        boolean check = false;

        for (Usuario user : u) {

            if (user.getIdUser().equals("id" + nombre)) {
                this.userActivo = user;
                this.crearInventario();
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
    public Usuario crearUsuario(String nombre, String pass) {

        UsuarioTO user = dameUsuarioById("id"+nombre);

        if(user == null){
            Usuario u = new Usuario(nombre,pass);
            this.usuarios.put(u.idUser,u); //LO EQUIVALENTE EN DAO AL SAVE
            return u;
        }else{

            return null;
        }

    }

    @Override
    public List<Usuario> dameUsuarios() {

       List<Usuario> list = new ArrayList(this.usuarios.values());



        return list;
    }

    @Override
    public List<UsuarioTO> dameUsuariosTO() {

        List<Usuario> u = this.dameUsuarios();

        List<UsuarioTO> list = new ArrayList<>();

        for(Usuario g: u){
            list.add(new UsuarioTO(g.getIdUser(),g.getNombre(),g.getDinero(),g.getPuntuacionTotal()));

        }

        return list;
    }

    @Override
    public UsuarioTO dameUsuarioById(String id) {

        List<Usuario> u = new ArrayList(this.usuarios.values());
        UsuarioTO uto = null;

        for (Usuario usuario: u){
            if(usuario.getIdUser().equals(id)){

                uto = new UsuarioTO(usuario.getIdUser(),usuario.getNombre(), usuario.getDinero(),usuario.getPuntuacionTotal());
                break;
            }

        }



        return uto;
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
    public void moodificarVida(String idUser) {

    }



    @Override
    public void añadirUsuario(String idUser, String pass) {

    }

    @Override
    public List<Objeto> dameObjetos(){

        return this.inventario;
    }

    @Override
    public void activarmeObjeto(String idObjeto, String idUser) {





    }

    @Override
    public void desactivarmeObjeto(String idObjecto, String idUser) {

    }

    @Override
    public void crearInventario() { //AQUÍ HABRÁ QUE IMPLIMENTAR EL SELECT PARA RELLENAR LA LIST INVENTARIO

        this.inventario.add(0, new Objeto("Linterna","0",1,5));
        this.inventario.add(1, new Objeto("Ganzua","1",1,10));

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
