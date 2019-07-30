import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel {
private Display display;
private Scoreboard scoreboard;
	public Panel() {
		
      display = new Display();
      scoreboard = new Scoreboard();
		setLayout(new BorderLayout());
		
		add(display, BorderLayout.CENTER);
		add(scoreboard, BorderLayout.SOUTH);
		
		Timer t = new Timer(10, new Listener());
		t.start();
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(display.gameEnd()) {
				scoreboard.storeHighScore();
				display.stopGame();
				JOptionPane.showMessageDialog(null, "You lost! Your score was: " + scoreboard.getScore());
				System.exit(0);
			}
			if(display.pointScored()) {
				scoreboard.incrementScore();
			}
			if(display.roundWon()) {
				JOptionPane.showMessageDialog(null, "You won!");
			}
		}
	}
}
