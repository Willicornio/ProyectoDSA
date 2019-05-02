package juego;
import javax.management.ObjectName;
import java.util.LinkedList;


public class Inventario {

    LinkedList<Objetos> inventario;
    String idinventario;

    public Inventario(LinkedList<Objetos> inventario, String idinventario) {
        this.inventario = inventario;
        this.idinventario = idinventario;
    }

    public LinkedList<Objetos> getInventario() {
        return inventario;
    }

    public void setInventario(LinkedList<Objetos> inventario) {
        this.inventario = inventario;
    }

    public String getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(String idinventario) {
        this.idinventario = idinventario;
    }
}
