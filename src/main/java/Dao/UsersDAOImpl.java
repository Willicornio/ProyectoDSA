package Dao;


import juego.Objeto;
import juego.Usuario;
import org.w3c.dom.UserDataHandler;


import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

public class UsersDAOImpl implements UsersDAO {


    Factoria factoria;
    final static Logger log = Logger.getLogger(UsersDAOImpl.class.getName());




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

    public static List<juego.Usuario> dameListUsuarios1() throws Exception {
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
            List<juego.Usuario> lista = new ArrayList<juego.Usuario>(listaUsuarios);
            Collections.sort(lista, new Comparator<juego.Usuario>(){
                public int compare( juego.Usuario p1, juego.Usuario p2){
                    return  (int)(-p1.getPuntuacion()+p2.getPuntuacion());
                }
            });

            return lista;

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

   public boolean borrarInventario (String id) throws  Exception{
        boolean resultado = false;

       Session s = Factoria.getSession();
       Statement st = s.getStatement();
        try {
    String query = "DELETE FROM inventario WHERE iduser='" + id + "'";
    st.execute(query);
    resultado = true;
    log.info("Eliminado correctamente");


}catch (SQLException ex){
            throw new Exception("No se ha podido eliminar");
        }
       return resultado;
   }


    public boolean borrarUsuario (String idUser) throws Exception {
        boolean resultadoBorrarUsuario = false;
        boolean resultadoBorrarInventario = false;
        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        String id = idUser;

            try {
                String query = "DELETE FROM usuario WHERE id='" + id + "'";
                st.execute(query);
               resultadoBorrarInventario= borrarInventario(id);
               if (resultadoBorrarInventario == true){
                   resultadoBorrarUsuario = true;
                   return resultadoBorrarUsuario;
               }
            } catch (SQLException ex) {
                throw new Exception("No se ha podido eliminar");
            }
            finally {
                st.close();
                s.close();
                return resultadoBorrarUsuario;
            }

        }

    public void cambiarPass(String nombre, String pass, String newpass, String id) throws  Exception {
        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        try {
            juego.Usuario u = new juego.Usuario();
            u = (juego.Usuario) s.get(id, juego.Usuario.class);
            String contra = u.getPass();
            System.out.println("La contraseña actual es :" + contra);
            System.out.println("La que pones tu para confimar es :" + pass);
            if (contra.equals(pass)) {

                String query = "UPDATE `usuario` SET `pass` = '" + newpass + "' WHERE (`id` = '" + id + "')";
                st.executeUpdate(query);

            }

        } catch (Exception e) {

            throw new Exception("No se ha podido realizar");

        } finally {
            st.close();
            s.close();
        }
    }

////////////////////////////////// Modicifar dinero/////////////////////////////


    public int modificarDinero(String id, int cantidad) throws Exception {
        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        try{
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

    }catch (Exception e){

        throw new Exception("No se ha podido realizar");

    }
            finally {
        st.close();
        s.close();
    }
    }

// //////////////////////////////// Modificar puntuacion/////////////////////////////

    public int modificarPuntuacion(String id, int puntu) throws Exception {
        Session s = Factoria.getSession();
        Statement st = s.getStatement();

        try{
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

    }catch (Exception e){

        throw new Exception("No se ha podido realizar");

    }
            finally {
        st.close();
        s.close();
    }
}





    }






