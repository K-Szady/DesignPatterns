package javacourse.desingpatterns.DesignPatters.demo1.controller;

import javacourse.desingpatterns.DesignPatters.demo1.model.Model;
import javacourse.desingpatterns.DesignPatters.demo1.view.View;

public class Controller {
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	

}
