package Dao;

import juego.Inventario;

import java.sql.SQLException;

public class InventarioDAOImpl {

    public static void addInventario(Inventario i) throws Exception {
        Session s = Factoria.getSession();
        s.save(i);

    }
}
