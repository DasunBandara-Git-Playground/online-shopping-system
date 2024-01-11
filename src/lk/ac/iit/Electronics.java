package lk.ac.iit;

import java.util.Date;

public class Electronics extends Product{
    private String brand;
    private Date warrantyPeriod;

    public Electronics(String productID, String productName, int numberOfAvailableItems, double price, String brand, Date warrantyPeriod) {
        super(productID, productName, numberOfAvailableItems, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public Date getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWarrantyPeriod(Date warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return String.format("Electronics - Product ID:%s, Product Name:%s, No of Available Items:%d, Price:%.2f, Brand:%s, Color:%s \n",
                this.getProductID(),this.getProductName(),this.getNumberOfAvailableItems(),this.getPrice(),this.brand,this.warrantyPeriod);
    }
}
