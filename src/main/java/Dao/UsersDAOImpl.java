package Dao;

import juego.Inventario;


import java.sql.*;
import java.util.*;

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

    //--------------------------------------------PRUEBAS ADRI----------------------------------------

    public static void addUser(juego.Usuario u) throws Exception{
        try  {
            Session a = Factoria.getSession();
            a.save(u);




        }catch (Exception e){
            throw e;
        }
    }

    public LinkedList<Usuario> dameListUsuarios() throws Exception {
        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        String query = "SELECT * FROM usuario";
        LinkedList <Usuario> listaUsuarios = new LinkedList<Usuario>();
        ResultSet rs = st.executeQuery(query);

        try {
            while (rs.next()){
                 Usuario u = new Usuario();
                ResultSetMetaData rsmd = rs.getMetaData();
                int nCols = rsmd.getColumnCount();
                for (int i = 1; i <= nCols;i++){

                    if(i ==1) { u.setId(rs.getString(i)); }
                    if(i ==2) { u.setNombre(rs.getString(i)); }
                    if(i ==3) { u.setPass(rs.getString(i)); }

                }
                listaUsuarios.add(u);

            }

            return listaUsuarios;

        }catch(Exception e){
            throw e;
        }
    }



    //--------------------------------------------PRUEBAS ADRI----------------------------------------
}