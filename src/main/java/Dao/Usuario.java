package Dao;


public class Usuario {

    String id;
    String Nombre;
    String Apellido;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario (String id, String nombre, String apellido){

        this.id = id;
        this.Nombre = nombre;
        this.Apellido = apellido;
    }

    public Usuario(){}


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