package com.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.conexion.Cls_conexion;

import model.Dim_subregion;
import model.fac_report;

public class daoSubregion {
	
	public ArrayList<Dim_subregion> FindAllSubregion() throws SQLException {
		ArrayList<Dim_subregion> fe = new ArrayList<>();

		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select* from dim_subregion");
		int sk_subregion;
		int pk_subregion;
		String sub_region_1;
		String sub_region_2;
		Date v_desde;
		Date v_hasta;
		int version;

		while (re.next()) {
			sk_subregion = re.getInt(1);
			pk_subregion = re.getInt(2);
			sub_region_1 = re.getString(3);
			sub_region_2 = re.getString(4);
			v_desde = re.getDate(5);
			v_hasta = re.getDate(6);
			version = re.getInt(7);

			fe.add(new Dim_subregion(sk_subregion, pk_subregion, sub_region_1, sub_region_2, v_desde, v_hasta,
					version));

		}

		return fe;

	}
	
	public ArrayList<String> getProvincia()	{
		ArrayList<String> lista_provincia = new ArrayList<>();
		Cls_conexion cl = new Cls_conexion();
		try {
			ResultSet re;
			re = cl.consulta("select   sub_region_1 from dim_subregion group by sub_region_1 order by sub_region_1");
			
			while (re.next()) {
				
				lista_provincia.add(re.getString(1));
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
		return lista_provincia;
	}
	
	public List<SelectItem> obtenerProvincias()	{
		Cls_conexion cl = new Cls_conexion();
		List<SelectItem> lista=new ArrayList<>();
		lista.add(new SelectItem(null, "Seleccione"));
		try {
			ResultSet re;
			re = cl.consulta("select   sub_region_1 from dim_subregion group by sub_region_1 order by sub_region_1");
			
			while (re.next()) {
				lista.add(new SelectItem(re.getString(1)));
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
		return lista;
	}
	
	

}
