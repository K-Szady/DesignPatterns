package memoryVSdatabase.example;

import javax.swing.SwingUtilities;

import memoryVSdatabase.example.controller.Controller;
import memoryVSdatabase.example.model.Model;
import memoryVSdatabase.example.view.View;

public class App {

	public static void main(String[] args) {
		/*
		 * This is the recommended way to create a Swing 
		 * event dispatch threat ---- to run a Swing
		 * program.
		 */
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				runApp();
				
			}
		});
		
	}
	
	public static void runApp(){
		/*
		 * Create the model. It's inportant thing 
		 * to have a model package, where you
		 * put your model code
		 */
		Model model = new Model();
		
		
		/*
		 * The view here listens to the model, but some
		 * implementations of MVC do not allow the view to
		 * touch the model in any way, rather only allowing
		 * the controller package classes to interact with 
		 * model package classes
		 */
		View view = new View(model);
		
		/*
		 * Controller or Controllers or sub-controllers
		 * but for many apps, there will just be one controller
		 * witch deals with routing all messages; it listens to 
		 * the view and model and instructs both what to do
		 */
		Controller controller = new Controller(view, model);
		
		/*
		 * The controller must listen to the view to find
		 * out what happens in it. Controller should not be concerned with what actually
		 * happens in the view in terms of buttons and 
		 * other widgets, but only a high-level view of 
		 * instructions coming from the view(save such-and-such,
		 * adjust such-and-such, shutdown the app, etc)
		 */
		view.setCreateUserListener(controller);
		view.setSaveListener(controller);
		view.setAppListener(controller);
		
		model.setPeopleChangedListener(view);
	}

}
