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

/*
	
	public String eliminarUsuario(Persona persona) {
		String result = "";
		PreparedStatement st = null;
		Cls_conexion cl = new Cls_conexion();
		try {
			st = cl.getConexion().prepareStatement("delete from usuarios where id_usuario = ? ");
			st.setInt(1, persona.getId_usuario());
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
	
*/
/*	
    public void modificarPer(Persona persona) throws SQLException {

        Cls_conexion cl = new Cls_conexion();
        PreparedStatement st = cl.getConexion().prepareStatement("UPDATE persona SET clave = ? where cedula = ? ");
        st.setString(1, persona.getClave());
        st.setString(2, persona.getDoc_identidad());
        st.executeUpdate();

    }
    
*/  
	
/*
    public Persona LeerID(Persona persona) throws Exception {

        Persona per = new Persona();
        ResultSet re;
        Cls_conexion cl = new Cls_conexion();
        re = cl.consulta("select * from usuarios where id_usuario = " + persona.getId_usuario() + "");

        while (re.next()) {

            per.setId_usuario(re.getInt("id_usuario"));
            per.setClave(re.getString("clave"));
            per.setCorreo(re.getString("correo"));
        }
        return per;
    }
   
   /*
   
  /*  
    public ArrayList<Persona> FindAllCedulas() throws SQLException {
		ArrayList<Persona> persona = new ArrayList<>();

		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select cedula,clave from persona");
		
		String doc_identidad;
		
		
		while (re.next()) {
			
			doc_identidad = re.getString(1);
			
			
			persona.add(new Persona(doc_identidad));
		}
		return persona;
	} */
    

}