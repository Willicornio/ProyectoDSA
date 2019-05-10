package juego;

public class UsuarioTO {
    String idUser;
    String nombre;
    int dinero;
    int puntuacionTotal;

    public UsuarioTO() {


    }

    public UsuarioTO(String idUser, String nombre, int dinero, int puntuacionTotal) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.dinero = dinero;
        this.puntuacionTotal = puntuacionTotal;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }
}
