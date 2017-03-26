package singleton.example.controller;

import Observer.demo2.model.Model;
import Observer.demo2.view.LoginFormEvent;
import Observer.demo2.view.LoginListener;
import Observer.demo2.view.View;

public class Controller implements LoginListener {
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void loginPerformed(LoginFormEvent event) {
		System.out.println("Welcome: " + event.getName() );
		
	}
	
	

}
