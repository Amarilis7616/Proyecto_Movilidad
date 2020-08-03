package com.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import controller.controllerFecha;
import model.Dim_Fecha;



@Named(value = "beanFecha")
@SessionScoped
public class beanFecha implements Serializable{
	private static final long serialVersionUID = 1L;
	private String sk_fecha;
	private Date fecha;
	private String dia;
	private String mes;
	private String anio;
	private Dim_Fecha fecha_c;
	
	
	public beanFecha() {
		
	}


	public String getSk_fecha() {
		return sk_fecha;
	}


	public void setSk_fecha(String sk_fecha) {
		this.sk_fecha = sk_fecha;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}


	public String getAnio() {
		return anio;
	}


	public void setAnio(String anio) {
		this.anio = anio;
	}


	public Dim_Fecha getFecha_c() {
		return fecha_c;
	}


	public void setFecha_c(Dim_Fecha fecha_c) {
		this.fecha_c = fecha_c;
	}
	
	
	public ArrayList<Dim_Fecha> listaFechas() throws SQLException {
		controllerFecha controller = new controllerFecha();
		return controller.ImprimeFechas();
	}
	
	public ArrayList<String> listaMeses() throws SQLException {
		controllerFecha controller = new controllerFecha();
		return controller.ImprimeMeses();
	}
	
	/*
	
	public ArrayList<String> listaAnios() throws SQLException {
		controllerFecha controller = new controllerFecha();
		return controller.ImprimeAnios();
	}
	*/
	

}
