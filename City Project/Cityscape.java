import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 * Theodore Ng
 * Mr Hayes 7th Period
 * 1/31/2022
 */
public class Cityscape extends JComponent
{
    // define the objects in your Cityscape as instance variables
    // ...
    BridgeFloor floor = new BridgeFloor();
    private BridgeFloor ground;
    private BridgeOverhead overhead1, overhead2, overhead3;
    private BridgeRailings rail1,rail2,rail3; 
    private Building building1,building2,building3,building4,building5,building6;
    private River river;
    private DayCycle cycle;
    private int running = 0;
    private Cars car;
    
    /**
    *Constructor(): initialize all instance variables
    *@param 
    *@return 
    */
    public Cityscape()
    {
        cycle = new DayCycle();//day and night cycle
        
        building1 = new Building(1); //creates all 6 buildings and windows
        building2 = new Building(2);
        building3 = new Building(3);
        building4 = new Building(4); 
        building5 = new Building(5); 
        building6 = new Building(6); 
        
        ground = new BridgeFloor();//grey bridge that the bridge overhead stands on
        
        overhead1 = new BridgeOverhead(1);//creates bridge arcs and overlays white color
        overhead2 = new BridgeOverhead(2);
        overhead3 = new BridgeOverhead(3);
        
        rail1 = new BridgeRailings(1);//draws line from the arc to the bridge ground
        rail2 = new BridgeRailings(2);
        rail3 = new BridgeRailings(3); 
        
        river = new River();//boat animation 
        
        car = new Cars(); //car animation
        
        Thread t1 = new Thread(building1);
        Thread t2 = new Thread(building2);
        Thread t3 = new Thread(building3);
        Thread t4 = new Thread(building4);
        Thread t5 = new Thread(building5);
        Thread t6 = new Thread(building6);
        Thread t7 = new Thread(cycle);
        Thread t8 = new Thread(car);
        Thread t9 = new Thread(river); 
        //some threads start earlier in order to overlay properly
        t7.start();
        t1.start();
        t2.start(); 
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t8.start(); 
        t9.start(); 
        
    }
    
    
    /**
     * paintComponent(Graphics g): This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     * 
     * @param g a reference to the Graphics object used for all drawing operations
     *
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
                
        cycle.draw(g2); 
        
        building1.draw(g2); 
        building2.draw(g2);
        building3.draw(g2); 
        building4.draw(g2); 
        building5.draw(g2); 
        building6.draw(g2); 
        
        ground.draw(g2);
        
        overhead1.draw(g2);
        overhead2.draw(g2);
        overhead3.draw(g2);
        
        rail1.draw(g2); 
        rail2.draw(g2);
        rail3.draw(g2); 
        
        river.draw(g2);
        
        car.draw(g2);
        
        //ALL objects are invoked in orde to be actually drawn
    }
    
    /**
     * nextFrame(): Animate the cityscape by updating the objects such that 
     * they appear to be animated when they are next drawn.
     * @param
     * @return
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
