package main;

/**
 * Pizza class represents a pizza object
 */
public class Pizza {

    private String size;
    private String toppings;
    private double price;

    // Constructor
    public Pizza(String size, String toppings, double price) {
        this.size = size;
        this.toppings = toppings;
        this.price = price;
    }

    public Pizza() {}

    // Getter and Setter methods
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getToppings() { return toppings; }
    public void setToppings(String toppings) { this.toppings = toppings; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Flat string for sending
    public String toDataString() {
        return size + "," + toppings + "," + price;
    }

    // Create Pizza from flat string (no fancy parsing)
    public static Pizza fromDataString(String data) {
        String[] parts = data.split(",");
        Pizza pizza = new Pizza();
        pizza.setSize(parts[0]);
        pizza.setToppings(parts[1]);
        pizza.setPrice(Double.parseDouble(parts[2]));
        return pizza;
    }

    // JSON
    public String toJSON() {
        return "{size:" + size + ",toppings:" + toppings + ",price:" + price + "}";
    }

    // Create Pizza
    public static Pizza fromJSON(String data) {
        // Remove { } and split by comma
        data = data.replace("{", "").replace("}", "");
        String[] parts = data.split(",");

        Pizza pizza = new Pizza();
        pizza.setSize(parts[0].split(":")[1]);
        pizza.setToppings(parts[1].split(":")[1]);
        pizza.setPrice(Double.parseDouble(parts[2].split(":")[1]));

        return pizza;
    }

    public String toString() {
        return "Pizza [size=" + size + ", toppings=" + toppings + ", price=" + price + "]";
    }
}