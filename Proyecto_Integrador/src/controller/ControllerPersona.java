package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.DaoPersona;
import model.Persona;

public class ControllerPersona {

	public void enviaDatoEstudiante(int id_usuario, String nombre, String apellido, String correo,String clave,
			int id_perfil) throws SQLException {

		DaoPersona daoAlumno = new DaoPersona();
		daoAlumno.envioPersona(id_usuario, nombre, apellido, correo, clave,id_perfil);
	}
	
	
	 public ArrayList<Persona> ImprimirPersona() throws SQLException{
	        DaoPersona daoalumno;
	        daoalumno = new DaoPersona();
	        return daoalumno.FindAllPersonas();
	    }
}