package Dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Logger;

public class Session {

    Logger log = Logger.getLogger(Session.class.getName());
    Connection session = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    protected Session () {

        try {
            this.session = getConnection();

        }catch (Exception e){
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

    public void save (Object o) throws SQLException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        statement = session.createStatement();
        String preparedQuery = null;
        String query = null;
        int contador = 1;

        String table = o.getClass().getSimpleName();
        log.info(table);
        Field[] fields = o.getClass().getDeclaredFields();


        for(int i = 1; i <= fields.length; i++){
            if(i == 1 || i != fields.length){
                preparedQuery = "?,";
            }else {
                preparedQuery += "?";
            }
        }

        query = "INSERT INTO " + table + " VALUES (" + preparedQuery +")";
        log.info(query);

        PreparedStatement ps =  this.session.prepareStatement(query);

        for(Field f : fields){
            ps.setString(contador, new PropertyDescriptor(fields[contador - 1].getName(),o.getClass()).getReadMethod().invoke(o).toString() );
            contador++;

        }

        ps.executeUpdate();
        log.info("OK!");
        ps.close();

    }





}

