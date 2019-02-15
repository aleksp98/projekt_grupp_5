package projekt_grupp_5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bird extends JLabel {
	
	private int  y_position;
	private int fuckalll;
	private int fuckall3;
	private int  x_position;
	private int height;
	private int width;
	private ImageIcon img = new ImageIcon(this.getClass().getResource("/bird_down.png"));
	
	public Bird() 
	{
	setImage();
	Dimension size = getPreferredSize();
	
	width = size.width;
	height = size.height;

	//ger position till fågeln och skapar bilden
	setPosition(100, 200);
	}
	
	public void setPosition(int x, int y) {
		x_position = x;
		y_position = y;
		setBounds(x, y, width, height);	
	}
	
	private void setImage() {
		super.setIcon(img);
	}
	

	public int getX() {return x_position;}
	
	public int getY() {return y_position;}
	
	public int getWidth() {return width;}
	
	public int getHeight() {return height;}
	
	
	
	
}
