import javax.swing.*;

public class Driver
{
	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(null, "Welcome to Breakout2!");
		
		JFrame frame = new JFrame("Breakout2");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPositionRelativeTo(null);
		frame.setContentPane(new Display());
	}
}
