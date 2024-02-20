import java.util.ArrayList;
import java.util.Scanner;

public class Food {
    private String itemName;
    private double price;
    private int quantity;

    public Food(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getTotalPrice() {
        return price * quantity;
    }
}