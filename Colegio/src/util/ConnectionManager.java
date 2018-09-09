/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cbustamante
 */
public class ConnectionManager {

    private static Connection conn;

    public static Connection connect() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            try {
                //Iniciar la conexion
                Class.forName(ConfigManager.getConfig("dbdriver"));
                conn = DriverManager.getConnection(
                        ConfigManager.getConfig("dburl"), 
                        ConfigManager.getConfig("dbuser"), 
                        ConfigManager.getConfig("dbpassword"));
                System.out.println("Connection established ");
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

        }
        return conn;

    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Connection Test");
        Connection con = ConnectionManager.connect();
        System.out.println("Connection Realizada");
    }
    
    
    

}
