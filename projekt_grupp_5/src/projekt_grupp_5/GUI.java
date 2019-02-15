package projekt_grupp_5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class GUI implements KeyListener, ActionListener{
	private JFrame frame;
	private Container contentPane;
	private Bird untz;
	private static int period = 150;
	private Pipe pU[] = new Pipe[3];
	private Pipe pD[] = new Pipe[3];
    
	private final int WIDTH = 800, HEIGHT = 800;
	int kaos;

	//�ndra tiden f�r att �teropa funktionen
	private Timer timer = new Timer(period,this); // Swing-timer

	public GUI() {
		makefram();
	}

	private void makefram() {
		frame = new JFrame("FLAPPY BIRDS");
		frame.setFocusable( true );
		contentPane = frame.getContentPane();
		//skapa paneler
		makePanels(contentPane);
		//l�gg  till knapp avlyssnare i JFramen
		frame.addKeyListener(this);
		frame.pack();
		//storlek p� jFRame
		frame.setSize(WIDTH,HEIGHT);
		frame.setVisible(true);
	}

	//skapar knapparna till start menyn och 
	public void makePanels(Container contentPane) {
		contentPane.setLayout(new GridLayout(3,2,3,3));
		JButton start = new JButton("START");
		//procedur n�r start trycks
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

	//funktion f�r att trigga ig�ng spelet
	private void start() {
		//System.out.println("testar START \n");
		//rensar bort start meny
		contentPane.removeAll();
		contentPane.setLayout(null);
		//skapa bird
		untz = new Bird();
		contentPane.add(untz);
		//skapa (just nu) 3 pipes
		makepipes();
		//skapa bakground
		ImageIcon back = new ImageIcon(this.getClass().getResource("/sten.jpg"));
		JLabel background = new JLabel(back);
		background.setBounds(0, 0,WIDTH,HEIGHT);
		contentPane.add(background);
		//starta timer f�r att f�geln automatiskt skall �ka ned�t
		timer.start();
		contentPane.repaint();
	}

	//hur f�r jag dem att flytta p� sig?
	//kanske l�gga alla r�r i en array.
	//sedan anropa en funktion tex move. Som �ndrar positionen i x led p� alla r�r tex -20
	//funktionen move anropas efter en viss period 0.5s ?
	//om pipe �ker f�rbi sk�rmen �ndras positionen s� att den kommer tillbaka
	private void makepipes() {
		int set = WIDTH;
		for(int i = 0; i<3; i++) {
			Pipe up = new Pipe();	
			int height = up.prefHeight();
			upPipe(set,height,up);
			pU[i] = up;
			contentPane.add(up);

			Pipe pipeDown = new Pipe();
			downPipe(set,600,pipeDown);
			pD[i] = pipeDown;
			contentPane.add(pipeDown);	
			set = set +300;
		}
	}



	private void upPipe(int x_pos,int height, Pipe pipe) {
		//		Random rand = new Random();
		//		int random = rand.nextInt(200) - 100;
		//		kaos = pipe.prefHeight() + random;	
		pipe.setPosition(x_pos, 0, pipe.prefWidth(), height);
	}
	private void downPipe(int x_pos,int y_pos, Pipe pipe) {
		pipe.setPosition(x_pos, y_pos, pipe.prefWidth(), pipe.prefHeight());
	}

	//funktion f�r att trigga HighScore
	private void HS() {
		System.out.println("testar HIGH SCORE \n");
	}

	//timer ropar upp den h�r funktionen f�r att f� f�gelna att �ka ner automatiskt(tyngkraft)
	// testa med att flytta r�ren ocks�
	public void actionPerformed(ActionEvent e) {
		///////////////////////////////////////f�geln
		int y = untz.getY() + 40;

		untz.setPosition(100, y);
		//contentPane.repaint(); 
		////////////////////////////////////////////
		///////////////////////////////////////////f� r�ren att r�ren r�ra p�s sig
		for(int i= 0; i<3 ;i++) {
			
         //om f�gel nuddar taket
			if(untz.getY() < 0) {
				timer.stop();
				frame.dispose();
				makefram();
				return;	
			}

             //om f�geln nuddar taket
			if(untz.getY() > (HEIGHT-untz.getHeight())) {
				timer.stop();
				frame.dispose();
				makefram();
				return;
			}
			
			if(untz.getY()< pU[i].getY()+ pU[i].getHeight() && (untz.getX()>= pU[i].getX() &&   untz.getX()<= pU[i].getX()+ pU[i].getWidth()    ) ) {
				timer.stop();
			frame.dispose();
			makefram();
				return;
				}


			int x_pos =	pU[i].getX();

			if(x_pos < 0 - pU[i].prefWidth()) {

				Random rand = new Random();
				int random = rand.nextInt(200) - 100;
				int testhojd = pU[i].prefHeight() + random;	
				int Position2 = testhojd+ 600 - 200;
				upPipe(WIDTH,testhojd, pU[i]);
				downPipe(WIDTH,Position2, pD[i]);
			}
			else {

				pU[i].setPosition(x_pos-40, 0 , pU[i].prefWidth(), pU[i].getHeight());
				pD[i].setPosition(x_pos-40, pD[i].getY() , pD[i].prefWidth(), pD[i].prefHeight());

			}


		}
	} 

	@Override
	//vid klick upp s� skall f�geln r�ra sig upp�t
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("testar key UP \n");
			int y = untz.getY() - 100;
			untz.setPosition(100, y);
			contentPane.repaint(); 
		}
	}

	//anv�nds ej
	public void keyPressed (KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
