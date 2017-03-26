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
public class PersonDAO {

	public void addPerson(Person person) throws SQLException{
		Connection conn = Database.getInstance().getConnection();
		
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("insert into people (name, password) values (?,?)");
		
		preparedStatement.setString(1, person.getName());
		preparedStatement.setString(2, person.getPassword());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	public Person getPerson(int id){
		return null;
	}
	
	public List<Person> getPeople() throws SQLException{
		List<Person> people = new ArrayList<Person>();
		
		Connection conn = Database.getInstance().getConnection();
		
		String sql = "select id, name, password for people order by id";
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
	
	public void updatePerson(Person person){
		
	}
	
	public void deletePerson(int id ){
		
	}
}
