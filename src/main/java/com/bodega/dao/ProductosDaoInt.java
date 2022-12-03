package com.bodega.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bodega.model.Productos;

@Repository
public interface ProductosDaoInt extends CrudRepository<Productos, Integer>{

}
