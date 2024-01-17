import java.util.*;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("1. You Vs Computer 2. Two- player");
    System.out.println("Enter your choice to play the  game");
    int n = sc.nextInt();
    Random rand = new Random();
    switch (n) {
      case 1:
        while (true) {
          System.out.println("Enter your move(rock, paper,scissor)");
          String user = sc.next().toLowerCase();
          if (!(user.equals("rock") || user.equals("paper") || user.equals("scissor"))) {
            System.out.println("Invalid movie, Enter the valid movie (Rock,Paper or Scissor)");
           continue;
          }
          String[] moves = { "rock", "paper", "scissor" };
          int computer_move = rand.nextInt(3);
          String computer = moves[computer_move];
          System.out.println("Computer move: " + computer_move);

          if (user.equals(computer)) {
            System.out.println("Tie");
          } else if ((user.equals("rock") && computer.equals("paper"))
              || (user.equals("paper") && computer.equals("scissor")
                  || (user.equals("scisssor") && computer.equals("rock")))) {
            System.out.println("Computer Wins");
          } else {
            System.out.println("You Win");          
          }
          System.out.println("Do you want to play again? (yes/no)");
          String play = sc.next().toLowerCase();
          if(!(play.equals("yes")))
          {
            System.out.println("Thank you for Playing");
            break;
          }
        }
        break;
      case 2:
        while (true) {
        System.out.println("Enter User1 move(rock, paper,scissor)");
        String user1 = sc.next().toLowerCase();
        if (!(user1.equals("rock") || user1.equals("paper") || user1.equals("scissor"))) {
          System.out.println("Invalid movie, Enter the valid movie (Rock,Paper or Scissor)");
         continue;
        }
        System.out.println("Enter User2 move(rock, paper,scissor)");
          String user2 = sc.next().toLowerCase();
          if (!(user2.equals("rock") || user2.equals("paper") || user2.equals("scissor"))) {
            System.out.println("Invalid movie, Enter the valid movie (Rock,Paper or Scissor)");
           continue;
          }
          if (user1.equals(user2)) {
            System.out.println("Tie");
          } else if ((user1.equals("rock") && user2.equals("paper"))
              || (user1.equals("paper") && user2.equals("scissor")
                  || (user1.equals("scisssor") && user2.equals("rock")))) {
            System.out.println("User2 Win");
          } else {
            System.out.println("User1 Win");          
          }
          System.out.println("Do you want to play again? (yes/no)");
          String play = sc.next().toLowerCase();
          if(!(play.equals("yes")))
          {
            System.out.println("Thank you for Playing");
            break;
          }
        }
        break;
      default:
        System.out.print("Invaild choice, Please Enter the 1 or 2 ");
    }
  }
} 
