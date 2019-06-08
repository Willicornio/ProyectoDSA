package Dao;

import java.util.LinkedList;
import java.util.SplittableRandom;

public interface ObjetoDAO {

    //public LinkedList<juego.Objeto> dameTodosObjetos () throws  Exception;
    public juego.Objeto getObjeto (String id) throws Exception;
    public void addObjeto (String id, String nombre, int puntos, int dinero) throws Exception;


}
