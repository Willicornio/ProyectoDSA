package Dao;

import java.util.concurrent.ExecutionException;

public interface UsersDAO {
    public void addUSer(String nombre, String apellidos) throws Exception;
    public void getUser(String id) throws Exception;
}