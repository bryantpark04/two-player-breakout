import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class StartPanel extends JPanel
{
   public JFrame f;
   private BufferedImage myImage;
   private Graphics myBuffer;

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
		   frame.setContentPane(new Panel());
         frame.setVisible(true);

      }
   }
      

   public void paintComponent(Graphics g)
   {
      ImageIcon breakout=new ImageIcon("ree.jpg");
      g.drawImage(breakout.getImage(),0,0,640,300,null);
   }
 }  