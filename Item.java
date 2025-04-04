//Item v1 to be worked on
public class Item {
    private String description;
    private double weight;

    // Constructor
    public Item(String description, double weight) {
        this.description = description;
        this.weight = weight;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    // Setters (optional, if you want to modify items later)
    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item: " + description + " (Weight: " + weight + "kg)";
    }
}
