package Dao;

public class Main {
    public static void main(String[] args) throws Exception {
        UsersDAO dao = new UsersDAOImpl();
        //  dao.addUSer("Willi6099779","este ", "men");

        Usuario u = new Usuario();
        u =dao.getUser("Willi");
        String nombre= u.getNombre();
        System.out.println(nombre);




    }


}
