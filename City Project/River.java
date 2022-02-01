    import java.awt.*;
    import java.util.*;
    
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JComponent;
    
/**
 * Theodore Ng
 * Mr Hayes 7th Period
 * 1/31/2022
 * River class
 * Makes the river usinga  rectangle and animates the boates
 */
public class River extends JComponent implements Runnable
{
    private int x,y,w,h,startAngle,arcAngle,bx,by,bw,bh,x1,x2,y1,y2,bx2,by2;
    Color sqColor = new Color(0,64,255);
    
    /**
    *Constructor(): sets the dimensions of the river and sets the boats' base
    *@param 
    *@return 
    */
    public River()
    {
        x = 0;
        y = 312;
        w = 600;
        h = 150;
        
        bx = 450;
        by = 320;
        bw = 80;
        bh = 35;
        startAngle = 180;
        arcAngle = 180;
        
        bx2 = 25;
        by2 = 380;   
    }

        /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     *
     * @param g a reference to the Graphics object used for all drawing operations
     *
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        // invoke the draw method 
        // ...
        draw(g2);
        
        
    }
    
    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when
     *      they are next drawn.
     *
     */
    public void setX(int running)
    {
        // update the objects in the cityscape so they are animated
        // ...
        //height = 100 +generator.nextInt(45);
        /*
        if (running % 2 == 0)
            x +=20;
        else
            x -= 20;
        */
        
        
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        //  do not explicitly invoke the paintComponent method
        repaint();
    }
    
       /**
        * draw(): draws the base, pole, and sail of the boat
        * @param the virtual drawing on palette
        * @return 
        */
       public void draw (Graphics2D page)//page is the virtual drawing on palette
       {
          page.setColor(sqColor);
          page.fillRect(x,y,w,h);//river color
          
          //boat 1 (the one on top)
          page.setColor(Color.yellow); 
          page.fillArc(bx,by,bw,bh,startAngle,arcAngle);//using arcs we can create an oval base
          
          page.setColor(Color.black);
          page.drawArc(bx,by,bw,bh,startAngle,arcAngle);//pole holding up the sail
          page.fillRect((bw-5)/2+bx,by-bh+5,5,50);
        
          page.drawLine((bw-5)/2+bx,by-bh+5,(bw-10)/2+bx+30,by-bh+25);//Triangle made from lines
          page.drawLine((bw-5)/2+bx,by-bh+25,(bw-10)/2+bx+30,by-bh+25);
          //boat 2 (bottom) 
          page.setColor(Color.green); //using arcs we can create an oval base
          page.fillArc(bx2,by2,bw,bh,startAngle,arcAngle);
          
          page.setColor(Color.black);
          page.drawArc(bx2,by2,bw,bh,startAngle,arcAngle);//pole holding up the sail
          page.fillRect((bw-5)/2+bx2,by2-bh+5,5,50);
        
          page.drawLine((bw-5)/2+bx2,by2-bh+5,(bw-10)/2+bx2+30,by2-bh+25);//Triangle made from lines
          page.drawLine((bw-5)/2+bx2,by2-bh+25,(bw-10)/2+bx2+30,by2-bh+25);
          
       }
       
       /**
        * run(): takes no param, makes a thread that allows the boats to move in opposite
        * directions, it also resets the boat's position once they move off screen
        * @param
        * @return
        */       
    public void run()
    {
        while(true){         
            if (bx2 > 600){//when boat 2 moves off screen to the right
                //, the boat is replaced back to the left
                bx2 = -200;
            }
            bx2+=2;//boat 2 moves to the right 
            if (bx < -100) 
            {//boat 1 moves off screen to the left, this  if statement accounts for that 
                bx = 700;
            }  
            bx-=2;//boat 1 moves to the left
            try{
                Thread.sleep(25);
            }catch (Exception e){}
            repaint();
        }
    }
}
