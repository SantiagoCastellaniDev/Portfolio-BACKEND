
//clase PERSONA

package com.portfolio.sc.model;


import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Persona {
    
    //Atributos, definir cuales atributos quedan//
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;
    
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    
    private String presentacion;

    private String descripcion;
    
    private String img_perfil;
    
    private String img_banner;
    
    // CONSTRUCTORES
    
    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String presentacion, String descripcion, String img_perfil, String img_banner) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.presentacion = presentacion;
        this.descripcion = descripcion;
        this.img_perfil = img_perfil;
        this.img_banner = img_banner;
    }    
    
}
