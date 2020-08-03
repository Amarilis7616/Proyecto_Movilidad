package model;

import java.util.Date;

public class Dim_Porcentaje_Cambio {
	private int sk_porcentaje_cambio;
	private int pk_porcentaje_cambio;
	private int porcentaje_ventas;
	private int porcentaje_supermercado_farmacia;
	private int porcentaje_parques;
	private int porcentaje_estaciones_transito;
	private int porcentaje_lugares_trabajo;
	private int porcentaje_residencias;
	private Date v_desde;
	private Date v_hasta;
	private int version;

	public Dim_Porcentaje_Cambio(int sk_porcentaje_cambio, int pk_porcentaje_cambio, int porcentaje_ventas,
			int porcentaje_supermercado_farmacia, int porcentaje_parques, int porcentaje_estaciones_transito,
			int porcentaje_lugares_trabajo, int porcentaje_residencias, Date v_desde, Date v_hasta, int version) {
		super();
		this.sk_porcentaje_cambio = sk_porcentaje_cambio;
		this.pk_porcentaje_cambio = pk_porcentaje_cambio;
		this.porcentaje_ventas = porcentaje_ventas;
		this.porcentaje_supermercado_farmacia = porcentaje_supermercado_farmacia;
		this.porcentaje_parques = porcentaje_parques;
		this.porcentaje_estaciones_transito = porcentaje_estaciones_transito;
		this.porcentaje_lugares_trabajo = porcentaje_lugares_trabajo;
		this.porcentaje_residencias = porcentaje_residencias;
		this.v_desde = v_desde;
		this.v_hasta = v_hasta;
		this.version = version;
	}

	
	public Dim_Porcentaje_Cambio() {

	}

	public int getSk_porcentaje_cambio() {
		return sk_porcentaje_cambio;
	}

	public void setSk_porcentaje_cambio(int sk_porcentaje_cambio) {
		this.sk_porcentaje_cambio = sk_porcentaje_cambio;
	}

	public int getPk_porcentaje_cambio() {
		return pk_porcentaje_cambio;
	}

	public void setPk_porcentaje_cambio(int pk_porcentaje_cambio) {
		this.pk_porcentaje_cambio = pk_porcentaje_cambio;
	}

	public int getPorcentaje_ventas() {
		return porcentaje_ventas;
	}

	public void setPorcentaje_ventas(int porcentaje_ventas) {
		this.porcentaje_ventas = porcentaje_ventas;
	}

	public int getPorcentaje_supermercado_farmacia() {
		return porcentaje_supermercado_farmacia;
	}

	public void setPorcentaje_supermercado_farmacia(int porcentaje_supermercado_farmacia) {
		this.porcentaje_supermercado_farmacia = porcentaje_supermercado_farmacia;
	}

	public int getPorcentaje_parques() {
		return porcentaje_parques;
	}

	public void setPorcentaje_parques(int porcentaje_parques) {
		this.porcentaje_parques = porcentaje_parques;
	}

	public int getPorcentaje_estaciones_transito() {
		return porcentaje_estaciones_transito;
	}

	public void setPorcentaje_estaciones_transito(int porcentaje_estaciones_transito) {
		this.porcentaje_estaciones_transito = porcentaje_estaciones_transito;
	}

	public int getPorcentaje_lugares_trabajo() {
		return porcentaje_lugares_trabajo;
	}

	public void setPorcentaje_lugares_trabajo(int porcentaje_lugares_trabajo) {
		this.porcentaje_lugares_trabajo = porcentaje_lugares_trabajo;
	}

	public int getPorcentaje_residencias() {
		return porcentaje_residencias;
	}

	public void setPorcentaje_residencias(int porcentaje_residencias) {
		this.porcentaje_residencias = porcentaje_residencias;
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

}
