package beans.example;

import javax.swing.SwingUtilities;

import beans.example.controller.Controller;
import beans.example.model.Model;
import beans.example.view.View;

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
