import javax.swing.JFrame;
import java.awt.*;

/**
 * Theodore Ng
 * Mr Hayes 7th Period
 * 1/31/2022
 * CityscapeViewer main
 * Class that contains the main method for the program 
 * and creates the frame containing the component. 
 */
public class CityscapeViewer
{
    // the cityscape animation time is controled here
    static final int ANIMATION_TIME_IN_SECONDS = 1800;
   
    /**
     * main method for the program which creates and configures the frame for the program
     * @param args  not used
     */
    public static void main(String[] args) throws InterruptedException
    {
        // create and configure the frame (window) for the program
        JFrame frame = new JFrame();
        
        frame.setSize(600 /* x */, 450 /* y */);
        frame.setTitle("Cityscape");
        frame.setBackground(Color.red);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        int h1 = 100 + (int)(Math.random()*45);
        int h2 = 100 + (int)(Math.random()*45);
        
        // a frame contains a single component; create the Cityscape component and add it to the frame
        Cityscape component = new Cityscape();
        frame.add(component);
        
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
        
        // animate the cityscape
        for( int seconds = 0; seconds < ANIMATION_TIME_IN_SECONDS; seconds++ )
        {
            component.nextFrame();
            Thread.sleep(100 );
        }
        
    }

}
