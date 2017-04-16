package memoryVSdatabase.example.model;

public class MySQLDAOFactory extends DAOFactory{

	@Override
	public PersonDAO getPersonDAO() {
		// TODO Auto-generated method stub
		return new MySQLPersonDAO();
	}

	@Override
	public LogDAO getLogDAO() {
		// TODO Auto-generated method stub
		return new MySQLLogDAO();
	}

}
