package Dao;

import juego.Inventario;
import juego.Objeto;

import java.sql.SQLException;
import java.util.List;

public class ObjetoDAOImpl {

    public static List<Objeto> dameListObjetos() throws Exception {
        Session s = Factoria.getSession();
        return s.selecAllObjetos();

    }
}
