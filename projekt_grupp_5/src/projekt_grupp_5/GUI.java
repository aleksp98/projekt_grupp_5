package projekt_grupp_5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class GUI implements KeyListener, ActionListener  {
	private JFrame frame;
	private Container contentPane;
	private Bird untz;
	private Dimension size;
	private int y_pos = 200;
	private static int period = 150;
	private Pipe array[] = new Pipe[3];
	Dimension siz;

	private JLabel background;
	//ändra tiden för att återopa funktionen
	private Timer timer = new Timer(period,this); // Swing-timer

	public GUI() {
		makefram();
	}

	private void makefram() {
		frame = new JFrame("FLAPPY BIRDS");
		contentPane = frame.getContentPane();

		//skapa paneler
		makePanels(contentPane);
		//lägg  till knapp avlyssnare i JFramen
		frame.addKeyListener(this);
		frame.pack();

		//storlek på jFRame
		frame.setSize(1280,800);
	
		
		frame.setVisible(true);
	}

	//skapar knapparna till start menyn och 
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
		//System.out.println("testar START \n");

		//rensar bort start meny
		contentPane.removeAll();
		contentPane.setLayout(null);
		//skapa bird
		untz = new Bird();
	    size = untz.getPreferredSize();

		contentPane.add(untz);
		
	    //skapa (just nu) 3 pipes
		 makepipes();
		//skapa bakground
		ImageIcon back = new ImageIcon(this.getClass().getResource("/sten.jpg"));
		background = new JLabel(back);
		background.setBounds(0, 0,1280,800);
		contentPane.add(background);
		
		
		//starta timer för att fågeln automatiskt skall åka nedåt
		timer.start();

		contentPane.repaint();
	}
	
	//hur får jag dem att flytta på sig?
	//kanske lägga alla rör i en array.
	//sedan anropa en funktion tex move. Som ändrar positionen i x led på alla rör tex -20
	//funktionen move anropas efter en viss period 0.5s ?
	//om pipe åker förbi skärmen ändras positionen så att den kommer tillbaka
	private void makepipes() {
		
		int set = 0;
		int test = 0;
		for(int i = 0; i<3; i++) {
		
			//göra så att test blir ett random tal mellan 0-300
			
		//ImageIcon img = new ImageIcon(this.getClass().getResource("/pipe.jpg"));
		Pipe pipe = new Pipe();
		siz = pipe.getPreferredSize();
		pipe.setPosition(set, 0 , siz.width/5, (siz.height+test)/5);
		contentPane.add(pipe);
		
		array[i] = pipe;
		//test = test +200;
       
		set = set + 500;
		}
	}

	//funktion för att trigga HighScore
	private void HS() {
		System.out.println("testar HIGH SCORE \n");
	}
	
	//timer ropar upp den här funktionen för att få fågelna att åka ner automatiskt(tyngkraft)
	// testa med att flytta rören också
	public void actionPerformed(ActionEvent e) {
	///////////////////////////////////////fågeln
		y_pos = y_pos + 10;
		untz.setPosition(400, y_pos, size.width, size.height);
		//contentPane.repaint(); 
		////////////////////////////////////////////
		/////////////////////////////////////////7//få fören att rören röra pås sig
		for(Pipe test : array) {
		int x_pos =	test.getX();
			test.setPosition(x_pos-30, 0 , siz.width/5, (siz.height)/5);
			
			if(x_pos < -(siz.width/5)) {
				
				test.setPosition(1280, 0 , siz.width/5, (siz.height)/5);
				
			}
		}
		
		
	} 
	

	

	@Override

	//vid klick upp så skall fågeln röra sig uppåt
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("testar key UP \n");
			y_pos = y_pos - 100;
			untz.setPosition(400, y_pos, size.width, size.height);
			contentPane.repaint(); 
		}
	}

	//används ej
	public void keyPressed (KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
