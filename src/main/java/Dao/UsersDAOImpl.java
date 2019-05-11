package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class UsersDAOImpl implements UsersDAO {


    Factoria factoria;


    public void addUSer(String  id,String nombre, String apellidos) throws Exception{
        try  {
            Session a = Factoria.getSession();
            Usuario u = new Usuario(id, nombre, apellidos);
            a.save(u);




        }catch (Exception e){
            throw e;
        }
    }

    public Usuario getUser(String id) throws Exception {
        Session s = Factoria.getSession();
        Usuario u= (Usuario)s.get(id, Usuario.class);
        System.out.println("DAO: "+u);
        return u;
    }
}