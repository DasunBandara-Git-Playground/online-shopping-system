package lk.ac.iit;

import java.io.Serializable;

public abstract class Product implements Serializable, Comparable<Product>{
    private String productID;  // P01
    private String productName;
    private int numberOfAvailableItems;
    private double price;

    public Product() {
    }

    public Product(String productID, String productName, int numberOfAvailableItems, double price) {
        this.productID = productID;
        this.productName = productName;
        this.numberOfAvailableItems = numberOfAvailableItems;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getNumberOfAvailableItems() {
        return numberOfAvailableItems;
    }

    public double getPrice() {
        return price;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setNumberOfAvailableItems(int numberOfAvailableItems) {
        this.numberOfAvailableItems = numberOfAvailableItems;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product o) {
        return Integer.parseInt(this.productID.substring(1)) - Integer.parseInt(o.productID.substring(1));
    }
}
