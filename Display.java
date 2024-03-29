import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Display extends JPanel 
{
   private BufferedImage myImage; 	// private fields
   private Graphics buffer;
   private Ball ball;
   private Slider slider;
   private Block[][] blocks = new Block[10][6];
   private Key k = new Key();
   private int level = 0;
   public boolean on1, on2, on3, on4;
   public Display() { 	// constructor
      myImage = new BufferedImage(Driver.WIDTH, Driver.HEIGHT, BufferedImage.TYPE_INT_RGB);
      buffer = myImage.getGraphics();
      buffer.setColor(Color.black);
      buffer.fillRect(0, 0, Driver.WIDTH, Driver.HEIGHT);
      
      ball = new Ball(300.0, 300.0, 0, 3); 	// instantiates objects
      slider = new Slider(270, 550);
      for(int r = 0; r < blocks.length; r++) {
         for(int c = 0; c < blocks[0].length; c++) {
            blocks[r][c] = new Block(1 + 60 * r, 1 + 30 * c);
         }
      }
   
      addKeyListener(k); 	// add key listener
      setFocusable(true);
      
      Timer t = new Timer(10, new Listener()); 	// add timer listener
      t.start();
   }
	
   public void stopGame() {
      ball.setdx(0);
      ball.setdy(0);
      removeKeyListener(k);
      
      on1 = false;
      on2 = false;
      on3 = false;
      on4 = false;
   }
   public void newRound() {
      for(int r = 0; r < blocks.length; r++) {
         for(int c = 0; c < blocks[0].length; c++) {
            blocks[r][c].setX(1 + 60 * r);
            blocks[r][c].setY(1 + 30 * c);
         }
      }
      
      ball.setX(300);
      ball.setY(300);
      ball.setdx(0);
      ball.setdy(3 + level);
   	
      slider.setX(270);
      slider.setY(550);
      
      level++;
      
      slider.setWidth(slider.getWidth() - 5 * level);
   }
   public void reset() {
      level = 0;
      
   	// resets objects
      for(int r = 0; r < blocks.length; r++) {
         for(int c = 0; c < blocks[0].length; c++) {
            blocks[r][c].setX(1 + 60 * r);
            blocks[r][c].setY(1 + 30 * c);
         }
      }
      
      ball.setX(300);
      ball.setY(300);
      ball.setdx(0);
      ball.setdy(3 + level);
   	
      slider.setX(270);
      slider.setY(550);
      
      addKeyListener(k);
   }
	
	// boolean methods
   public boolean gameEnd() {
      if(ball.hitsBottom()) {
         return true;
      }
      return false;
   }
   public boolean pointScored() {
      for(int r = 0; r < blocks.length; r++) {
         for(int c = 0; c < blocks[0].length; c++) {
            if(collision(blocks[r][c], ball)) {
               return true;
            }
         }
      }
      return false;
   }
   public boolean roundWon() {
      for(int r = 0; r < blocks.length; r++) {
         for(int c = 0; c < blocks[0].length; c++) {
            if(blocks[r][c].getX() != -100) {
               return false;
            }
         }
      }
      return true;
   }
	
	// collision helpers
   private void collisionSlider(Ball b) {
      if(collision(slider, b)) {
         b.setdy(-1 * b.getdy());
      }
   }
   private void collisionBlocks(Ball b) {
      for(int r = 0; r < blocks.length; r++) {
         for(int c = 0; c < blocks[0].length; c++) {
            if(collision(blocks[r][c], b)) {
               blocks[r][c].setX(-100);
               blocks[r][c].setY(-100);
               b.setdy(-1 * b.getdy());
               b.setdx(Math.random() * (4 + 2 * level) - (2 + level));
            }
         }
      }
   }
   private boolean collision(Rectangle r, Ball b) {
      if(b.getX() + b.getDiameter() > r.getX() && b.getX() < r.getX() + r.getWidth()) {
         if(b.getY() + b.getDiameter() > r.getY() && b.getY() < r.getY() + r.getHeight()) {
            return true;
         }
      }
      return false;
   }
	
   // Listeners
   private class Listener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         buffer.setColor(Color.black);
         buffer.fillRect(0, 0, Driver.WIDTH, Driver.HEIGHT);
      	
         try {
            
            for(int r = 0; r < blocks.length; r++) {
               for(int c = 0; c < 2; c++) {
                  buffer.setColor(Color.RED);
                  blocks[r][c].draw(buffer);
               }
            }
            
            for(int r = 0; r < blocks.length; r++) {
               for(int c = 2; c < 4; c++) {
                  buffer.setColor(Color.ORANGE);
                  blocks[r][c].draw(buffer);
               }
            }
            
            for(int r = 0; r < blocks.length; r++) {
               for(int c = 4; c < 6; c++) {
                  buffer.setColor(Color.GREEN);
                  blocks[r][c].draw(buffer);
               }
            }
         
         
         }
         catch(NullPointerException n) {
         	
         }
      	
         collisionBlocks(ball);
         collisionSlider(ball);
      	
         ball.update();
      	
         buffer.setColor(Color.BLUE.brighter());
         slider.draw(buffer);
         buffer.setColor(Color.WHITE);
         ball.draw(buffer);
      	
         if(on1&&on2) 	// moves slider depending on if keys are pressed
         {
            slider.moveLeft();
         }
         if(on3&&on4)
         {
            slider.moveRight();
         }
      
         repaint();
      }
   }
   private class Key extends KeyAdapter {
      public void keyPressed(KeyEvent e) {
         if(e.getKeyCode()==KeyEvent.VK_LEFT) 
         {
            on1=true;
         }        
         
         if(e.getKeyCode()==KeyEvent.VK_A)
         {
            on2=true;
         }
         if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
         {
            on3 =true;
         }
         if(e.getKeyCode()==KeyEvent.VK_D)
         {
            on4=true;
         }
      }
      public void keyReleased(KeyEvent e){
         if(e.getKeyCode()==KeyEvent.VK_LEFT) 
         {
            on1=false;
         }        
         
         if(e.getKeyCode()==KeyEvent.VK_A)
            on2=false;
         if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
         {
            on3 =false;
         }
         if(e.getKeyCode()==KeyEvent.VK_D)
         {
            on4=false;
         }
      }
   }
	
   public void paintComponent(Graphics g) {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
}
