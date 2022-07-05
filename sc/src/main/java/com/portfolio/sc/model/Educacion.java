
// clase EDUCACION

package com.portfolio.sc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Educacion {
    //Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEdu;
    
    private String tituloEdu;
    
    private String fechaEdu;
    
    private String institucionEdu;

    private String descripcionEdu;
    
    private String img_LogoEdu;
    
    //Constructor

    public Educacion() {
    }

    public Educacion(Long idEdu, String tituloEdu, String fechaEdu, String institucionEdu, String descripcionEdu, String img_LogoEdu) {
        this.idEdu = idEdu;
        this.tituloEdu = tituloEdu;
        this.fechaEdu = fechaEdu;
        this.institucionEdu = institucionEdu;
        this.descripcionEdu = descripcionEdu;
        this.img_LogoEdu = img_LogoEdu;
    }       
    
}
