package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.conexion.Cls_conexion;

import model.fac_report;



public class daoFactReport {
	
	public ArrayList<fac_report> FindAllFactReport() throws SQLException {
		ArrayList<fac_report> fe = new ArrayList<>();

		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select * from fac_report");
		int sk_subregion;
		String sk_fecha;
		int sk_porcentaje_cambio;
		String code_p;
		String region_p;
		
		
			while (re.next()) {
			sk_subregion = re.getInt(1);
			sk_fecha = re.getString(2);
			sk_porcentaje_cambio = re.getInt(3);
			code_p = re.getString(4);
			region_p = re.getString(5);
			

			fe.add(new fac_report(sk_subregion,sk_fecha,sk_porcentaje_cambio,code_p,region_p));
		}
		return fe;
	}
	
	public ArrayList<String> getPaises()	{
		ArrayList<String> listaPais = new ArrayList<>();
		Cls_conexion cl = new Cls_conexion();
		try {
			ResultSet re;
			re = cl.consulta("select  code_p, region_p from fac_report group by region_p ,code_p order by region_p");
			
			while (re.next()) {
				
				listaPais.add(re.getString(2));
			}
			
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			try {
				
				cl.getConexion().close();
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
		return listaPais;
	}
	
	public List<SelectItem> obtenerPaises()	{
		Cls_conexion cl = new Cls_conexion();
		List<SelectItem> listaPais=new ArrayList<>();
		listaPais.add(new SelectItem(null, "Seleccione"));
		try {
			ResultSet re;
			re = cl.consulta("select  code_p, region_p from fac_report group by region_p ,code_p order by region_p");
			
			while (re.next()) {
				listaPais.add(new SelectItem(re.getString(1),re.getString(2)));
			}
			    listaPais.add(new SelectItem(130, "TODOS LOS PAISES"));
			
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			try {
				
				cl.getConexion().close();
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
		return listaPais;
	}
	
	
	

}
