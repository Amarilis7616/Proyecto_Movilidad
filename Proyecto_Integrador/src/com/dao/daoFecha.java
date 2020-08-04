package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.conexion.Cls_conexion;
import model.Dim_Fecha;


public class daoFecha {
	
	public ArrayList<Dim_Fecha> FindAllFechas() throws SQLException {
		ArrayList<Dim_Fecha> fe = new ArrayList<>();

		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select * from dim_fecha");
		String sk_fecha;
		Date date;
		String dia;
		String mes;
		String anio;
		
		
			while (re.next()) {
			sk_fecha = re.getString(1);
			date = re.getDate(2);
			dia = re.getString(3);
			mes = re.getString(4);
			anio = re.getString(5);
			

			fe.add(new Dim_Fecha(sk_fecha,date,dia, mes,anio));
		}
		return fe;
	}

	public ArrayList<String> getMeses() {
		ArrayList<String> lista_fechas = new ArrayList<>();
		Cls_conexion cl = new Cls_conexion();
		try {
			ResultSet re;
			re = cl.consulta("select mes from dim_fecha group by mes order by mes");

			while (re.next()) {

				lista_fechas.add(re.getString(1));
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			try {

				cl.getConexion().close();
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
		return lista_fechas;
	}
	
	public List<SelectItem> ObtenerMeses() {
		List<SelectItem> lista_fechas=new ArrayList<>();
		Cls_conexion cl = new Cls_conexion();
		lista_fechas.add(new SelectItem(null, "Seleccione"));
		try {
			ResultSet re;
			re = cl.consulta("select mes from dim_fecha group by mes order by mes");

			while (re.next()) {

				lista_fechas.add(new SelectItem(re.getString(1)));
			}
			lista_fechas.add(new SelectItem(13, "TODOS LOS MESES"));	

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			try {

				cl.getConexion().close();
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
		return lista_fechas;
	}
	

}
