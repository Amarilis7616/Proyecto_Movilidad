package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class clsConexion {
	private Statement St;
	private String driver;
	private String user;
	private String pwd;
	private String cadena;
	private Connection con;

	String getDriver() {
		return this.driver;
	}

	String getUser() {
		return this.user;
	}

	String getPwd() {
		return this.pwd;
	}

	String getCadena() {
		return this.cadena;
	}

	public Connection getConexion() {
		return this.con;
	}

	public clsConexion() {
		this.driver = "org.postgresql.Driver";
		this.user = "postgres";
		this.pwd = "ama";
		this.cadena = "jdbc:postgresql://localhost:5432/Reporte_Movilidad";
		this.con = this.crearConexion();
	}

	Connection crearConexion() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		}
		try {
			Class.forName(getDriver()).newInstance();
			Connection con = DriverManager.getConnection(getCadena(), getUser(), getPwd());
			return con;
		} catch (Exception ee) {
			System.out.println("Error: " + ee.getMessage());
			return null;
		}
	}

	public String Ejecutar(String sql) {
		String error = "";
		try {
			St = getConexion().createStatement();
			St.executeUpdate(sql);
			error = "Datos insertados";
		} catch (Exception ex) {
			error = ex.getMessage();
		}
		return (error);
	}

	public ResultSet Consulta(String sql) {
		String error = "";
		ResultSet reg = null;
		try {
			St = getConexion().createStatement();
			reg = St.executeQuery(sql);
		} catch (Exception ee) {
			error = ee.getMessage();
		}
		return (reg);
	}

	public void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public CachedRowSet obtenerRegistros(String sql) throws SQLException {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(cadena, user, pwd);
			St = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = St.executeQuery(sql);
			CachedRowSet crs = new CachedRowSetImpl();
			crs.populate(rs);
			rs.close();
			St.close();
			con.close();
			return crs;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (St != null) {
				St.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return null;
	}
}
