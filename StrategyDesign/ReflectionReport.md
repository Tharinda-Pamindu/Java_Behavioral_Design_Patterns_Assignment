# Reflection Report: Strategy Design Pattern

## 1. Introduction

This report reflects on the design and implementation of the `StrategyDesign` project. The project's goal was to implement the Strategy behavioral design pattern by creating a shopping cart system that allows payment methods to be selected and changed at runtime.

The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable, allowing the algorithm to vary independently from the clients that use it.

## 2. Design and Implementation

-   **Context (`ShoppingCart`):** This class maintains a reference to a `PaymentStrategy` object. It is configured with a concrete strategy by the client and delegates the payment action to that strategy object via its `checkout()` method.

-   **Strategy (`PaymentStrategy`):** This interface is the common contract for all supported payment algorithms, declaring the `pay()` method.

-   **Concrete Strategies (`CreditCardPayment`, `PayPalPayment`, etc.):** Each of these classes provides a specific implementation of a payment algorithm.

-   **Key Feature & Iterative Refinement:** The project perfectly demonstrated the "Open/Closed Principle" by allowing a new `CryptoPayment` strategy to be added with zero modification to the `ShoppingCart` class. The design was also iteratively refined to separate strategy selection (`setPaymentStrategy`) from execution (`checkout`), and to add null-safety, resulting in a robust and clean design.

## 3. Final Console Output

The final output shows the cart total, a gracefully handled attempt to check out with no strategy selected, and then successful payments using four different, interchangeable strategies.

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

The primary benefit of the Strategy pattern is the ease with which new algorithms can be added. To add a new `BankTransferPayment` method:

1.  **Create a new class** that implements `PaymentStrategy`:
    ```java
    public class BankTransferPayment implements PaymentStrategy {
        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Bank Transfer.");
        }
    }
    ```
2.  **In `Main.java`, use the new strategy:**
    ```java
    cart.setPaymentStrategy(new BankTransferPayment());
    cart.checkout();
    ```
This demonstrates that the system is open for extension but closed for modification.
