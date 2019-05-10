package Dao;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Session {

    Connection session = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    protected Session() {

        try {
            this.session = getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            session = DriverManager
                    .getConnection("jdbc:mysql://localhost/feedback?"
                            + "user=root&password=dsa2019");

            return session;

        } catch (Exception e) {

            throw e;
        }


    }


    public void close() throws Exception {
        session.close();
    }


    public void save(Object o) throws Exception {


        statement = session.createStatement();
        String preparedQuery = null;
        String query = null;
        // Result set get the result of the SQL query
        String table;
        int contador = 1;
        table = o.getClass().getSimpleName();

        System.out.println(table);


        Field[] fields = o.getClass().getDeclaredFields();


        for (int i = 1; i <= fields.length; i++) {

            if (i == 1) {

                preparedQuery = "?,";

            }
            if (i != fields.length & i != 1) {

                preparedQuery += "?,";
            }
            if (i == fields.length)
                preparedQuery += "?";
        }


        query = "INSERT INTO " + table + " VALUES (" + preparedQuery + ")";
        System.out.println(query);
        for (Field f : fields) {
            System.out.println(fields.length);
        }

        PreparedStatement ps = this.session.prepareStatement(query);

        for (Field f : fields) {
            ps.setString(contador, new PropertyDescriptor(fields[contador - 1].getName(), o.getClass()).getReadMethod().invoke(o).toString());
            contador++;

        }

        ps.executeUpdate();
        ps.close();
    }


    /*if ( a == "Usuario"){

        String nombre;



        e.getName();

        preparedStatement = session
                .prepareStatement("insert into  feedback." + a +"values (default, ?, ?)");
        // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
        // Parameters start with 1
        preparedStatement.setString(1, Nombre);
        preparedStatement.setString(2, apellido);
        preparedStatement.executeUpdate();
    }


}catch (Exception fatal){
    throw fatal;
}


}




}






*/
    public void update ( Object o, String id) throws Exception {

        statement = session.createStatement();
        String preparedQuery = null;
        String query = null;
        // Result set get the result of the SQL query
        String table;
        int contador = 1;
        table = o.getClass().getSimpleName();

        System.out.println(table);


        Field[] fields = o.getClass().getDeclaredFields();


        for (int i = 1; i <= fields.length; i++) {

            if (i == 1) {

                preparedQuery = "? = ?,";

            }
            if (i != fields.length & i != 1) {

                preparedQuery += "? = ?,";
            }
            if (i == fields.length)
                preparedQuery += "? =? ";
        }

        query = "UPDATE " + table + " SET nombre = caracaola WHERE ( id = " + id + " )";

        // UPDATE `feedback`.`usuario` SET `nombre` = 'este' WHERE (`id` = 'Willi25');


        query = "UPDATE " + table + " SET (" + preparedQuery + ") WHERE id =" + id;
        System.out.println(query);
        for (Field f : fields) {
            System.out.println(fields.length);
        }

        PreparedStatement ps = this.session.prepareStatement(query);
        contador = (fields.length-1)*2;
        for (int cosa = 0; cosa < contador; cosa ++) {


            if (contador%2 == 0)
                ps.setString(contador, new PropertyDescriptor(fields[contador +1].getName(), o.getClass()).getReadMethod().invoke(o).toString());

            if (contador%2 != 0){
                ps.setString(contador, new PropertyDescriptor(fields[contador +1].getName(), o.getClass()).getName().toString());
            }
            contador = contador +1;


            ps.executeUpdate();
            ps.close();


        }
    }


    public Object get( String id, Class clase) throws Exception {

        Object o = clase.newInstance();
        String table = o.getClass().getSimpleName();
        statement = session.createStatement();
        String preparedQuery = null;
        String query = null;
        int contador = 1;


        //Field[] fields = o.getClass().getDeclaredFields();
        Field[] fields = clase.getDeclaredFields();

        for (int i = 1; i <= fields.length; i++) {
            if (i == 1 || i != fields.length) {
                preparedQuery = "?,";
            } else {
                preparedQuery += "?";
            }
        }

        query = "SELECT " + preparedQuery + " FROM " + table + "WHERE id =" + id;


        PreparedStatement ps = this.session.prepareStatement(query);
/*
        for(Field f : fields){
            ps.setString(contador, new PropertyDescriptor(fields[contador - 1].getName(),o.getClass()).getReadMethod().invoke(o).toString() );
            contador++;

        }*/

        resultSet = ps.executeQuery();
        o = writeResultSet(resultSet, o);

        ps.close();


        return  o;


    }


    private Object writeResultSet(ResultSet resultSet, Object instancia) throws Exception {
        try{
            int contador = 1 ;
            int p = 0;

//        if (resultSet!=null && resultSet.next()) {
            //else

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int nCols = rsmd.getColumnCount();

            System.out.println(rsmd.getColumnCount());
            System.out.println(rsmd.getColumnName(1));
            System.out.println(rsmd.getColumnName(2));
            System.out.println(rsmd.getColumnType(1));
            System.out.println(rsmd.getColumnType(2));


            int i =0;
            String property = null;
            Method m = instancia.getClass().getMethod(instancia.getClass().getSimpleName());

            while (i < nCols) {
                // switch

                property = rsmd.getColumnName(i);
                setter(instancia, m, resultSet.getString(i),property);
            }

        /*
        LinkedList<String> lista = new LinkedList<String>();
        int i = 1;
        Field[] fields = instancia.getClass().getDeclaredFields();
        while(i<= fields.length){
            lista.add(resultSet.getString(fields[i].getName()));
            i++;
        }




        while (p < lista.size() ) {

            String set = fields[p].getName();
            String set2 = "set"+set;
            // set.substring(0,1).toUpperCase()+set.substring(1);

            Method m = instancia.getClass().getMethod(set2);
            m.invoke(instancia, lista.get(p));

            Object[] params = {instancia.getClass().getMethod("Usuario")};
           Object a = m.invoke(instancia, "guillermo");


          }
*/
            return instancia;

        }catch (Exception e){
            System.out.println("no va");
            throw e;
        }
    }

    public Object setter (Object a, Method m, String result, String param) throws Exception{

        m.invoke(a,param,result);
        return a;
    }
}






