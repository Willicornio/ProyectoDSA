package juego;
import javax.management.ObjectName;
import java.util.LinkedList;


public class Inventario {

    LinkedList<Objetos> inventario;
    String idInventario;

    public Inventario(LinkedList<Objetos> inventario, String idinventario) {
        this.inventario = inventario;
        this.idInventario = idinventario;

    }
    public Inventario (String idinventario) {
        this.inventario = inventario;
        this.idInventario = idinventario;
        inventario = new LinkedList<Objetos>();
    }


    public LinkedList<Objetos> getInventario() {
        return inventario;
    }

    public void setInventario(LinkedList<Objetos> inventario) {
        this.inventario = inventario;
    }

    public String getIdinventario() {
        return idInventario;
    }

    public void setIdinventario(String idinventario) {
        this.idInventario = idinventario;
    }
}
