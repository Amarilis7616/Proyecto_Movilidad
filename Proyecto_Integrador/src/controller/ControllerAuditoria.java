package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.daoAuditoria;

import model.Auditoria;



public class ControllerAuditoria {
	
	public ArrayList<Auditoria> ImprimeTb_Auditoria() throws SQLException {
		daoAuditoria daoauditoria;
		daoauditoria= new daoAuditoria();
		return daoauditoria.FindAllAuditoria();
	}

}
