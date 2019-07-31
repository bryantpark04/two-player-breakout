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
   	
      currentScore = new JLabel(" Current score: " + score);
      highScore = new JLabel("High score: " + hs + " ");
   	
      setBackground(Color.black);
      currentScore.setForeground(Color.white);
      highScore.setForeground(Color.white);
      setLayout(new BorderLayout());
      add(currentScore, BorderLayout.WEST);
      add(highScore, BorderLayout.EAST);
   }
	
   public void incrementScore() {
      score++;
      if(score > hs) {
         hs = score;
         storeHighScore();
         highScore.setText("High score: " + hs + " ");
      }
      currentScore.setText(" Current score: " + score);
   }
   private void loadHighScore() 	// loads high score from a txt file
   {
      try
      {
         s = new Scanner(new File("data.txt"));
         hs = s.nextInt();
      }
      catch(Exception e)
      {
         System.out.println("Data file not found! High score set to 0.");
      }
   }
   public void storeHighScore() 	// writes high score to a txt file - should be called whenever the high score updates
   {
      try
      {
         PrintWriter p = new PrintWriter(new FileWriter("data.txt"));
         p.println(hs);
         p.close();
      }
      catch(Exception e)
      {
         System.out.println("High score could not be written to file! High score will be set to 0 on next run.");
      }
   }
   public void reset() {
		score = 0;
		loadHighScore();
		currentScore.setText(" Current score: " + score);
		highScore.setText("High score: " + hs + " ");
	}
   public int getScore() {
      return score;
   }
}
