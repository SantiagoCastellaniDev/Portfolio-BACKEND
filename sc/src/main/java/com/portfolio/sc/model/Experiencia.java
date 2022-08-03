
// clase EXPERIENCIA

package com.portfolio.sc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Experiencia {
    
    //Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEx;
    
    private String puestoEx;
    
    private String fechaEx;
    
    private String empresaEx;

    private String descripcionEx;
    
    private String img_LogoEx;
    
    //Constructor

    public Experiencia() {
    }

    public Experiencia(Long idEx, String puestoEx, String fechaEx, String empresaEx, String descripcionEx, String img_LogoEx) {
        this.idEx = idEx;
        this.puestoEx = puestoEx;
        this.fechaEx = fechaEx;
        this.empresaEx = empresaEx;
        this.descripcionEx = descripcionEx;
        this.img_LogoEx = img_LogoEx;
    }
 
        
}
