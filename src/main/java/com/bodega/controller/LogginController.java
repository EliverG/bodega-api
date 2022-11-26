package com.bodega.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.dao.UsuariosDaoInt;
import com.bodega.model.GenericResponse;
import com.bodega.model.Usuarios;

@RequestMapping
@RestController
public class LogginController {
	
	@Autowired
	UsuariosDaoInt usuariosDao;
	
    private static final Logger logger = Logger.getLogger(LogginController.class.getName());

	
	@RequestMapping(method = RequestMethod.POST, value="login")
	public GenericResponse accessGrant(@RequestBody Usuarios users) {

        GenericResponse genericResponse = new GenericResponse();
        Usuarios loginResult = usuariosDao.findUserLogin(users.getUsuario(), users.getContrasena());
        
		try {
			if(loginResult != null) {
				genericResponse.setStatus(200);
				genericResponse.setMessage("usuario encontrado");
				genericResponse.setBody(loginResult);	
			}else {
				genericResponse.setStatus(204);
				genericResponse.setMessage("No data found");
				genericResponse.setBody(loginResult);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "error en: {0}" , e.getMessage());
			genericResponse.setStatus(406);
            genericResponse.setMessage("Error service:  " + e.getMessage());
		}
		return genericResponse;
	}
}
