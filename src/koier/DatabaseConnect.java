package koier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnect {
    private static Connection instance; hei

    static final String SQL_DRIVER = "com.mysql.jdbc.Driver";
    static final String SQL_URL = "jdbc:mysql://mysql.stud.ntnu.no/";
    static final String DB_NAME = "oyvbr_koie";
    static final String USER_NAME = "oyvbr_prosjekt1";
    static final String USER_PW = "oyvbr_prosjekt1";

    /**
     * @return Connection
     */
    public static Connection getInstance() {
        if (instance == null) createInstance();
        return instance;
    }

    private static Connection createInstance() {
        if (instance == null) {
            try {
                Class.forName(SQL_DRIVER).newInstance();
                instance = DriverManager.getConnection(SQL_URL + DB_NAME, USER_NAME, USER_PW);
            } catch (InstantiationException ie) {
                Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, ie.getMessage(), ie);
            } catch (IllegalAccessException iae) {
                Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, iae.getMessage(), iae);
            } catch (ClassNotFoundException nfe) {
                Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, nfe.getMessage(), nfe);
            } catch (SQLException e) {
                Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
       
        return instance;
    }


}