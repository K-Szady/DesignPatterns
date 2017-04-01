package javacourse.desingpatterns.DesignPatters.demo1.view;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import javacourse.desingpatterns.DesignPatters.demo1.model.Model;

public class View extends JFrame {
	private Model model;

	public View(Model model) throws HeadlessException {
		super("MVC Demo");
		this.model = model;
	}
	

}
