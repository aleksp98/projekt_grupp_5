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
				(ActionEvent e) -> {test(); }
				);
		contentPane.add(start);


		JButton HS = new JButton("HIGH SCORE");
		HS.addActionListener(
				(ActionEvent e) -> {test2(); }
				);


		contentPane.add(HS);


	}

	private void test() {
		System.out.println("testar START \n");
		//hur tar man bort gridlayouten och startar spelet
		contentPane.removeAll();
		contentPane.repaint();
		//anropa funktion som startar spelet
		contentPane.add(new JLabel("test"));
	}

	private void test2() {
		System.out.println("testar HIGH SCORE \n");}
	
}
