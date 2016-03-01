package view;

import javax.swing.JFrame;

import control.Controller;
import view.Gamepanel;

public class Frame extends JFrame{
	
	private Controller controller;
	
	public Frame(Controller controller) {
		
		this.controller = controller;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setBounds(300, 100, controller.getFrameWidth(), controller.getFrameHeight());
	    this.setLayout(null);
	    this.setVisible(true);
	    this.setResizable(false);
	    
	    Gamepanel gamepanel = new Gamepanel(controller);
	    Optionpanel optionpanel = new Optionpanel(controller);
	    this.add(gamepanel);
	    this.add(optionpanel);
	    
	}
	
}
