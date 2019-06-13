package Dao;

import juego.Inventario;

import java.util.LinkedList;

public interface InventarioDAO {

    public LinkedList<Inventario> dameInventario(String idUser) throws Exception;
    public void cambiarActivado(String idUser, String idObjeto) throws Exception;
    public void desactivarObjetos (String idUser) throws Exception;

}
