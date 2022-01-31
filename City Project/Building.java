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
public class Building extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private int x,y,w,h;
    Color sqColor = new Color(160, 160, 160);
    Color colornum = new Color (168,220,217);
    
    /**
     * Constructor for objects of class Floor
     */
    public Building(int num)
    {
        if (num == 1)
        {
            x = 30;
            y = 70;
            w = 56;
            h = 150; 
        }
        else if (num == 2)
        {
            x = 105;
            y = 40;
            w = 56;
            h = 200;
        }
        else if (num == 3)
        {
           x = 170;
           y = 140;
           w = 56;
           h = 170;
        }
        else if (num == 4)
        {
            x = 240;
            y = 30;
            w = 56;
            h = 200;
        }
        else if (num == 5)
        {
            x = 320;
            y = 90;
            w = 56;
            h = 200; 
        }
        else if (num == 6)
        {
            x = 420;
            y = 60;
            w = 56;
            h = 150;
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
          page.setColor(sqColor);
          page.fillRect(x,y,w,h);
          page.setColor(Color.black);
          page.drawRect(x,y,w,h);
                    
          Random gen = new Random();
          for (int z = y + 8, a = 0; a!=9 ; z += 16, a++)
          {
              page.setColor(new Color(gen.nextInt(256),gen.nextInt(256),gen.nextInt(256)));
              page.fillRect(x+8,z,8,8);
          }
          
          for (int z = y + 8, a = 0; a!=9 ; z += 16, a++)
          {
              page.setColor(new Color(gen.nextInt(256),gen.nextInt(256),gen.nextInt(256)));
              page.fillRect(x+24,z,8,8);
          }
          
          for (int z = y + 8, a = 0; a!=9 ; z += 16, a++)
          {
              page.setColor(new Color(gen.nextInt(256),gen.nextInt(256),gen.nextInt(256)));
              page.fillRect(x+40,z,8,8);
          }
       }
       
    public void run()
    {
        while(true){           
            try{
                Thread.sleep(5);
            }catch (Exception e){}
            repaint();
        }
    }
}
