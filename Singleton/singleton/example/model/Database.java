package singleton.example.model;

/////// SINGLETON CLASS

public class Database {
	
	private static Database instance = new Database();
	
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
	

	public void connect(){
		System.out.println("Connect to database");
		
	}
	
	public void disconnect(){
		System.out.println("Disconnect.");
	}
	
}
