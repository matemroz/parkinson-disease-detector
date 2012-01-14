package pw.inz.pd.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pw.inz.pd.db.helper.DBConnectionStatus;

public class DB2DAOFactory extends DAOFactory {

	String dburl = "jdbc:db2://localhost:50000/PDDB:user=student;password=student;";

	public Connection createConnection() throws SQLException {

		DBConnectionStatus.connectionStatus = DBConnectionStatus.INIT_CONNECTION_DB2_DB;
		DBConnectionStatus.printConnectionStatus();

		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return DriverManager.getConnection(dburl);
	}

	public PatientDAO getKontoDAO() {
		return new DB2PatientDAO();
	}

	public MedExaminationDAO getMedExaminationDAO(){
		return new DB2MedExaminationDAO();
	}
}
