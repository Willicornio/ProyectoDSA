package juego;
import java.util.LinkedList;

public class Usuario {


String idUser;
String nombre;
String pass;
int dinero;
int puntuacionTotal;

    public Usuario() {
    }

    public Usuario (String nombre, String pass){

         this.nombre = nombre;
         this.pass = pass;
         this.idUser = "id" + nombre;
         this.dinero = 0;
         this.puntuacionTotal = 0;
     }

    public Usuario(String idUser, String nombre, String pass, int dinero, int puntuacionTotal) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.pass = pass;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
 //hola