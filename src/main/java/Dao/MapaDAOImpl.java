package Dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class MapaDAOImpl implements MapaDAO {

    public void addMapa(String id, String mapatodo) throws Exception {


        Session a = Factoria.getSession();
        Mapa mapa = new Mapa(id, mapatodo);
        try  {
            a.save(mapa);
        }catch (Exception e){
            throw e;
        }finally {
            a.close();
        }
    }


    public Mapa getMapa(String id) throws Exception {
        Session s = Factoria.getSession();
        Mapa u = new Mapa();
        try {
            u = (Mapa) s.get(id, Mapa.class);
            System.out.println("DAO: " + u);

        }catch (Exception e){
            System.out.println("ese mapa no estaa Loloololo");
        }finally {
            s.close();
        }
        return u;
    }


    public boolean borrarMapa (Usuario user) throws Exception {
        boolean resultado = false;
        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        try {
            String query = "DELETE FROM mapa WHERE id='" + user.getId() + "'";
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
    }

