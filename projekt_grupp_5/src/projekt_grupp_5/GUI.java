package projekt_grupp_5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI {
	private JFrame frame;
	private Container contentPane;
	public GUI() {
		makefram();
	}

	private void makefram() {
		frame = new JFrame("FLAPPY BIRDS");
		contentPane = frame.getContentPane();
		//makeMenuBar(frame);
		//skapa paneler
		makePanels(contentPane);
		frame.pack();
		frame.setVisible(true);
	}

	public void makePanels(Container contentPane) {
		contentPane.setLayout(new GridLayout(3,2,3,3));
		JButton start = new JButton("START");
		//procedur när start trycks
		start.addActionListener(
				(ActionEvent e) -> {start(); }
				);
		contentPane.add(start);

		JButton HS = new JButton("HIGH SCORE");
		HS.addActionListener(
				(ActionEvent e) -> {HS(); }
				);
		contentPane.add(HS);
	}

	//funktion för att trigga igång spelet
	private void start() {
		System.out.println("testar START \n");
		
		contentPane.removeAll();
		contentPane.repaint();
		//anropa funktion som startar spelet
		//game.start();
		
		//skapa bird
		ImageIcon img = new ImageIcon(this.getClass().getResource("/bird.png"));
		Bird untz = new Bird(img);
		contentPane.add(untz);
	}

	//funktion för att trigga HighScore
	private void HS() {
		System.out.println("testar HIGH SCORE \n");}
	
}
