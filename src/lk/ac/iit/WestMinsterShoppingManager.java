package lk.ac.iit;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WestMinsterShoppingManager implements ShoppingManager{

    private static final List<Product> listOfTheProducts = new ArrayList<>();

    @Override
    public void addANewProduct(String productID, String productName, int numberOfAvailableItems, double price, String brand, Date warrantyPeriod) {
        listOfTheProducts.add(new Electronics(productID,productName,numberOfAvailableItems,price,brand,warrantyPeriod));
    }

    @Override
    public void addANewProduct(String productID, String productName, int numberOfAvailableItems, double price, double size, String colour) {
        listOfTheProducts.add(new Clothing(productID,productName,numberOfAvailableItems,price,size,colour));
    }

    @Override
    public void deleteAProduct(String productID) {
        for (Product product : listOfTheProducts) {
            if (product.getProductID().equals(productID)){
                listOfTheProducts.remove(product);
                break;
            }
        }
    }

    @Override
    public void printTheListOfTheProduct() {

    }

    @Override
    public void saveInAFile(File file) {
        // Todo: Save Objects in a file.
    }
}
