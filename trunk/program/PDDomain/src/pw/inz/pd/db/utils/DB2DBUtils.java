package pw.inz.pd.db.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import pw.inz.pd.db.dao.DAOFactory;
import pw.inz.pd.db.dao.DB2DAOFactory;
import pw.inz.pd.db.helper.DBConnectionStatus;

public class DB2DBUtils {

	/**
	 * INSERT into database
	 * 
	 * @param tableName
	 *            table name
	 * @param columns
	 *            columns list
	 * @param values
	 *            values list
	 * @return true if success of false if not
	 */
	public static boolean insertCommand(String schemaName, String tableName, List<String> columns,
			List<String> values) {

		Iterator<String> itColumns = columns.iterator();
		Iterator<String> itValues = values.iterator();
		StringBuilder sql = new StringBuilder("INSERT INTO ");
		boolean success = false;

		sql.append(schemaName);
		sql.append(".");
		sql.append(tableName).append(" (");

		while (itColumns.hasNext())
			sql.append(itColumns.next()).append(", ");

		sql.deleteCharAt(sql.lastIndexOf(","));
		sql.append(") VALUES (");

		while (itValues.hasNext()) {
			String value = itValues.next().toString();
			sql.append(value).append(", ");
		}

		sql.deleteCharAt(sql.lastIndexOf(","));
		sql.append(" )");

		try {
			Statement st = getConnectionToDB2DB().createStatement();
			System.out.println(sql.toString());
			st.setQueryTimeout(10);
			st.executeUpdate(sql.toString());
			success = true;
			st.close();
		} catch (SQLException ex) {
			System.err.println("Error while inserting data into database. \n"
					+ ex.getSQLState() + "\n" + ex.getErrorCode() + "\n"
					+ ex.getMessage());
		}

		return success;
	}

	/**
	 * UPDATE in database
	 * 
	 * @param tableName
	 *            table name
	 * @param columnName
	 *            column name which will be updated
	 * @param condition
	 *            condition after WHERE
	 * @return true if success of false if not
	 */

	public static boolean updateCommand(String tableName, String columnName,
			String value, String condition) {

		boolean success = false;
		StringBuilder sql = new StringBuilder("UPDATE ");
		sql.append(tableName).append(" SET ").append(columnName).append(" = ")
				.append(value).append(" ");
		sql.append("WHERE ").append(condition);

		try {
			PreparedStatement st = getConnectionToDB2DB().prepareStatement(
					sql.toString());
			System.out.println(sql.toString());
			st.setQueryTimeout(10);
			success = st.executeUpdate() > 0;
			st.close();

		} catch (SQLException ex) {
			System.err.println("Error while updating data in database. \n"
					+ ex.getSQLState() + "\n" + ex.getErrorCode());
		}

		return success;
	}

	/**
	 * UPDATE many columns in database
	 * 
	 * @param tableName
	 *            table name
	 * @param columnNames
	 *            column names which will be updated
	 * @param values
	 *            list of new values which will be assigned to columns
	 * @param condition
	 *            condition after WHERE
	 * @return true if success of false if not
	 */
	public static boolean updateCommand(String tableName,
			List<String> columnNames, List<String> values, String condition) {
		Iterator<String> itColNames = columnNames.iterator();
		Iterator<String> itValues = values.iterator();
		boolean success = false;
		StringBuilder sql = new StringBuilder("UPDATE ");
		sql.append(tableName).append(" SET ");

		while (itColNames.hasNext())
			sql.append(itColNames.next()).append(" = ").append(itValues.next())
					.append(", ");

		sql.deleteCharAt(sql.lastIndexOf(","));
		sql.append("WHERE ").append(condition);

		try {
			PreparedStatement st = getConnectionToDB2DB().prepareStatement(
					sql.toString());
			System.out.println(sql.toString());
			st.setQueryTimeout(10);
			success = st.executeUpdate() > 0;
			st.close();

		} catch (SQLException ex) {
			System.err.println("Error while updating data in database. \n"
					+ ex.getSQLState() + "\n" + ex.getErrorCode() + "\n"
					+ ex.getMessage());
		}
		return success;
	}

	/**
	 * DELETE data from database
	 * 
	 * @param tableName
	 *            table name
	 * @param columnName
	 *            column name which will be updated
	 * @param condition
	 *            condition after WHERE
	 * @return true if success of false if not
	 */

	public static boolean deleteCommand(String tableName, String condition) {

		boolean success = false;
		StringBuilder sql = new StringBuilder("DELETE FROM ");

		if (!condition.equals("") || !condition.equals(null))
			sql.append(tableName).append(" WHERE ").append(condition);

		try {
			PreparedStatement st = getConnectionToDB2DB().prepareStatement(
					sql.toString());
			System.out.println(sql.toString());
			st.setQueryTimeout(10);
			success = st.execute(sql.toString());
			st.close();
		} catch (SQLException ex) {
			System.err.println("Error while deleting data from database. \n"
					+ ex.getSQLState() + "\n" + ex.getErrorCode() + "\n"
					+ ex.getMessage());
		}
		return success;
	}

	/**
	 * Query command for getting data from database.
	 * 
	 * @param tableName
	 *            table name
	 * @param columnName
	 *            querying column
	 * @param condition
	 *            condition after WHERE
	 * @return ResultSet object that contains the data produced by the given
	 *         query; never null
	 */

	public static ResultSet queryCommand(String schemaName, String tableName, String columnName,
			String condition) {

		ResultSet rs = null;
		StringBuilder sql = null;
		sql = new StringBuilder("SELECT ");

		if (condition.equals("")) {
			sql.append(columnName).append(" FROM ").append(schemaName).append(".").append(tableName);
		} else {
			sql.append(columnName).append(" FROM ").append(schemaName).append(".").append(tableName)
					.append(" WHERE ").append(condition);
		}

		try {
			Statement st = getConnectionToDB2DB().createStatement();
			System.out.println(sql.toString());
			st.setQueryTimeout(15);
			rs = st.executeQuery(sql.toString());
		} catch (SQLException ex) {
			System.err.println("Error while querying data from database.\n"
					+ ex.getSQLState() + "\n" + ex.getErrorCode() + "\n"
					+ ex.getMessage());
		}
		return rs;
	}

	/**
	 * Query command for getting data from database. Tables are in relation.
	 * 
	 * @param columnNames
	 *            list of querying column names
	 * @param tableNames
	 *            table names
	 * @param columnRelations
	 *            column names which join table in relation
	 * @param condition
	 *            condition after WHERE
	 * @return ResultSet object that contains the data produced by the given
	 *         query; never null
	 */
	public static ResultSet queryCommand(List<String> columnNames,
			List<String> tableNames, List<String> columnRelations,
			String condition) {

		ResultSet rs = null;
		StringBuilder sql = new StringBuilder("SELECT ");
		Iterator<String> itColNames = columnNames.iterator();
		Iterator<String> itTableNames = tableNames.iterator();
		Iterator<String> itTableRelations = columnRelations.iterator();
		String tabName = "";
		String prevTabName = "";
		String tableRelation = "";
		int i = 0;

		while (itColNames.hasNext()) {
			sql.append(itColNames.next().toString());
			sql.append(", ");
		}

		sql.deleteCharAt(sql.lastIndexOf(","));
		sql.append(" FROM ");

		while (itTableNames.hasNext()) {
			tabName = itTableNames.next().toString();
			tableRelation = "";
			sql.append(tabName);

			if (i > 0 && itTableRelations.hasNext()) {
				sql.append(" ON ");
				tableRelation = itTableRelations.next().toString();
				sql.append(prevTabName).append(".").append(tableRelation);
				sql.append(" = ");
				sql.append(tabName).append(".").append(tableRelation);
			}
			prevTabName = tabName;
			sql.append(" INNER JOIN ");
			i++;
		}

		sql.delete(sql.toString().length() - " INNER JOIN ".length(), sql
				.toString().length());
		sql.append(" WHERE ");
		sql.append(condition);

		try {
			Statement st = getConnectionToDB2DB().createStatement();
			System.out.println(sql.toString());
			st.setQueryTimeout(15);
			rs = st.executeQuery(sql.toString());
		} catch (SQLException ex) {
			System.err.println("Error while querying data from database. \n"
					+ ex.getSQLState() + "\n" + ex.getErrorCode() + "\n"
					+ ex.getMessage());
		}
		return rs;
	}

	private static Connection getConnectionToDB2DB() {
		DB2DAOFactory db2daof = (DB2DAOFactory) DAOFactory.getDAOFactory(0);
		Connection conn = null;
		try {
			conn = db2daof.createConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(conn != null)
			DBConnectionStatus.connectionStatus = DBConnectionStatus.CONNECTED_TO_DB2_DB;
		
		DBConnectionStatus.printConnectionStatus();
		
		return conn;
	}
}
