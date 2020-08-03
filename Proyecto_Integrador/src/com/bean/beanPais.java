package com.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import controller.controllerFact;
import model.fac_report;

@Named(value = "beanPais")
@SessionScoped

public class beanPais implements Serializable {
	private static final long serialVersionUID = 1L;

	private int sk_subregion;
	private String sk_fecha;
	private int sk_porcentaje_cambio;
	private String code_p;
	private String region_p;

	public beanPais() {

	}

	public int getSk_subregion() {
		return sk_subregion;
	}

	public void setSk_subregion(int sk_subregion) {
		this.sk_subregion = sk_subregion;
	}

	public String getSk_fecha() {
		return sk_fecha;
	}

	public void setSk_fecha(String sk_fecha) {
		this.sk_fecha = sk_fecha;
	}

	public int getSk_porcentaje_cambio() {
		return sk_porcentaje_cambio;
	}

	public void setSk_porcentaje_cambio(int sk_porcentaje_cambio) {
		this.sk_porcentaje_cambio = sk_porcentaje_cambio;
	}

	public String getCode_p() {
		return code_p;
	}

	public void setCode_p(String code_p) {
		this.code_p = code_p;
	}

	public String getRegion_p() {
		return region_p;
	}

	public void setRegion_p(String region_p) {
		this.region_p = region_p;
	}

	public ArrayList<fac_report> listaPais() throws SQLException {
		controllerFact controller = new controllerFact();
		return controller.ImprimePais();
	}

	public ArrayList<String> listaPaises() throws SQLException {
		controllerFact controller = new controllerFact();
		return controller.ImprimePaises();
	}

}
