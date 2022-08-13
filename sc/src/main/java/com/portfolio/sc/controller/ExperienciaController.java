
// EXPERIENCIA CONTROLLER

package com.portfolio.sc.controller;

import com.portfolio.sc.model.Experiencia;
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
public class ExperienciaController {
    
    @Autowired
    private IService<Experiencia> iexperienciaService;
    
    //VER EXPERIENCIA
    @GetMapping ("/experiencia/ver")
    public List<Experiencia> ver() throws Exception{
        return iexperienciaService.ver();
    }    
    
    //GUARDAR EXPERIENCIA
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/experiencia/guardar")
    public void guardarExperiencia(@RequestBody Experiencia experiencia) throws Exception{
        iexperienciaService.guardar(experiencia);
    }
    
    //BORRAR EXPERIENCIA
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/experiencia/borrar/{id}")
    public void borrarExperiencia(@PathVariable Long id) throws Exception{
        iexperienciaService.borrar(id);
    }
    
        
    //EDITAR EXPERIENCIA
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/experiencia/editar/{id}")
    public ResponseEntity<Experiencia> actualizarExperiencia 
                            (@PathVariable Long id,
                             @RequestBody Experiencia nuevaExperiencia) throws Exception {
        
        Experiencia experiencia = this.iexperienciaService.buscar(id);
        
        experiencia.setPuestoEx(nuevaExperiencia.getPuestoEx());
        experiencia.setFechaEx(nuevaExperiencia.getFechaEx());
        experiencia.setEmpresaEx(nuevaExperiencia.getEmpresaEx());
        experiencia.setDescripcionEx(nuevaExperiencia.getDescripcionEx());
        experiencia.setImg_LogoEx(nuevaExperiencia.getImg_LogoEx());
        
        //Nueva experiencia        
        iexperienciaService.guardar(experiencia);
              
        return ResponseEntity.ok(experiencia);
    }
    
}

