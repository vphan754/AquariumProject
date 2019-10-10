import java.awt.Color;
import java.util.Random;

/** Aquarium Lab Series: <br>    
 *      The AquaSimApplication class contains the main function that will
 *      run the Aquarium Simulation. (This description should be updated
 *      when the behavior of the program changes.)<br>
 *
 * Modifications: <br>
 *   23 March 2008,  Alyce Brady,  Created skeleton main that constructs and
 *                                 displays an empty aquarium.<br>
 *   (date), (your name), Modified to .... <br>
 *
 *  @author  Alyce Brady  (should be Your Name)
 *  @version 23 March 2008  (should be today's date)
 *  @see AquariumController
 **/
public class AquaSimApplication
{
    /**
     *  This is the main function.  It executes the program.
     *  @param    String args[] is never used
     **/
    public static void main(String args[])
    {
        System.out.println("THIS IS A SIMULATION 0100010101010101010");

        // CONSTRUCT OBJECTS NEEDED FOR THE AQUARIUM SIMULATION.
        Random generator = new Random();
        //int randNum = generator.randInt(10);
        
        // Construct the aquarium.  Specify its dimensions when creating it.
        Aquarium aqua;                 // create reference to an Aquarium ...
        aqua = new Aquarium(600, 840); // ... object that has now been created

        // Construct fish and add them to the aquarium.
        AquaFish fish1 = new AquaFish(aqua, RandomColor(generator));
        AquaFish fish2= new AquaFish(aqua, RandomColor(generator));
        AquaFish fish3 = new AquaFish(aqua, RandomColor(generator));
        AquaFish fish4 = new AquaFish(aqua, RandomColor(generator));
        AquaFish fish5= new AquaFish(aqua, RandomColor(generator));
        AquaFish fish6 = new AquaFish(aqua, RandomColor(generator));
        
        aqua.add(fish1);
        aqua.add(fish2);
        aqua.add(fish3);
        aqua.add(fish4);
        aqua.add(fish5);
        aqua.add(fish6);

        // Construct a graphical user interface (GUI) to display and control
        // the simulation.  The user interface needs to know about the
        // aquarium, so we pass aqua to the user interface constructor.
        AquaSimGUI userInterface;              // create reference to GUI ...
        userInterface = new AquaSimGUI(aqua, true);  // ... and then GUI itself

        // Tell the user how to start the aquarium simulation.
        System.out.println("Press the Start button to start the simulation.");

        // Now wait for the user to press the start button.
        userInterface.waitForStart();

        // Draw the initial view of the aquarium and its contents.
        userInterface.showAquarium();


        // RUN THE AQUARIUM SIMULATION.

        // Make the fish move and redisplay.
        //      CODE MISSING HERE!
        
        for (int i = 0; i<userInterface.getNumberOfSteps(); i++)
        {
            moveFish(fish1, generator);
            moveFish(fish2, generator);
            moveFish(fish3, generator);
            moveFish(fish4, generator);
            moveFish(fish5, generator);
            moveFish(fish6, generator);
            userInterface.showAquarium();
        }

    }//end main

    public static Color RandomColor(Random rand)
    {
        int randNum = rand.nextInt(6);
        switch (randNum)
        {
            case 0:
                return Color.RED;
            case 1:
                return Color.ORANGE;
            case 2:
                return Color.YELLOW;
            case 3:
                return Color.GREEN;
            case 4:
                return Color.BLUE;
            case 5:
                return Color.MAGENTA;
            default:
                return null;
        }
    }
    
    public static boolean randomChoice(Random rand)
    {
        int randNum = rand.nextInt(4);
        if (randNum == 1) return true;
        else return false;
    }
    
    public static void moveFish(AquaFish fish, Random rand) //moves a fish.
    {
        fish.moveForward();
        if (fish.atWall() || randomChoice(rand)) fish.changeDir();
    }
}//end class
