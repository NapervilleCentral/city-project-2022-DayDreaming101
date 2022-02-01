import java.awt.*;
    import java.util.*;
    
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JComponent;
/**
 * Theodore Ng
 * Mr Hayes 7th Period
 * 1/31/2022
 * BridgeFloor class
 * Makes the floor the bridge overhead stands on 
 */
public class BridgeFloor extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private int x,y,w,h;
    Color sqColor = new Color(160, 160, 160);
    
    /**
    *Constructor(): sets the dimensions of the grey base of the bridge
    *@param building number
    *@return 
    */
    public BridgeFloor()
    {
        x = 0;
        y = 300;
        w = 600;
        h = 12;
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
        * draw(): Draws the rectangular base of the bridge
        * @param the virtual drawing on palette
        * @return 
        */
       public void draw (Graphics2D page)//page is the virtual drawing on palette
        {
          page.setColor(sqColor);
          page.fillRect(x, y, w, h);
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
    */}
}
