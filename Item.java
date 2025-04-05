public class Item {
    private String description;
    private double weight;

    // Constructor to initialize description and weight
    public Item(String description, double weight) {
        this.description = description;
        this.weight = weight;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Getter for weight
    public double getWeight() {
        return weight;
    }

    // Provide a string representation of the item for easy printing
    @Override
    public String toString() {
        return description + " (Weight: " + weight + ")";
    }

    // Optionally, you can add a method to display a summary or additional information about the item
    public String getItemInfo() {
        return "Item: " + description + "\nWeight: " + weight + "kg";
    }
}
