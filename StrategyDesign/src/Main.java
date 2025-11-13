import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        cart.addItem("8GB RAM", 2500);
        cart.addItem("10GB RAM", 4500);
        cart.addItems(Map.of(
                "I7 Processor", 35000,
                "I5 Processor", 18000,
                "I3 Processor", 8500
        ));

        System.out.println(cart.getSubtotal());

        cart.paymentStrategy(new CreditCardPayment());
        cart.paymentStrategy(new PayPalPayment());
        cart.paymentStrategy(new UPIPayment());
        cart.paymentStrategy(new CryptoPayment());

    }

}