package lk.ac.iit;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WestMinsterShoppingManager implements ShoppingManager{

    private static final List<Product> listOfTheProducts = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String BLUE = "\033[1;34m";
    private static final String GREEN = "\033[1;32m";
    private static final String RED = "\033[1;31m";
    private static final String BOLD = "\033[1;0m";
    private static final String DEFAULT_COLOR = "\033[0;0m";

    private static final WestMinsterShoppingManager WMSM = new WestMinsterShoppingManager();
    public static void main(String[] args) {

        clearConsole();
        System.out.printf("\n\n%10s%s%s\n\n",BLUE, "WestMinister Shopping Manager", DEFAULT_COLOR);
        int dashboard = 0;

        L1:
        while (true){
            clearConsole();
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
                                System.out.print("\nDo you want to add another product(Y/n): ");
                                if (!(SCANNER.nextLine()).equalsIgnoreCase("Y")) {
                                    dashboard = 0;
                                    continue L1;
                                }else {
                                    continue L2;
                                }
                            case 2:
                                addElectronicsItem();
                                System.out.print("\nDo you want to add another product(Y/n): ");
                                if (!(SCANNER.nextLine()).equalsIgnoreCase("Y")) {
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
                    System.out.print("\nDo you want to delete another product(Y/n): ");
                    if (!(SCANNER.nextLine()).equalsIgnoreCase("Y")) {
                        dashboard = 0;
                        continue L1;
                    }else {
                        continue L1;
                    }

                case 3:
                    WMSM.printTheListOfTheProduct();
                    System.out.print("\nEnter any letter to back to home: ");
                    if (!(SCANNER.nextLine()).isEmpty()) {
                        dashboard = 0;
                        continue L1;
                    }else {
                        continue L1;
                    }

                case 4:
                    // Todo: serialization
                default:
                    clearConsole();
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

    public boolean addANewProduct(String productID, String productName, int numberOfAvailableItems, double price, double size, String colour) {
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

    public boolean saveInAFile(File file) {
        // Todo: Save Objects in a file.
        return false;
    }

    public List<Product> getListOfTheProducts(){
        return listOfTheProducts;
    }

    private static void deleteProduct(){
        System.out.printf("\n%10s%s%s",BOLD,"Product ID: ",DEFAULT_COLOR);
        String productID = SCANNER.nextLine();
        System.out.println();

        if(WMSM.deleteAProduct(productID)){
            System.out.printf("\n%10s%s%s",GREEN,"The product is deleted successfully",DEFAULT_COLOR);
        }else {
            System.out.printf("\n%10s%s%s",RED,"The product is not available in the list",DEFAULT_COLOR);
        }
    }

    private static void addClothingItem(){
        System.out.printf("\n%10s%s%s",BOLD,"Product ID: ",DEFAULT_COLOR);
        String productID = SCANNER.nextLine();
        System.out.println();

        System.out.printf("%10s%s%s",BOLD,"Product Name: ",DEFAULT_COLOR);
        String productName = SCANNER.nextLine();
        System.out.println();

        System.out.printf("%10s%s%s",BOLD,"No Of Available Items: ",DEFAULT_COLOR);
        int noOfAvailableItems = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println();

        System.out.printf("%10s%s%s",BOLD,"Price: ",DEFAULT_COLOR);
        double price = SCANNER.nextDouble();
        SCANNER.nextLine();
        System.out.println();

        System.out.printf("%10s%s%s",BOLD,"Size: ",DEFAULT_COLOR);
        double size = SCANNER.nextDouble();
        SCANNER.nextLine();
        System.out.println();

        System.out.printf("%10s%s%s",BOLD,"Color: ",DEFAULT_COLOR);
        String color = SCANNER.nextLine();
        System.out.println();

        if(WMSM.addANewProduct(productID,productName,noOfAvailableItems,price,size,color)){
            System.out.printf("\n\n%10s%s%s",GREEN,"The product is added successfully",DEFAULT_COLOR);
        }else {
            System.out.printf("\n\n%10s%s%s",RED,"The product limit is exceeded or the product already exist",DEFAULT_COLOR);
        }
    }

    private static void addElectronicsItem(){
        System.out.printf("\n%10s%s%s",BOLD,"Product ID: ",DEFAULT_COLOR);
        String productID = SCANNER.nextLine();
        System.out.println();

        System.out.printf("\n%10s%s%s",BOLD,"Product Name: ",DEFAULT_COLOR);
        String productName = SCANNER.nextLine();
        System.out.println();

        System.out.printf("\n%10s%s%s",BOLD,"No Of Available Items: ",DEFAULT_COLOR);
        int noOfAvailableItems = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println();

        System.out.printf("\n%10s%s%s",BOLD,"Price: ",DEFAULT_COLOR);
        double price = SCANNER.nextDouble();
        SCANNER.nextLine();
        System.out.println();

        System.out.printf("\n%10s%s%s",BOLD,"Brand: ",DEFAULT_COLOR);
        String brand = SCANNER.nextLine();
        System.out.println();

        System.out.printf("\n%10s%s%s",BOLD,"Warranty period: ",DEFAULT_COLOR);
        int period = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println();

        if(WMSM.addANewProduct(productID,productName,noOfAvailableItems,price,brand,period)){
            System.out.printf("\n\n%10s%s%s",GREEN,"The product is added successfully",DEFAULT_COLOR);
        }else {
            System.out.printf("\n\n%10s%s%s",RED,"The product limit is exceeded or the product already exist",DEFAULT_COLOR);
        }
    }

    private static int addProduct(){
        System.out.printf("%10s%s%s \n\n",BOLD,"[1] Add a clothing item",DEFAULT_COLOR);
        System.out.printf("%10s%s%s \n\n",BOLD,"[2] Delete a Electronic item",DEFAULT_COLOR);
        return getOption();
    }

    private static int home(){
        System.out.printf("%10s%s%s \n\n",BOLD,"[1] Add a new product",DEFAULT_COLOR);
        System.out.printf("%10s%s%s \n\n",BOLD,"[2] Delete a product",DEFAULT_COLOR);
        System.out.printf("%10s%s%s \n\n",BOLD,"[3] Print the list of products",DEFAULT_COLOR);
        System.out.printf("%10s%s%s \n\n",BOLD,"[4] Save in a file",DEFAULT_COLOR);
        System.out.printf("%10s%s%s \n\n",BOLD,"[5] Exit",DEFAULT_COLOR);
        return getOption();
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static int getOption(){
        System.out.print("Enter your option : ");
        int option = SCANNER.nextInt();
        SCANNER.nextLine();
        return option;
    }
}
