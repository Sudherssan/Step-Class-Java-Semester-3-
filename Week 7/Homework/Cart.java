
import java.util.*;

public class Cart {

    // Private array to store item prices
    private double[] prices;

    // Number of items added
    private int itemCount;

    // Final cart ID
    private final String cartId;

    // Constructor
    public Cart(String cartId, int maxItems) {
        if (maxItems < 0) {
            throw new IllegalArgumentException(
                "Maximum items cannot be negative"
            );
        }

        this.cartId = cartId;
        prices = new double[maxItems];
        itemCount = 0;
    }

    // Add an item price
    public void addItem(double price) {
        if (price < 0) {
            System.out.println("Invalid price: cannot be negative");
            return;
        }

        if (itemCount >= prices.length) {
            System.out.println("Cart is full");
            return;
        }

        prices[itemCount] = price;
        itemCount++;
    }

    // Calculate total from stored prices
    public double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    // Calculate item count on request
    public int getItemCount() {
        int count = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i < itemCount) {
                count++;
            }
        }

        return count;
    }

    // Read-only access to cart ID
    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {

        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
