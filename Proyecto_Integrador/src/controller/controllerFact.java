package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.daoFactReport;


import model.fac_report;


public class controllerFact {

	public ArrayList<fac_report> ImprimePais() throws SQLException {
		daoFactReport daopais;
		daopais = new daoFactReport();
		return daopais.FindAllFactReport();
	}

	public ArrayList<String> ImprimePaises() throws SQLException {
		daoFactReport daoprov;
		daoprov = new daoFactReport();
		return daoprov.getPaises();
	}

}
