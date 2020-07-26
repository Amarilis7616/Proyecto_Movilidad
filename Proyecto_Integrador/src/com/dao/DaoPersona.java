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
	        re = cl.consulta("select * from usuarios;");
	        int id_usuario;
	        String nombre;
	        String apellido;
	        String correo_electronico;
	        String Clave;
	        int id_perfil;
	        while (re.next()) {
	        	id_usuario = re.getInt(1);
	            nombre = re.getString(2);
	            apellido = re.getString(3);
	            correo_electronico= re.getString(4);
	            Clave = re.getString(5);
	            id_perfil = re.getInt(6);
	            persona.add(new Persona(id_usuario,nombre,apellido,correo_electronico,Clave,id_perfil));
	        }
	        return persona;
	    }
	 
	 public ArrayList<Persona> envioPersona(int id_usuario,String nombre, String apellido,String correo,String Clave, int id_perfil) 
			 throws SQLException {
		 	Persona persona = new Persona(id_usuario,nombre,apellido,correo,Clave,id_perfil);
	        persona.setId_usuario(id_usuario);
		 	persona.setNombre(nombre);
	        persona.setApellido(apellido);
	        persona.setCorreo_electronico(correo);
	        persona.setClave(Clave);
	        persona.setId_perfil(id_perfil);

	        Cls_conexion cl = new Cls_conexion();
	        cl.ejecutar("insert into usuarios (nombre, apellido,correo, clave, id_perfil) values('" + nombre + "','" + apellido + "','" 
	        + correo + "','" + Clave + "'," + 2 +" );");

	        return this.FindAllPersonas();
				
			
	    }
	 
	 public String Registrar(int id_persona, String nombre, String apellido, String correo,String clave,
				 int id_perfil) {
			String result = "";
			Cls_conexion cl = new Cls_conexion();
			PreparedStatement usuario = null;
			String sql = "INSERT INTO usuarios(nombre, apellido, correo, clave, id_perfil)";
			sql += "VALUES(?,?,?,?,?)";
			try {
			    usuario = cl.getConexion().prepareStatement(sql);
				usuario.setString(1, nombre);
				usuario.setString(2, apellido);
				usuario.setString(3, correo);
				usuario.setString(4, clave);
				usuario.setInt(5, 2);

				if (usuario.executeUpdate() == 1) {
					result = "RegistroCorrecto";
				} else {
					result = "error";
				}
			} catch (Exception ex) {
				result = ex.getMessage();
			} finally {
				try {
					usuario.close();
					cl.getConexion().close();
				} catch (Exception ex) {
					result = ex.getMessage();
				}
			}

			return result;
		}

	 
 
 }


