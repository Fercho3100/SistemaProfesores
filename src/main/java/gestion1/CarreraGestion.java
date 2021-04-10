/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.carreras;
import model.estudiante;

/**
 *
 * @author Fernando
 */
public class CarreraGestion {
    private static final String SELECT_ALL = "SELECT * FROM carreras;";
    public static final String SELECT2 = "SELECT id_carrera,nombre_carrera FROM carreras;";
    private static final String SELECT_FILTER = "SELECT * FROM carreras WHERE id_carrera = ?;";
    private static final String UPDATE_FILTER = "UPDATE  carreras SET  nombre_carrera = ?,  codigo = ?,  creditos = ? WHERE id_carrera = ? ;";
    private static final String INSERT = "INSERT INTO carreras (  `nombre_carrera`,  `codigo`,  `creditos`) VALUES  (?,?,?) ;";
    
    public static ArrayList<carreras> getCarreras() {
        ArrayList<carreras> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SELECT_ALL);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new carreras(
                        rs.getInt(1),
                        rs.getInt(4),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CarreraGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return lista;

    }
    
    public static carreras getCarrera(int id) {
        carreras carreras_ = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SELECT_FILTER);
            sentencia.setInt(1, id);
            
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                carreras_ = new carreras(
                       rs.getInt(1),
                        rs.getInt(4),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarreraGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return carreras_;

    }
     
    public static boolean update(carreras carreras_) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(UPDATE_FILTER);
            sentencia.setString(1, carreras_.getNombre_carrera());
            sentencia.setString(2, carreras_.getCodigo());
            sentencia.setInt(3, carreras_.getCreditos());
            sentencia.setInt(4, carreras_.getId_carrera());

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(EstudianteGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
    public static boolean insert(carreras carreras_) {
        try { 
//            DELETE FROM estudiante where id=? and idEstudiante=?
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(INSERT);
            
            sentencia.setString(1, carreras_.getNombre_carrera());
            sentencia.setString(2, carreras_.getCodigo());
            sentencia.setInt(3, carreras_.getCreditos());

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CarreraGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
