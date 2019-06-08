package Dao;

import juego.Inventario;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ObjetoDAOImpl implements ObjetoDAO{



    public static LinkedList<juego.Objeto> dameTodosObjetos() throws Exception {


        Session s = Factoria.getSession();
        Statement st = s.getStatement();
        String query = "SELECT * FROM objeto";
        LinkedList <juego.Objeto> listaObjetos = new LinkedList<juego.Objeto>();
        ResultSet rs = st.executeQuery(query);

        try {
            while (rs.next()){
                juego.Objeto o = new juego.Objeto();
                ResultSetMetaData rsmd = rs.getMetaData();
                int nCols = rsmd.getColumnCount();
                for (int i = 1; i <= nCols;i++){

                    if(i ==1) { o.setId(rs.getString(i)); }
                    if(i ==2) { o.setNombre(rs.getString(i)); }
                    if(i ==3) { o.setPuntos(rs.getInt(i)); }
                    if(i ==4) { o.setDinero(rs.getInt(i)); }
                    if(i ==5) { o.setActivado(rs.getString(i)); }

                }

                listaObjetos.add(o);

            }

            return listaObjetos;

        }catch(Exception e){
            throw e;
        }


    }

    @Override
    public juego.Objeto getObjeto(String id) throws Exception {
        Session s = Factoria.getSession();
        juego.Objeto u = new juego.Objeto();
        try {
            u = (juego.Objeto) s.get(id, juego.Objeto.class);
            System.out.println("DAO: " + u);
            System.out.println("nombre: " +u.getNombre());
        }catch (Exception e){
            System.out.println("no existe ese objeto siusplau");
        }finally {
            s.close();
        }
        return u;
    }


}
