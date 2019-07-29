import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel {
private Display display;
private Scoreboard scoreboard;
	public Panel() {
		
      display=new Display();
      scoreboard=new Scoreboard();
		setLayout(new BorderLayout());
		
		add(display, BorderLayout.CENTER);
		add(scoreboard, BorderLayout.SOUTH);
		
		Timer t = new Timer(100, new Listener());
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
      
			scoreboard.update();
			display.update();
		}
	}
}
