package singleton.example;

import javax.swing.SwingUtilities;

import Observer.demo2.controller.Controller;
import Observer.demo2.model.Model;
import Observer.demo2.view.View;

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
