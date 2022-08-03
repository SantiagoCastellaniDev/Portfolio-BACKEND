
//Implementacion PERSONA SERVICE

package com.portfolio.sc.service;

import com.portfolio.sc.model.Persona;
import com.portfolio.sc.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IService<Persona> {
    
    @Autowired
    private PersonaRepository persoRepo;
    
    //VER
    @Override
    public List<Persona> ver() throws Exception {
       List<Persona> listaPersonas = persoRepo.findAll();
       return listaPersonas; 
    }
    
    //BUSCAR
    @Override
    public Persona buscar(Long id) throws Exception {
        Persona persona = persoRepo.findById(id).orElse(null);        
        return persona;
    }
    
    //GUARDAR
    @Override
    public void guardar(Persona persona) throws Exception {
        persoRepo.save(persona);
    }
    
    //BORRAR
    @Override
    public void borrar(Long id) throws Exception {
        persoRepo.deleteById(id);
    }
    
    //ACTUALIZAR
    @Override
    public void actualizar(Long id, Persona persona) throws Exception {
        persoRepo.save(persona);
    }
    
}
