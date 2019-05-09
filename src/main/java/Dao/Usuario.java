package Dao;


public class Usuario {

    String Nombre;
    String Apellido;



    public Usuario (String nombre, String apellido){

        this.Nombre = nombre;
        this.Apellido = apellido;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }
}