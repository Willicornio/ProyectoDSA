package Dao;

import java.util.LinkedList;

public class MapaCompleto {

    LinkedList<Casilla> mapa;
    String id;

    public MapaCompleto (){
        this.id = null;
        this.mapa = new LinkedList<Casilla>();
    }

    public MapaCompleto (LinkedList mapa , String id){
         this.mapa = mapa;
         this.id = id;
    }


    public LinkedList<Casilla> getMapa() {
        return mapa;
    }

    public void setMapa(LinkedList<Casilla> mapa) {
        this.mapa = mapa;
    }

    public void añadirCasilla (Casilla casilla){
        mapa.add(casilla);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

