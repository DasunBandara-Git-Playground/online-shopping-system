package lk.ac.iit;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface ShoppingManager {

    boolean addANewProduct(String productID, String productName, int numberOfAvailableItems, double price, String brand, int warrantyPeriod);

    boolean addANewProduct(String productID, String productName, int numberOfAvailableItems, double price, double size, String colour);

    boolean deleteAProduct(String productID);

    void printTheListOfTheProduct();

    boolean saveInAFile(File file);

}
