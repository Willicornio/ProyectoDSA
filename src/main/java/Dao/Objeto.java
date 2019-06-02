package Dao;

public class Objeto {

    String id;
    String nombre;
    int puntos;
    int dinero;
    String actvivado;

    public Objeto() {

        this.nombre = null;
        this.id = null;
        this.puntos = 0;
        this.dinero = 0;
        this.actvivado = "false";

    }

    public Objeto(String id,String Nombre, int puntos, int dinero){

        this.dinero = dinero;
        this.id = id;
        this.nombre = Nombre;
        this.puntos = puntos;
        this.actvivado = null;
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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public String getActvivado() {
        return actvivado;
    }

    public void setActvivado(String actvivado) {
        this.actvivado = actvivado;
    }
}
