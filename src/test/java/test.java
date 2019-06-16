import juego.*;
import Dao.*;
import org.glassfish.grizzly.utils.EchoFilter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class test {

    private Juego ju;


    UsersDAO dao = new UsersDAOImpl();

    @Before
    public void setUp() throws Exception {
        ju = JuegoManager.getInstance();
        List<Objeto> list = this.ju.dameObjetos();


    }

    @Test
    public void crearUsuario() throws Exception {


        UsuarioTO u = this.ju.crearUsuario(new Auth("Julio","1234"));
        Assert.assertEquals("Neus",u.getNombre());
    }

    @Test

        public void testfailCrearUsuario() throws Exception{

             UsuarioTO u = this.ju.crearUsuario(new Auth("Julio","1234"));
             Assert.assertEquals(null, u);

    }

    @Test
    public void dameUsuarios() throws Exception {

        List<UsuarioTO> list = this.ju.dameUsuariosTO();

        Assert.assertEquals(5, list.size());
    }

    @Test
    public void dameUsuariosById() throws Exception {

        List<Usuario> list = this.ju.dameUsuarios();
        Usuario uto = ju.dameUsuarioById("idManolo");

        Assert.assertEquals("Manolo", uto.getNombre());
    }

    @Test
    public void login() throws Exception {

        List<Usuario> list = this.ju.dameUsuarios();
        boolean check = ju.login("Adri", "1234");



        Assert.assertEquals(true, check);


    }

    @Test
    public void modificarDinero() throws Exception{
        ju.modificarDinero("idJulio", 500);
    }

    @Test
    public void modificarpuntuacion() throws Exception{
        ju.sumarPuntuacionFinal("idJulio", 500);
    }


    @Test
    public void comprarObjeto() throws Exception{

        Assert.assertEquals("null", ju.comprarObjeto("idVero", "idLinterna"));
    }

    @Test
    public void desactivarInventario() throws Exception{

        ju.desactivarmeObjetos("idJulio");
        Usuario u = ju.dameUsuarioById("idJulio");

        LinkedList<Inventario> i = ju.dameInventarioPorID("idJulio");

        Assert.assertEquals("false", i.get(1).getActivado());
    }

    @Test
    public void ConsultarActivado() throws Exception{


      String activado = ju.consultaActivado("idVero","idGanzua");

        Assert.assertEquals("false", activado);
    }






    @After
    public void limpiar(){

        this.ju.clear();
    }
}
