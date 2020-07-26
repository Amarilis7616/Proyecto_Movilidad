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
	private String correo;
	private String clave;
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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String almaceneDatosPersona() throws SQLException {
		int perfil = 2;
		ControllerPersona controller = new ControllerPersona();

		String respuesta = controller.enviaDatoEstudiante(id_usuario, nombre, apellido,
				correo, clave, perfil);

		return respuesta;
	}

	public String almacenarPersona() {
		int perfil = 2;
		ControllerPersona controller = new ControllerPersona();
		String respuesta = controller.agregarPersona(id_usuario, nombre, apellido, correo,
				clave, perfil);
		clear();
		return respuesta;
	}

	public String addPersona() {
		int perfil = 2;
		String r2 = "";
		ControllerPersona controller = new ControllerPersona();
		String respuesta = controller.agregarPersona(id_usuario, nombre, apellido, correo,
				clave, perfil);
		clear();
		if (respuesta == "RegCor")
			r2 = "AddCor";
		return r2;
	}

	public void clear() {
		setNombre(null);
		setApellido(null);
		setCorreo(null);
		setClave(null);

	}// end clear`
	
	public void clearLogin() {
		
		setCorreo(null);
		setClave(null);

	}
	
	

	public ArrayList<Persona> listaPersona() throws SQLException {
		ControllerPersona controller = new ControllerPersona();
		return controller.ImprimePersona();
	}
	
	/*public ArrayList<Persona> listaCedula() throws SQLException {
		ControllerPersona controller = new ControllerPersona();
		return controller.ImprimeCedula();
	}
	*/
	

	public String irEdicion() {
		return "editar_user";
	}

	public String irMenu() {
		return "menuadmin";
	}

	public String irLogin() {
		return "login";
	}

	public String irRegistro() {
		return "volReg";
	}
/*
    public void EliminarDatosPersona(Persona persona) throws SQLException{
        
    	ControllerPersona controller = new ControllerPersona();
        controller.eliminarPersona(persona);
       
    }

	public void ModificaDatosPersona() throws SQLException {

		ControllerPersona controller = new ControllerPersona();
		controller.modificarPersona(persona);

	}
	
	public String leerId(Persona persona) throws Exception {
	      
		ControllerPersona controller = new ControllerPersona();
        Persona per;
        
        per = controller.leerIDPersona(persona);
        
        if (per != null) {
            this.persona = per;
        }
        return "editar_user";
    }
	*/
	public String ingresoAlSistema() throws SQLException {
		ControllerPersona controller = new ControllerPersona();

        int valor = controller.login(correo, clave);

        if (valor != 0) {
        	        	
            if (valor == 1) {
            	clearLogin();
                return "" + valor;           

            }

            if (valor == 2) {
            	clearLogin();
                return "" + valor;
            }

            
        } else {
        	clearLogin();
            return "no";
        }
        clearLogin();
        return "no";
    }

}