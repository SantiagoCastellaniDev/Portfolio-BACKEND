
// Implementacion EDUCACION SERVICE

package com.portfolio.sc.service;

import com.portfolio.sc.model.Educacion;
import com.portfolio.sc.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IService<Educacion>{
    
    @Autowired
    private EducacionRepository educaRepo;
    
    //VER
    @Override
    public List<Educacion> ver() throws Exception {
       List<Educacion> listaEducacion = educaRepo.findAll();
       return listaEducacion;
    }
    
    //BUSCAR
    @Override
    public Educacion buscar(Long id) throws Exception {
        Educacion educacion = educaRepo.findById(id).orElse(null);
        return educacion;
    }
    
    //GUARDAR
    @Override
    public void guardar(Educacion educacion) throws Exception {
        educaRepo.save(educacion);
    }
    
    //BORRAR
    @Override
    public void borrar(Long id) throws Exception {
        educaRepo.deleteById(id);
    }
    
    //ACTUALIZAR
    @Override
    public void actualizar(Long id, Educacion educacion) throws Exception {
        educaRepo.save(educacion);
    }
    
}
