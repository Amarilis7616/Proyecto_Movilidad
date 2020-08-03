package com.bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import controller.controllerFact;
import controller.controllerSubregion;
import model.Dim_subregion;
import model.fac_report;

@Named(value = "beanSubregion")
@SessionScoped
public class beanSubregion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int sk_subregion;
	private int pk_subregion;
	private String sub_region_1;
	private String sub_region_2;
	private Date v_desde;
	private Date v_hasta;
	private int version;
	
	public beanSubregion() {
		
	}
	
	public int getSk_subregion() {
		return sk_subregion;
	}

	public void setSk_subregion(int sk_subregion) {
		this.sk_subregion = sk_subregion;
	}

	public int getPk_subregion() {
		return pk_subregion;
	}

	public void setPk_subregion(int pk_subregion) {
		this.pk_subregion = pk_subregion;
	}

	public String getSub_region_1() {
		return sub_region_1;
	}

	public void setSub_region_1(String sub_region_1) {
		this.sub_region_1 = sub_region_1;
	}

	public String getSub_region_2() {
		return sub_region_2;
	}

	public void setSub_region_2(String sub_region_2) {
		this.sub_region_2 = sub_region_2;
	}

	public Date getV_desde() {
		return v_desde;
	}

	public void setV_desde(Date v_desde) {
		this.v_desde = v_desde;
	}

	public Date getV_hasta() {
		return v_hasta;
	}

	public void setV_hasta(Date v_hasta) {
		this.v_hasta = v_hasta;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public ArrayList<Dim_subregion> listaPais() throws SQLException {
		controllerSubregion controller = new controllerSubregion();
		return controller.ImprimeProvincia();
	}

	public ArrayList<String> listaPaises() throws SQLException {
		controllerSubregion controller = new controllerSubregion();
		return controller.ImprimeProvincias();
	}
	
	
     
}
