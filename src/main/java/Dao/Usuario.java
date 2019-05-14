package Dao;


public class Usuario {

    String id;
    String Nombre;
    String pass;
    String dinero;

    String puntuacion;


    public void setDinero(String dinero) {
        this.dinero = dinero;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getDinero() {
        return dinero;
    }

    public void setDinero() {

        this.dinero = dinero;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario (String id, String nombre, String pass){

        this.id = id;
        this.Nombre = nombre;
        this.pass = pass;
    }
    public Usuario (String id, String nombre, String pass, String dinero, String puntuacion){

        this.id = id;
        this.Nombre = nombre;
        this.pass = pass;
        this.dinero = dinero;
        this.puntuacion = puntuacion;
    }
    public Usuario(){
        this.id = null;
        this.Nombre = null;
        this.pass = null;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }




    public String toString() {
        return this.getNombre()+" "+" "+this.pass;
    }
}