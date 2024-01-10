import java.util.*;
import java.util.Random;
public class javaguessthenumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String play ="yes";
    while(play.equals("yes")){
        Random r = new Random();
        int rand = r.nextInt(100);
        int guess =-1;
        int tries = 0;
        while(guess!=rand){
          System.out.println("Guess a number between 1 and 100");
          guess = sc.nextInt();
          tries++;
          if(guess == rand){
            System.out.println("Awesome! You guessed the number");
            System.out.println("It only took you "+" guess!");
            System.out.println("Would you like to play again ? Yes or No");
            play = sc.next().toLowerCase();
          }
            else if(guess> rand)
            {
              System.out.println("You guess is too high, try again.");
            }
            else
            {
              System.out.println("You guess is too low, try again.");
            }
        }
    }
    sc.close();
  }
    
}
