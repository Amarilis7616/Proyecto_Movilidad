package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.conexion.Cls_conexion;


import model.Persona;



public class DaoPersona {
	
	public ArrayList<Persona> FindAllPersonas() throws SQLException {
		ArrayList<Persona> persona = new ArrayList<>();

		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select id_usuario, nombre, apellido, correo, clave, perfil.id_perfil, descripcion from usuarios,perfil where usuarios.id_perfil=perfil.id_perfil");
		int id_usuario;
		String nombre;
		String apellido;
		String correo;
		String clave;
		int id_perfil;
		String descripcion;
		while (re.next()) {
			id_usuario = re.getInt(1);
			nombre = re.getString(2);
			apellido = re.getString(3);
			correo = re.getString(4);
			clave = re.getString(5);
			id_perfil = re.getInt(6);
			descripcion=re.getString(7);
			persona.add(new Persona(id_usuario, nombre, apellido, correo, clave, id_perfil,descripcion));
		}
		return persona;
	}

	public ArrayList<Persona> envioPersona(int id_usuario, String nombre, String apellido,
			String correo, String clave, int id_perfil, String descripcion) throws SQLException {
		Persona persona = new Persona(id_usuario, nombre, apellido, correo, clave, 2,descripcion);
		persona.setId_usuario(id_usuario);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setCorreo(correo);
		persona.setClave(clave);
		persona.setId_perfil(id_perfil);

		Cls_conexion cl = new Cls_conexion();
		cl.ejecutar(
				"insert into usuarios (nombre, apellido, correo, clave, id_perfil) values ('"
						+ nombre + "','" + apellido + "','" + correo + "','" + clave + "','" + 2
						+ "');");
		return this.FindAllPersonas();

	}

	public String RegistrarUsuario(int id_usuario, String nombre, String apellido, String correo,
			String clave, int id_perfil) {
		String result = "";
		Cls_conexion cl = new Cls_conexion();
		PreparedStatement pr = null;
		String sql = "INSERT INTO usuarios(nombre, apellido, correo, clave, id_perfil)";
		sql += "VALUES(?,?,?,?,?)";
		try {
			pr = cl.getConexion().prepareStatement(sql);
			pr.setString(1, nombre);
			pr.setString(2, apellido);
			pr.setString(3, correo);
			pr.setString(4, clave);
			pr.setInt(5, 2);

			if (pr.executeUpdate() == 1) {
				result = "RegCor";
			} else {
				result = "no";
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


    

}