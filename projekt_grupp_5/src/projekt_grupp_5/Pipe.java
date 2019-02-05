package projekt_grupp_5;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pipe extends JLabel{

	private int  y_position;
	private int  x_position;
	private int height;
	private int width;
	public Pipe(ImageIcon img) {
		super(img);	
	}
	
	public void setPosition(int x, int y, int width, int height) {
		x_position = x;
		y_position = y;
		this.width = width;
		this.height = height;
		setBounds(x, y, width, height);	
	}
}
