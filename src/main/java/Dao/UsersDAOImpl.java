package Dao;


import juego.Objeto;
import sun.awt.image.ImageWatched;

import java.sql.*;
import java.util.*;

public class UsersDAOImpl implements UsersDAO {


    Factoria factoria;


    public void addUSer(String nombre, String apellidos) throws Exception{
        Session a = Factoria.getSession();
        juego.Usuario u = new juego.Usuario(nombre, apellidos);
        try  {

            a.save(u);




        }catch (Exception e){
            throw e;
        }
        finally {
            a.close();
        }
    }

    public juego.Usuario getUser(String id) throws Exception {
        Session s = Factoria.getSession();
        juego.Usuario u = new juego.Usuario();
        try {
            u = (juego.Usuario) s.get(id, juego.Usuario.class);
            System.out.println("DAO: " + u);
            System.out.println("nombre: " +u.getNombre());

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

    public static LinkedList<juego.Usuario> dameListUsuarios1() throws Exception {
        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        String query = "SELECT * FROM usuario";
        LinkedList <juego.Usuario> listaUsuarios = new LinkedList<juego.Usuario>();
        ResultSet rs = st.executeQuery(query);

        try {
            while (rs.next()){
                juego.Usuario u = new juego.Usuario();
                ResultSetMetaData rsmd = rs.getMetaData();
                int nCols = rsmd.getColumnCount();
                for (int i = 1; i <= nCols;i++){

                    if(i ==1) { u.setId(rs.getString(i)); }
                    if(i ==2) { u.setNombre(rs.getString(i)); }
                    if(i ==3) { u.setPass(rs.getString(i)); }
                    if(i==4) { u.setDinero(rs.getInt(i)); }
                    if(i==5) { u.setPuntuacion(rs.getInt(i)); }


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

    public  LinkedList<juego.Usuario> dameListUsuarios() throws Exception {
        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        String query = "SELECT * FROM usuario";
        LinkedList <juego.Usuario> listaUsuarios = new LinkedList<juego.Usuario>();
        ResultSet rs = st.executeQuery(query);

        try {
            while (rs.next()){
                juego.Usuario u = new juego.Usuario();
                ResultSetMetaData rsmd = rs.getMetaData();
                int nCols = rsmd.getColumnCount();
                for (int i = 1; i <= nCols;i++){

                    if(i ==1) { u.setId(rs.getString(i)); }
                    if(i ==2) { u.setNombre(rs.getString(i)); }
                    if(i ==3) { u.setPass(rs.getString(i)); }
                    if(i==4) { u.setDinero(rs.getInt(i)); }
                    if(i==5) { u.setPuntuacion(rs.getInt(i)); }


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
    public boolean borrarUsuario (juego.Usuario user) throws Exception {
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

        juego.Usuario u = new juego.Usuario();
        u = (juego.Usuario) s.get(id, juego.Usuario.class);
        String contra = u.getPass();
        System.out.println("La contraseña actual es :" +contra);
        System.out.println("La que pones tu para confimar es :" + pass);
        if ( contra.equals(pass)){

            String query = "UPDATE `usuario` SET `pass` = '" + newpass + "' WHERE (`id` = '" + id +"')";
                    st.executeUpdate(query);

        }
    else
        {
            throw new Exception("la contraseña fatal  o el usuario a saber escribe bien porfavor");

        }


    }
////////////////////////////////// Modicifar dinero/////////////////////////////


    public int modificarDinero(String id, int cantidad) throws Exception {
        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        juego.Usuario u = new juego.Usuario();
        u = (juego.Usuario) s.get(id, juego.Usuario.class);
        System.out.println("Dinero antes :" + u.getDinero());
        int dinero1 = u.getDinero();
         dinero1 = dinero1 + cantidad;

        String query = "UPDATE `usuario` SET `dinero` = '" + dinero1 + "' WHERE (`id` = '" + id +"')";
        st.executeUpdate(query);
        juego.Usuario a = (juego.Usuario) s.get(id, juego.Usuario.class);
        System.out.println("Dinero después :" + a.getDinero());

        return dinero1;

    }

// //////////////////////////////// Modificar puntuacion/////////////////////////////

    public int modificarPuntuacion(String id, int puntu) throws Exception {
        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        juego.Usuario u = new juego.Usuario();
        u = (juego.Usuario) s.get(id, juego.Usuario.class);
        System.out.println("Puntuación antes de update :" + u.getPuntuacion());

       int puntUs =  u.getPuntuacion();

         puntUs = puntUs + puntu;

        String query = "UPDATE `usuario` SET `puntuacion` = '" + puntUs + "' WHERE (`id` = '" + id +"')";
                /*"UPDATE  usuario SET puntuacion ='" + puntUs + "'WHERE ('id' = '"+id+"')";
        */
        st.executeUpdate(query);
        juego.Usuario a = (juego.Usuario) s.get(id, juego.Usuario.class);

       System.out.println("Puntuación después del update: " + a.getPuntuacion());
        return puntUs;

    }



    public void comprarObjeto (String idUser, String idObjeto) throws Exception{

        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        juego.Usuario u = new juego.Usuario();
        u =(juego.Usuario) s.get(idUser, juego.Usuario.class);

        ObjetoDAO b = new ObjetoDAOImpl();

        InventarioDAO a = new InventarioDAOImpl();
        LinkedList<juego.Inventario> inventarios = a.dameInventario(idUser);

        for (int i=0; i<inventarios.size(); i++){

            if ( idObjeto.equals(inventarios.get(i).getIdObjeto())){

                int dineroUsuario = u.getDinero();

               Objeto objeto = b.getObjeto(inventarios.get(i).getIdObjeto());

               int dineroObjeto = objeto.getDinero();

               if(dineroUsuario > dineroObjeto){
                   int dinerooperacion = dineroUsuario - dineroObjeto;

                   modificarDinero(idUser, dinerooperacion);
                   a.cambiarActivado(u.getId(), objeto.getId());

               }

            }
        }


    }






}