import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking {
    String name;
    int RoomNo;
    Date startDate;
    Date endDate;
    boolean checkedIn;

Booking(){
    Scanner sc  = new Scanner(System.in);
    System.out.println("Enter your name");
    name = sc.next();
    System.out.println("Enter your Room no");
    RoomNo = sc.nextInt();
    System.out.println("Enter the start date (dd-mm-yyyy)");
    String startda = sc.next();
     SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    try {
        startDate = dateFormat.parse(startda);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    System.out.println("Enter the end date (dd-mm-yyyy)");
    String endda = sc.next();
     SimpleDateFormat dateFormatend = new SimpleDateFormat("dd-MM-yyyy");
    try {
        endDate = dateFormatend.parse(endda);
    } catch (ParseException e) {
        e.printStackTrace();
    }
}
public boolean checkIn(ArrayList<Booking> bookings, ArrayList<Room> rooms) {
    boolean checkin = false;
    if (isRoomAvailable(bookings, rooms)) {
        checkin = true;
    }
    return checkin;
}

public boolean isRoomAvailable(ArrayList<Booking> bookings, ArrayList<Room> rooms) {
    for (Booking booking : bookings) {
        if (booking.RoomNo == RoomNo) {
            if (!(endDate.before(booking.startDate) || startDate.after(booking.endDate))) {
                return false; 
            }
        }
    }
    return true; 
}
public int stayduration(ArrayList<Booking> bookings, int roomno) {
    int totalstay=0;
    for (Booking booking : bookings) {
        if (booking.RoomNo == roomno) {
            long diff = booking.endDate.getTime() - booking.startDate.getTime();
            totalstay+=(int)(diff / (1000 * 60 * 60 * 24));
        }
    }
    return totalstay;
}

}