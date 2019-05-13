package Dao;

public class Mapa {

    String id;
    String mapatodo;

public Mapa(){

    this.id = null;
    this.mapatodo = null;
}

public Mapa (String id, String mapatodo){
    this.id = id;
    this.mapatodo = mapatodo;
}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMapatodo() {
        return mapatodo;
    }

    public void setMapatodo(String mapatodo) {
        this.mapatodo = mapatodo;
    }
}
