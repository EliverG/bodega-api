package com.bodega.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bodega.model.Usuarios;

@Repository
public interface UsuariosDaoInt extends JpaRepository<Usuarios, Integer>{

	@Query(value="select new com.bodega.model.Usuarios(u.usuario, u.nombre) from Usuarios u where u.usuario = ?1 and contrasena = ?2")
	public Usuarios findUserLogin(String usuario, String contrasena);
}
