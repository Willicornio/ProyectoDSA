package juego;
import java.util.LinkedList;

public class Usuario {


String idUser;
String nombre;
String pass;
Inventario inventario;
int dinero;
boolean partidaEnCurso;
String idPartidaEnCurso;
int puntuacionTotal;


     public Usuario (String nombre, String pass, Inventario i){

         this.nombre = nombre;
         this.pass = pass;
         this.idUser = "id" + nombre;
         this.dinero = 0;
         this.partidaEnCurso = false;
         inventario = i;
         puntuacionTotal = 0;
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

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public boolean isPartidaEnCurso() {
        return partidaEnCurso;
    }

    public void setPartidaEnCurso(boolean partidaEnCurso) {
        this.partidaEnCurso = partidaEnCurso;
    }

    public String getIdPartidaEnCurso() {
        return idPartidaEnCurso;
    }

    public void setIdPartidaEnCurso(String idPartidaEnCurso) {
        this.idPartidaEnCurso = idPartidaEnCurso;
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }
}
 //hola