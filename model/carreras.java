/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Fernando
 */
public class carreras {
    private int id_carrera;
    private int creditos;
    private String nombre_carrera,codigo,fecha_ingreso;

    public carreras(int id_carrera, String nombre_carrera) {
        this.id_carrera = id_carrera;
        this.nombre_carrera = nombre_carrera;
    }

    
    public carreras() {
    }

    public carreras(int id_carrera, int creditos, String nombre_carrera, String codigo, String fecha_ingreso) {
        this.id_carrera = id_carrera;
        this.creditos = creditos;
        this.nombre_carrera = nombre_carrera;
        this.codigo = codigo;
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }


    
}
