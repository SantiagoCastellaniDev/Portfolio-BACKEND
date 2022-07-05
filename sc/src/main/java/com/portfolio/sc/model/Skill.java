
// clase SKILL

package com.portfolio.sc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Skill {
    //Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSkill;
    
    private String nombreSkill;
    
    private String nivelSkill;
    
    private int porcentajeSkill;

    private String colorSkill;
    
    private String img_Skill;
    
    //Constructor

    public Skill() {
    }

    public Skill(Long idSkill, String nombreSkill, String nivelSkill, int porcentajeSkill, String colorSkill, String img_Skill) {
        this.idSkill = idSkill;
        this.nombreSkill = nombreSkill;
        this.nivelSkill = nivelSkill;
        this.porcentajeSkill = porcentajeSkill;
        this.colorSkill = colorSkill;
        this.img_Skill = img_Skill;
    }
        
}
