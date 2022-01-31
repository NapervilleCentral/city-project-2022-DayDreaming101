import java.awt.*;
    import java.util.*;
    
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JComponent;
/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DayCycle extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private int x,y,w,h,startAngle,arcAngle;
    
    /**
     * Constructor for objects of class Floor
     */
    public DayCycle()
    {
        x = 5;
        y = 100;
        w = 75;
        h = 75;
        startAngle = 0; 
        arcAngle = 360; 
    }

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
    
       //-----------------------------------------------------------------
       //  Draws this figure relative to baseX, baseY, and height.
       //-----------------------------------------------------------------
       public void draw (Graphics2D page)//page is the virtual drawing on palette
       {
          page.setColor(Color.yellow);
          page.fillArc(x,y,w,h,startAngle,arcAngle);
            
       }
       
    public void run()
    {
        while(true){         
            if (x > 500){
                x = 10;
                y = 100;
            }
            x+=5;
            if (x < 300)
            {
                y -= 1;
            }
            else
            {
                y += 1;
            }            
            try{
                Thread.sleep(50);
            }catch (Exception e){}
            repaint();
        }
    }
}
