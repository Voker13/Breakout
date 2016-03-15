package view;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Controller;

public class ScoreFrame extends JFrame{
	
	private Controller controller;
	private JPanel scorePanel;
	private JLabel scoreTitle;
	JLabel first;
	JLabel second;
	JLabel third;
	JLabel fourth;
	JLabel fifth;
	JLabel sixth;
	JLabel seventh;
	JLabel heighth;
	JLabel ninth;
	JLabel tenth;
	
	public ScoreFrame(Controller controller) {
		this.controller = controller;
		Font font = new Font("name", 0, 18);
		
		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(controller.getFrameX()+controller.getFrameWidth()+10, controller.getFrameY(), 200, controller.getFrameHeight());
		this.setVisible(true);
		
		scorePanel = new JPanel();
		scorePanel.setBounds(0, 0, 200, controller.getFrameHeight());
		scorePanel.setBackground(Color.white);
		scorePanel.setLayout(null);
		this.add(scorePanel);
		
		scoreTitle = new JLabel("HelloWorld");
		scoreTitle.setBounds(50, 0, 200, 50);
		scoreTitle.setFont(font);
		scoreTitle.setText("Scoreboard:");
		scoreTitle.setForeground(Color.black);
		scorePanel.add(scoreTitle);
		
		first = new JLabel("HelloWorld");
		first.setBounds(10, controller.getFrameHeight() / 20 * 0 + 50, 200, 50);
		first.setFont(font);
		first.setForeground(Color.black);
		scorePanel.add(first);
		
		second = new JLabel("HelloWorld");
		second.setBounds(10, controller.getFrameHeight() / 20 * 1 + 50, 200, 50);
		second.setFont(font);
		second.setForeground(Color.black);
		scorePanel.add(second);
		
		third = new JLabel("HelloWorld");
		third.setBounds(10, controller.getFrameHeight() / 20 * 2 + 50, 200, 50);
		third.setFont(font);
		third.setForeground(Color.black);
		scorePanel.add(third);
		
		fourth = new JLabel("HelloWorld");
		fourth.setBounds(10, controller.getFrameHeight() / 20 * 3 + 50, 200, 50);
		fourth.setFont(font);
		fourth.setForeground(Color.black);
		scorePanel.add(fourth);
		
		fifth = new JLabel("HelloWorld");
		fifth.setBounds(10, controller.getFrameHeight() / 20 * 4 + 50, 200, 50);
		fifth.setFont(font);
		fifth.setForeground(Color.black);
		scorePanel.add(fifth);
		
		sixth = new JLabel("HelloWorld");
		sixth.setBounds(10, controller.getFrameHeight() / 20 * 5 + 50, 200, 50);
		sixth.setFont(font);
		sixth.setForeground(Color.black);
		scorePanel.add(sixth);
		
		seventh = new JLabel("HelloWorld");
		seventh.setBounds(10, controller.getFrameHeight() / 20 * 6 + 50, 200, 50);
		seventh.setFont(font);
		seventh.setForeground(Color.black);
		scorePanel.add(seventh);
		
		heighth = new JLabel("HelloWorld");
		heighth.setBounds(10, controller.getFrameHeight() / 20 * 7 + 50, 200, 50);
		heighth.setFont(font);
		heighth.setForeground(Color.black);
		scorePanel.add(heighth);
		
		ninth = new JLabel("HelloWorld");
		ninth.setBounds(10, controller.getFrameHeight() / 20 * 8 + 50, 200, 50);
		ninth.setFont(font);
		ninth.setForeground(Color.black);
		scorePanel.add(ninth);
		
		tenth = new JLabel("HelloWorld");
		tenth.setBounds(10, controller.getFrameHeight() / 20 * 9 + 50, 200, 50);
		tenth.setFont(font);
		tenth.setForeground(Color.black);
		scorePanel.add(tenth);
		
		setText();
		
	}
	
	public void setText() {
		first.setText("1. " + controller.getHighscoreList().get(0).getName() + " " + controller.getHighscoreList().get(0).getScore());
		second.setText("2. " + controller.getHighscoreList().get(1).getName() + " " + controller.getHighscoreList().get(1).getScore());
		third.setText("3. " + controller.getHighscoreList().get(2).getName() + " " + controller.getHighscoreList().get(2).getScore());
		fourth.setText("4. " + controller.getHighscoreList().get(3).getName() + " " + controller.getHighscoreList().get(3).getScore());
		fifth.setText("5. " + controller.getHighscoreList().get(4).getName() + " " + controller.getHighscoreList().get(4).getScore());
		sixth.setText("6. " + controller.getHighscoreList().get(5).getName() + " " + controller.getHighscoreList().get(5).getScore());
		seventh.setText("7. " + controller.getHighscoreList().get(6).getName() + " " + controller.getHighscoreList().get(6).getScore());
		heighth.setText("8. " + controller.getHighscoreList().get(7).getName() + " " + controller.getHighscoreList().get(7).getScore());
		ninth.setText("9. " + controller.getHighscoreList().get(8).getName() + " " + controller.getHighscoreList().get(8).getScore());
		tenth.setText("10. " + controller.getHighscoreList().get(9).getName() + " " + controller.getHighscoreList().get(9).getScore());
	}
	
	
}
