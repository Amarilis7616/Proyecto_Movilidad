package model;

public class Persona {
	private int id_usuario;
	private String nombre;
    private String apellido;
    private String correo_electronico;
    private String Clave;
    private int id_perfil;
    
    public Persona() {
    	
    }
    
    public Persona(int id_usuario,String nombre, String apellido, String correo, String clave, int id_perfil) {
    	this.id_usuario = id_usuario;
    	this.nombre= nombre;
    	this.apellido = apellido;
    	this.correo_electronico = correo;
    	this.Clave = clave;
    	this.id_perfil = id_perfil;
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

    
	
    
    

}