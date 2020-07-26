package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.DaoPersona;
import model.Persona;

public class ControllerPersona {

	public String DatoEstudiante(int id_usuario, String nombre, String apellido,
			String correo, String clave, int id_perfil) {
		DaoPersona persona = new DaoPersona();
		String respuesta = "";
		try {
		    persona.envioPersona(id_usuario, nombre, apellido, correo, clave, id_perfil);
			respuesta = "RegCor";
		} catch (Exception e) {
			respuesta = "no";
		}

		return respuesta;
	}
	
	public String agregarPersona(int id_usuario, String nombre, String apellido, String correo,
			String clave, int id_perfil) {
		DaoPersona daoAlumno = new DaoPersona();
		String respuesta = daoAlumno.Registrar(id_usuario, nombre, apellido, correo, clave, id_perfil);
		return respuesta;
	}
	
	
	 public ArrayList<Persona> ImprimirPersona() throws SQLException{
	        DaoPersona daoalumno;
	        daoalumno = new DaoPersona();
	        return daoalumno.FindAllPersonas();
	    }
}