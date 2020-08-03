package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexion.Cls_conexion;

import model.DatosPais;
import model.ReporteInfor;

public class daoReporte {

	public List<ReporteInfor>consultaPMes() {
		String sql = "select region_p,"
				+ "round(sum(dim_porcentaje_cambio.retail_and_recreation_percent_change_from_baseline)/count(*)*(-1))"
				+ " as recreacion from dim_porcentaje_cambio,"
				+ "fac_report where dim_porcentaje_cambio.sk_porcentaje_cambio=fac_report.sk_porcentaje_cambio"
				+ " and region_p in('ECUADOR','SPAIN','ITALY','PANAMA','BOLIVIA','ARGENTINA','PERU','LUXEMBOURG',"
				+ " 'FRANCE','PHILIPPINES','KUWAIT','SRI LANKA','MALAYSIA','BELGIUM','NEPAL','COLOMBIA','INDIA',"
				+ " 'PORTUGAL') group by fac_report.region_p ORDER by recreacion  ASC";
		ResultSet rs = null;
		List<ReporteInfor> datos = new ArrayList<ReporteInfor>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				ReporteInfor dr= new ReporteInfor();
				dr.setContador(rs.getInt(2));
				dr.setDatos(rs.getString(1));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	
	public List<DatosPais>consultaXPais(String code) {
		String sql = "select region_p as Pais, "
				+ "count(pk_porcentaje_cambio) as PCambio,"
				+ " count(retail_and_recreation_percent_change_from_baseline) as Venta,"
				+ "count(grocery_and_pharmacy_percent_change_from_baseline) as Farmacia,"
				+ "count(parks_percent_change_from_baseline) as Parques,"
				+ "count(transit_stations_percent_change_from_baseline) as Transito,"
				+ "count(workplaces_percent_change_from_baseline) as Trabajo,"
				+ "count(residential_percent_change_from_baseline) as Residencia from dim_porcentaje_cambio as po,"
				+ "fac_report as fa where po.sk_porcentaje_cambio=fa.sk_porcentaje_cambio and code_p='"+code+"' group by Pais"; 
		ResultSet rs = null;
		List<DatosPais> datos = new ArrayList<DatosPais>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosPais dr= new DatosPais();
				dr.setPais(rs.getString(1));
				dr.setPcambio(rs.getInt(2));
				dr.setVenta(rs.getInt(3));
				dr.setFarmacia(rs.getInt(4));
				dr.setParques(rs.getInt(5));
				dr.setTransito(rs.getInt(6));
				dr.setTrabajo(rs.getInt(7));
				dr.setResidencia(rs.getInt(8));
				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	
	public List<DatosPais>consultaXPais() {
		String sql = "select region_p as Pais, "
				+ "count(pk_porcentaje_cambio) as PCambio,"
				+ " count(retail_and_recreation_percent_change_from_baseline) as Venta,"
				+ "count(grocery_and_pharmacy_percent_change_from_baseline) as Farmacia,"
				+ "count(parks_percent_change_from_baseline) as Parques,"
				+ "count(transit_stations_percent_change_from_baseline) as Transito,"
				+ "count(workplaces_percent_change_from_baseline) as Trabajo,"
				+ "count(residential_percent_change_from_baseline) as Residencia from dim_porcentaje_cambio as po,"
				+ "fac_report as fa where po.sk_porcentaje_cambio=fa.sk_porcentaje_cambio  group by Pais"; 
		ResultSet rs = null;
		List<DatosPais> datos = new ArrayList<DatosPais>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosPais dr= new DatosPais();
				dr.setPais(rs.getString(1));
				dr.setPcambio(rs.getInt(2));
				dr.setVenta(rs.getInt(3));
				dr.setFarmacia(rs.getInt(4));
				dr.setParques(rs.getInt(5));
				dr.setTransito(rs.getInt(6));
				dr.setTrabajo(rs.getInt(7));
				dr.setResidencia(rs.getInt(8));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	
	
	public List<DatosPais>consultaParque(String code) {
		String sql = "select region_p as Pais, "
				+ "count(pk_porcentaje_cambio) as PCambio,"
				+ " count(retail_and_recreation_percent_change_from_baseline) as Venta,"
				+ "count(grocery_and_pharmacy_percent_change_from_baseline) as Farmacia,"
				+ "count(parks_percent_change_from_baseline) as Parques,"
				+ "count(transit_stations_percent_change_from_baseline) as Transito,"
				+ "count(workplaces_percent_change_from_baseline) as Trabajo,"
				+ "count(residential_percent_change_from_baseline) as Residencia from dim_porcentaje_cambio as po,"
				+ "fac_report as fa where po.sk_porcentaje_cambio=fa.sk_porcentaje_cambio and code_p='"+code+"' group by Pais"; 
		ResultSet rs = null;
		List<DatosPais> datos = new ArrayList<DatosPais>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosPais dr= new DatosPais();
				dr.setPais(rs.getString(1));
				dr.setPcambio(rs.getInt(2));
				dr.setVenta(rs.getInt(3));
				dr.setFarmacia(rs.getInt(4));
				dr.setParques(rs.getInt(5));
				dr.setTransito(rs.getInt(6));
				dr.setTrabajo(rs.getInt(7));
				dr.setResidencia(rs.getInt(8));
				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	
	public List<DatosPais>consultaParq() {
		String sql = "select region_p as Pais, "
				+ "count(pk_porcentaje_cambio) as PCambio,"
				+ " count(retail_and_recreation_percent_change_from_baseline) as Venta,"
				+ "count(grocery_and_pharmacy_percent_change_from_baseline) as Farmacia,"
				+ "count(parks_percent_change_from_baseline) as Parques,"
				+ "count(transit_stations_percent_change_from_baseline) as Transito,"
				+ "count(workplaces_percent_change_from_baseline) as Trabajo,"
				+ "count(residential_percent_change_from_baseline) as Residencia from dim_porcentaje_cambio as po,"
				+ "fac_report as fa where po.sk_porcentaje_cambio=fa.sk_porcentaje_cambio  group by Pais"; 
		ResultSet rs = null;
		List<DatosPais> datos = new ArrayList<DatosPais>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosPais dr= new DatosPais();
				dr.setPais(rs.getString(1));
				dr.setPcambio(rs.getInt(2));
				dr.setVenta(rs.getInt(3));
				dr.setFarmacia(rs.getInt(4));
				dr.setParques(rs.getInt(5));
				dr.setTransito(rs.getInt(6));
				dr.setTrabajo(rs.getInt(7));
				dr.setResidencia(rs.getInt(8));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	
	/*
	
	public List<ReporteInfor>consultaPAument() {
		String sql = "select region_p,"
				+ " round(sum(dim_porcentaje_cambio.parks_percent_change_from_baseline)"
				+ " count(*)) as parques from dim_porcentaje_cambio,"
				+ "fac_report where dim_porcentaje_cambio.sk_porcentaje_cambio=fac_report.sk_porcentaje_cambio and region_p in('DENMARK','NORWAY','NETHERLANDS','GERMANY','FINLAND','LITHUANIA','SOUTH KOREA', 'SWEDEN','SLOVAKIA','BELARUS','HUNGARY','CANADA','CZECHIA','SWITZERLAND', 'UNITED STATES') group by fac_report.region_p ORDER by parques  DESC";
		ResultSet rs = null;
		List<ReporteInfor> datos = new ArrayList<ReporteInfor>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				ReporteInfor dr= new ReporteInfor();
				dr.setContador(rs.getInt(2));
				dr.setDatos(rs.getString(1));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	*/
}
