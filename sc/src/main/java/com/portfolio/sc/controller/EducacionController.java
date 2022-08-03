
// EDUCACION CONTROLLER

package com.portfolio.sc.controller;

import com.portfolio.sc.model.Educacion;
import com.portfolio.sc.service.IService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class EducacionController {
    
    @Autowired
    private IService<Educacion> ieducacionService;
    
    //VER EDUCACION
    @GetMapping ("/educacion/ver")
    public List<Educacion> ver() throws Exception{
        return ieducacionService.ver();
    }    
    
    //GUARDAR EDUCACION
    @PostMapping ("/educacion/guardar")
    public void guardarEducacion(@RequestBody Educacion educacion) throws Exception{
        ieducacionService.guardar(educacion);
    }
    
    //BORRAR EDUCACION
    @DeleteMapping ("/educacion/borrar/{id}")
    public void borrarEducacion(@PathVariable Long id) throws Exception{
        ieducacionService.borrar(id);
    }
        
    //EDITAR EDUCACION
    @PutMapping ("/educacion/editar/{id}")
    public ResponseEntity<Educacion> actualizarEducacion 
                            (@PathVariable Long id,
                             @RequestBody Educacion nuevaEducacion) throws Exception {
        
        Educacion educacion = this.ieducacionService.buscar(id);
        
        educacion.setTituloEdu(nuevaEducacion.getTituloEdu());
        educacion.setFechaEdu(nuevaEducacion.getFechaEdu());
        educacion.setInstitucionEdu(nuevaEducacion.getInstitucionEdu());
        educacion.setDescripcionEdu(nuevaEducacion.getDescripcionEdu());
        educacion.setImg_LogoEdu(nuevaEducacion.getImg_LogoEdu());
        
        //Nueva experiencia        
        ieducacionService.guardar(educacion);
              
        return ResponseEntity.ok(educacion);
    }
    
}
