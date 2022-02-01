import java.awt.*;
    import java.util.*;
    
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JComponent;
    
    
/**
 * Theodore Ng
 * Mr Hayes 7th Period
 * 1/32/2022
 * DayCycle class
 * Stimulates the day and night cycle with stars, moon, and sun
 */
public class DayCycle extends JComponent implements Runnable
{
    private int x,y,w,h,startAngle,arcAngle,count = 1;
    Color suncolor = Color.yellow;
    private int x0,y0,w0,h0;
    Color sqColor = new Color(153,217,234);
    
    /**
    *Constructor(): sets the dimensions of the sun and sky
    *@param 
    *@return 
    */
    public DayCycle()
    {
        x = 5;
        y = 100;
        w = 75;
        h = 75;
        startAngle = 0; 
        arcAngle = 360; 
        x0 = 0;
        y0 = 0;
        w0 = 600;
        h0 = 300;
    }

    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     * @param g a reference to the Graphics object used for all drawing operations
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
        * draw(): Draws the sky, sun, and stars
        * @param the virtual drawing on palette
        * @return 
        */
       public void draw (Graphics2D page)//page is the virtual drawing on palette
       {
          Random gen = new Random() ;
          page.setColor(sqColor);
          page.fillRect(x0,y0,w0,h0);//Light blue sky
          
          page.setColor(suncolor);//yellow sun for morning or white moon for night
          page.fillArc(x,y,w,h,startAngle,arcAngle);
          
          if (count == 2)
          {
              for (int star = 0; star <= 35; star++)
              {
                  page.setColor(Color.white);
                  page.fillArc(gen.nextInt(600),gen.nextInt(450),7,7,0,360);
                  //randomizes the stars' positioning
                }
            }
          
       }

       /**
        * run(): takes no param, makes a thread that resets the sun after moving to the right
        * After moving to the right, the sky turns dark with stars
        * @param
        * @return
        */
    public void run()
    {
        while(true){         
            if (x > 620){//if the sun moves off screem, the sun is reset to the very left
                x = 0;
                y = 100;
                if (count == 1)//if its day, the sky turns black with the sun turning into a moon
                {
                    count = 2;
                    suncolor = Color.white;
                    sqColor = Color.black; 
                }
                else//if its night, the sky turns light blue with the moon turning into a sun
                {
                    count = 1;
                    suncolor = Color.yellow;
                    sqColor = new Color(153,217,234);
                }
            }
            x+=5;//moves the actual sun
            if (x < 300)//when the sun is about to go above the window, the sun will start
            //to dip down
            {
                y -= 1;
            }
            else
            {
                y += 1;
            }            
            try{
                Thread.sleep(50);//changes "speed"
            }catch (Exception e){}
            repaint();
        }
    }
}
