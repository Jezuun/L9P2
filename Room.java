import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits; 
    private ArrayList<Item> items; // holds multiple items

    public Room(String description) 
    {
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString() + "\n" + getItemString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    private String getItemString() {
        if (items.isEmpty()) {
            return "There are no items here.";
        }

        StringBuilder sb = new StringBuilder("You see the following items:");
        for (Item item : items) {
            sb.append("\n - ").append(item.toString());
        }
        return sb.toString();
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}


