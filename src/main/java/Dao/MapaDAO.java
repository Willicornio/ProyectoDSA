package Dao;





public interface MapaDAO {

    public void addMapa(String id, String mapatodo) throws Exception;
    public Mapa getMapa(String id) throws Exception;
    public boolean borrarMapa (Usuario user) throws Exception;
}
