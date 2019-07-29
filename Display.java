import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Display extends JPanel 
{
   //making information private
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Timer t;
   int hits;
   
   //make fields for blocks, slider, etc
   private Block block;
   private Ball ball;
   private Slider slider;

	public Display() 
	{
      //setting up background
      myImage=new BufferedImage(Driver.WIDTH, Driver.HEIGHT,BufferedImage.TYPE_INT_RGB);
      myBuffer=myImage.getGraphics();
      myBuffer.setColor(Color.BLACK);
      myBuffer.fillRect(0, 0, Driver.WIDTH, Driver.HEIGHT);
      //instantiate blocks, slider, etc
      slider=new Slider();
      ball=new Ball(300,300);
      for(int x=1;x<=120;x++)
         block=new Block();
      //adding int listener
      addKeyListener(new Key());
      setFocusable(true);
      t=new Timer(5, new Listener());
      t.start();
      hits=0;
   }
   
   public void update() {
		
	}
   //setting up the key class
   private class Key extends KeyAdapter
   {
      public void keyPressed(KeyEvent e)
      {
         if(e.getKeyCode()==(KeyEvent.VK_A))
         {
            if(e.getKeyCode()==(KeyEvent.VK_LEFT))
            {
               slider.moveLeft();
            }
         }
         if(e.getKeyCode()==(KeyEvent.VK_D))
         {
            if(e.getKeyCode()==(KeyEvent.VK_RIGHT))
            {
               slider.moveRight();
            }
         }
      }
   }
   
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myBuffer.setColor(Color.BLACK);
         
         //draw block
         for(int x=0;x<600;x+=40)
         {
            for(int y=0;y<280;y+=35)
            {
               myBuffer.setColor(Color.YELLOW);
               myBuffer.fillRect(x,y,x+40,y+40);
            }
         }
         
         //draw slider
        
         slider.draw(myBuffer);
         
         //draw ball
         
         ball.draw(myBuffer);
         
         //clear and move ball
         myBuffer.setColor(Color.BLACK);
         myBuffer.fillRect(0,0,600,600); 
         ball.move(600, 600);
      
      }
   }
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage,0,0,getWidth(),getHeight(),null);
   }
    
   public void collide(Ball ball, Block block)
   {
      double dist=distance(ball.getX(),ball.getY(),block.getX(),block.getY());
      
      if(dist<block.getLength()+7.5)
      {
         hits++;
      }
   }
    
   private double distance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }

}
