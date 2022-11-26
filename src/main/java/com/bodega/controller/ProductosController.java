package com.bodega.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.model.GenericResponse;
import com.bodega.model.Productos;
import com.bodega.svc.interfaces.ProductosSvcInt;

@RequestMapping
@RestController
public class ProductosController {

	@Autowired
	ProductosSvcInt productos;

	private static final Logger logger = Logger.getLogger(ProductosController.class.getName());

	@RequestMapping(method = RequestMethod.GET, value = "list/products")
	public GenericResponse ListProducts() {
		GenericResponse response = new GenericResponse();
		List<Productos> lstProducts = productos.listAllProducts();
		
		try {
			if (!lstProducts.isEmpty()) {
				response.setStatus(200);
				response.setMessage("se obtuvo la lista de productos");
				response.setBody(lstProducts);
			} else {
				response.setStatus(204);
				response.setMessage("products no data found");
				response.setBody(lstProducts);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "error en servicio: ", e.getMessage());
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "delete/{id}")
	public GenericResponse deleteProductById(@PathVariable int id) {
		GenericResponse response = new GenericResponse();

		try {
			productos.deleteProductById(id);
			response.setStatus(200);
			response.setMessage("registro eliminado correctamente");
			response.setBody(id);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "error en servicio de eliminacion: " + e.getMessage());
			response.setStatus(204);
			response.setMessage("fallo al eliminar el producto: " + e.getMessage());
			response.setBody(null);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "get-product-id/{id}")
	public GenericResponse getProductById(@PathVariable int id) {
		
		GenericResponse response = new GenericResponse();
		
		try {
			
			Optional<Productos> result = productos.getProductById(id);
			response.setStatus(200);
			response.setMessage("se obtuvo el registro");
			response.setBody(result);
		} catch (Exception e) {
			response.setStatus(204);
			response.setMessage("No data found");
			response.setBody(null);
		}
		return response;
	}
}
