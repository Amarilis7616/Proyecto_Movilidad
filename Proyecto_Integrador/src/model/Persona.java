package model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Persona;
import java.io.Serializable;


@Named(value="persona")
@SessionScoped

public class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_usuario;
	private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private int id_perfil;
    private String descripcion;
    
    public Persona() {
    	
    }
    
    public Persona(int id_usuario,String nombre, String apellido, String correo, String clave, int id_perfil, String descripcion) {
    	this.id_usuario = id_usuario;
    	this.nombre= nombre;
    	this.apellido = apellido;
    	this.correo = correo;
    	this.clave=clave;
    	this.id_perfil = id_perfil;
    	this.setDescripcion(descripcion);
    }
    
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}