package Dao;

public class PreparacionDeMapaImpl implements PreparacionDeMapa{

    public MapaCompleto CreaYdameMapa (String id) throws Exception{


        MapaDAO daom = new MapaDAOImpl();
        Mapa mapa = daom.getMapa("2");
        String mapilla = mapa.getMapatodo();
        MapaCompleto supermapa = new MapaCompleto();

        int x = 1;
        int y = 1;
        int contador = 1;
        try {
            for (int n= 0; n <mapilla.length ();n++){

                char c = mapilla.charAt(n);
                String c2 = Character.toString(c);
                Casilla casilla = new Casilla(c2, x,y);
                supermapa.añadirCasilla(casilla);

                contador++;
                x++;

                if (contador == 8 ){
                    contador = 1;
                    x = 1;
                    y++;

                }
            }


        }catch (Exception e){
        }

        return supermapa;
    }
}
