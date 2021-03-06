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
public class Floor extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private int x,y,w,h;
    Color sqColor = new Color(168,220,217);
    /**
     * Constructor for objects of class Floor
     */
    public Floor()
    {
        x = 50;
        y = 125;
        w = 250;
        h = 50;
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
        
        if (running % 2 == 0)
            x +=20;
        else
            x -= 20;
        
        
        
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        //  do not explicitly invoke the paintComponent method
        repaint();
    }
    
       //-----------------------------------------------------------------
       //  Draws this figure relative to baseX, baseY, and height.
       //-----------------------------------------------------------------
       public void draw (Graphics2D page)//page is the virtual drawing on palette
       {
          page.setColor(Color.black);
          page.fillRect(x, y, w, h);
          
          
          
          page.setColor(sqColor);
          page.drawRect(x+10,y+2,10,10);
          
          page.setColor(sqColor);
          page.fillRect(x+10, y+18, 10, 10);
         
          page.setColor(sqColor);
          page.fillRect(x+10, y+34, 10, 10);
         
          page.setColor(sqColor);
          page.fillRect(x+26, y+2, 10, 10);
         
          page.setColor(sqColor);
          page.fillRect(x+26, y+18, 10, 10);
          
          page.setColor(sqColor);
          page.fillRect(x+42, y+34, 10, 10);
          
          page.setColor(sqColor);
          page.fillRect(x+42, y+2, 10, 10);
         
          page.setColor(sqColor);
          page.fillRect(x+42, y+18, 10, 10);
          
          page.setColor(sqColor);
          page.fillRect(x+42, y+34, 10, 10);
       }
       
    public void run()
    {
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
  
    }
}
