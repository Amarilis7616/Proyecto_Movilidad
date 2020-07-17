package model;

public class Persona {
	
	private int id_usuario;
	private String nombre;
	private String apellido;
	private String direccion;
	private String correo;
	private int id_perfil;
	
	public Persona() {
		
	}
	
	public Persona(int id_usuario,String nombre, String apellido, String correo, int id_perfil) {
		this.id_usuario=id_usuario;
		this.nombre=nombre;
		this.apellido=apellido;
		this.correo=correo;
		this.id_perfil=id_perfil;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	public int getId_perfil() {
		return id_perfil;
	}
	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}
	
	
	

}
