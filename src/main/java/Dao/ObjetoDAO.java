package Dao;

import java.util.LinkedList;

public interface ObjetoDAO {

    //public LinkedList<Objeto> dameTodosObjetos () throws  Exception;
    public juego.Objeto getObjeto (String id) throws Exception;
}
