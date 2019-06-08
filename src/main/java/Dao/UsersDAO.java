package Dao;

import java.util.LinkedList;


public interface UsersDAO {
    public void addUSer(String nombre, String apellidos) throws Exception;
    public juego.Usuario getUser(String id) throws Exception;
    public  LinkedList<juego.Usuario> dameListUsuarios() throws  Exception;


    public boolean borrarUsuario (juego.Usuario user) throws Exception;
    public int modificarDinero(String id, int cantidad) throws Exception;
    public int modificarPuntuacion(String id, int puntuacion) throws Exception;
    public void cambiarPass(String nombre, String pass, String newpass, String id) throws  Exception;


    //public void comprarObjeto(String idUser, String idObjeto)throws Exception;
}