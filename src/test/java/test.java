import juego.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class test {

    private Juego ju;

    @Before
    public void setUp(){
        ju = JuegoManager.getInstance();
        List<Objeto> list = this.ju.dameObjetos();
        Usuario u = this.ju.crearUsuario("Julio","1234",list);
        Usuario i = this.ju.crearUsuario("Pedro","1234",list);

    }

    @Test
    public void crearUsuario() {
        List<Objeto> list = this.ju.dameObjetos();

        Usuario u = this.ju.crearUsuario("Adri","1234",list);
        Assert.assertEquals(2, u.getInventario().getObjetos().length);
    }

    @Test
    public void dameUsuarios() {

        List<UsuarioTO> list = this.ju.dameUsuarios();

        Assert.assertEquals(2, list.size());
    }

    @After
    public void limpiar(){

        this.ju.clear();
    }
}
