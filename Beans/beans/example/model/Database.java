package beans.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/////// SINGLETON CLASS

public class Database {

private static Database instance = new Database();

private Connection con;

private Database(){
	
}
public static Database getInstance(){
	return instance;
}
/*
/// old way or when we dont wont to create
/// instance before we need it, this example is 
/// not thread safe
private static Database instanceOld;

public static Database getInstanceOld(){
	if(instanceOld == null){
		instanceOld = new Database();
	}
	
	return instanceOld;
	
}
	*/


public void connect() throws Exception{
	if(con != null)
		return;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		throw new Exception("Driver not found!");
	}
	
	String url = String.format("jdbc:mysql://localhost:%d/patterns", 3306);
	
	con = DriverManager.getConnection(url, "root", "");
	System.out.println("Connection succes!");
}

public void disconnect(){
	if(con != null){
		try{
			con.close();
		}catch(SQLException	e){
			System.out.println("Can't close connection");
			
		}
	}
}

}
