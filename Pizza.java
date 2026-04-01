package main;

/**
 * Pizza class to represent a pizza object
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

    // Getters
    public String getSize() {
        return size;
    }

    public String getToppings() {
        return toppings;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setSize(String size) {
        this.size = size;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Flat representation
    public String toFlatString() {
        return size + "," + toppings + "," + price;
    }

    // JSON-like representation
    public String toJsonString() {
        return "{size:" + size + ",toppings:" + toppings + ",price:" + price + "}";
    }
}