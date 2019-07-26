import java.util.Scanner;
import java.io.*;
import javax.swing.JPanel;

public class Scoreboard extends JPanel
{
	public Scoreboard()
	{
		
	}
	
	private int loadHighScore()
	{
		Scanner s = new Scanner(new File("data.txt"));
		int hs = s.nextInt();
		s.close();
	}
	private void storeHighScore(int hs)
	{
		
	}
}
