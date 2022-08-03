
// Implementacion SKILL SERVICE

package com.portfolio.sc.service;

import com.portfolio.sc.model.Skill;
import com.portfolio.sc.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements IService<Skill>{
    
    @Autowired
    private SkillRepository skillRepo;
    
    //VER
    @Override
    public List<Skill> ver() throws Exception {
       List<Skill> listaSkill = skillRepo.findAll();
       return listaSkill;
    }
    
    //BUSCAR
    @Override
    public Skill buscar(Long id) throws Exception {
        Skill skill = skillRepo.findById(id).orElse(null);        
        return skill;
    }
    
    //GUARDAR
    @Override
    public void guardar(Skill skill) throws Exception {
        skillRepo.save(skill);
    }
    
    //BORRAR
    @Override
    public void borrar(Long id) throws Exception {
        skillRepo.deleteById(id);
    }
    
    //ACTUALIZAR
    @Override
    public void actualizar(Long id, Skill skill) throws Exception {
        skillRepo.save(skill);
    }
    
}
