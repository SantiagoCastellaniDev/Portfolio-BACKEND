
// EDUCACION CONTROLLER

package com.portfolio.sc.controller;

import com.portfolio.sc.model.Educacion;
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
public class EducacionController {
    
    @Autowired
    private IService<Educacion> ieducacionService;
    
    //VER EDUCACION
    @GetMapping ("/educacion/ver")
    public List<Educacion> ver() throws Exception{
        return ieducacionService.ver();
    }
    
    //BUSCAR EDUCACION
    
    
    
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
    public Educacion newEducacion (@PathVariable Long id,
                                 @RequestParam("tituloEdu") String newTituloEdu,
                                 @RequestParam("fechaEdu") String newFechaEdu,
                                 @RequestParam("institucionEdu") String newInstitucionEdu,
                                 @RequestParam("descripcionEdu") String newDescrpcionEdu,
                                 @RequestParam("img_LogoEdu") String newImg_LogoEdu) throws Exception{
        
        Educacion educacion = ieducacionService.buscar(id);
        //nuevo seteo
        educacion.setTituloEdu(newTituloEdu);
        educacion.setFechaEdu(newFechaEdu);
        educacion.setInstitucionEdu(newInstitucionEdu);
        educacion.setDescripcionEdu(newDescrpcionEdu);
        educacion.setImg_LogoEdu(newImg_LogoEdu);
        
        //Nueva educacion        
        ieducacionService.guardar(educacion);
        return educacion;       
        
    }
    
}
