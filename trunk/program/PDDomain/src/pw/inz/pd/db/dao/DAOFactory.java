package pw.inz.pd.db.dao;

public class DAOFactory {
	public static DB2DAOFactory getDAOFactory(int whichFactory) {
	
		switch (whichFactory) {
		case 0:
			return new DB2DAOFactory();
		default:
			return null;
		}
	}
}
