package DAO.example;

import javax.swing.SwingUtilities;

import DAO.example.controller.Controller;
import DAO.example.model.Model;
import DAO.example.view.View;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			public void run() {
				runApp();
				
			}
			
		}); 
		
	}
	
	public static void runApp(){
		Model model = new Model();
		View view = new View(model);
		Controller controller = new Controller(model, view);
		
		view.setLoginListener(controller);
	}

}