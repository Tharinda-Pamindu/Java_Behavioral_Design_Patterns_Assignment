# Reflection Report: Command Design Pattern

## 1. Introduction

This report reflects on the design and implementation of the `CommandDesign` project. The project's goal was to implement the Command behavioral design pattern by creating a smart home remote control that can execute actions on various devices.

The Command pattern turns a request into a stand-alone object that contains all information about the request. This lets you parameterize clients with different requests, queue or log requests, and support undoable operations.

## 2. Design and Implementation

-   **Command (`Command` interface):** Declares an interface for executing an operation (`execute()`) and, for this project, reversing it (`undo()`).

-   **Receiver (`Light`, `Fan`):** These classes contain the actual business logic. They know how to perform the work (e.g., `turnOn()`, `turnOff()`).

-   **Concrete Commands (`LightOnCommand`, `FanOnCommand`, etc.):** These classes bind a Receiver to a specific action. An instance of a concrete command holds a reference to a receiver object and implements `execute()` by calling the appropriate method on that receiver.

-   **Invoker (`RemoteControl`):** The `RemoteControl` holds and triggers the commands. It is completely decoupled from the Receiver; it only knows about the `Command` interface.

-   **Key Feature & Undo Functionality:** The project successfully decoupled the `RemoteControl` (Invoker) from the devices it controls (`Light`, `Fan`). The most powerful demonstration of this pattern was the **undo feature**. The remote can reverse the last action simply by calling `undo()` on the last executed command object, without needing to know any details about the action itself.

## 3. Final Console Output

The output demonstrates turning devices on and off, and using the undo button to reverse the most recent action. The remote correctly tracks the last command and executes its `undo` method when the undo button is pushed.

```
--- Testing Remote Control ---
Light is ON
Fan is ON
Undo: Fan is OFF
------------------------------
Light is OFF
Fan is ON
Undo: Fan is OFF
Undo: Fan is OFF
```
