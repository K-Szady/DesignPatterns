package javacourse.desingpatterns.DesignPatters.demo1;

import javax.swing.SwingUtilities;

import javacourse.desingpatterns.DesignPatters.demo1.controller.Controller;
import javacourse.desingpatterns.DesignPatters.demo1.model.Model;
import javacourse.desingpatterns.DesignPatters.demo1.view.View;

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
	}

}
