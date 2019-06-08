package Dao;

import juego.Inventario;
import juego.Juego;
import juego.JuegoManager;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {


      UsersDAO dao = new UsersDAOImpl();



        juego.Usuario u = dao.getUser("WilliRico");



     // dao.modificarPuntuacion("WilliRico", 300);
     // dao.modificarDinero("WilliRico", 250);

       // dao.cambiarPass("Willi", "aa", "funciona", "WilliRico");

        LinkedList<juego.Usuario> lista = dao.dameListUsuarios();

        System.out.println(lista.get(0).getNombre());
        System.out.println(lista.get(1).getNombre());
        System.out.println(lista.get(2).getNombre());
        System.out.println(lista.get(3).getNombre());
        System.out.println(lista.get(4).getNombre());
        System.out.println(lista.get(5).getNombre());
        System.out.println(lista.get(6).getNombre());
        System.out.println(lista.get(0).getPuntuacion());
        System.out.println(lista.get(6).getPuntuacion());












        ObjetoDAO dao1 = new ObjetoDAOImpl();

       dao1.getObjeto("c2");




        /*Usuario u = new Usuario();
        u =dao.getUser("Willi");
        String nombre= u.getNombre();
        System.out.println(nombre);*/


       // String str = "texto aquí";

         //for (int n= 0; n <str.length ();n++) { char c = str.charAt (n); System.out.println (c); }





        /*PreparacionDeMapa pdm = new PreparacionDeMapaImpl();

      MapaCompleto mapismo =  pdm.CreaYdameMapa("1");

      LinkedList<Casilla> casillas = mapismo.getMapa();
      String casillita1 = casillas.get(26).getId();

      String casillita28 = casillas.get(27).getId();
        int x3 = casillas.get(27).getX();
        int y4 = casillas.get(27).getY();

       System.out.println(casillita1);
        System.out.println(casillita28);
        System.out.println(x3);
        System.out.println(y4);


*/
    }


}
