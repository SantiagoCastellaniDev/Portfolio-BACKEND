
//Interface Generica 

package com.portfolio.sc.service;

import java.util.List;


public interface IService <X> {
    
    //Generico VER DATOS (findAll)
    public List<X> ver() throws Exception;
    
    //Generico BUSCAR POR ID  (findById)  
    public X buscar(Long id) throws Exception;
    
    //Generico GUARDAR DATOS  (save)
    public void guardar(X entidad) throws Exception;
    
    //Generico BORRAR DATOS  (deleteById)
    public void borrar(Long id) throws Exception;
    
    //Generico ACTUALIZAR DATOS  (updateById)
    public void actualizar(Long id, X entidad) throws Exception;    
    
}
