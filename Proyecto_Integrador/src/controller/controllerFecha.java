package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.daoFecha;

import model.Dim_Fecha;




public class controllerFecha {
	
	public ArrayList<Dim_Fecha> ImprimeFechas() throws SQLException {
		daoFecha daofecha;
		daofecha = new daoFecha();
		return daofecha.FindAllFechas();
	}
	
	public ArrayList<String> ImprimeMeses() throws SQLException {
		daoFecha daofecha;
		daofecha = new daoFecha();
		return daofecha.getMeses();
	}
	
	

}
