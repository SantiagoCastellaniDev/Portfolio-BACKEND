
//Interface Generica 

package com.portfolio.sc.service;

import java.util.List;


public interface IService <X> {
    
    //Generico VER DATOS (podria cambiarse por findAll)
    public List<X> ver() throws Exception;
    
    //Generico BUSCAR POR ID  (podria cambiarse por findById)  
    public X buscar(Long id) throws Exception;
    
    //Generico GUARDAR DATOS  (podria cambiarse por save)
    public void guardar(X entidad) throws Exception;
    
    //Generico BORRAR DATOS  (podria cambiarse por deleteById)
    public void borrar(Long id) throws Exception;    
    
}
