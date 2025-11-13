import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Integer> items;
    private int subtotal;

    {
        items = new HashMap<>();
        this.subtotal = 0;
    }

    public void addItem(String itemName, int amount) {
        this.subtotal += amount;
        items.put(itemName, amount);
        System.out.println("Added item worth " + amount);
    }

    public void addItems(Map<String, Integer> items) {
        if (items != null) {
            this.items.putAll(items);

            Collection<Integer> values = items.values();
            for (Integer value : values) {
                subtotal += value;
                System.out.println("Added item worth " + value);
            }

        } else {
            System.out.println("items is null");
        }
    }

    public void display() {
        items.forEach((i, v) -> System.out.println(i + " -> $" + v));
    }

    public String getSubtotal() {
        return "Total " + subtotal;
    }

    public void paymentStrategy(PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(subtotal);
    }
}
