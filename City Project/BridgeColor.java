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
public class BridgeColor extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private int x,y,w,h,startAngle, arcAngle;
    Color sqColor = new Color(173,216,230);
    
    /**
     * Constructor for objects of class Floor
     */
    public BridgeColor(int num)
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
        else if (num == 3)
        {
            x = 200;
            y = 112;
            w = 183;
            h = 375;
            startAngle = 0;
            arcAngle = 180;
        }
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
          page.setColor(Color.white);
          page.fillArc(x,y,w,h,startAngle,arcAngle); 
          
          /*
          page.setColor(sqColor);
          page.drawRect(x+10,y+2,10,10);
          
          page.setColor(sqColor);
          page.fillRect(x+10, y+18, 10, 10);
         
          page.setColor(sqColor);
          page.fillRect(x+10, y+34, 10, 10);*/
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
    }*/
    
  
    }
}
