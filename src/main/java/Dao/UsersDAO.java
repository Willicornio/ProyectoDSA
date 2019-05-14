package Dao;

import java.util.LinkedList;


public interface UsersDAO {
    public void addUSer(String id, String nombre, String apellidos) throws Exception;
    public Usuario getUser(String id) throws Exception;
    public  LinkedList<Usuario> dameListUsuarios() throws  Exception;
    public boolean borrarUsuario (Usuario user) throws Exception;
    public String modificarDinero(String id, int cantidad) throws Exception;
    public String modificarPuntuacion(String id, int puntuacion) throws Exception;
    public void cambiarPass(String nombre, String pass, String newpass, String id) throws  Exception;
}