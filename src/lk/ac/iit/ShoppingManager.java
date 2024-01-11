package lk.ac.iit;

import java.io.File;
import java.util.Date;

public interface ShoppingManager {

    void addANewProduct(String productID, String productName, int numberOfAvailableItems, double price, String brand, Date warrantyPeriod);
    void addANewProduct(String productID, String productName, int numberOfAvailableItems, double price, double size, String colour);

    void deleteAProduct(String productID);

    void printTheListOfTheProduct();

    void saveInAFile(File file);
}
