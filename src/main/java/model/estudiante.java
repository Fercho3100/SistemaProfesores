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
public class estudiante {
    private int id_estudiante;
    private String nombre,email,fecha_nacimiento,contrasena,desc_estudiante,nombre_carrera,identicacion;

    public estudiante() {
    }

    public estudiante(int id_estudiante, String nombre, String email, String fecha_nacimiento, String contrasena, String desc_estudiante, String nombre_carrera, String identicacion) {
        this.id_estudiante = id_estudiante;
        this.nombre = nombre;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.contrasena = contrasena;
        this.desc_estudiante = desc_estudiante;
        this.nombre_carrera = nombre_carrera;
        this.identicacion = identicacion;
    }


    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDesc_estudiante() {
        return desc_estudiante;
    }

    public void setDesc_estudiante(String desc_estudiante) {
        this.desc_estudiante = desc_estudiante;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public String getIdenticacion() {
        return identicacion;
    }

    public void setIdenticacion(String identicacion) {
        this.identicacion = identicacion;
    }
    
            
            
            
            
            
            
}
