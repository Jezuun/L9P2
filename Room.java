import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items; // holds multiple items

    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public void addItem(Item item) {
        items.add(item);  // Adds an item to the room
    }

    public void removeItem(Item item) {
        items.remove(item);  // Removes the item from the room
    }

    public ArrayList<Item> getItems() {
        return items;  // Returns the list of items in the room
    }

    public String getShortDescription() {
        return description;  // Returns the short description of the room
    }

    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString() + "\n" + getItemString();
    }

    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    private String getItemString() {
        if (items.isEmpty()) {
            return "There are no items here.";  // No items in the room
        }

        StringBuilder sb = new StringBuilder("You see the following items:");
        for (Item item : items) {
            sb.append("\n - ").append(item.toString());  // List all items
        }
        return sb.toString();
    }

    public Room getExit(String direction) {
        return exits.get(direction);  // Get the exit in the specified direction
    }
}



