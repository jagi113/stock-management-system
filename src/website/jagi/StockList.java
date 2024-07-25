package website.jagi;

import java.util.*;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // we are getting item from list if it is already there
            if (inStock != item) {   // we will check if item in stock is any
                item.adjustStock(inStock.availableQuantity());  // if so, we will adjust quantity of our item
            }

            list.put(item.getName(), item); // and we put our item in list (either we will rewrite the one in Map or write it in)
            return item.availableQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);

        if ((inStock != null) && (quantity > 0)) {
            return inStock.finaliseStock(quantity);
        }
        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if ((inStock != null) && (quantity > 0)) {
            return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if ((inStock != null) && (quantity > 0)) {
            return inStock.unreserveStock(quantity);
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);  // it returns read-only view of map
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s = s + stockItem + ". Value is " + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total Stock value is: " + String.format("%.2f", totalCost);
    }

}
