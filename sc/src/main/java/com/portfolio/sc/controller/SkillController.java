
// SKILL CONTROLLER

package com.portfolio.sc.controller;

import com.portfolio.sc.model.Skill;
import com.portfolio.sc.service.IService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/skill/guardar")
    public void guardarSkill(@RequestBody Skill skill) throws Exception{
        iskillService.guardar(skill);
    }
    
    
    //BORRAR SKILL
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/skill/borrar/{id}")
    public void borrarSkill(@PathVariable Long id) throws Exception{
        iskillService.borrar(id);
    }
    
    
    //EDITAR SKILL
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/skill/editar/{id}")
    public ResponseEntity<Skill> actualizarSkill 
                            (@PathVariable Long id,
                             @RequestBody Skill nuevaSkill) throws Exception {
        
        Skill skill = this.iskillService.buscar(id);
        
        skill.setNombreSkill(nuevaSkill.getNombreSkill());
        skill.setNivelSkill(nuevaSkill.getNivelSkill());
        skill.setPorcentajeSkill(nuevaSkill.getPorcentajeSkill());
        skill.setColorSkill(nuevaSkill.getColorSkill());
        skill.setImg_Skill(nuevaSkill.getImg_Skill());
        
        
        //Nueva experiencia        
        iskillService.guardar(skill);
              
        return ResponseEntity.ok(skill);
    }
                            
}
