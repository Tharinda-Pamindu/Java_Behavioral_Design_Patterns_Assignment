# Reflection Report: Strategy Design Pattern

## 1. Introduction

This report reflects on the design and implementation of the `StrategyDesign` project. The project's goal was to implement the Strategy behavioral design pattern by creating a shopping cart system that allows payment methods to be selected and changed at runtime.

The Strategy pattern involves defining a family of algorithms, encapsulating each one, and making them interchangeable. This allows the algorithm to vary independently from the clients that use it.

## 2. Final Design Analysis

The final version of the project is a clean and robust implementation of the Strategy pattern.

-   **`PaymentStrategy` (The Strategy Interface):** This interface defines a common contract (`pay(int amount)`) for all supported payment algorithms. It is the core abstraction that enables loose coupling.

-   **`CreditCardPayment`, `PayPalPayment`, etc. (Concrete Strategies):** Each of these classes provides a specific implementation of the `PaymentStrategy` interface. They are the interchangeable algorithms.

-   **`ShoppingCart` (The Context):** This class holds a reference to a `PaymentStrategy` object. It is not aware of the specific implementation details of any strategy. Its `checkout()` method simply delegates the action to the current strategy object. This demonstrates a key design principle: **composition over inheritance**.

The design evolved through several iterations to improve encapsulation and robustness, resulting in a clear separation of concerns:
1.  The `ShoppingCart` is responsible for managing items and initiating payment.
2.  The `PaymentStrategy` implementations are responsible for the specific details of how a payment is processed.
3.  The `Main` class (the client) is responsible for configuring the `ShoppingCart` with the desired strategy at runtime.

## 3. Final Console Output

The following is the output from the final version of the code. It correctly demonstrates the graceful handling of a missing strategy on the first `checkout()` call. Note that `CreditCardPayment` is set but then immediately replaced by `PayPalPayment` before `checkout` is called again, so it does not appear in the payment output.

```
Added item worth 2500
Added item worth 4500
Added item worth 18000
Added item worth 35000
Added item worth 8500
Total 68500
Please set payment strategy first.
Paid 68500 using PayPal.
Paid 68500 using UPI.
Paid 68500 using Crypto.
```

## 4. How to Add a New Payment Method

The primary benefit of the Strategy pattern is the ease with which new algorithms can be added without modifying the context (`ShoppingCart`) or other existing strategies.

Here is how to add a new `BankTransferPayment` method:

### Step 1: Create the New Strategy Class

Create a new Java file named `BankTransferPayment.java`. This class must implement the `PaymentStrategy` interface.

```java
// src/BankTransferPayment.java

public class BankTransferPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        // Specific logic for bank transfer would go here
        System.out.println("Paid " + amount + " using Bank Transfer.");
    }
}
```

### Step 2: Use the New Strategy in the Client

Modify the client code (`Main.java`) to use your new strategy. No other files need to be changed.

```java
// In Main.java

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        // ... add items to cart

        // ... other payment checkouts

        // Use the new strategy
        cart.setPaymentStrategy(new BankTransferPayment());
        cart.checkout();
    }
}
```

That's it. The `ShoppingCart` class remains completely untouched, demonstrating that the system is open for extension but closed for modification.

## 5. Conclusion

The `StrategyDesign` project is a successful and practical demonstration of the Strategy pattern. It effectively decouples the payment algorithms from the shopping cart that uses them, resulting in a flexible, maintainable, and easily extensible system.