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
    private BridgeRailings rail1,rail2,rail3; 
    private TopSky topsky;
    private BridgeColor bridgecolor1, bridgecolor2,bridgecolor3; 
    private Building building1,building2,building3,building4,building5,building6,building7;
    private int running = 0;
    
    
    // define the Cityscape contructor and intiailize all instance variables
    // ...
    public Cityscape()
    {
        topsky = new TopSky();
        
        building1 = new Building(1); 
        building2 = new Building(2);
        building3 = new Building(3);
        
        bridgecolor1 = new BridgeColor(1);
        bridgecolor2 = new BridgeColor(2);
        bridgecolor3 = new BridgeColor(3);
        
        ground = new BridgeFloor();
        
        overhead1 = new BridgeOverhead(1);
        overhead2 = new BridgeOverhead(2);
        overhead3 = new BridgeOverhead(3);
        
        rail1 = new BridgeRailings(1);
        rail2 = new BridgeRailings(2);
        rail3 = new BridgeRailings(3); 
        
        Thread t1 = new Thread(ground);
        Thread t2 = new Thread(overhead1);
        Thread t3 = new Thread(overhead2);
        Thread t4 = new Thread(overhead3);
        Thread t5 = new Thread(rail1);
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
        
        topsky.draw(g2);
        
        building1.draw(g2); 
        building2.draw(g2);
        building3.draw(g2); 
        
        bridgecolor1.draw(g2); 
        bridgecolor2.draw(g2); 
        bridgecolor3.draw(g2); 
        
        ground.draw(g2);
        
        overhead1.draw(g2);
        overhead2.draw(g2);
        overhead3.draw(g2);
        
        rail1.draw(g2); 
        rail2.draw(g2);
        rail3.draw(g2); 
        
        
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
