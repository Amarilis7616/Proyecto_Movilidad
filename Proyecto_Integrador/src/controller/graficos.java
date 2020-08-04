package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;


import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.PieChartModel;

import com.dao.daoFecha;
import com.dao.daoReporte;
import com.dao.daoSubregion;
import com.dao.daoFactReport;

import model.DatosPais;
import model.ReporteInfor;
import model.ReportesCon;




@Named("graficos")
@ViewScoped


public class graficos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String codPais;
	private String codMes;
	private String codPar;
	private String resultado;
	private List<SelectItem> listaProvincia;
	private List<SelectItem> listaPais;
	private List<SelectItem> listaAnios;
	private List<SelectItem> listaMes;
	private List<SelectItem> listaEtnia;
	private PieChartModel torta;
	private BarChartModel barra;
	private List<ReporteInfor> lista;
	private List<DatosPais> listalinea;
	List<ReporteInfor> reporte;
	List<ReporteInfor> reportecron;
	List<DatosPais> reportepais;
	List<ReporteInfor> reportepar;
		
	@PostConstruct
	private void init() {
		listaProvincia = new ArrayList<SelectItem>();
		listaPais = new ArrayList<SelectItem>();
		listaMes = new ArrayList<SelectItem>();
		daoSubregion daoProvincia = new daoSubregion();
		daoFecha daoFecha = new daoFecha();
		daoFactReport daof=new daoFactReport();
		listaProvincia = daoProvincia.obtenerProvincias();
		listaMes = daoFecha.ObtenerMeses();
		listaPais= daof.obtenerPaises();
		buscarAum();
		buscarCron();
		

	}
	private String codProvincia;
	public String getCodPais() {
		return codPais;
	}
	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}
	public List<SelectItem> getListaPais() {
		return listaPais;
	}
	public void setListaPais(List<SelectItem> listaPais) {
		this.listaPais = listaPais;
	}
	public List<DatosPais> getListalinea() {
		return listalinea;
	}
	public void setListalinea(List<DatosPais> listalinea) {
		this.listalinea = listalinea;
	}
	public List<DatosPais> getReportepais() {
		return reportepais;
	}
	public void setReportepais(List<DatosPais> reportepais) {
		this.reportepais = reportepais;
	}
	
	public List<SelectItem> getListaProvincia() {
		return listaProvincia;
	}

	public void setListaProvincia(List<SelectItem> listaProvincia) {
		this.listaProvincia = listaProvincia;
	}

	public String getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}

	public graficos() {
		// TODO Auto-generated constructor stub
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<SelectItem> getListaAnios() {
		return listaAnios;
	}

	public void setListaAnios(List<SelectItem> listaAnios) {
		this.listaAnios = listaAnios;
	}

	
	public List<ReporteInfor> getReporte() {
		return reporte;
	}

	public void setReporte(List<ReporteInfor> reporte) {
		this.reporte = reporte;
	}

	public PieChartModel getTorta() {
		return torta;
	}

	public void setTorta(PieChartModel torta) {
		this.torta = torta;
	}

	public List<ReporteInfor> getLista() {
		return lista;
	}

	public void setLista(List<ReporteInfor> lista) {
		this.lista = lista;
	}

	public List<SelectItem> getListaMes() {
		return listaMes;
	}

	public void setListaMes(List<SelectItem> listaMes) {
		this.listaMes = listaMes;
	}

	public String getCodMes() {
		return codMes;
	}

	public void setCodMes(String codMes) {
		this.codMes = codMes;
	}

	public List<ReporteInfor> getReportecron() {
		return reportecron;
	}

	public void setReportecron(List<ReporteInfor> reportecron) {
		this.reportecron = reportecron;
	}

	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}

	
	public List<SelectItem> getListaEtnia() {
		return listaEtnia;
	}

	public void setListaEtnia(List<SelectItem> listaEtnia) {
		this.listaEtnia = listaEtnia;
	}

	

	
	public String getCodPar() {
		return codPar;
	}
	public void setCodPar(String codPar) {
		this.codPar = codPar;
	}
	
	
	public List<ReporteInfor> getReportepar() {
		return reportepar;
	}
	public void setReportepar(List<ReporteInfor> reportepar) {
		this.reportepar = reportepar;
	}
	

	

	

	public void buscarCron() {
		try {
			daoReporte daoReportes = new daoReporte();
			reportecron = daoReportes.consultaPMes();
				graficarB();
			resultado = "Proceso ejecutado";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarPais() {
		try {
			daoReporte daoReportes = new daoReporte();
			reportepais = daoReportes.consultaXPais(codPais);
			if (codPais.equalsIgnoreCase("130")) {
				reportepais = daoReportes.consultaXPais();
				graficarBarrat();
			}else {
				graficarBarra();
			}
			resultado = "Proceso ejecutado";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void graficarBarrat() {
		daoReporte dao = new daoReporte();
		listalinea = dao.consultaXPais();
		barra = new BarChartModel();
		ChartSeries serie; 
		for (int i = 0; i < listalinea.size(); i++) {
			serie = new ChartSeries();
			serie.setLabel(listalinea.get(i).getPais());
			serie.set(listalinea.get(i).getPais(), listalinea.get(i).getFarmacia());
			barra.addSeries(serie);	
		}

		barra.setLegendPosition("ne");
		barra.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
		Axis x = barra.getAxis(AxisType.X);
		x.setLabel("Provincias");
		Axis y = barra.getAxis(AxisType.Y);
		y.setLabel("Cantidad");
		y.setMin(0);
		y.setMax(283000);
	}
	
	
	    public void graficarB() {
	    	daoReporte dao = new daoReporte();
			lista = dao.consultaPMes();
			barra = new BarChartModel();
			ChartSeries serie; 
			for (int i = 0; i < lista.size(); i++) {
				serie = new ChartSeries();
				serie.setLabel(lista.get(i).getDatos());
				serie.set(lista.get(i).getDatos(), lista.get(i).getContador());
				barra.addSeries(serie);
				
			}
			
			barra.setTitle("Movilidad por sitios Farmaceúticos");
			barra.setLegendPosition("ne");
			barra.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
			Axis x = barra.getAxis(AxisType.X);
			x.setLabel("PAISES");
			Axis y = barra.getAxis(AxisType.Y);
			y.setLabel("Farmacias");
			y.setMin(0);
			y.setMax(80);
	}
	    
	    
	    public void graficarBarra() {
			daoReporte dao = new daoReporte();
			listalinea = dao.consultaXPais(codPais);
			barra = new BarChartModel();
			ChartSeries serie; 
			for (int i = 0; i < listalinea.size(); i++) {
				serie = new ChartSeries();
				serie.setLabel(listalinea.get(i).getPais());
				serie.set(listalinea.get(i).getPais(), listalinea.get(i).getPcambio());
				barra.addSeries(serie);	
			}
			
			barra.setTitle("Disminución de Movilidad en Comercios Minoristas y Recreacionales");
			barra.setLegendPosition("ne");
			barra.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
			Axis x = barra.getAxis(AxisType.X);
			x.setLabel("PAISES");
			Axis y = barra.getAxis(AxisType.Y);
			y.setLabel("RECREACIÓN");
			y.setMin(0);
			y.setMax(10000);

		}
	    
	    public void buscarAum() {
	    	try {
				daoReporte daoReportes = new daoReporte();
				reportecron = daoReportes.consultaAument();
					graficarAum();
							resultado = "Proceso ejecutado";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    
	    
	   	    
	    public void graficarAum() {
	    	torta = new PieChartModel();
			daoReporte dao = new daoReporte();
			lista = dao.consultaAument();

			for (ReporteInfor dr : lista) {
				torta.set(dr.getDatos(), dr.getContador());
			}

			torta.setTitle("Países con Mayor movilidad en Áreas Recreativas");
			torta.setLegendPosition("e");
			torta.setFill(true);
			torta.setShowDataLabels(true);
			torta.setDiameter(300);
		}
	    
	    
	


	

	
}
