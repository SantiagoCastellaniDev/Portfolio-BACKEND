
// clase PROYECTO

package com.portfolio.sc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Proyecto {
    
    //Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProject;
    
    private String nombreProject;
    
    private String fechaProject;
    
    private String puestoProject;

    private String descripcionProject;
    
    private String img_Project;
    
    //Constructor

    public Proyecto() {
    }

    public Proyecto(Long idProject, String nombreProject, String fechaProject, String puestoProject, String descripcionProject, String img_Project) {
        this.idProject = idProject;
        this.nombreProject = nombreProject;
        this.fechaProject = fechaProject;
        this.puestoProject = puestoProject;
        this.descripcionProject = descripcionProject;
        this.img_Project = img_Project;
    }    
    
}
