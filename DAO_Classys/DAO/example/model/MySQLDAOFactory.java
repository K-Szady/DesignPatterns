package DAO.example.model;

public class MySQLDAOFactory extends DAOFactory {
	/* (non-Javadoc)
	 * @see DAO.example.model.DAOFactory#getPersonDAO()
	 */
	public   PersonDAO getPersonDAO() {
		return new MySQLPersonDAO(); 
	}
	
	/* (non-Javadoc)
	 * @see DAO.example.model.DAOFactory#getLogDAO()
	 */
	public  LogDAO getLogDAO(){
		return new MySQLLogDAO();
	}

}
