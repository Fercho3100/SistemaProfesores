/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion1.CarreraGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.carreras;

/**
 *
 * @author User
 */
@Named(value = "carrerasController")
@SessionScoped
public class CarrerasController extends carreras implements Serializable {

    /**
     * Creates a new instance of EstudianteController
     */
    public CarrerasController() {
    }

    public List<carreras> getCarreras() {
        System.out.println(CarreraGestion.getCarreras());
        return CarreraGestion.getCarreras();
    }

    
    public String editaCarrera(int id) {
        carreras carreras_ = CarreraGestion.getCarrera(id);
        if (carreras_ != null) {
            
            this.setNombre_carrera(carreras_.getNombre_carrera());
            this.setCodigo(carreras_.getCodigo());
            this.setCreditos(carreras_.getCreditos());
            this.setId_carrera(carreras_.getId_carrera());

            return "edita.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "list.xhtml";
        }

    }


    public String updateCarrera() {
        if (CarreraGestion.update(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Ocurrio un error al modificar el estudiante");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "edita.xhtml";

        }
    }

    public String saveRecord(){
        return "list.xhtml";
    }
    public String InsertarCarreraa(){
        if (CarreraGestion.insert(this)) {
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
