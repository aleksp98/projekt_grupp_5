package projekt_grupp_5;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pipe extends JLabel{
	private int  y_position;
	private int  x_position;
	private int height;
	private int width;
	Dimension size;

	
	
	public Pipe() {
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/test.jpg"));
		
		setImage(img);
		
		size = getPreferredSize();
		
		width = size.width;
		height = size.height;
		
		setPosition(1280,0,size.width,size.height);
		
	}
	
	public void setPosition(int x, int y, int width2, int height2) {
		x_position = x;
		y_position = y;
		this.width = width2;
		this.height = height2;
		setBounds(x, y, width2, height2);	
	}
	
	
	private void setImage(ImageIcon img) {
		
		super.setIcon(img);
	}
	
	public int prefWidth() {return size.width;}
	public int prefHeight() {return size.height;}
    public int getX() {return x_position;}
	public int getY() {return y_position;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
}
