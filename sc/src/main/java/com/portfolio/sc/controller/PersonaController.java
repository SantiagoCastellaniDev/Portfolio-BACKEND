
// PERSONA CONTROLLER

package com.portfolio.sc.controller;

import com.portfolio.sc.model.Persona;
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

//CROSS ORIGIN
@CrossOrigin(origins="*")
//CROSS ORIGIN

//REQUEST MAPPING indica donde esta mapeado, la url del front
//@RequestMapping("/persona")
//REQUEST MAPPING

public class PersonaController {
    
    @Autowired
    private IService<Persona> ipersonaService;
    
    //VER PERSONA
    @GetMapping ("/persona/ver")
    public List<Persona> ver() throws Exception{
        return ipersonaService.ver();
    }
    
    //GUARDAR PERSONA
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/persona/guardar")
    public String guardarPersona(@RequestBody Persona persona) throws Exception{
        ipersonaService.guardar(persona);
        return "La persona se guardó correctamente";
    }
    
    //BORRAR PERSONA
    @PreAuthorize("hasRole('ADMIN')")    
    @DeleteMapping ("/persona/borrar/{id}")
    public String borrarPersona(@PathVariable Long id) throws Exception{
        ipersonaService.borrar(id);
        return "La persona se eliminó correctamente";
    }
    
  
    //EDITAR PERSONA
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/persona/editar/{id}")
    public ResponseEntity<Persona> actualizarPersona
                            (@PathVariable Long id,
                             @RequestBody Persona nuevaPersona) throws Exception {
        
        Persona persona = this.ipersonaService.buscar(id);
        
        persona.setNombre(nuevaPersona.getNombre());
        persona.setApellido(nuevaPersona.getApellido());
        persona.setPresentacion(nuevaPersona.getPresentacion());
        persona.setDescripcion(nuevaPersona.getDescripcion());
        persona.setImg_perfil(nuevaPersona.getImg_perfil());
        persona.setImg_banner(nuevaPersona.getImg_banner());
       
        
        //Nueva persona      
        ipersonaService.guardar(persona);
              
        return ResponseEntity.ok(persona);
    }
                      


    
    
}
