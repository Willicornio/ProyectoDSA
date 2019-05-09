import juego.Juego;
import juego.JuegoManager;
import juego.Objeto;
import juego.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class test {

    private Juego ju;

    @Before
    public void setUp(){
        ju = JuegoManager.getInstance();

    }

    @Test
    public void crearUsuario() {
        List<Objeto> list = this.ju.dameObjetos();

        Usuario u = this.ju.crearUsuario("Adri","1234",list);
        Assert.assertEquals(2, u.getInventario().getObjetos().length);
    }
}
