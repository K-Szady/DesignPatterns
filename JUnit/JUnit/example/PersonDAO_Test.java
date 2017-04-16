package JUnit.example;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DAO.example.model.MySQLDAOFactory;
import DAO.example.model.Database;
import DAO.example.model.Person;
import DAO.example.model.PersonDAO;

public class PersonDAO_Test{
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("set up before class");
		Database.getInstance().connect();
	}
	
	@AfterClass
	public static void tearDwonAfterClass() throws Exception{
		System.out.println("tear down after class");
		Database.getInstance().disconnect();
	}
	/*
	@Before
	public void setUp() throws Exception {
		System.out.println("set up");
		PersonDAO dao = MySQLDAOFactory.getPersonDAO();
		dao.deleteAll();
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("tear dwon");
	}
	
	@Test
	public void testDemo(){
		int value = 7;
		value += 2;
		System.out.println("Running demo test");
		assertEquals("Check that armithmetic works in Java", 9, value);
	}
	
	@Test
	public void testCreate() throws SQLException{
		PersonDAO dao = MySQLDAOFactory.getPersonDAO();
		Person person1 = new Person("Bob", "letmein");
		Person person2 = new Person("Sue", "hello");
		dao.addPerson(person1);
		dao.addPerson(person2);
		List<Person> people = dao.getPeople();
		assertEquals("Should be two people in database", 2, people.size());
		assertEquals("These to people should be the same", person1, people.get(0));
		assertEquals("These to people should be the same", person2, people.get(1));
		
	}
	*/

}
