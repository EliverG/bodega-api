package com.bodega.svc.interfaces;

import java.util.List;
import java.util.Optional;

import com.bodega.model.Productos;

public interface ProductosSvcInt{
	
	public List<Productos>listAllProducts();
	
	public void deleteProductById(int idProduct);
	
	public Optional<Productos>getProductById(int idProduct);
	
	public int saveProduct(Productos p);
}
