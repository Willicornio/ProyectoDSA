package Dao;

import juego.Inventario;
import sun.awt.image.ImageWatched;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class InventarioDAOImpl implements InventarioDAO {


    public static void addInventario(Inventario i) throws Exception {
        Session s = Factoria.getSession();
        s.save(i);

    }

    public LinkedList<juego.Inventario> dameInventario(String idUser) throws Exception{

        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        LinkedList<juego.Inventario> inventarios = new LinkedList<Inventario>();


        String query = "SELECT `idObjeto` FROM `inventario` WHERE (`id` = '" + idUser +"')";

        ResultSet rs = st.executeQuery(query);

        try {
            while (rs.next()){
                juego.Inventario u = new juego.Inventario();
                ResultSetMetaData rsmd = rs.getMetaData();
                int nCols = rsmd.getColumnCount();
                for (int i = 1; i <= nCols;i++){

                    if(i ==1) { u.setIdUser(rs.getString(i)); }
                    if(i ==2) { u.setIdObjeto(rs.getString(i)); }
                    if(i ==3) { u.setActivado(rs.getString(i)); }

                }
                inventarios.add(u);

            }

            return inventarios;

        }catch(Exception e){
            throw e;
        }
        finally {
            st.close();
            s.close();
        }
    }

    public void cambiarActivado(String idUser, String idObjeto) throws Exception{

        Session s = Factoria.getSession();
        Statement st = s.getStatement();

        String query = "UPDATE `inventario` SET `activado` = 'true' WHERE (`id` = '" + idUser +"' AND `id` = '" + idObjeto +"' )";

        st.executeUpdate(query);



    }
    }

