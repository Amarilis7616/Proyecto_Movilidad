package controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Persona;

@Named(value = "beanRegistroPersona")
@SessionScoped
public class BeanRegistroPersona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_usuario;
	private String nombre;
	private String apellido;
	private String correo_electronico;
	private String Clave;
	private int id_perfil;

	private Persona persona = new Persona();

	public BeanRegistroPersona() {

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

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		this.Clave = clave;
	}

	public int getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public void almacenDatosPersona() throws SQLException {
		int perfil = 2;
		ControllerPersona controller = new ControllerPersona();
		controller.enviaDatoEstudiante(id_usuario,nombre,apellido,correo_electronico,Clave,perfil);
	}

	public ArrayList<Persona> listaPersona() throws SQLException {
		ControllerPersona controller = new ControllerPersona();
		return controller.ImprimirPersona();
	}
	
	public String Menu(){
	    return "PaginaAdmin";
	    } 

}