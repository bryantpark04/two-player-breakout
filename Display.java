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
      
      //adding int listener
      addKeyListener(new Key());
      setFocusable(true);
      t=new Timer(5, new Listener());
      t.start();
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
         ball=new Ball(300,300);
         ball.draw(myBuffer);
      }
    }
    public void paintComponent(Graphics g)
    {
      g.drawImage(myImage,0,0,getWidth(),getHeight(),null);
    }
}
