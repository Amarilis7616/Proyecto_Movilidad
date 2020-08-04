package com.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.conexion.Cls_conexion;

import controller.ControllerPersona;
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
	private String temporal;
	private String descripcion;
	

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
	
	
	public String getTemporal() {
		return temporal;
	}

	public String setTemporal(String temporal) {
		return this.temporal = temporal;
	}
	

	public String almaceneDatosPersona() throws SQLException {
		int perfil = 2;
		ControllerPersona controller = new ControllerPersona();

		String respuesta = controller.DatosEstudiante(id_usuario, nombre, apellido,
				correo, clave, perfil,descripcion);

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

	public String addUsuario() {
		int perfil = 2;
		String pro = "";
		ControllerPersona controller = new ControllerPersona();
		String respuesta = controller.agregarPersona(id_usuario, nombre, apellido, correo,
				clave, perfil);
		clear();
		if (respuesta == "RegCor")
			pro = "AddCor";
		return pro;
	}

	public void clear() {
		setNombre(null);
		setApellido(null);
		setCorreo(null);
		setClave(null);

	}
	
	public void clearLogin() {
		
		setCorreo(null);
		setClave(null);

	}
	
	

	public ArrayList<Persona> listaPersona() throws SQLException {
		ControllerPersona controller = new ControllerPersona();
		return controller.ImprimePersona();
	}
	

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
		
	
	public String iniciarSesion() throws SQLException {
		ControllerPersona controller = new ControllerPersona();

        int valor = controller.login(correo, clave);

        if (valor != 0) {
        	        	
            if (valor == 1) {
            	clearLogin();
                return "PaginaAdmin.xhtml";           

            }

            if (valor == 2) {
            	clearLogin();
                return "PaginaRegistrado.xhtml";
            }

            
        } else {
        	clearLogin();
            return "no";
        }
        clearLogin();
        return "no";
    }
	
	public String eliminar(String correo) {
		String result = "";
		PreparedStatement st = null;
		Cls_conexion cl = new Cls_conexion();
		try {

			st = cl.getConexion().prepareStatement("delete from usuarios where correo = ? ");
			st.setString(1, correo);
           if (st.executeUpdate() == 1) {
				result = "eliminado";
			} else {
				result = "noelim";
			}
		} catch (Exception ex) {

			result = ex.getMessage();
		} finally {
			try {
				st.close();
				cl.getConexion().close();
			} catch (Exception ex) {
				result = ex.getMessage();
			}
		}
		return result;

	}
	
	//cambiar clave usuario
	
	public String ingresar(String correo) {
		temporal=setTemporal(correo);
		return "cambiarClave.xhtml";
	}
	
	public String modificarPer() {
		String result = "";
		Cls_conexion cl = new Cls_conexion();
		PreparedStatement pr = null;
		String sql = "UPDATE usuarios SET clave = ? where correo = ? ";
		try {
			pr = cl.getConexion().prepareStatement(sql);
			pr.setString(1, clave);
			pr.setString(2, temporal);
			if (pr.executeUpdate() == 1) {
				result = "usuarios.xhtml";
			} else {
				result = "usuarios.xhtml";
			}
		} catch (Exception ex) {
			result = ex.getMessage();
		} finally {
			try {
				pr.close();
				cl.getConexion().close();
			} catch (Exception ex) {
				result = ex.getMessage();
			}
		}

		return result;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
	
	
	

}