import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JPanel
{
	private JLabel currentScore, highScore;
	private int score = 0, hs = 0;
	private Scanner s;
	public Scoreboard()
	{
		loadHighScore();
		
		currentScore = new JLabel("Current score: " + score);
		highScore = new JLabel("High score: " + hs);
		
		setBackground(Color.white);
		setLayout(new BorderLayout());
		add(currentScore, BorderLayout.EAST);
		add(highScore, BorderLayout.WEST);
	}
	
	public void incrementScore() {
		score++;
		if(score > hs) {
			hs = score;
			storeHighScore();
			highScore.setText("High score: " + hs);
		}
		currentScore.setText("Current score: " + score);
	}
	private void loadHighScore() 	// loads high score from a txt file
	{
		try
		{
			s = new Scanner(new File("data.txt"));
			hs = s.nextInt();
			s.close();
		}
		catch(Exception e)
		{
			System.out.println("Data file not found! High score set to 0.");
		}
	}
	private void storeHighScore() 	// writes high score to a txt file - should be called whenever the high score updates
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
