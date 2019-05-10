package juego;
import java.util.List;


public class Inventario {

    Objeto[] objetos;

    public Inventario() {


    }

    public Inventario(List<Objeto> listaObjetos) {

        this.objetos = new Objeto[listaObjetos.size()];
        int contador = 0;

        for(Objeto o: listaObjetos){
            objetos[contador] = o;
            contador++;
        }

    }

    public Objeto[] getObjetos() {
        return objetos;
    }

    public void setObjetos(Objeto[] objetos) {
        this.objetos = objetos;
    }
}





