import javax.swing.*;

public class Driver
{
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	
	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(null, "Welcome to Breakout2!");
		JOptionPane.showMessageDialog(null, "It's like normal breakout, but you only move if both A and left arrow or D and right arrow are pressed.");
		JOptionPane.showMessageDialog(null, "This is meant to be a two player game. \nCooperation is key!");
		JOptionPane.showMessageDialog(null, "Good luck!");
		
      JFrame f=new JFrame("Breakout2");
      f.setSize(640,360);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLocationRelativeTo(null);
      f.setContentPane(new StartPanel(f));
      f.setVisible(true);
      
			}
}
