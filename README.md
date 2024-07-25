# Stock Management System

## Overview

This repository contains a simple Stock Management System implemented in Java. The system allows you to manage stock items, reserve and sell items, and maintain a basket for customers. It demonstrates basic object-oriented principles and includes the following main components:

- `StockItem`: Represents an item in stock.
- `StockList`: Manages a collection of stock items.
- `Basket`: Represents a customer's basket containing items they intend to purchase.
- `App`: The main application to demonstrate the functionality of the stock management system.

## Features

- Add stock items to the inventory.
- Reserve and unreserve stock items.
- Sell stock items.
- Add and remove items from a customer's basket.
- Checkout a customer's basket and update the inventory accordingly.

## Class Descriptions

### `StockItem`

Represents an individual stock item with attributes:
- `name`: The name of the item.
- `price`: The price of the item.
- `quantityInStock`: The total quantity available in stock.
- `reserved`: The quantity reserved for customers.

Methods:
- `getName()`, `getPrice()`, `availableQuantity()`, `setPrice()`, `setQuantity()`, `adjustStock()`, `reserveStock()`, `unreserveStock()`, `finaliseStock()`
- Overrides for `equals()`, `hashCode()`, `compareTo()`, and `toString()`

### `StockList`

Manages a collection of `StockItem` objects using a `Map`.

Methods:
- `addStock()`: Adds or updates the stock of an item.
- `sellStock()`, `reserveStock()`, `unreserveStock()`: Manages stock operations.
- `get()`: Retrieves a stock item by name.
- `Items()`: Returns an unmodifiable view of the stock list.
- Overrides for `toString()`

### `Basket`

Represents a customer's shopping basket containing `StockItem` objects.

Methods:
- `addToBasket()`, `removeFromBasket()`: Manages items in the basket.
- `clearBasket()`: Clears all items from the basket.
- `Items()`: Returns an unmodifiable view of the basket.
- Overrides for `toString()`

### `App`

The main application class to demonstrate the functionality.

Methods:
- `main()`: Entry point to the application.
- `orderItem()`, `removeItem()`, `checkOut()`: Handles ordering, removing, and checking out items.

## Usage

### Running the Application

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/stock-management-system.git
    cd stock-management-system
    ```

2. Compile the Java code:
    ```sh
    javac -d bin src/website/jagi/*.java
    ```

3. Run the application:
    ```sh
    java -cp bin website.jagi.App
    ```

### Example Output

The `App` class demonstrates various operations:
- Adding stock items.
- Creating a basket for a customer and adding/removing items.
- Displaying the stock list and basket contents before and after checkout.

```plaintext
Stock List
bread - price: 0.86 - Overall quantity: 100 Reserved quantity: 0. Value is 86.00
cake - price: 1.1 - Overall quantity: 7 Reserved quantity: 0. Value is 7.70
car - price: 12.5 - Overall quantity: 2 Reserved quantity: 0. Value is 25.00
...
Total Stock value is: 6227.17

Shopping basket Tim contains 1 items
car - price: 12.5 - Overall quantity: 2 Reserved quantity: 1. Value is 25.00
Total Cost: 12.5
```

## License
This project is licensed under the MIT License.

## Author
Jaroslav Girovsky

## Acknowledgements
Based on [Java 17 Masterclass: Start Coding in 2024](https://www.udemy.com/course/java-the-complete-java-developer-course/?couponCode=ST3MT72524) of Tim Buchalka.