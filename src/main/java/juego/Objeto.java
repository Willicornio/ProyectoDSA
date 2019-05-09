package juego;
public class Objeto {

    String id;
    String nombre;
    int puntos;
    int dinero;
    boolean actvivado;


    public Objeto(String Nombre, String id, int puntos, int dinero){

        this.dinero = dinero;
        this.id = id;
        this.nombre = Nombre;
        this.puntos = puntos;
        actvivado = false;
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

    public boolean isActvivado() {
        return actvivado;
    }

    public void setActvivado(boolean actvivado) {
        this.actvivado = actvivado;
    }
}
