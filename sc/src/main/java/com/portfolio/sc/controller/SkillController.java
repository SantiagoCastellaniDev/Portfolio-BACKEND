
// SKILL CONTROLLER

package com.portfolio.sc.controller;

import com.portfolio.sc.model.Skill;
import com.portfolio.sc.service.IService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class SkillController {
   
    @Autowired
    private IService<Skill> iskillService;
    
    //VER SKILL
    @GetMapping ("/skill/ver")
    public List<Skill> ver() throws Exception{
        return iskillService.ver();
    }
    
    //GUARDAR SKILL
    @PostMapping ("/skill/guardar")
    public void guardarSkill(@RequestBody Skill skill) throws Exception{
        iskillService.guardar(skill);
    }
    
    //BORRAR SKILL
    @DeleteMapping ("/skill/borrar/{id}")
    public void borrarSkill(@PathVariable Long id) throws Exception{
        iskillService.borrar(id);
    }
    
    //EDITAR SKILL
    @PutMapping ("/skill/editar/{id}")
    public Skill  newSkill (@PathVariable Long id,
                                 @RequestParam("nombreSkill") String newNombreSkill,
                                 @RequestParam("nivelSkill") String newNivelSkill,
                                 @RequestParam("porcentajeSkill") String newPorcentajeSkill,
                                 @RequestParam("colorSkill") String newColorSkill,
                                 @RequestParam("img_Skill") String newImg_Skill) throws Exception{
        
        Skill skill = iskillService.buscar(id);
        //nuevo seteo
        skill.setNombreSkill(newNombreSkill);
        skill.setNivelSkill(newNivelSkill);
        skill.setPorcentajeSkill(0);
        skill.setColorSkill(newColorSkill);
        skill.setImg_Skill(newImg_Skill);
                
        //Nuevo Skill       
        iskillService.guardar(skill);
        return skill;
        
    }
    
    
}
