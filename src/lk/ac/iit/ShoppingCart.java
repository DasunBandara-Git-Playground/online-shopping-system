package lk.ac.iit;

import java.util.List;

public class ShoppingCart {
    private List<Product> listOfProducts;

    public void addProduct(Product product){
        listOfProducts.add(product);
    }

    public void removeProduct(Product product){
        listOfProducts.remove(product);
    }

    public double calculateTotalCost(){
        double totalCost = 0;
        for (Product product: listOfProducts) {
            totalCost += product.getNumberOfAvailableItems() * product.getPrice();
        }
        return totalCost;
    }
}
