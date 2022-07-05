
// PROYECTO CONTROLLER

package com.portfolio.sc.controller;

import com.portfolio.sc.model.Proyecto;
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
public class ProyectoController {

   
    @Autowired
    private IService<Proyecto> iproyectoService;
    
    //VER PROYECTO
    @GetMapping ("/proyecto/ver")
    public List<Proyecto> ver() throws Exception{
        return iproyectoService.ver();
    }
    
    //GUARDAR PROYECTO
    @PostMapping ("/proyecto/guardar")
    public void guardarProyecto(@RequestBody Proyecto proyecto) throws Exception{
        iproyectoService.guardar(proyecto);
    }
    
    //BORRAR PROYECTO
    @DeleteMapping ("/proyecto/borrar/{id}")
    public void borrarProyecto(@PathVariable Long id) throws Exception{
        iproyectoService.borrar(id);
    }
    
    //EDITAR PROYECTO
    @PutMapping ("/proyecto/editar/{id}")
    public Proyecto  newProyecto (@PathVariable Long id,
                                 @RequestParam("nombreProject") String newNombreProject,
                                 @RequestParam("fechaProject") String newFechaProject,
                                 @RequestParam("puestoProject") String newPuestoProject,
                                 @RequestParam("descripcionProject") String newDescrpcionProject,
                                 @RequestParam("img_Project") String newImg_Project) throws Exception{
        
        Proyecto proyecto = iproyectoService.buscar(id);
        //nuevo seteo
        proyecto.setNombreProject(newNombreProject);
        proyecto.setFechaProject(newFechaProject);
        proyecto.setPuestoProject(newPuestoProject);
        proyecto.setDescripcionProject(newDescrpcionProject);
        proyecto.setImg_Project(newImg_Project);
                
        //Nuevo Proyecto        
        iproyectoService.guardar(proyecto);
        return proyecto;       
        
    }
    
    
}
