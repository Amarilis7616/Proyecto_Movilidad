package com.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.conexion.Cls_conexion;

import model.Dim_Porcentaje_Cambio;


public class daoCambio {
	
	public ArrayList<Dim_Porcentaje_Cambio> FindAllPorcentaje() throws SQLException {
		ArrayList<Dim_Porcentaje_Cambio> pr = new ArrayList<>();
		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select * from dim_porcentaje_cambio");
		int sk_porcentaje_cambio;
		int pk_porcentaje_cambio;
		int porcentaje_ventas;
		int porcentaje_supermercado_farmacia;
		int porcentaje_parques;
		int porcentaje_estaciones_transito;
		int porcentaje_lugares_trabajo;
		int porcentaje_residencias;
		Date v_desde;
		Date v_hasta;
		int version;
		while (re.next()) {
			sk_porcentaje_cambio = re.getInt(1);
			pk_porcentaje_cambio = re.getInt(2);
			porcentaje_ventas = re.getInt(3);
			porcentaje_supermercado_farmacia = re.getInt(4);
			porcentaje_parques = re.getInt(5);
			porcentaje_estaciones_transito = re.getInt(6);
			porcentaje_lugares_trabajo = re.getInt(7);
			porcentaje_residencias = re.getInt(8);
			v_desde = re.getDate(9);
			v_hasta = re.getDate(10);
			version = re.getInt(11);
			pr.add(new Dim_Porcentaje_Cambio(sk_porcentaje_cambio, pk_porcentaje_cambio, porcentaje_ventas,
					porcentaje_supermercado_farmacia, porcentaje_parques, porcentaje_estaciones_transito,
					porcentaje_lugares_trabajo, porcentaje_residencias, v_desde, v_hasta, version));

		}
		return pr;
	}
	
	
	
	
	

}
