package juego;
public class Objetos {

    String Nombre;
    int idObjeto;
    int puntos;
    int dinero;
    boolean actvivado;


    public Objetos (String Nombre, int idObjeto, int puntos, int dinero){

        this.dinero = dinero;
        this.idObjeto = idObjeto;
        this.Nombre = Nombre;
        this.puntos = puntos;
        actvivado = false;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
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
