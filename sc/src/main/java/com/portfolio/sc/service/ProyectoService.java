
// Implementacion PROYECTO SERVICE

package com.portfolio.sc.service;

import com.portfolio.sc.model.Proyecto;
import com.portfolio.sc.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IService<Proyecto>{
    
    @Autowired
    private ProyectoRepository proyeRepo;
    
    //VER
    @Override
    public List<Proyecto> ver() throws Exception {
       List<Proyecto> listaProyecto = proyeRepo.findAll();
       return listaProyecto;
    }
    
    //BUSCAR
    @Override
    public Proyecto buscar(Long id) throws Exception {
        Proyecto proyecto = proyeRepo.findById(id).orElse(null);        
        return proyecto;
    }
    
    //GUARDAR
    @Override
    public void guardar(Proyecto proyecto) throws Exception {
        proyeRepo.save(proyecto);
    }
    
    //BORRAR
    @Override
    public void borrar(Long id) throws Exception {
        proyeRepo.deleteById(id);
    }
    
    //ACTUALIZAR
    @Override
    public void actualizar(Long id, Proyecto proyecto) throws Exception {
        proyeRepo.save(proyecto);
    }
    
}
