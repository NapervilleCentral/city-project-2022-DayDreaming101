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
public class BridgeRailings extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private int x1,y1,x2,y2,a1,b1,a2,b2,c1,d1,c2,d2;
    
    /**
     * Constructor for objects of class Floor
     */
    public BridgeRailings(int num)
    {
        if (num == 1)
        {
            x1 = 50;
            y1 = 185;
            x2 = 50;
            y2 = 300;
            
            a1 = 100;
            b1 = 165;
            a2 = 100;
            b2 = 300;
            
            c1 = 150;
            d1 = 185;
            c2 = 150;
            d2 = 300; 
        }
        else if (num == 2)
        {
            x1 = 245;
            y1 = 138;
            x2 = 245;
            y2 = 300;
            
            a1 = 290;
            b1 = 112;
            a2 = 290;
            b2 = 300;
            
            c1 = 335;
            d1 = 138;
            c2 = 335;
            d2 = 300; 
        }
        else
        {
            x1 = 433;
            y1 = 185;
            x2 = 433;
            y2 = 300;
            
            a1 = 483;
            b1 = 165;
            a2 = 483;
            b2 = 300;
            
            c1 = 533;
            d1 = 185;
            c2 = 533;
            d2 = 300; 
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
          page.setColor(Color.black);
          page.drawLine(x1,y1,x2,y2);
          page.drawLine(a1,b1,a2,b2);
          page.drawLine(c1,d1,c2,d2);
          
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
