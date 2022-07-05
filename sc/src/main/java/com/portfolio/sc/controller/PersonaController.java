
// PERSONA CONTROLLER

package com.portfolio.sc.controller;

import com.portfolio.sc.model.Persona;
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
    @PostMapping ("/persona/guardar")
    public String guardarPersona(@RequestBody Persona persona) throws Exception{
        ipersonaService.guardar(persona);
        return "La persona se guardó correctamente";
    }
    
    //BORRAR PERSONA
    @DeleteMapping ("/persona/borrar/{id}")
    public String borrarPersona(@PathVariable Long id) throws Exception{
        ipersonaService.borrar(id);
        return "La persona se eliminó correctamente";
    }
    
    //EDITAR PERSONA
    @PutMapping ("/persona/editar/{id}")
    public Persona nuevaPersona (@PathVariable Long id,
                                 @RequestParam("nombre") String newNombre,
                                 @RequestParam("apellido") String newApellido,
                                 @RequestParam("presentacion") String newPresentacion,
                                 @RequestParam("descripcion") String newDescrpcion,
                                 @RequestParam("img_perfil") String newImg_perfil,
                                 @RequestParam("img_banner") String newImg_banner) throws Exception{
        
        Persona persona = ipersonaService.buscar(id);
        //nuevo seteo
        persona.setNombre(newNombre);
        persona.setApellido(newApellido);
        persona.setPresentacion(newPresentacion);
        persona.setDescripcion(newDescrpcion);
        persona.setImg_perfil(newImg_perfil);
        persona.setImg_banner(newImg_banner);
        
        ipersonaService.guardar(persona);
        return persona;        
    }   
    
}
