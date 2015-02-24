package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Creates a connection to the database and returns a Connection instance
 *
 */
public class DatabaseConnect {
	
    private static Connection instance;
    
 
    static final String SQL_DRIVER = "com.mysql.jdbc.Driver";
    static final String SQL_URL = "jdbc:mysql://mysql.stud.ntnu.no/";
    static final String DB_NAME = "<database name>";
    static final String USER_NAME = "<username with database access>";
    static final String USER_PW = ">user password>";
    
    /**
     * Returns a Connection object and calls createInstance() if the instance is null
     * 
     * @return Instance of the connection to the database
     */
    public static Connection getInstance() {
        if (instance == null) createInstance();
        return instance;
    }
    
    /**
     * Enables a connection to the database with the String objects SQL_DRIVER, SQL_URL, DB_NAME, USER_NAME, USER_PW
     * declared at the top of the class. Logs an error message if something in the connection is not right.
     * @return Instance of the connection to the database
     */
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
