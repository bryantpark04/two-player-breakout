import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.sound.sampled.*;
import java.io.*;

public class StartPanel extends JPanel
{
   public JFrame f;
   private BufferedImage myImage;
   private Graphics myBuffer;
   private AudioInputStream inputStream;
   private Clip clip;

   public StartPanel(JFrame fr)
   {
      f=fr;
      setLayout(new BorderLayout());
      myImage = new BufferedImage(640, 360, 1);
      myBuffer = myImage.getGraphics();
      JButton start=new JButton("Start");
      start.addActionListener(new Listener());
      add(start,BorderLayout.SOUTH);
      
      
   }
   
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) {
         setVisible(false);
         f.setVisible(false);
         JFrame frame = new JFrame("Breakout2");
		   frame.setSize(Driver.WIDTH, Driver.HEIGHT);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setLocationRelativeTo(null);
		   frame.setContentPane(new Panel(f));
         frame.setVisible(true);
         playClip("ree.wav");

      }
   }
      
   public void playClip(String filename)
   {
      try{
         inputStream=AudioSystem.getAudioInputStream(new File(filename));
         DataLine.Info lineInfo=new DataLine.Info(Clip.class,inputStream.getFormat());
         clip=(Clip)AudioSystem.getLine(lineInfo);
         clip.open(inputStream);
         
            clip.loop(Clip.LOOP_CONTINUOUSLY);
               }
      catch(Exception e)
      {}
    }
         

   public void paintComponent(Graphics g)
   {
      ImageIcon breakout=new ImageIcon("ree.jpg");
      g.drawImage(breakout.getImage(),0,0,640,300,null);
   }
 }  
