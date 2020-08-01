package model;

import java.sql.Date;

public class Dim_Fecha {
	private int sk_fecha;
	private Date date;
	private double dia;
	private double mes;
	private double anio;

	public Dim_Fecha() {

	}

	public Dim_Fecha(int sk_f, Date date, double dia, double mes, double anio) {
		this.sk_fecha=sk_f;
		this.date=date;
		this.dia=dia;
		this.mes=mes;
		this.anio=anio;
	}

	public int getSk_fecha() {
		return sk_fecha;
	}

	public void setSk_fecha(int sk_fecha) {
		this.sk_fecha = sk_fecha;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getDia() {
		return dia;
	}

	public void setDia(double dia) {
		this.dia = dia;
	}

	public double getMes() {
		return mes;
	}

	public void setMes(double mes) {
		this.mes = mes;
	}

	public double getAnio() {
		return anio;
	}

	public void setAnio(double anio) {
		this.anio = anio;
	}
}
