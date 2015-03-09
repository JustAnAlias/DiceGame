
package diceplay;

import java.util.Scanner;

public final class GameEngine {
    

    // Prompts for new player
    Player playerOne = new Player();
    
    String playerName = playerOne.getName();

    int credit = playerOne.getCredit();
    int round = 0; // Round count
    int input;
    int input_dice1;
    int input_dice2;
    int sum;
    int woncredit;

    // For statistics
    int totalwagered = 0; // Total betted
    int creditswon = 0; // Total credits won
    int creditslost = 0; // Total credits lost
    int lostrounds = 0; // Lost rounds count
    int wonrounds = 0; // Won rounds count
    
    // For statistics
    // Dice roll statistics
    int totalones = 0; // Count ones
    int totaltwos = 0; // Count twos
    int totalthrees = 0; // Count Threes
    int totalfours = 0; // Count Fours
    int totalfives = 0; // Count Fives
    int totalsixes = 0; // Count Sixes
    
    // For statistics
    // Count user guesses
    int guessone = 0; // Guesses on ones
    int guesstwo = 0; // Guesses on twos
    int guessthree = 0; // Guesses on threes
    int guessfour = 0; // Guesses on fours
    int guessfive = 0; // Guesses on fives
    int guesssix = 0; // Guesses on sixes
    
    
    String keep_playing;
    private static final Scanner s = new Scanner(System.in);
    boolean play = true;

    public GameEngine() {
                    
        // Display Greeting
        displayGreeting();
        // While play = true, keep looping.
        while(play) {
        // Updated current round
        round++;
        // Display current round
        displayStatistic();
        // Ask player to put in bet
        getBet();
        // Checks bet is not larger than current account credit
        if (input > credit) {
            // Display error if bet is larger than current account balance
            betError();
        } 
        // If nothing is wrong, Lets roll the dice
        else {
            // Roll new dices
            Dice diceRoll = new Dice();
            diceRoll.rollDice();
            // Print out total sum
            System.out.println("The total sum is: " + diceRoll.getSum());
            // int for dice1 and 2, gonna use them later.
            int dice1 = diceRoll.getDice1();
            int dice2 = diceRoll.getDice2();
            sum = diceRoll.getSum();
            
            // Switch to keep track of Advanced reward system (v2)
            switch (sum) {
            // sum is 2, 3, 11 or 12 get credit back 1.5 times.
            case 2: woncredit = (int) (1.5 * input) ; 
            // Break to get out of switch and move on with program.
            break;
            case 3:  woncredit = (int) (1.5 * input) ;
            break;
            case 11:  woncredit = (int) (1.5 * input) ;
            break;
            case 12: woncredit = (int) (1.5 * input) ;
            break;
            // sum is 4, 5, 9 or 10 get credit back 2 times.
            case 4:  woncredit = (int) (2 * input) ;
            break;
            case 5:  woncredit = (int) (2 * input) ;
            break;
            case 9:  woncredit = (int) (2 * input) ;
            break;
            case 10: woncredit = (int) (2 * input) ;
            break;
            // sum is 6, 7 or 8 get credit back 3 times.
            case 6:  woncredit = (int) (3 * input) ;
            break;
            case 7:  woncredit = (int) (3 * input) ;
            break;
            case 8: woncredit = (int) (3 * input) ;
            break;

            default: break; // Break out of switch
        }

            
//            goRoll();
            // Register userguess
            getGuess();
            // Switch for dice statistics - dice1
            switch (dice1) {
            // if 1 is rolled, add +1 to totalones
            case 1:  totalones++; 
            break;
            case 2:  totaltwos++;
            break;
            case 3:  totalthrees++;
            break;
            case 4:  totalfours++;
            break;
            case 5:  totalfives++;
            break;
            case 6:  totalsixes++;
            break;
            default: break;
        }
            
            // Switch for dice statistics - dice2
            switch (dice2) {
            case 1:  totalones++;
            break;
            case 2:  totaltwos++;
            break;
            case 3:  totalthrees++;
            break;
            case 4:  totalfours++;
            break;
            case 5:  totalfives++;
            break;
            case 6:  totalsixes++;
            break;
            default: break;
        }
            
            // Switch for guess statistics - guess1
            switch (input_dice1) {
            // Guess on 1 adds +1 to guessone
            case 1:  guessone++;
            break;
            case 2:  guesstwo++;
            break;
            case 3:  guessthree++;
            break;
            case 4:  guessfour++;
            break;
            case 5:  guessfive++;
            break;
            case 6:  guesssix++;
            break;
            default: break;
        }
            // Switch for guess statistics - guess2            
            switch (input_dice2) {
            case 1:  guessone++;
            break;
            case 2:  guesstwo++;
            break;
            case 3:  guessthree++;
            break;
            case 4:  guessfour++;
            break;
            case 5:  guessfive++;
            break;
            case 6:  guesssix++;
            break;
            default: break;
        }

            // checks if dice1 & dice2 equals guess1 and guess2
            if (input_dice1 == diceRoll.getDice1() 
            && input_dice2 == diceRoll.getDice2() 
            // OR
            // the other way around (case not sensitive version)
            || input_dice1 == diceRoll.getDice2() 
            && input_dice2 == diceRoll.getDice1())
            {
            // Prints user guesses
            System.out.println("Your guesses were: " + input_dice1 + " and "
                    + input_dice2 + "!");
            // Prints dices rolled
            System.out.println("The rolled dices were " + dice1 + " and "
            + dice2 + "!");                        
            // Its  win, so lets update user credit
            // with woncredit from switch (advanced reward system)
            credit = woncredit + credit;

            // Prints Win to user and ask to play again
            displayWin();
            // checks wether or not to play again
            playAgain();

            } else {
            // Prints user guesses
            System.out.println("Your guesses were: " + input_dice1 + " and "
            + input_dice2 + "!");
            // Prints dices rolled
            System.out.println("The rolled dices were " + dice1 + " and "
            + dice2 + "!");
            // update credit if lost
            credit = credit - input;

            // Prints Lose to user and ask to play again.
            displayLose();
            // Checks wether or not to play again.
            playAgain();

                }
        
            }
        
        }
    }
    
    
    /* BELOW THIS LINE IS ALL THE FUNCTIONS */
    
    private void displayGreeting() {      
        // Create new string greeting
        String greeting;
        // string content
        greeting = ("Hi, " + playerName + "! \n"
                + "Your current balance is " + credit + "! \n"
                + "\n"
                + "\n");
        // Prints greeting
        System.out.println(greeting);
    }

    public void displayWin(){
        // adds +1 to won rounds
        wonrounds++;
        // Adds woncredit to creditswon
        creditswon += woncredit;       
        // Prints Win message for user
        System.out.println("You're correct! \n"
                + "You have won: " + woncredit + ". \n \n "
                + "Your current balance is now: " + (credit) + "\n ");
        // double scanner nextline to workaround java core problem
        s.nextLine();
        // Prompts user to play again
        System.out.println("Do you want to continue playing? Yes: y No: n");
        keep_playing = s.nextLine();
        
    }
    
    public void displayStatistic(){
        // display current round
        System.out.println("Current round: " + round + "!");
    }
    
    public void displayLose(){
        // adds +1 to lostrounds
        lostrounds++;
        // adds bet amount to creditslost
        creditslost += input;
        // prints losing message for user
        System.out.println("You're incorrect! You have lost your money! \n"
                + "You lost: " + input
                + "Your current balance is: " + (credit)
                + "\n");
        // Checks user blance is not below or equal to 0
        while(credit <= 0){      
        // if user credit is insufissient stop game nd print gameover.
        play = false;
        System.out.println("Your credit is 0, Game Over");
        }
        
        //Double scanner to workaround java core problem
        s.nextLine();
        // Prompts user to play again
        System.out.println("Do you want to continue playing? Yes: y No: n");
        keep_playing = s.nextLine();
            
        
    }
    
    public void getBet(){
        System.out.println("Please place your bet here: \n");
        input = s.nextInt();
        // Adds bet to total wagered
        totalwagered += input;
    }
    
    private void betError() {         
            String beterror;
            beterror = ("ERROR! \n \n "
                    + "The amount of money you have tried to bet, "
                    + "is larget than your current balance.\n"
                    + "Your current blance is: " + credit
                    + "Please make a new bet \n \n");
       
            System.out.println(beterror);
        }

		public void playAgain(){
                if (keep_playing.equalsIgnoreCase("y")) {
                    System.out.println("Awesome ! \n Starting new round"
                            + ".........................");
                    play = true;
                } else if (keep_playing.equalsIgnoreCase("n")) {
                    System.out.println("Thanks for playing! \n "
                            + "Hope to see you again soon \n"
                            + "Your final account balance is: " + credit);
							// prints statistics
                        gameStatistics();
                        diceStatistics();
                        guessStatistics();
                    play = false;
                }
                else {
                    s.nextLine();
                    System.out.println("ERROR \n Wrong input !");
                    keep_playing = s.nextLine();
                }
    }
  /*  public void goRoll(){
            
    }
*/
    public void getGuess(){
            System.out.println("First guess: ");
            input_dice1 = s.nextInt();
			// checks for error on input 1 
            while (sum - 6 > input_dice1 || input_dice1 < 1 || input_dice1 > 6){
                System.out.println("Error, try again");
                input_dice1 = s.nextInt();
            }
            System.out.println("Second guess: ");
            input_dice2 = s.nextInt();
			// checks for error on input 2
            while (input_dice2 < 1 || input_dice2 > 6){
                System.out.println("Error, try again");
                input_dice2 = s.nextInt();
            }
            

    }   
    
    public void gameStatistics(){
        System.out.println("Total Credits Betted: " + totalwagered);
        System.out.println("Total Credits won: " + creditswon);
        System.out.println("Total Credits lost: " + creditslost);
        System.out.println("Total rounds lost: " + lostrounds);
        System.out.println("Total rounds won: " + wonrounds);
    }
    
    public void diceStatistics(){
        
        System.out.println("Ones rolled: " + totalones);
        System.out.println("Twos rolled: " + totaltwos);
        System.out.println("Threes rolled: " + totalthrees);
        System.out.println("Fours rolled: " + totalfours);
        System.out.println("Fives rolled: " + totalfives);
        System.out.println("Sixes rolled: " + totalsixes);
        
    }

    public void guessStatistics(){
        System.out.println("You guessed ");
        System.out.println("One: " + guessone + " times");
        System.out.println("Two: " + guesstwo + " times");
        System.out.println("Three: " + guessthree + " times");
        System.out.println("Four: " + guessfour + " times");
        System.out.println("Five: " + guessfive + " times");        
        System.out.println("Six: " + guesssix + " times");        
    }

}