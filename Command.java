/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word (for example, if the command was "take map", then the two strings
 * obviously are "take" and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is <null>.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 19. Applying MVC to your text-based adventure game would involve organizing 
 * the game's data (like player stats and inventory)
 * as the Model, the game's textual outputs as the View, 
 * and the logic that processes user commands as the Controller. 
 * This separation enhances code maintainability and scalability.
 * 
 * 21. The Item class should produce the string describing the item because 
 * it contains the item's data and knows how to represent itself. 
 * The Room class should print this information since it contains the item and 
 * is responsible for describing everything present in the room.
 * 
 * 24. Test Case 1: Normal back Usage
 * "You go back to the outside the main entrance of the university."
 * Test Case 2: Incorrect back Usage (Second Word)
 * "I don't know what you mean..."
 * Test Case 3: back at the Starting Point
 * "You can't go back! This is your starting point."
 * Test Case 4: back After Moving
 * "You go back to the outside the main entrance of the university."
 * "You can't go back! This is your starting point."
 * .25. it won't work when you type back twice
 */

public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     * @param firstWord The first word of the command. Null if the command
     *                  was not recognised.
     * @param secondWord The second word of the command.
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * @return The command word.
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * @return true if this command was not understood.
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

