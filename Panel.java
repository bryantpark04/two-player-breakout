import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel {
private Display display;
public JFrame f;
public JFrame fr;

private Scoreboard scoreboard;
	public Panel(JFrame l) {
		f=l;
      display = new Display();
      scoreboard = new Scoreboard();
		setLayout(new BorderLayout());
		
		add(display, BorderLayout.CENTER);
		add(scoreboard, BorderLayout.SOUTH);
		
		Timer t = new Timer(10, new Listener());
		t.start();
      fr = new JFrame("Breakout2");
		fr.setSize(625, 320);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setContentPane(new EndPanel());
      fr.setVisible(false);

      
	}
   
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(display.gameEnd()) {
				scoreboard.storeHighScore();
				display.stopGame();
            f.setVisible(false);
            fr.setVisible(true);
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
