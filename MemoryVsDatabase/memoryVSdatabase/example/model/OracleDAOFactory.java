package memoryVSdatabase.example.model;

public class OracleDAOFactory extends DAOFactory {

	@Override
	public PersonDAO getPersonDAO() {
		// TODO Auto-generated method stub
		return new OraclePersonDAO();
	}

	@Override
	public LogDAO getLogDAO() {
		// TODO Auto-generated method stub
		return new OracleLogDAO();
	}

}
