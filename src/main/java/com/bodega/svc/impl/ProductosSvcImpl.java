package com.bodega.svc.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bodega.dao.ProductosDaoInt;
import com.bodega.model.Productos;
import com.bodega.svc.interfaces.ProductosSvcInt;

@Service
public class ProductosSvcImpl implements ProductosSvcInt{
	
	@Autowired
	ProductosDaoInt productosData;

	@Override
	public List<Productos> listAllProducts() {
		return (List<Productos>) productosData.findAll();
	}

	@Override
	public void deleteProductById(int idProduct) {
		productosData.deleteById(idProduct);
	}

	@Override
	public Optional<Productos> getProductById(int idProduct) {
		return productosData.findById(idProduct);
	}
	
}
