package model;

import java.util.Date;

public class Dim_Fecha {
	private String sk_fecha;
	private Date date;
	private String dia;
	private String mes;
	private String anio;

	public Dim_Fecha() {

	}

	public Dim_Fecha(String sk_fecha, Date date, String dia, String mes, String anio) {
		this.sk_fecha=sk_fecha;
		this.date=date;
		this.dia=dia;
		this.mes=mes;
		this.anio=anio;
	}

	public String getSk_fecha() {
		return sk_fecha;
	}

	public void setSk_fecha(String sk_fecha) {
		this.sk_fecha = sk_fecha;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	
}
