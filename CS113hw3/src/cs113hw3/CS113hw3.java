package cs113hw3;
/**
 *
 * @author mahigada
 */
import java.util.Scanner;
import java.util.Random;
public class CS113hw3 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // PP 5.2
    int year = 1583;
    while (year > 1582 || year != -1) {
        System.out.println("Enter the year (Answer -1 if you want to stop): ");
        year = scan.nextInt();
        if (year == -1) 
            break;
        if (year < 1582)
            System.out.println("Enter a higher year, the Georgian calendar"
                    + "hasn't been adopted yet.");
        else if ((year %4 ==0 || year %400 ==0 ) || (year%400 ==0 && year%100 ==0))
            System.out.println(year + " is a leap year.");
        else
            System.out.println(year + " isn't a leap year.");
    }
  // PP 5.4
    String restart = "y";
    Random generator = new Random();
        while (restart.equalsIgnoreCase("y")) {
            int count = 0;
            int answer = generator.nextInt(100) + 1;
            System.out.print("Guess a number (Type 0 to quit)? ");
            while (true) {
                int guess = scan.nextInt();
                if (guess == 0) {
                    System.out.println("Thanks for playing!");
                    break;
                }
                count++;
                if (guess == answer) {
                    System.out.println("You're right! You made " + count + " guesses.");
                    break;
                }

                if (guess < answer) 
                    System.out.println("Guess is too low, guess again.");
                 else 
                    System.out.println("Guess is too high, guess again.");
            }
            System.out.println("Do you want to replay (Y/N)?");
            restart = scan.next();
        }   
    // Euler Problem
    int sum = 0;
    for(int i=0; i<1000; i++){
             if (i%3 ==0 || i%5 == 0){
                 sum +=i;            
                 }
    }
    System.out.println(sum);
}
}