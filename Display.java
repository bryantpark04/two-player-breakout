import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Display extends JPanel 
{
   //making information private
   private BufferedImage my Image;
   private Graphics myBuffer;
   private Timer t;
   //make fields for blocks, slider, etc
   
	public Display(int x,int y) 
	{
      //setting up background
      myImage=new Buffered(x,y,BufferedImage.TYPE_INT_RGB);
      myBuffer=myImage.getGraphics();
      myBuffer.setColor(Color.BLACK);
      myBuffer.fillRect(0,0,x,y);
      //instantiate blocks, slider, etc
      
      //adding int listener
      addKeyListener(new Key());
      setFoucsable(true);
      t=new Timer(5,new Listener());
      t.start();
   }
   //setting up the key class
   private class Key extends KeyAdapter
   {
      public void keyPressed(KeyEvent e)
      {
         if(e.getKeyCode()==(KeyEvent.VK_A&&KeyEvent.VK_LEFT)
         {
            //move slider left
         }
         if(e.getKeyCode()==(KeyEvent.VK_D&&KeyEvent.VK_RIGHT)
         {
            //move slider right
         }
      }
    }
    private class Listener implements ActionListener
    {
      public void actionPerformed(ActionEvent e)
      {
         myBuffer.setColor(Display.BACKGROUND);
         myBuffer.setColor(Color.BLACK);
         
         //draw blocks
         //draw slider
         //draw ball
         
      }
    }
    public void paintComponent(Graphics g)
    {
      g.drawImage(myImage,0,0,getWidth(),getHeight(),null);
    }
}
