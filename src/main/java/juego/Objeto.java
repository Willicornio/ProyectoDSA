package juego;

import javax.print.DocFlavor;

public class Objeto {

    String id;
    String nombre;
    String descripcion;
    String foto;
    int dinero;
    int vida;
    String activado;

    public Objeto() {

    }

    public Objeto(String id, String Nombre, String descripcion, int dinero, int vida, String foto){

        this.dinero = dinero;
        this.id = id;
        this.nombre = Nombre;
        this.descripcion = descripcion;
        this.foto=foto;
        this.vida = vida;
        this.activado = "false";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public String getActivado() {
        return activado;
    }

    public void setActivado(String activado) {
        this.activado = activado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
