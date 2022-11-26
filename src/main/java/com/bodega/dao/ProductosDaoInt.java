package com.bodega.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bodega.model.Productos;

@Repository
public interface ProductosDaoInt extends JpaRepository<Productos, Integer>{

}
