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
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(display.gameEnd()) {
				JOptionPane.showMessageDialog(null, "Game Over!");
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
