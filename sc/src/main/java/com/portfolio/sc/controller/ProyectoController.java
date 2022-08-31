
// PROYECTO CONTROLLER

package com.portfolio.sc.controller;

import com.portfolio.sc.model.Proyecto;
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
public class ProyectoController {

   
    @Autowired
    private IService<Proyecto> iproyectoService;
    
    //VER PROYECTO
    @GetMapping ("/proyecto/ver")
    public List<Proyecto> ver() throws Exception{
        return iproyectoService.ver();
    }
    
    //GUARDAR PROYECTO
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/proyecto/guardar")    
    public void guardarProyecto(@RequestBody Proyecto proyecto) throws Exception{
        iproyectoService.guardar(proyecto);
    }
    
    //BORRAR PROYECTO
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/proyecto/borrar/{id}")
    public void borrarProyecto(@PathVariable Long id) throws Exception{
        iproyectoService.borrar(id);
    }
    
    //EDITAR PROYECTO
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/proyecto/editar/{id}")
    public ResponseEntity<Proyecto> actualizarExperiencia 
                            (@PathVariable Long id,
                             @RequestBody Proyecto nuevoProyecto) throws Exception {
        
        Proyecto proyecto = this.iproyectoService.buscar(id);
        
        proyecto.setNombreProject(nuevoProyecto.getNombreProject());
        proyecto.setFechaProject(nuevoProyecto.getFechaProject());
        proyecto.setPuestoProject(nuevoProyecto.getPuestoProject());
        proyecto.setDescripcionProject(nuevoProyecto.getDescripcionProject());
        proyecto.setImg_Project(nuevoProyecto.getImg_Project());
        
        //Nuevo proyecto        
        iproyectoService.guardar(proyecto);
              
        return ResponseEntity.ok(proyecto);
    }    
    
    
}
