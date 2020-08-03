package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.daoSubregion;

import model.Dim_subregion;


public class controllerSubregion {

	public ArrayList<Dim_subregion> ImprimeProvincia() throws SQLException {
		daoSubregion daoprovi;
		daoprovi = new daoSubregion();
		return daoprovi.FindAllSubregion();
	}

	public ArrayList<String> ImprimeProvincias() throws SQLException {
		daoSubregion daoprov;
		daoprov = new daoSubregion();
		return daoprov.getProvincia();
	}
	
	
}
