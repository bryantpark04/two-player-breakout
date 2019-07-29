import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Display extends JPanel 
{
   private BufferedImage myImage; 	// orivate fields
   private Graphics buffer;
   private Ball ball;
   private Slider slider;
   private Block[][] blocks = new Block[10][5];
   public Display() { 	// constructor
		myImage = new BufferedImage(Driver.WIDTH, Driver.HEIGHT, BufferedImage.TYPE_INT_RGB);
      buffer = myImage.getGraphics();
      
      buffer.setColor(Color.white);
      buffer.fillRect(0, 0, Driver.WIDTH, Driver.HEIGHT);
      
      ball = new Ball(300.0, 300.0, Math.random() * 2 - 1, 0.6);
      
      slider = new Slider(270, 550);
      
      for(int r = 0; r < blocks.length; r++) {
			for(int c = 0; c < blocks[0].length; c++) {
				blocks[r][c] = new Block(1 + 60 * r, 1 + 30 * c);
			}
		}
      
      addKeyListener(new Key()); 	// add key listener
      setFocusable(true);
      
      Timer t = new Timer(1, new Listener()); 	// add timer listener
      t.start();
	}
	
	// collision helpers
	private void collisionSlider(Ball b) {
		if(b.getX() + b.getDiameter() > slider.getX() && b.getX() < slider.getX() + slider.getWidth()) {
			if(b.getY() + b.getDiameter() > slider.getY() && b.getY() < slider.getY() + slider.getHeight()) {
				b.setdy(-1 * b.getdy());
			}
		}
	}
	private void collisionBlocks(Ball b) {
		for(int r = 0; r < blocks.length; r++) {
			for(int c = 0; c < blocks[0].length; c++) {
				try {
					if(b.getX() + b.getDiameter() > blocks[r][c].getX() && b.getX() < blocks[r][c].getX() + blocks[r][c].getWidth()) {
						if(b.getY() + b.getDiameter() > blocks[r][c].getY() && b.getY() < blocks[r][c].getY() + blocks[r][c].getHeight()) {
							blocks[r][c].setX(-100);
							blocks[r][c].setY(-100);
							b.setdy(-1 * b.getdy());
							b.setdx(Math.random() * 2 - 1);
							//break; 	// tmp fix
						}
					}
				}
				catch(NullPointerException e) {
					
				}
			}
		}
	}
	
   // Listeners
   private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buffer.setColor(Color.white);
			buffer.fillRect(0, 0, Driver.WIDTH, Driver.HEIGHT);
			
			try {
				for(int r = 0; r < blocks.length; r++) {
					for(int c = 0; c < blocks[0].length; c++) {
						blocks[r][c].draw(buffer);
					}
				}
			}
			catch(NullPointerException n) {
				
			}
			
			collisionBlocks(ball);
			collisionSlider(ball);
			
			ball.update();
			
			slider.draw(buffer);
			ball.draw(buffer);
			
			repaint();
		}
	}
	private class Key extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT: 
					slider.moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					slider.moveRight();
					break;
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
}
