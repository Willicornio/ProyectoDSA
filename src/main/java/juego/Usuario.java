package juego;
import java.util.LinkedList;

public class Usuario {


String idUser;
String nombre;
String pass;
Inventario inventario;
boolean partidaEnCurso;
String idPartidaEnCurso;
int puntuacionTotal;


     public Usuario (String nombre, String pass){

         this.nombre = nombre;
         this.pass = pass;
         this.idUser = "id" + nombre;
         this.partidaEnCurso = false;
         inventario = new Inventario(idUser);
         puntuacionTotal = 0;
     }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPuntuacionTotal(){
         return puntuacionTotal;
    }

    public void setPuntuacionTotal(int puntuacionPartida) {
        this.puntuacionTotal = puntuacionTotal + puntuacionPartida;
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

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
}
 //hola