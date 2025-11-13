import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<String, Integer> items;
    private int subtotal;
    private PaymentStrategy paymentStrategy;

    {
        items = new HashMap<>();
        this.subtotal = 0;
    }

    public void addItem(String itemName, int amount) {
        this.subtotal += amount;
        items.put(itemName, amount);
        System.out.println("Added item worth " + amount);
    }

    public void addItemSet(Map<String, Integer> items) {
        if (items != null) {
            items.forEach(this::addItem);
        } else {
            System.out.println("items is null");
        }
    }

    public void display() {
        items.forEach((i, v) -> System.out.println(i + " -> $" + v));
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        try {
            this.paymentStrategy.pay(subtotal);
        } catch (NullPointerException e) {
            System.out.println("Please set payment strategy first.");
        }
    }
}
