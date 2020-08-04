package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import com.dao.DaoPersona;
import model.Persona;

public class ControllerPersona {

	public String DatosEstudiante(int id_usuario, String nombre, String apellido,
			String correo, String clave, int id_perfil, String descripcion) {
		DaoPersona Alumno = new DaoPersona();
		String respuesta = "";
		try {
			Alumno.envioPersona(id_usuario, nombre, apellido, correo, clave, id_perfil,descripcion);
			respuesta = "RegCor";
		} catch (Exception e) {
			respuesta = "no";
		}

		return respuesta;
	}

	public String agregarPersona(int id_usuario, String nombre, String apellido, String correo,
			String clave, int id_perfil) {
		DaoPersona Alumno = new DaoPersona();
		String respuesta = Alumno.RegistrarUsuario(id_usuario, nombre, apellido, correo, clave,
				id_perfil);
		return respuesta;
	}
	
	
	public void forward() throws IOException {
		String url = "destination.xhtml";
		FacesContext.getCurrentInstance().getExternalContext().dispatch(url);
	}

	public ArrayList<Persona> ImprimePersona() throws SQLException {
		DaoPersona daoalumno;
		daoalumno = new DaoPersona();
		return daoalumno.FindAllPersonas();
	}

	
	public int login(String user, String pass) throws SQLException {
		DaoPersona daouser = new DaoPersona();
		for (Persona u : daouser.FindAllPersonas()) {
			if (u.getCorreo().equals(user) && u.getClave().equals(pass)) {
				return u.getId_perfil();
			}
		}
		return 0;
	}

}