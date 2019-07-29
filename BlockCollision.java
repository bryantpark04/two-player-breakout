  public class BlockCollision
   {
      private static double nearestX;	// used to approximate what point of the block  
      private static double nearestY;  // a ball collided with
   
       public static void collide(Block block, Ball ball)
      {
         // see if the ball hit the block!
         if(block.inBlock(ball))
         {	   	
            // back the ball up until it is just outside the block
            while(block.inBlock(ball))
            {
               ball.setX(ball.getX() - ball.getdx()/10.0);
               ball.setY(ball.getY() - ball.getdy()/10.0);
            }
            
            // find the point on the edge of the block closest to the ball
            findImpactPoint(block, ball);
         	
            double ux=nearestX-ball.getX();
            double uy=nearestY-ball.getY();
            double ur=Math.sqrt(ux*ux+uy*uy);
            ux/=ur;
            uy/=ur;
            int dx=(int)ball.getdx();
            int dy=(int)ball.getdy();
            double dot_1= ux*dx+uy*dy;
            double dot_2=-uy*dx+ux*dy;
            dot_1*=-1; // this is the actual "bounce"
            double[] d = new double[2];
            d[0]=dot_1*ux-dot_2*uy;      //vector math
            d[1]=dot_1*uy+dot_2*ux;      //vector math
            dx=(int)Math.round(d[0]);
            dy=(int)Math.round(d[1]);
            ball.setdx(dx);
            ball.setdy(dy);
         }
      }
      
       private static void findImpactPoint(Block block, Ball ball)
      {
          // first assume the nw corner is closest
         nearestX = block.getX();  
         nearestY = block.getY();
         
         // now work around the edge of the block looking for a closer point
         for (int x = block.getX(); x <= block.getX() + block.getLength(); x++)  // top & bottom edges
         {
            updateIfCloser(x, block.getY(), ball);
            updateIfCloser(x, block.getY() + block.getWidth(), ball);
         }
         for (int y = block.getY(); y <= block.getY() + block.getWidth(); y++)  // right & left edges
         {
            updateIfCloser(block.getX(), y, ball);
            updateIfCloser(block.getX() + block.getLength(), y, ball);
         }
      }
         
      // makes (x,y) the nearest point if it is closer to the ball
       private static void updateIfCloser(int x, int y, Ball b)
      {
         if(distance(x, y, b.getX(), b.getY()) < distance(nearestX, nearestY, b.getX(), b.getY()))
         {
            nearestX = x;
            nearestY = y;
         }
      }
          
      // returns distance between (x1, y1) and (x2, y2)
       private static double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }	
   }