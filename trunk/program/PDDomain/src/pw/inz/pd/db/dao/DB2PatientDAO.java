package pw.inz.pd.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pw.inz.pd.db.utils.DB2DBUtils;
import pw.inz.pd.domain.Patient;

public class DB2PatientDAO implements PatientDAO{

	@Override
	public boolean isExistPatient(Patient p) {
		String schemaName = "PDDBSCH";
		String columnNames = "PERSONALNUM";
		String condition = "PERSONALNUM = '" + p.getPersonalNum() + "'";
		String tableName = "PATIENT";
		ResultSet rs = DB2DBUtils.queryCommand(schemaName, tableName, columnNames,
				condition);
		
		try {
			return rs.next();
		} catch (SQLException ex) {
			System.err.println("Error while getting patient data");
		}
		
		return true;
	}

	@Override
	public boolean addPatient(Patient p) {
		String schemaName = "PDDBSCH";
		String tableName = "PATIENT";
		ArrayList<String> columnNames = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();

		columnNames.add("PERSONALNUM");
		columnNames.add("AGE");
		columnNames.add("SEX");

		values.add("'" + p.getPersonalNum() + "'");
		values.add("'" + p.getAge() + "'");
		values.add("'" + p.getSex() + "'");

		return DB2DBUtils.insertCommand(schemaName, tableName, columnNames, values);
	}

	
	public static void main(String[] args){
		DB2PatientDAO db2pdao = new DB2PatientDAO();
		Patient p = new Patient();
		p.setAge(31);
		p.setPersonalNum("99120500511");
		p.setSex(0);
		if(!db2pdao.isExistPatient(p))
			db2pdao.addPatient(p);
	}
}
