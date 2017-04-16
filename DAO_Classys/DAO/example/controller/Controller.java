package DAO.example.controller;

import java.sql.SQLException;

import DAO.example.model.DAOFactory;
import DAO.example.model.Model;
import DAO.example.model.Person;
import DAO.example.model.PersonDAO;
import DAO.example.model.MySQLPersonDAO;
import DAO.example.view.CreateUserEvent;
import DAO.example.view.CreateUserListener;
import DAO.example.view.View;

public class Controller implements CreateUserListener {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void userCreated(CreateUserEvent event) {
		DAOFactory factory =  DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		
		PersonDAO personDAO = factory.getPersonDAO();
		
		System.out.println("Event login recived: " + event.getName() + "; " + event.getPassword() );
		
		try{
			personDAO.addPerson(new Person(event.getName(), event.getPassword()));
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
}
