import java.awt.*;
    import java.util.*;
    
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JComponent;
/**
 * Theodore Ng
 * Mr Hayes 7th Period
 * 1/31/2022
 * BridgeOverhead class
 * Overlays a white bridge over the sky backgrouynd and makes the actual arcs
 */
public class BridgeOverhead extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private int x,y,w,h,startAngle,arcAngle;
    
    /**
    *Constructor(): takes the bridge number and sets the dimensions of the arc
    *@param bridge no.
    *@return 
    */
    public BridgeOverhead(int num)
    {
        if (num == 1)
        {
            x = 0;
            y = 165;
            w = 200;
            h = 270;
            startAngle = 0;
            arcAngle = 180;
        }
        else if (num == 2)
        {
            x = 383;
            y = 165;
            w = 200;
            h = 270;
            startAngle = 0;
            arcAngle = 180;
        }
        else
        {
            x = 200;
            y = 112;
            w = 183;
            h = 375;
            startAngle = 0;
            arcAngle = 180;
        }

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
        * draw(): Draws the bridge arc and fills it
        * @param the virtual drawing on palette
        * @return 
        */       
       public void draw (Graphics2D page)//page is the virtual drawing on palette
       {
          page.setColor(Color.white);//fill the inside arc
          page.fillArc(x,y,w,h,startAngle,arcAngle); 
           
          page.setColor(Color.black);//outline arc to make it more defined
          page.drawArc(x, y,w,h,startAngle,arcAngle);
       }
       
    public void run()
    {/*
        int running  = 0;
    while(true){
        
        if(running % 2 == 0)
            x +=20;
        else
            x -= 20;
        running ++;
            try{
            Thread.sleep(100);
        }catch (Exception e){}
        
        System.out.print(x+"-----------------");
        //repaint();
    }
    
  */
    }
}
