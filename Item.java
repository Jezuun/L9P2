public class Item {
    private String name;
    private String description;
    private double weight;

    // Constructor to initialize description and weight
    public Item(String name, String description, double weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    // Getter for name
    public String getName() {
        return name;
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
        return name + " (Weight: " + weight + ")";
    }
}


