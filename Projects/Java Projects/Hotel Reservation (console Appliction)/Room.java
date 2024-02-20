import java.util.*;
public class Room{
    int RoomNo;
    boolean ac;
Room(int RoomNo,boolean ac){
    this.RoomNo =RoomNo;
    this.ac = ac;
}
public int getRoomNo() {
    return RoomNo;
}
public void setAc(boolean ac) {
    this.ac = ac;
}
public boolean isAc(){
    return ac;
}
public void displaybusinfo(){
    System.out.println("Room No: "+RoomNo);
}
}
