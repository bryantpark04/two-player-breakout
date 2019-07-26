import javax.swing.*;

public class Driver
{
	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(null, "Welcome to Breakout2!");
		JOptionPane.showMessageDialog(null, "It's like normal breakout, but you only move if both A and left arrow or D and right arrow are pressed.");
		JOptionPane.showMessageDialog(null, "This is meant to be a two player game. \nCooperation is key!");
		JOptionPane.showMessageDialog(null, "Good luck!\nPress space to start.");
		
		JFrame frame = new JFrame("Breakout2");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		//frame.setContentPane(new Display());
	}
}
