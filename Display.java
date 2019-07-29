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
   public boolean on1;
   public boolean on2;
   public boolean on3;
   public boolean on4;
   public Display() { 	// constructor
      myImage = new BufferedImage(Driver.WIDTH, Driver.HEIGHT, BufferedImage.TYPE_INT_RGB);
      buffer = myImage.getGraphics();
      
      buffer.setColor(Color.white);
      buffer.fillRect(0, 0, Driver.WIDTH, Driver.HEIGHT);
      
      ball = new Ball(300.0, 300.0, 0.3, 0.4);
      
      slider = new Slider(270, 550);
      
      for(int r = 0; r < blocks.length; r++) {
         for(int c = 0; c < blocks[0].length; c++) {
            blocks[r][c] = new Block(1 + 60 * r, 1 + 30 * c);
         }
      }
      
      addKeyListener(new Key()); 	// add key listener
      setFocusable(true);
      
      Timer t = new Timer(10, new Listener()); 	// add timer listener
      t.start();
   }
	
	// collision helpers
   private void collisionSlider(Ball b) {
      if(b.getX() > slider.getX() && b.getX() < slider.getX() + slider.getWidth()) {
         if(Math.abs(b.getY() + b.getDiameter() - slider.getY()) < 0.5) {
            b.setdy(-1 * b.getdy());
         }
      }
   }
   private void collisionBlocks(Ball b) {
      for(int r = 0; r < blocks.length; r++) {
         for(int c = 0; c < blocks[0].length; c++) {
            try {
               if(b.getX() > blocks[r][c].getX() && b.getX() + 7.5 < blocks[r][c].getX() + blocks[r][c].getWidth()) {
                  if(b.getY() > blocks[r][c].getY() && b.getY() + 7.5 < blocks[r][c].getY() + blocks[r][c].getHeight()) {
                     blocks[r][c].setX(-100);
                     blocks[r][c].setY(-100);
                     b.setdy(-1 * b.getdy());
                     b.setdx(Math.random() * 2 - 1);
                     break; 	// tmp fix
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
      	
         if(on1&&on2)
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
            on2=true;
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
