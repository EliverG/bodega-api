package com.bodega.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class Usuarios {
	
	@Id
	private Integer id;
	
	private String usuario;
	
	private String contrasena;
	
	private String nombre;
	

	public Usuarios(String usuario, String nombre) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
	}

	public Usuarios() {
		super();
	}
	
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", usuario=" + usuario + ", contrasena=" + contrasena + ", nombre=" + nombre
				+ "]";
	}
	
	

}
