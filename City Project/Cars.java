import java.awt.*;
    import java.util.*;
    
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JComponent;
/**
 * Theodore Ng
 * Mr Hayes 7th Period
 * 1/31/2022
 * Cars class
 * Makes the cars and allows the cars to reset to the left
 */
public class Cars extends JComponent implements Runnable
{
    private int x,y,w,h,startAngle,arcAngle;
    
    /**
    *Constructor(): sets the dimensions of the car's base
    *@param 
    *@return 
    */
    public Cars()
    {
        x = 5;
        y = 280;
        w = 60;
        h = 15;
        startAngle = 0; 
        arcAngle = 360; 
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
        * draw(): Draws the rectangular car bases and based on those values, the method
        * creates the windows
        * @param the virtual drawing on palette
        * @return 
        */
       public void draw (Graphics2D page)//page is the virtual drawing on palette
       {
          page.setColor(Color.red);//car base 1
          page.fillRect(x,y,w,h);
          
          page.setColor(Color.black);
          page.fillArc(x+10,y+10,10,10,startAngle,arcAngle);//2 tires
           
          page.fillArc(x+40,y+10,10,10,startAngle,arcAngle);
          
          page.drawLine(x+5,y,x+10,y-10);//window
          page.drawLine(x+10,y-10,x+40,y-10);
          page.drawLine(x+40,y-10,x+45,y);
          
          //car 2
          page.setColor(Color.green);
          page.fillRect(x+150,y,w,h);//car base 2
          
          page.setColor(Color.black);
          page.fillArc(x+10+150,y+10,10,10,startAngle,arcAngle);//2 tires
           
          page.fillArc(x+40+150,y+10,10,10,startAngle,arcAngle);
          
          page.drawLine(x+5+150,y,x+10+150,y-10);
          page.drawLine(x+10+150,y-10,x+40+150,y-10);//window
          page.drawLine(x+40+150,y-10,x+45+150,y);
         
          //car 3
          page.setColor(Color.blue);
          page.fillRect(x+300,y,w,h);//car base 3
          
          page.setColor(Color.black);
          page.fillArc(x+10+300,y+10,10,10,startAngle,arcAngle);//2 tires
           
          page.fillArc(x+40+300,y+10,10,10,startAngle,arcAngle);
          
          page.drawLine(x+5+300,y,x+10+300,y-10);
          page.drawLine(x+10+300,y-10,x+40+300,y-10);//window
          page.drawLine(x+40+300,y-10,x+45+300,y);
          
       }

       /**
        * run(): takes no param, makes a thread that resets the car position when it goes
        * too far off screen
        * @param
        * @return
        */
    public void run()
    {
        while(true){         
            if (x > 620){
                x = -400;
            }
            x+=2;//car movement
            try{
                Thread.sleep(25);
            }catch (Exception e){}
            repaint();
        }
    }
}
