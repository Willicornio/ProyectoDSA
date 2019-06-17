package juego;

public class Auth {

    private String nombre;
    private String pass;

    public Auth(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    public Auth() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
