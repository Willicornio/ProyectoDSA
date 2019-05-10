package Dao;

import java.util.concurrent.ExecutionException;

public interface UsersDAO {
    public void addUSer(String id, String nombre, String apellidos) throws Exception;
    public Usuario getUser(String id) throws Exception;
}