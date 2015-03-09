package diceplay;

import java.util.Random;

public class Dice {
    // creating an object from Random class
    private final Random r = new Random();
    private int dice1;
    private int dice2;
    
/*    public void rollDice(){
        // generating a random int 1-6
        dice1 = r.nextInt(6) + 1;
        dice2 = r.nextInt(6) + 1;
    }
  */  
    public void rollDice() {    
    Random rand = new Random();
    dice1 = (int)rand.nextInt(6) + 1;
    dice2 = (int)rand.nextInt(6) + 1;
   }
    
    
    public int getDice1(){
		// return dice1
        return dice1;
    }
    
    public int getDice2(){
		// return dice2
        return dice2;
    }
    
    public int getSum(){
    int sum = dice1 + dice2;
	// return sum
    return sum;
    }

    
}

















