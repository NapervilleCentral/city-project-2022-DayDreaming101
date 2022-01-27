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
    Color sqColor = new Color(127,127,127);
    
    /**
     * Constructor for objects of class Floor
     */
    public Building(int num)
    {
        if (num == 1)
        {
            x = 30;
            y = 70;
            w = 57;
            h = 150; 
        }
        else if (num == 2)
        {
            x = 105;
            y = 40;
            w = 65;
            h = 200;/*
            a1 = 100;
            b1 = 165;
            a2 = 100;
            b2 = 300;*/
        }
        else if (num == 3)
        {
           x = 190;
           y = 100;
           w = 20;
           h = 100;
            
           /*
            * c1 = 150;
            d1 = 185;
            c2 = 150;
            d2 = 300; 
            */
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
