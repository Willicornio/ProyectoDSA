package Dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class MapaDAOImpl implements MapaDAO {
    private Logger log = Logger.getLogger(MapaDAOImpl.class.getName());

    public void addMapa(String id, String mapatodo) throws Exception {


        Session a = Factoria.getSession();
        juego.Mapa mapa = new juego.Mapa(id, mapatodo);
        try  {
            a.save(mapa);
        }catch (Exception e){
            throw e;
        }finally {
            a.close();
        }
    }


    public juego.Mapa getMapa(String id) throws Exception {
        Session s = Factoria.getSession();
        juego.Mapa u = new juego.Mapa();
        try {
            u = (juego.Mapa) s.get(id, juego.Mapa.class);

            if(u.getId() == null){
                u = null;
                log.info("No existe este mapa");

            }else{
                log.info("DAO: " + u);
            }

        }catch (Exception e){
            log.info("ERROR");
            u = null;

        }finally {
            s.close();
        }
        return u;
    }




        public static LinkedList<juego.Mapa> dameMapas() throws Exception {


            Session s = Factoria.getSession();
            Statement st = s.getStatement();
            String query = "SELECT * FROM mapa";
            LinkedList <juego.Mapa> listaMapas = new LinkedList<juego.Mapa>();
            ResultSet rs = st.executeQuery(query);

            try {
                while (rs.next()){
                    juego.Mapa m = new juego.Mapa();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int nCols = rsmd.getColumnCount();
                    for (int i = 1; i <= nCols;i++){

                        if(i ==1) { m.setId(rs.getString(i)); }
                        if(i ==2) { m.setMapa(rs.getString(i)); }
                    }

                    listaMapas.add(m);

                }

                return listaMapas;

            }catch(Exception e){
                throw e;
            }


        }
    }

