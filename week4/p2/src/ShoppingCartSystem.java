public class ShoppingCartSystem {
    public static void main(String []args){
        ShoppingCart cart = new ShoppingCart();

        Product p1 = new Product(1001, "手机", 5000.0);
        Product e1 = new Product(1002, "耳机", 300.0);
        Product p2 = new Product(1001, "手机", 5000.0);

        cart.addProduct(p1, 1);
        cart.addProduct(e1, 2);
        cart.addProduct(p2, 1);

        cart.removeProduct(1002);

        cart.printReceipt();

        System.out.printf("the sum of the cart is "+ cart.calculateTotal());
    }
}