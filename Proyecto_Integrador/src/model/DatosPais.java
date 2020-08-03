package model;

public class DatosPais {
	
	private String pais;
	private int pcambio;
	private int venta;
	private int farmacia;
	private int parques;
	private int transito;
	private int trabajo;
	private int residencia;
	
	public DatosPais() {
		
	}

	public DatosPais(String pais, int pcambio, int venta, int farmacia, int parques, int transito, int trabajo,
			int residencia) {
		super();
		this.pais = pais;
		this.pcambio = pcambio;
		this.venta = venta;
		this.farmacia = farmacia;
		this.parques = parques;
		this.transito = transito;
		this.trabajo = trabajo;
		this.residencia = residencia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getPcambio() {
		return pcambio;
	}

	public void setPcambio(int pcambio) {
		this.pcambio = pcambio;
	}

	public int getVenta() {
		return venta;
	}

	public void setVenta(int venta) {
		this.venta = venta;
	}

	public int getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(int farmacia) {
		this.farmacia = farmacia;
	}

	public int getParques() {
		return parques;
	}

	public void setParques(int parques) {
		this.parques = parques;
	}

	public int getTransito() {
		return transito;
	}

	public void setTransito(int transito) {
		this.transito = transito;
	}

	public int getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(int trabajo) {
		this.trabajo = trabajo;
	}

	public int getResidencia() {
		return residencia;
	}

	public void setResidencia(int residencia) {
		this.residencia = residencia;
	}
	
	

}
