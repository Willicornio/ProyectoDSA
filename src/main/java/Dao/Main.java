package Dao;

import juego.Inventario;
import juego.Juego;
import juego.JuegoManager;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
      UsersDAO dao = new UsersDAOImpl();
         LinkedList<Usuario> lista = dao.dameListUsuarios();

         String id1 = lista.get(0).getId();
         System.out.println(id1);
        String id2 = lista.get(1).getId();
        System.out.println(id2);
        String id3 = lista.get(2).getId();
        System.out.println(id3);


        ObjetoDAO dao1 = new ObjetoDAOImpl();
        LinkedList<Objeto> lista1 = dao1.dameTodosObjetos();

        String nombre1 = lista1.get(0).getNombre();
        System.out.println(nombre1);
        String nombre2 = lista1.get(1).getNombre();
        System.out.println(nombre2);
        String nombre3 = lista1.get(2).getNombre();
        System.out.println(nombre3);

        Usuario abs = dao.getUser("Willi25");

        dao.borrarUsuario(abs);


        /*Usuario u = new Usuario();
        u =dao.getUser("Willi");
        String nombre= u.getNombre();
        System.out.println(nombre);*/










    }


}
