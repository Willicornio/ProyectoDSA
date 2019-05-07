package juego;
import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.LinkedList;


public class Inventario {

    Objetos[] inventario;
    String idInventario;

    public Inventario(String idUser) {
        this.inventario = new Objetos[2]; // de momento pongo 2
        this.inventario[0] = new Objetos("Linterna", "linterna",1,5);
        this.inventario[1] = new Objetos("Ganzua", "ganzua",1,10);
        this.idInventario = idUser;

    }

    public Objetos[] getInventario() {
        return inventario;
    }

    public void setInventario(Objetos[] inventario) {
        this.inventario = inventario;
    }

    public String getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(String idInventario) {
        this.idInventario = idInventario;
    }
}





