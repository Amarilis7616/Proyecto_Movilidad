package model;

public class fac_report {
	
	private int sk_subregion;
	private String sk_fecha;
	private int sk_porcentaje_cambio;
	private String code_p;
	private String region_p;
	
	public fac_report(){
		
	}
	
	public fac_report(int sk_subregion,String sk_fecha,int sk_porcentaje_cambio,String code_p,String region_p){
		this.sk_subregion=sk_subregion;
		this.sk_fecha=sk_fecha;
		this.sk_porcentaje_cambio=sk_porcentaje_cambio;
		this.code_p=code_p;
		this.region_p=region_p;
		
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
	
		
	

}
