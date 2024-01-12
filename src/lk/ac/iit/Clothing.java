package lk.ac.iit;

import java.io.Serializable;

public class Clothing extends Product implements Serializable {
    private String size;
    private String colour;

    public Clothing(String productID, String productName, int numberOfAvailableItems, double price, String size, String colour) {
        super(productID, productName, numberOfAvailableItems, price);
        this.size = size;
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public String getColour() {
        return colour;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return String.format("Clothing - Product ID:%s, Product Name:%s, No of Available Items:%d, Price:%.2f, Size:%s, Color:%s",
                this.getProductID(),this.getProductName(),this.getNumberOfAvailableItems(),this.getPrice(),this.size,this.colour);
    }
}
