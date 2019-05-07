import io.swagger.models.auth.In;
import juego.Interfaz;
import juego.JuegoManager;
import juego.Objetos;
import juego.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class test {

    private Interfaz ju;

    @Before
    public void setUp(){
        ju = JuegoManager.getInstance();

    }

    @Test
    public void crearUsuario() {
        List<Objetos> list = this.ju.dameObjetos();

        Usuario u = this.ju.crearUsuario("Adri","1234",list);
        Assert.assertEquals(2, u.getInventario().getObjetos().length);
    }
}
