package beans.example.controller;

import beans.example.model.Model;
import beans.example.view.LoginFormEvent;
import beans.example.view.LoginListener;
import beans.example.view.View;

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
	
	