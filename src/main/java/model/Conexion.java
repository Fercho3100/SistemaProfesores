/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Conexion {

    private static Conexion conexion;
    private static final String DBURL = "jdbc:mysql://localhost:3306/profesores?serverTimezone=UTC";
    private static Connection conn = null;

    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
                    .getDeclaredConstructor()
                    .newInstance();
            conn = DriverManager.getConnection(DBURL, "root", "8314579Kh$");
                System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException
                | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException ex) {
            System.out.println("No conectado");

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Singleton Patron de Diseño*/
    public static synchronized Connection getConexion() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conn;
    }

}
