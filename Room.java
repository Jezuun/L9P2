import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  
 * @version 
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private Item item;

    /**
     * Create a room described by "description", with no item.
     */
    public Room(String description) 
    {
        this.description = description;
        this.exits = new HashMap<>();
        this.item = null;
    }

    /**
     * Create a room described by "description", with an item.
     */
    public Room(String description, Item item) 
    {
        this.description = description;
        this.exits = new HashMap<>();
        this.item = item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room.
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a long description of this room, including item info and exits.
     */
    public String getLongDescription() {
        String itemString = (item != null) ? "You see " + item + "." : "There is no item here.";
        return "You are " + description + ".\n" + getExitString() + "\n" + itemString;
    }

    /**
     * Return a string describing the room's exits, for example "Exits: north west".
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

