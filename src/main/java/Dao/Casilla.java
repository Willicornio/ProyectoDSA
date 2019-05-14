package Dao;

public class Casilla {

    int x;
    int y;
    String id;

    public Casilla (){

        this.x = 0;
        this.y = 0;
        this.id = null;
    }

    public  Casilla (String id, int x, int y){

        this.id = id;
        this.x = x;
        this.y= y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
