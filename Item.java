public class Item {
    private String description;
    private double weight;

    public Item(String description, double weight) {
        this.description = description;
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return description + " (Weight: " + weight + ")";
    }
}
