package projekt_grupp_5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI implements KeyListener, ActionListener  {
	private JFrame frame;
	private Container contentPane;
	private Bird untz;
    private Dimension size;
    private int y_pos = 200;
    Timer timer = new Timer(300,this); // Swing-timer
	
	public GUI() {
		makefram();
	}

	private void makefram() {
		frame = new JFrame("FLAPPY BIRDS");
		contentPane = frame.getContentPane();
		//makeMenuBar(frame);
		
		 
		//skapa paneler
		makePanels(contentPane);
		 
		frame.addKeyListener(this);
		frame.pack();
		frame.setSize(1000,1000);
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
		
		//anropa funktion som startar spelet
		//game.start();
		
		//skapa bird
		ImageIcon img = new ImageIcon(this.getClass().getResource("/bird.png"));
		
		untz = new Bird(img);
		
		 size = untz.getPreferredSize();
	  
		 untz.setBounds(400, 200, size.width, size.height);
		 
		contentPane.add(untz);
		
		timer.start();
		
		contentPane.repaint();
	}

	//funktion för att trigga HighScore
	private void HS() {
		System.out.println("testar HIGH SCORE \n");}
	
	 public void keyReleased(KeyEvent e) {}
	    public void keyTyped(KeyEvent e) {}
	    
	    public void actionPerformed(ActionEvent e) {
	    	y_pos = y_pos + 10;
        	untz.setBounds(400, y_pos, size.width, size.height);
        	contentPane.repaint(); 
	    	 } 
	
	
	 @Override
	    public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == KeyEvent.VK_UP) {
	    		System.out.println("testar key UP \n");
	        	y_pos = y_pos - 10;
	        	untz.setBounds(400, y_pos, size.width, size.height);
	        	contentPane.repaint(); 
	        }
	    }
	
}
