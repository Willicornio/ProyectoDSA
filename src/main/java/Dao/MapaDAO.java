package Dao;





public interface MapaDAO {

    public void addMapa(String id, String mapatodo) throws Exception;
    public Mapa getMapa(String id) throws Exception;
    public boolean borrarMapa (Usuario user) throws Exception;
    public void cambiarPass(String nombre, String pass);

    //modificar dinero, modificar contraseña, delete objeto, add objeto a inventario, update puntuacion,





}
