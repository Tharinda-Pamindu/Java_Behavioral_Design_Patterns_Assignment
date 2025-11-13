import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        cart.addItem("8GB RAM", 2500);
        cart.addItem("10GB RAM", 4500);
        cart.addItemSet(Map.of(
                "I7 Processor", 35000,
                "I5 Processor", 18000,
                "I3 Processor", 8500
        ));

        System.out.println("Total " + cart.getSubtotal());

        cart.checkout();
        cart.setPaymentStrategy(new CreditCardPayment());

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout();

        cart.setPaymentStrategy(new UPIPayment());
        cart.checkout();

        cart.setPaymentStrategy(new CryptoPayment());
        cart.checkout();

    }

}