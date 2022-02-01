import java.awt.*;
import java.util.*;    
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
/**
 * Theodore Ng
 * Mr Hayes 7th Period
 * 1/31/2022
 * Building class
 * Makes the buildings and allows the windows to flash random colors
 */
public class Building extends JComponent implements Runnable
{
    private int x,y,w,h;
    Color sqColor = new Color(160, 160, 160);
    Color colornum = new Color (168,220,217);//custom colors
    
    /**
    *Constructor(): takes the building number as a param and sets the dimensions
    *@param building number
    *@return 
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
        * draw(): Draws the rectangular buildings and the random
        * color windows
        * @param the virtual drawing on palette
        * @return 
        */
       public void draw (Graphics2D page)
       {
          page.setColor(sqColor);//Draws the large buildings
          page.fillRect(x,y,w,h);
          page.setColor(Color.black);
          page.drawRect(x,y,w,h);
                    
          Random gen = new Random();//each for loop randomizes the color of each row of
          //windows
          for (int z = y + 8, a = 0; a!=9 ; z += 16, a++)
          {
              page.setColor(new Color(gen.nextInt(256),gen.nextInt(256),gen.nextInt(256)));
              //randomizes RGB values
              page.fillRect(x+8,z,8,8);//the RGB values are then set to the window rectangles
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
    
       /**
        * run(): takes no param, makes a thread that keeps "refreshing"
        * the window color
        * @param
        * @return
        */
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
