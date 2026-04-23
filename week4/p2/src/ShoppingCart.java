import java.util.HashMap;
import java.util.LinkedHashSet;

public class ShoppingCart {
    private final LinkedHashSet<Product> productSet;
    private final HashMap<Product, Integer> productCountMap;

    public ShoppingCart(){
        productSet = new LinkedHashSet<>();
        productCountMap = new HashMap<>();
    }

    public void addProduct(Product p, int qty){
        if(qty <= 0){
            System.out.println("quality must be larger than 0");
            return;
        }
        productSet.add(p);
        int oldQty = productCountMap.getOrDefault(p, 0);
        productCountMap.put(p, oldQty + qty);
    }

    public void removeProduct(int productId){
        Product target = null;
        for(Product p : productSet){
            if(p.getId() == productId){
                target = p;
                break;
            }
        }
        if(target != null ){
            productSet.remove(target);
            productCountMap.remove(target);
            System.out.println("the good id is: " + productId + "successfully removed");
        }else {
            System.out.println("there is not the specific good :"+productId);
        }
    }

    // calculate the account of the list
    public void printReceipt(){
        System.out.println("the receipt:");
        System.out.println("name   price   number  num-price");
        for(Product p : productSet){
            String name = p.getName();
            double price = p.getPrice();
            int count = productCountMap.get(p);
            double num_price = price* count;
            System.out.printf("| %-5s | %-6.1f | %-4d | %-7.1f |%n", name, price, count, num_price);
        }

    }

    public double calculateTotal(){
        double total = 0;
        for(Product p : productSet){
            total += p.getPrice()*productCountMap.get(p);
        }
        return total;
    }
}
