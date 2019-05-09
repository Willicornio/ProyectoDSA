package Dao;


    public class Factoria extends Session   {




        public static Session getSession() {
            Session s = new Session();
            return s;
        }


    }


