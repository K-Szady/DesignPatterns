package DAO.example.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

/*
 * One DAO class per table or view
 * CRUD - create, retrieve, update, delete
 */
public class MySQLPersonDAO implements PersonDAO {

	/* (non-Javadoc)
	 * @see DAO.example.model.PersonDAO#addPerson(DAO.example.model.Person)
	 */
	public void addPerson(Person person) throws SQLException{
		Connection conn = Database.getInstance().getConnection();
		
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("insert into people (name, password) values (?,?)");
		
		preparedStatement.setString(1, person.getName());
		preparedStatement.setString(2, person.getPassword());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	/* (non-Javadoc)
	 * @see DAO.example.model.PersonDAO#getPerson(int)
	 */
	public Person getPerson(int id) throws SQLException{
		Connection conn = Database.getInstance().getConnection();
		
		String sql = "select id, name, password from people where id=? order by id";
		PreparedStatement selectStatement  = (PreparedStatement) conn.prepareStatement(sql);
		
		selectStatement.setInt(1, id);
		
		ResultSet result = selectStatement.executeQuery();
		Person person = null;
		
		if(result.next()){
			String name = result.getString("name");
			String password = result.getString("password");
			
			person = new Person(id, name, password);
			
		}
		result.close();
		selectStatement.close();
		return person;
	}
	
	/* (non-Javadoc)
	 * @see DAO.example.model.PersonDAO#getPeople()
	 */
	public List<Person> getPeople() throws SQLException{
		List<Person> people = new ArrayList<Person>();
		
		Connection conn = Database.getInstance().getConnection();
		
		String sql = "select id, name, password from people order by id";
		Statement selectStatement = conn.createStatement();
		
		ResultSet result = selectStatement.executeQuery(sql);
		
		while(result.next()){
			int id = result.getInt("id");
			String name = result.getString("name");
			String password = result.getString("password");
			
			Person person = new Person(id, name, password);
			people.add(person);
		}
		
		result.close();
		selectStatement.close();
		return people;
	}
	
	/* (non-Javadoc)
	 * @see DAO.example.model.PersonDAO#updatePerson(DAO.example.model.Person)
	 */
	public int updatePerson(Person person) throws SQLException{
		
		Connection conn = Database.getInstance().getConnection();
		
		PreparedStatement p = (PreparedStatement) conn.prepareStatement("update people set name=?, password=? where id=?");
		p.setString(1, person.getName());
		p.setString(2, person.getPassword());
		p.setInt(3, person.getId());
		
		int updated = p.executeUpdate();
		
		p.close();
		
		return updated;
	}
	
	/* (non-Javadoc)
	 * @see DAO.example.model.PersonDAO#deletePerson(int)
	 */
	public int deletePerson(int id ) throws SQLException{
		Connection conn = Database.getInstance().getConnection();
		
		PreparedStatement p = (PreparedStatement) conn.prepareStatement("delete form people where id=?");
		p.setInt(1, id);
		
		int deleted = p.executeUpdate();
		p.close();
		
		return deleted;
		
		
	}

	/* (non-Javadoc)
	 * @see DAO.example.model.PersonDAO#deleteAll()
	 */
	public int deleteAll() throws SQLException {
		Connection conn = Database.getInstance().getConnection();
		
		PreparedStatement p = (PreparedStatement) conn.prepareStatement("delete from people");
		int delete = p.executeUpdate();
		p.close();
		
		return delete;
		
	}
}
