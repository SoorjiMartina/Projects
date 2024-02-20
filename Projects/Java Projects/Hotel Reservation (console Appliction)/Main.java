import java.util.*;
public class Main{
    public static void main(String[] args) {
        ArrayList<Room> room = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();
        ArrayList<Booking> nonacroom = new ArrayList<>();
        FoodBooking  foodb = new FoodBooking();
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while(n<4){
        System.out.println("1.Check-In\n2.Check-out\n3.Food\n4.Exit");
        System.out.println("Enter the option");
        n = sc.nextInt();
        switch (n) {
        case 1:
        System.out.println("Select your preference");
		System.out.println("1.AC- Rs.1000(perday)\n2.NON AC-Rs.500(perday)");
		int c = sc.nextInt();
        switch(c){
            case 1:
            room. add(new Room(101,false));
            room. add(new Room(102,false));
            room. add(new Room(103,false));
            for(Room r : room){
                r.displaybusinfo();
            }
            Booking booking = new Booking();
            if(booking.checkIn(bookings,room)){
                bookings.add(booking);
                System.out.println("Booking Confromied");
            }
            else{
                System.out.println("Sorry This Room is not Available");
            }
            break;
            case 2:
            room. add(new Room(201,true));
            room. add(new Room(202,true));
            room. add(new Room(203,true));
            for(Room r : room){
                r.displaybusinfo();
            }
            Booking nonacr = new Booking();
            if(nonacr.checkIn(nonacroom,room)){
                nonacroom.add(nonacr);
                System.out.println("Booking Confromied");
            }
            else{
                System.out.println("Sorry This Room is not Available");
            }
            break;
        }
        break;
        case 2:
        System.out.println("Enter your room number");
        int roomno = sc.nextInt();
        if (roomno >= 101 && roomno <= 103) {
            int totalCost = 0;
            for (Booking booking : bookings) {
                if (booking.RoomNo == roomno) {
                    int stay = booking.stayduration(bookings,roomno); 
                    totalCost += stay * 1000;
                }
                totalCost+=foodb.getTotalBill(roomno);
            }
            System.out.println("Total cost: Rs." + totalCost);
        }
        else if(roomno>=201 && roomno<=203){
            int totalCost = 0;
            for (Booking nonac : nonacroom) {
                if (nonac.RoomNo == roomno) {
                    int stay = nonac.stayduration(nonacroom,roomno); 
                    totalCost += stay * 500; 
                }
                totalCost+=foodb.getTotalBill(roomno);
            }
            System.out.println("Total cost: Rs." + totalCost);
        }
        break;
        case 3:
            System.out.println("Enter your room Number");
            int rm = sc.nextInt();
            
            System.out.println("Available items:");
            Set<String> menuItems = foodb.getMenuItems();
            for (String item : menuItems) {
                System.out.println(item + ": Rs." + foodb.getPrice(item));
            }
        while (true) {
            System.out.println("Enter item name from the menu (type 'done' to finish ordering):");
            String itemName = sc.next();
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }
            if (!menuItems.contains(itemName)) {
                System.out.println("Invalid item. Please select from the menu.");
                continue;
            }
            System.out.println("Enter quantity:");
            int quantity = sc.nextInt();
            double price = foodb.getPrice(itemName);
            Food orderItem = new Food(itemName, price, quantity);
            foodb.placeOrder(rm, orderItem);
          }
           System.out.println("Orders for Room " + rm + ":");
           List<Food> roomOrders = foodb.getOrder(rm);
           for (Food item : roomOrders) {
            System.out.println(item.getItemName() + ": Rs." + item.getPrice() *  item.getQuantity());
           }
            double totalBill = foodb.getTotalBill(rm);
           System.out.println("Total Bill: Rs." + totalBill);
            break;
    }

        }
        }
    }
