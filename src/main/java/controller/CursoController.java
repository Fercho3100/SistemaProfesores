/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion1.CursosGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.curso;

/**
 *
 * @author User
 */
@Named(value = "cursoController")
@SessionScoped
public class CursoController extends curso implements Serializable {

    /**
     * Creates a new instance of EstudianteController
     */
    

    private curso selectedcarrera;

    public curso getSelectedcarrera() {
        return selectedcarrera;
    }

    public void setSelectedcarrera(curso selectedcarrera) {
        this.selectedcarrera = selectedcarrera;
    } 
       
    public CursoController() {
        
    }

    public List<curso> getCursos() {
        return CursosGestion.getCurso();
    }
    
    public List<curso> getSelectcarreras() {
        return CursosGestion.getCarrerasSelect();
    }

    //Metodo encargado de mandar el parametro para la busqueda de un estudiante y 
    //mostrarlo en edita.xhtml
    public String editaCurso(int id) {
        curso curso_ =  CursosGestion.getCurso(id);
        if (curso_ != null) {
            
             // carrera
            this.setNombre_carrera(curso_.getNombre_carrera());
            this.setCodigo(curso_.getCodigo());
            this.setCreditos(curso_.getCreditos());
            this.setId_carrera(curso_.getId_carrera());
            
            // curso
            this.setNombre_curso(curso_.getNombre_curso());
            this.setDuracion_curso(curso_.getDuracion_curso());
            this.setDescripcion_curso(curso_.getDuracion_curso());
            this.setId_curso(curso_.getId_curso());

            return "edita.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "list.xhtml";
        }

    }


    public String updatecurso() {
        if (CursosGestion.update(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al modificar el estudiante");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";

        }
    }
/*
    public String deleteEstudiante() {
        if (EstudianteGestion.delete(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al eliminar el estudiante");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";
        }
    }*/
    
    public String Insertarcurso() {
        if (CursosGestion.insert(this)) {
            this.setNombre_curso("");
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al agregar el profesor");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "list.xhtml";
        }
    }
    
    public String inserta() {
      
       return "inserta.xhtml";
    }

}
