package diceplay;

import java.util.Scanner;

public class Player {
      
    public Player(){
		// define start_credit for player
        this.start_credit = 100;
		// ask player for name
        System.out.println("Please enter your name:");
        name = s.nextLine();
        // if you want to get numeric input, you would use s.nextInt();!
    }
    
    private static final Scanner s = new Scanner(System.in);
    private String name;
    private int start_credit;
    
    public String getName(){
        return name;
    }
    
    public int getCredit(){
        return start_credit;
    }
}
