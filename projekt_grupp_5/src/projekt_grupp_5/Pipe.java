package projekt_grupp_5;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pipe extends JLabel{
	private int  y_position;
	private int  x_position;
	private int height;
	private int width;
	private ImageIcon img = new ImageIcon(this.getClass().getResource("/pipe.jpg"));
	public Pipe() {
		
		setImage();
		Dimension size = getPreferredSize();

		
	}
	
	public void setPosition(int x, int y, int width, int height) {
		x_position = x;
		y_position = y;
		this.width = width;
		this.height = height;
		setBounds(x, y, width, height);	
	}
	
	
	private void setImage() {
		//ImageIcon img = new ImageIcon(this.getClass().getResource("/pipe.jpg"));
		super.setIcon(img);
	}
	
	
   public int getX() {return x_position;}
	
	public int getY() {return y_position;}
	
	public int getWidth() {return width;}
	
	public int getHeight() {return height;}
}