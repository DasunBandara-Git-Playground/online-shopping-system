package lk.ac.iit;

public class Clothing extends Product{
    private double size;
    private String colour;

    public Clothing(String productID, String productName, int numberOfAvailableItems, double price, double size, String colour) {
        super(productID, productName, numberOfAvailableItems, price);
        this.size = size;
        this.colour = colour;
    }

    public double getSize() {
        return size;
    }

    public String getColour() {
        return colour;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return String.format("Clothing - Product ID:%s, Product Name:%s, No of Available Items:%d, Price:%.2f, Size:%.2f, Color:%s \n",
                this.getProductID(),this.getProductName(),this.getNumberOfAvailableItems(),this.getPrice(),this.size,this.colour);
    }
}
