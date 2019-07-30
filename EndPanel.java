import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class EndPanel extends JPanel
{
   public JFrame f;
   private BufferedImage myImage;
   private Graphics myBuffer;

   public EndPanel()
   {
      
      setLayout(new BorderLayout());
      myImage = new BufferedImage(640, 360, 1);
      myBuffer = myImage.getGraphics();
      JButton end=new JButton("Quit");
      end.addActionListener(new Listener());
      add(end,BorderLayout.SOUTH);

      
      
      
      
   }
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) {
         System.exit(0);
      }
   }
 }  
   
