import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class EndPanel extends JPanel
{
   public JFrame f;
   private BufferedImage myImage;
   private Graphics myBuffer;
   public boolean buttonClicked = false;
   public EndPanel()
   {
      setLayout(new BorderLayout());
      JPanel subpanel = new JPanel();
      add(subpanel, BorderLayout.SOUTH);
      
      myImage = new BufferedImage(640, 360, 1);
      myBuffer = myImage.getGraphics();
      
      JButton end=new JButton("Quit");
      end.addActionListener(new Listener());
      
      JButton reset = new JButton("New Game");
      reset.addActionListener(new Listener2());
      
      subpanel.add(reset);  
      subpanel.add(end);
   }
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) {
         System.exit(0);
      }
   }
   private class Listener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClicked = true;
		}
	}
 }  
   
