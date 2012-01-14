package pw.inz.pd.db.helper;

public class DBConnectionStatus {
	public static final String INIT_CONNECTION_DB2_DB= "DB2 database connection initialization...";
	public static final String CONNECTED_TO_DB2_DB = "Successfully connected to DB2 database";	
	public static final String DISCONNECTED_FROM_DB2_DB = "Disconnected from DB2 database";	
	public static String connectionStatus;
	
	public static void printConnectionStatus(){
		System.out.println(connectionStatus);
	}
}
