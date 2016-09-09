import java.util.HashSet;

/**
 * This class implements a technical support system.
 * It is the top level class in this project.
 * The support system communicates via text input/output
 * in the text terminal.
 * 
 * This class uses an object of class InputReader to read input
 * from the user, and an object of class Responder to generate responses.
 * It contains a loop that repeatedly reads input and generates
 * output until the users wants to leave.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    1.0 (2011.07.31)
 */
public class Jabber
{
    private InputReader reader;
    private Responder responder;
    
    /**
     * Creates a technical support system.
     */
    public Jabber()
    {
        reader = new InputReader();
        responder = new Responder();
    }

    /**
     * Start the technical support system. This will print a welcome message and enter
     * into a dialog with the user, until the user ends the dialog.
     */
    public void start()
    {
        boolean finished = false;

        printWelcome();
        
        //Ask for the user's name
        String userName = responder.setName(getName());
        System.out.println(" " + userName + ", huh? let's see if I can drop some knowledge for you...");
        
        //Ask the user to choose whether to discuss R&B or hip-hop
        System.out.println(responder.chooseModePrompt());
        System.out.println(responder.chooseMode(reader.getInput()));
        
        while(!finished) {
            String input = "";
            input += reader.getInput();

            if(input.contains(responder.getEndingString())) {
                finished = true;
            } else {
                //Prints a String response to the terminal
                String response = responder.generateResponse(input);
                System.out.println(response);
                
                //Tells the responder to play a track if the user enters the correct input.
                if (input.contains(responder.playPrompt())) {
                    Track thisTrack = responder.generateTrack(input);
                    System.out.println("As you wish. More where that came from.\n" +
                    "Anything else you'd like to discuss?"); 
                }
            }
        }
        printGoodbye();
    }
    
    /**
     * Retrieves the user's name for later use
     * 
     * @return The user's name
     */
    public String getName()
    {
        return reader.getInput();
    }

    /**
     * Print a welcome message to the screen.
     */
    private void printWelcome()
    {
        System.out.println(responder.getWelcome());
    }

    /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye()
    {
        System.out.println(responder.getGoodbye());
    }
}
