import java.util.*;
class FoodBooking {
    private Map<Integer, List<Food>> orders; 
    private Map<String, Integer> menu;

    public FoodBooking() {
        orders = new HashMap<>();
        menu= new HashMap<>();
        menu.put("Chapatti",40);
        menu.put("idli",30);
        menu.put("Veg Briyani",90);
        menu.put("Mushroom Briyani",80);
        menu.put("Chicken Briyani",120);
        menu.put("Tea",10);
        menu.put("Coffee", 10);
        menu.put("Orange Juice", 30);
        menu.put("Waterlemon Juice",30);
        menu.put("Sandwich", 50);
        menu.put("Noodles",50);
        menu.put("Veg-Fired Rice",50);
        menu.put("Chicken Fired Rice",60);
    }
    public void placeOrder(int roomNo, Food orderItem) {
        if (!orders.containsKey(roomNo)) {
            orders.put(roomNo, new ArrayList<>());
        }
        orders.get(roomNo).add(orderItem);
    }

    public List<Food> getOrder(int roomNo) {
        return orders.getOrDefault(roomNo, new ArrayList<>());
    }
    public Set<String> getMenuItems() {
        return menu.keySet();
    }

    public double getPrice(String itemName) {
        return menu.getOrDefault(itemName, 0); 
    }


    public double getTotalBill(int roomNo) {
        double totalBill = 0;
        List<Food> roomOrders = getOrder(roomNo);
        for (Food item : roomOrders) {
            totalBill += item.getTotalPrice();
        }
        return totalBill;
    }


}
