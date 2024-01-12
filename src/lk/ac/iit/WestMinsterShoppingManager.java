package lk.ac.iit;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WestMinsterShoppingManager implements ShoppingManager{

    private static List<Product> listOfTheProducts = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final WestMinsterShoppingManager WMSM = new WestMinsterShoppingManager();
    public static void main(String[] args) {
        listOfTheProducts = setInitialProductList();
        int dashboard = 0;
        L1:
        while (true){
            System.out.println("### WestMinister Shopping Manager ###");
            switch (dashboard){
                case 0:
                    dashboard = home();
                    continue;
                case 1:
                    L2:
                    while (true){
                        int itemOption = addProduct();
                        switch (itemOption) {
                            case 1:
                                addClothingItem();
                                if (!(getString("Do you want to add another product(Y/n)")).equalsIgnoreCase("Y")) {
                                    dashboard = 0;
                                    continue L1;
                                }else {
                                    continue L2;
                                }
                            case 2:
                                addElectronicsItem();
                                if (!(getString("Do you want to add another product(Y/n)")).equalsIgnoreCase("Y")) {
                                    dashboard = 0;
                                    continue L1;
                                }else {
                                    continue L2;
                                }
                            default:
                                dashboard = 0;
                                continue L1;
                        }
                    }

                case 2:
                    deleteProduct();
                    if (!(getString("Do you want to delete another product(Y/n)")).equalsIgnoreCase("Y")) {
                        dashboard = 0;
                        continue L1;
                    }else {
                        continue L1;
                    }

                case 3:
                    WMSM.printTheListOfTheProduct();
                    if (!(getString("Enter any letter to back to home")).isEmpty()) {
                        dashboard = 0;
                        continue L1;
                    }else {
                        continue L1;
                    }

                case 4:
                    if(WMSM.saveInAFile()){
                        System.out.println("Successfully saved in a file");
                    }else {
                        System.out.println("Sorry, interrupted the saving process. try again");
                    }
                    if (!(getString("Enter any letter to back to home")).isEmpty()) {
                        dashboard = 0;
                        continue L1;
                    }else {
                        continue L1;
                    }
                default:
                    break L1;

            }
        }
    }

    public boolean addANewProduct(String productID, String productName, int numberOfAvailableItems, double price, String brand, int warrantyPeriod) {
        if (listOfTheProducts.size() > 50){
            return false;
        }else {
            for (Product product : listOfTheProducts) {
                if(product.getProductID().equalsIgnoreCase(productID)){
                    return false;
                }
            }
        }
        listOfTheProducts.add(new Electronics(productID,productName,numberOfAvailableItems,price,brand,warrantyPeriod));
        return true;
    }

    public boolean addANewProduct(String productID, String productName, int numberOfAvailableItems, double price, String size, String colour) {
        if (listOfTheProducts.size() > 50){
            return false;
        }else {
            for (Product product : listOfTheProducts) {
                if(product.getProductID().equalsIgnoreCase(productID)){
                    return false;
                }
            }
        }
        listOfTheProducts.add(new Clothing(productID,productName,numberOfAvailableItems,price,size,colour));
        return true;
    }

    public boolean deleteAProduct(String productID) {
        for (Product product : listOfTheProducts) {
            if (product.getProductID().equals(productID)){
                listOfTheProducts.remove(product);
                return true;
            }
        }
        return false;
    }

    public void printTheListOfTheProduct() {
        Collections.sort(listOfTheProducts);
        for (Product product : listOfTheProducts) {
            System.out.println(product.toString());
        }
    }

    public boolean saveInAFile() {
        File file = new File("products.db");

        try {
            if(file.exists()) file.delete();
            file.createNewFile();
        } catch (IOException e) {
            return false;
        }
        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Product product : listOfTheProducts) {
                oos.writeObject(product);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Product> getListOfTheProducts(){
        return listOfTheProducts;
    }

    private static List<Product> setInitialProductList(){
        File file = new File("products.db");
        if(file.exists()){
            try(FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
                Product product = null;
                List<Product> productList = new ArrayList<>();
                while (true){
                    try {
                        product = (Product) ois.readObject();
                        productList.add(product);
                    }catch (EOFException e){
                        break;
                    }
                }
                return productList;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else {
            return new ArrayList<>();
        }
    }

    private static void deleteProduct(){
        String productID = getString("Product ID");
        if(WMSM.deleteAProduct(productID)){
            System.out.println("The product is deleted successfully");
        }else {
            System.out.println("The product is not available in the list");
        }
    }

    private static void addClothingItem(){
        String productID = getString("Product ID");
        String productName = getString("Product Name");
        int noOfAvailableItems = getInt("No Of Available Items");
        double price = getDouble("Price");
        String size = getString("Size");
        String color = getString("Color");

        if(WMSM.addANewProduct(productID,productName,noOfAvailableItems,price,size,color)){
            System.out.println("The product is added successfully");
        }else {
            System.out.println("The product limit is exceeded or the product already exist");
        }
    }

    private static void addElectronicsItem(){
        String productID = getString("Product ID");
        String productName = getString("Product Name");
        int noOfAvailableItems = getInt("No Of Available Items");
        double price = getDouble("Price");
        String brand = getString("Brand");
        int period = getInt("Warranty period");

        if(WMSM.addANewProduct(productID,productName,noOfAvailableItems,price,brand,period)){
            System.out.println("The product is added successfully");
        }else {
            System.out.println("The product limit is exceeded or the product already exist");
        }
    }

    private static int addProduct(){
        System.out.println("[1] Add a clothing item");
        System.out.println("[2] Add a Electronic item");
        int option = -1;
        while ((option = getInt("Enter your option")) == -1);
        return option;
    }

    private static int home(){
        System.out.println("[1] Add a new product");
        System.out.println("[2] Delete a product");
        System.out.println("[3] Print the list of products");
        System.out.println("[4] Save in a file");
        System.out.println("[5] Exit");
        int option = -1;
        while ((option = getInt("Enter your option")) == -1);
        return option;
    }

    private static int getInt(String msg){
        int value = -1;
        while (true){
            System.out.print(msg + ": ");
            try{
                value = SCANNER.nextInt();
                SCANNER.nextLine();
                break;
            }catch (Exception e){
                System.out.println("You can only input the integer numbers");
            }
        }
        return value;
    }
    private static double getDouble(String msg){
        double value = -1;
        while (true){
            System.out.print(msg + ": ");
            try{
                value = SCANNER.nextDouble();
                SCANNER.nextLine();
                break;
            }catch (Exception e){
                System.out.println("You can only input the numbers");
            }
        }
        return value;
    }
    private static String getString(String msg){
        System.out.print(msg + ": ");
        return SCANNER.nextLine();
    }
}
