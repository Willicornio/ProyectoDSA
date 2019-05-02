package juego;
public class Objetos {

    String Nombre;
    String idObjeto;
    int puntos;
    int dinero;


    public Objetos (String Nombre, String idObjeto, int puntos, int dinero){

        this.dinero = dinero;
        this.idObjeto = idObjeto;
        this.Nombre = Nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
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
}
