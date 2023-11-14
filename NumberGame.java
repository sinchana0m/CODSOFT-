import java.util.Random;
import java.util.Scanner;
public class Numbergame {
    public static void main(String[] args) {
        int RandNum = (int) (Math.random()*100)+1;   
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number between 1 and 100");
    int Guess = sc.nextInt();
    if( Guess != RandNum)
    {
        if( Guess > RandNum )
        {
        System.out.println("The guess is too high");
    }
    else{
        System.out.println("The guess is too low");
    }
    }
    if(Guess == RandNum)
    {
        System.out.println("Congratulations you guessed the number Correctly " + RandNum);
    }
    sc.close();
    }
    
}
