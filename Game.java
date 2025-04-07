import java.util.List;
import java.util.ArrayList;

public class Game {
    private Parser parser;
    private Player player;

    public Game() {
        createRooms();
        parser = new Parser();
        player = new Player(new Room("outside the main entrance of the university"));
    }

   private void createRooms() {
    // Create rooms and set exits
    Room outside, theater, pub, lab, office;
    outside = new Room("outside the main entrance of the university");
    theater = new Room("in a lecture theater");
    pub = new Room("in the campus pub");
    lab = new Room("in a computing lab");
    office = new Room("in the computing admin office");

    // Set exits
    outside.setExit("east", theater);
    outside.setExit("south", lab);
    outside.setExit("west", pub);

    theater.setExit("west", outside);
    pub.setExit("east", outside);
    lab.setExit("north", outside);
    lab.setExit("east", office);
    office.setExit("west", lab);

    // Add items to rooms using the correct addItem() method
    Item book = new Item("book","a dusty old book", 2.0);
    Item pen = new Item("pen","a stupid floorloot pencil", 3.2);
    lab.addItem(book);  // Place the book in the lab
    pub.addItem(pen);   // Place the pen in the pub

    player.setCurrentRoom(outside);  // Starting room
}


    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing. Goodbye.");
    }

    private void printWelcome() {
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
    }

private boolean processCommand(Command command) {
    boolean wantToQuit = false;

    String commandWord = command.getCommandWord();
    if (commandWord.equals("help")) {
        printHelp();
    } else if (commandWord.equals("go")) {
        goRoom(command);
    } else if (commandWord.equals("quit")) {
        wantToQuit = quit(command);
    } else if (commandWord.equals("eat")) {
        eatCookie(command);  // Call the new eat cookie command
    }

    return wantToQuit;
}

private void eatCookie(Command command) {
    Room currentRoom = player.getCurrentRoom();
    Item itemToEat = null;

    // Find the magic cookie in the player's current room
    for (Item item : currentRoom.getItems()) {
        if (item.getName().equalsIgnoreCase("magic cookie")) {
            itemToEat = item;
            break;
        }
    }

    if (itemToEat != null) {
        player.eatMagicCookie();  // Increase the player's carrying capacity
        currentRoom.removeItem(itemToEat);  // Remove the magic cookie from the room
    } else {
        System.out.println("There is no magic cookie here to eat.");
    }
}



    private void printHelp() {
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            player.setCurrentRoom(nextRoom);
            System.out.println(player.getCurrentRoom().getLongDescription());
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

private void takeItem() {
    Room currentRoom = player.getCurrentRoom();
    ArrayList<Item> itemsInRoom = currentRoom.getItems();

    if (!itemsInRoom.isEmpty()) {
        Item item = itemsInRoom.get(0);  // Take the first item (or any specific item if you want)

        player.addItem(item);  // Add the item to the player's inventory
        currentRoom.removeItem(item);  // Remove the item from the room (you'll need to implement this method in Room)
        System.out.println("You took the " + item.getDescription() + ".");  // Use getDescription() instead of getName()
    } else {
        System.out.println("There is no item to take here.");
    }
}

    // Implement the "drop" command
    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }

        String itemName = command.getSecondWord();
        List<Item> carriedItems = player.getCarriedItems();
        Item itemToDrop = null;

        for (Item item : carriedItems) {
            if (item.getName().equals(itemName)) {
                itemToDrop = item;
                break;
            }
        }
if (itemToDrop != null) {
    player.dropItem(itemToDrop);  // Use dropItem from the Player class
} else {
    System.out.println("You are not carrying that item.");
}

    }
}



