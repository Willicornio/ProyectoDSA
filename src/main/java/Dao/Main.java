package Dao;

import juego.Inventario;
import juego.Juego;
import juego.JuegoManager;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
      UsersDAO dao = new UsersDAOImpl();
//      dao.getUser("idRiquisimo");


     dao.cambiarPass("me", "gusta", "gustacion", "idRiquisimo");


     /*   ObjetoDAO dao1 = new ObjetoDAOImpl();
        LinkedList<Objeto> lista1 = dao1.dameTodosObjetos();

        String nombre1 = lista1.get(0).getNombre();
        System.out.println(nombre1);
        String nombre2 = lista1.get(1).getNombre();
        System.out.println(nombre2);
        String nombre3 = lista1.get(2).getNombre();
        System.out.println(nombre3);

        Usuario abs = dao.getUser("Willi25");

        dao.borrarUsuario(abs);
*/

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
