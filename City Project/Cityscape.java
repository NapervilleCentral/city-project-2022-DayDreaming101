import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 * 
 * @author gcschmit
 * @version 18 July 2014
 */
public class Cityscape extends JComponent
{
    // define the objects in your Cityscape as instance variables
    // ...
    BridgeFloor floor = new BridgeFloor();
    private BridgeFloor ground;
    private BridgeOverhead overhead1, overhead2, overhead3;
    private int running = 0;
    
    
    // define the Cityscape contructor and intiailize all instance variables
    // ...
    public Cityscape()
    {
        ground = new BridgeFloor();
        Thread t1 = new Thread(ground);
        
        overhead1 = new BridgeOverhead(1);
        overhead2 = new BridgeOverhead(2);
        overhead3 = new BridgeOverhead(3);
        
        //t1.start();

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
        ground.draw(g2);
        overhead1.draw(g2);
        
        
        // invoke the draw method on each object in your Cityscape
        // ...  
    }
    
    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when
     *      they are next drawn.
     *
     */
    public void nextFrame()
    {
       running ++;
       ground.setX(running);
       Thread t1 = new Thread(ground);
      // t1.start();
        // update the objects in the cityscape so they are animated
        // ...
        
        
        
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        //  do not explicitly invoke the paintComponent method
        repaint();
    }

}
