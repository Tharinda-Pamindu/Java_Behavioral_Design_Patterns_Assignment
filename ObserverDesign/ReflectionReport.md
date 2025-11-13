# Reflection Report: Observer Design Pattern

## 1. Introduction

This report reflects on the design and implementation of the `ObserverDesign` project. The project's primary goal was to demonstrate the Observer behavioral design pattern through a practical example: a Weather Station that automatically notifies multiple display devices of changes in weather data.

The Observer pattern establishes a one-to-many dependency between objects, so that when one object (the Subject) changes state, all its dependents (Observers) are notified and updated automatically.

## 2. Design and Implementation

-   **Subject (`WeatherStation`):** Manages a list of observers and provides an interface to attach (`addObserver`) and detach (`removeObserver`) them. It notifies observers via the `notifyObservers` method.

-   **Observer (`PhoneDisplay`, `TVDisplay`, `WebDashboard`):** These classes implement the `Observer` interface, which requires an `update` method. This method is called by the subject when a state change occurs.

-   **Key Feature & Flexibility:** The implementation successfully demonstrated the pattern's flexibility by adding and removing observers at runtime. The `Main` class simulates this by adding observers one by one, and later removing them. This shows that the `WeatherStation` is completely decoupled from the concrete observer classes. The use of `CopyOnWriteArrayList` also made the implementation robust and thread-safe.

## 3. Final Console Output

The output below clearly shows observers being added one by one, then all being notified together, and finally being removed one by one, demonstrating the dynamic nature of the pattern.

```
TV Display : Temp = 27 Humidity = 46%
-------------------------------------------------------
TV Display : Temp = 37 Humidity = 23%
Phone Display : Temp = 37 Humidity = 23%
-------------------------------------------------------
TV Display : Temp = 75 Humidity = 65%
Phone Display : Temp = 75 Humidity = 65%
Web Dashboard : Temp = 75 Humidity = 65%
-------------------------------------------------------
TV Display : Temp = 27 Humidity = 88%
Phone Display : Temp = 27 Humidity = 88%
Web Dashboard : Temp = 27 Humidity = 88%
-------------------------------------------------------
TV Display : Temp = 25 Humidity = 96%
Phone Display : Temp = 25 Humidity = 96%
Web Dashboard : Temp = 25 Humidity = 96%
-------------------------------------------------------
TV Display : Temp = 80 Humidity = 71%
Phone Display : Temp = 80 Humidity = 71%
Web Dashboard : Temp = 80 Humidity = 71%
-------------------------------------------------------
TV Display : Temp = 78 Humidity = 48%
Phone Display : Temp = 78 Humidity = 48%
Web Dashboard : Temp = 78 Humidity = 48%
-------------------------------------------------------
Phone Display : Temp = 45 Humidity = 27%
Web Dashboard : Temp = 45 Humidity = 27%
-------------------------------------------------------
Web Dashboard : Temp = 55 Humidity = 76%
-------------------------------------------------------
-------------------------------------------------------
```
