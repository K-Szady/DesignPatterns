package memoryVSdatabase.example.controller;

import memoryVSdatabase.example.model.Database;
import memoryVSdatabase.example.model.Model;
import memoryVSdatabase.example.model.Person;
import memoryVSdatabase.example.view.AppListener;
import memoryVSdatabase.example.view.CreateUserEvent;
import memoryVSdatabase.example.view.CreateUserListener;
import memoryVSdatabase.example.view.SaveListener;
import memoryVSdatabase.example.view.View;

public class Controller implements SaveListener, CreateUserListener,AppListener {

	private View view;
	private Model model;
	
	public Controller(View view, Model model){
		this.view = view;
		this.model = model;
	}
	
	public void onOpen() {
		try{
			Database.getInsctance().connect();
		}catch (Exception e) {
			view.showError("Cannot connect to Database");
		}
		try{
			model.load();
		}catch (Exception e) {
			view.showError("Error loading data from database");
		}
		
	}

	public void onClose() {
		Database.getInsctance().disconnect();
		
	}

	public void onUserCreated(CreateUserEvent event) {
		model.addPerson(new Person(event.getName(),event.getPassword()));
		
	}

	public void onSave() {
		try{
			model.save();
		}catch (Exception e) {
			view.showError("Error saving to Database");
		}
		
	}

}
