package projekt_grupp_5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bird extends JLabel {
	//private ImageIcon img;
	private int  y_position;
	private int  x_position;
	private int height;
	private int width;
	
	public Bird(ImageIcon img) 
	{
		super(img);
	}
	
	public void setPosition(int x, int y, int width, int height) {
		x_position = x;
		y_position = y;
		this.width = width;
		this.height = height;
		setBounds(x, y, width, height);	
	}
	
	public int getX() {return x_position;}
	
	public int getY() {return y_position;}
	
	public int getWidth() {return width;}
	
	public int getHeight() {return height;}
	
	
}
