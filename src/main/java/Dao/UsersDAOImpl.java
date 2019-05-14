package Dao;


import java.sql.*;
import java.util.*;

public class UsersDAOImpl implements UsersDAO {


    Factoria factoria;


    public void addUSer(String  id,String nombre, String apellidos) throws Exception{
        Session a = Factoria.getSession();
        Usuario u = new Usuario(id, nombre, apellidos);
        try  {

            a.save(u);




        }catch (Exception e){
            throw e;
        }
        finally {
            a.close();
        }
    }

    public Usuario getUser(String id) throws Exception {
        Session s = Factoria.getSession();
        Usuario u = new Usuario();
        try {
            u = (Usuario) s.get(id, Usuario.class);
            System.out.println("DAO: " + u);

        }catch (Exception e){
            System.out.println("no existe ese usuario");
        }finally {
            s.close();
        }
        return u;
    }


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
        finally {
            st.close();
            s.close();
        }
    }

///////////////////////////BORRAR USER////////////////////////////////////
    public boolean borrarUsuario (Usuario user) throws Exception {
        boolean resultado = false;
        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        try {
            String query = "DELETE FROM usuario WHERE id='" + user.getId() + "'";
            st.executeUpdate(query);
            resultado = true;
        } catch (SQLException ex) {
            throw new Exception("No se no va");
        } finally {
            st.close();
            s.close();
            return resultado;
        }
    }


   ////////////////////////////////// CAMBIAR PASS/////////////////////////////

    public void cambiarPass(String nombre, String pass, String newpass, String id) throws  Exception{
        Session s = Factoria.getSession();
        Statement st = s.getStatement();

         Usuario u = new Usuario();
        u = (Usuario) s.get(id, Usuario.class);
        String contra = u.getPass();
        if ( contra == pass){

            String query = "UPDATE  usuario set pass='" + newpass + "'WHERE ('id' = '"+id+"')";
                    st.executeUpdate(query);

        }
    else
        {
            throw new Exception("la contraseña fatal  o el usuario a saber escribe bien porfavor");

        }


    }
////////////////////////////////// Modicifar dinero/////////////////////////////


    public String modificarDinero(String id, int cantidad) throws Exception {
        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        Usuario u = new Usuario();
        u = (Usuario) s.get(id, Usuario.class);
        String dinero1 = u.getDinero();
        int entero = Integer.valueOf(dinero1);
         int enterof = entero + cantidad;
        String dineros = String.valueOf(enterof);
        String query = "UPDATE  usuario set dinero ='" + dineros + "'WHERE ('id' = '"+id+"')";
        st.executeUpdate(query);

        return dineros;

    }

// //////////////////////////////// Modificar puntuacion/////////////////////////////

    public String modificarPuntuacion(String id, int puntu) throws Exception {
        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        Usuario u = new Usuario();
        u = (Usuario) s.get(id, Usuario.class);

       String puntUs =  u.getPuntuacion();
       Integer entero = Integer.valueOf(puntUs);
        int enterof = entero + puntu;
        String pranking = String.valueOf(enterof);


        String query = "UPDATE  usuario set dinero ='" + pranking + "'WHERE ('id' = '"+id+"')";
        st.executeUpdate(query);

        return pranking;

    }







}