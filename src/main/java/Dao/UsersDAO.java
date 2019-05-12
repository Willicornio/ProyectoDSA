package Dao;

import java.util.LinkedList;


public interface UsersDAO {
    public void addUSer(String id, String nombre, String apellidos) throws Exception;
    public Usuario getUser(String id) throws Exception;
    public  LinkedList<Usuario> dameListUsuarios() throws  Exception;
}