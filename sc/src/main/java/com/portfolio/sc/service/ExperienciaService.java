
// Implementacion EXPERIENCIA SERVICE

package com.portfolio.sc.service;

import com.portfolio.sc.model.Experiencia;
import com.portfolio.sc.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IService<Experiencia>{
    
    @Autowired
    private ExperienciaRepository experiRepo;
    
    //VER
    @Override
    public List<Experiencia> ver() throws Exception {
       List<Experiencia> listaExperiencia = experiRepo.findAll();
       return listaExperiencia;
    }
        
    //BUSCAR
    @Override
    public Experiencia buscar(Long id) throws Exception {
        Experiencia experiencia = experiRepo.findById(id).orElse(null);
        return experiencia;
    }
    
    //GUARDAR
    @Override
    public void guardar(Experiencia experiencia) throws Exception {
        experiRepo.save(experiencia);
    }
    
    //BORRAR
    @Override
    public void borrar(Long id) throws Exception {
        experiRepo.deleteById(id);
    }
    
    
    //ACTUALIZAR
    @Override
    public void actualizar(Long id, Experiencia experiencia) throws Exception {
        experiRepo.save(experiencia);
    }
    
}
