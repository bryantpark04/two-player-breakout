import java.util.Scanner;
import java.io.*;
import javax.swing.JPanel;

public class Scoreboard extends JPanel
{
	public Scoreboard()
	{
		
	}
	
	private int loadHighScore() 	// loads high score from a txt file
	{
		int hs = 0;
		
		try
		{
			Scanner s = new Scanner(new File("data.txt"));
			hs = s.nextInt();
			s.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Data file not found! High score set to 0.");
		}
		
		return hs;
	}
	private void storeHighScore(int hs) 	// writes high score to a txt file - should be called whenever the high score updates
	{
		try
		{
			PrintWriter p = new PrintWriter(new FileWriter("data.txt"));
			p.println(hs);
		}
		catch(IOException e)
		{
			System.out.println("High score could not be written to file! High score will be set to 0 on next run.");
		}
	}
}
