import java.util.List;
import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private List<Item> carriedItems;
    private double carryingCapacity;  // Max weight player can carry
    private double currentWeight;  // The total weight of items the player is carrying

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.carriedItems = new ArrayList<>();
        this.carryingCapacity = 10.0;  // Set initial carrying capacity (e.g., 10kg)
        this.currentWeight = 0.0;  // No weight carried initially
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public List<Item> getCarriedItems() {
        return carriedItems;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void addItem(Item item) {
        // Check if adding the item exceeds the carrying capacity
        if (currentWeight + item.getWeight() <= carryingCapacity) {
            carriedItems.add(item);
            currentWeight += item.getWeight();  // Update the weight the player is carrying
            System.out.println("You picked up the " + item.getName() + ".");
        } else {
            System.out.println("You can't carry the " + item.getName() + " because it exceeds your carrying capacity.");
        }
    }

    public void removeItem(Item item) {
        if (carriedItems.contains(item)) {
            carriedItems.remove(item);
            currentWeight -= item.getWeight();  // Update the weight the player is carrying
            System.out.println("You dropped the " + item.getName() + ".");
        }
    }

    public void eatMagicCookie() {
        // Eating the magic cookie increases carrying capacity
        this.carryingCapacity += 5.0;  // Increase by 5kg (you can adjust this)
        System.out.println("You ate the magic cookie! Your carrying capacity increased by 5kg.");
    }

    public void dropItem(Item item) {
        if (carriedItems.contains(item)) {
            currentRoom.addItem(item);  // Add the item to the room
            carriedItems.remove(item);  // Remove the item from the player's inventory
            currentWeight -= item.getWeight();  // Update the weight the player is carrying
            System.out.println("You dropped the " + item.getName() + ".");
        } else {
            System.out.println("You are not carrying that item.");
        }
    }
}



