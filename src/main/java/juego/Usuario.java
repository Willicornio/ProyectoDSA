package juego;
import java.util.LinkedList;

public class Usuario {

String nombre;
String idUser;
String pass;
LinkedList<Partida> listaPartidas;
int puntuacionTotal;

     public Usuario (String nombre, String pass){

         this.nombre = nombre;
         this.pass = pass;
         this.idUser = "id" + nombre;
         this.listaPartidas = new LinkedList<Partida>();
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

        public LinkedList<Partida> getListaPartidas(){
         return this.listaPartidas;
        }

        public void setListaPartidas (Partida p){
         this.listaPartidas.add(p);
        }
}
