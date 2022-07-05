
// EXPERIENCIA CONTROLLER

package com.portfolio.sc.controller;

import com.portfolio.sc.model.Experiencia;
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
public class ExperienciaController {
    
    @Autowired
    private IService<Experiencia> iexperienciaService;
    
    //VER EXPERIENCIA
    @GetMapping ("/experiencia/ver")
    public List<Experiencia> ver() throws Exception{
        return iexperienciaService.ver();
    }    
    
    //GUARDAR EXPERIENCIA
    @PostMapping ("/experiencia/guardar")
    public void guardarExperiencia(@RequestBody Experiencia experiencia) throws Exception{
        iexperienciaService.guardar(experiencia);
    }
    
    //BORRAR EXPERIENCIA
    @DeleteMapping ("/experiencia/borrar/{id}")
    public void borrarExperiencia(@PathVariable Long id) throws Exception{
        iexperienciaService.borrar(id);
    }
    
    //EDITAR EXPERIENCIA
    @PutMapping ("/experiencia/editar/{id}")
    public Experiencia newExperiencia (@PathVariable Long id,
                                 @RequestParam("puestoEx") String newPuestoEx,
                                 @RequestParam("fechaEx") String newFechaEx,
                                 @RequestParam("empresaEx") String newEmpresaEX,
                                 @RequestParam("descripcionEx") String newDescrpcionEx,
                                 @RequestParam("img_LogoEx") String newImg_LogoEx) throws Exception{
        
        Experiencia experiencia = iexperienciaService.buscar(id);
        //nuevo seteo
        experiencia.setPuestoEx(newPuestoEx);
        experiencia.setFechaEx(newFechaEx);
        experiencia.setEmpresaEx(newEmpresaEX);
        experiencia.setDescripcionEx(newDescrpcionEx);
        experiencia.setImg_LogoEx(newImg_LogoEx);
        
        //Nueva experiencia        
        iexperienciaService.guardar(experiencia);
        return experiencia;       
        
    }
    
}
