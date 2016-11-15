// Fig. 6.8: Craps.java
// Craps class simulates the dice game craps.
import java.security.SecureRandom;

public class Craps 
{
   // create secure random number generator for use in method rollDice
   private static final SecureRandom randomNumbers = new SecureRandom();

   // enum type with constants that represent the game status
   private enum Status {CONTINUE, WON, LOST};
   
   // constants that represent game configurations
   private int sumOfDice = 0;
   private Status gameStatus = null;
   private int myPoint = 0;
   
   // constants that represent common rolls of the dice
   private static final int SNAKE_EYES = 2;
   private static final int TREY = 3;
   private static final int SEVEN = 7;
   private static final int YO_LEVEN = 11;
   private static final int BOX_CARS = 12;
   
   // constructor
   public Craps()
   {
	   
   }
   
   // roll dice, calculate sum and display results
//   public int rollDice()
//   {
//      // pick random die values
//      int die1 = 1 + randomNumbers.nextInt(6); // first die roll
//      int die2 = 1 + randomNumbers.nextInt(6); // second die roll
//
//      int sum = die1 + die2; // sum of die values
//
//      // display results of this roll
//      System.out.printf("Player rolled %d + %d = %d%n", 
//         die1, die2, sum);
//
//      return sum; 
//   }
   
   // roll dice, calculate sum and display results
   public int[] rollDice()
   {
		int[] returnRoll = new int[3];
		returnRoll[0] = (1 + randomNumbers.nextInt(6));
		returnRoll[1] = (1 + randomNumbers.nextInt(6));
		returnRoll[2] = returnRoll[0] + returnRoll[1];
		return returnRoll;

   }
   
   public void scoring(int[] diceRoll)
   {
	   
	   int[] dice = diceRoll;
	   System.out.println("enter method scoring");
	   System.out.println(dice[0]);
	   System.out.println(dice[1]);
	   System.out.println(dice[2]);
	   
	   sumOfDice = dice[2];

	   	
	   System.out.println("scoring sum " + sumOfDice);
	   
	   // determine game status and point based on first roll 
	      switch (sumOfDice) 
	      {
	         case SEVEN: // win with 7 on first roll
	         case YO_LEVEN: // win with 11 on first roll           
	            gameStatus = Status.WON;
	            break;
	         case SNAKE_EYES: // lose with 2 on first roll
	         case TREY: // lose with 3 on first roll
	         case BOX_CARS: // lose with 12 on first roll
	            gameStatus = Status.LOST;
	            break;
	         default: // did not win or lose, so remember point         
	            gameStatus = Status.CONTINUE; // game is not over
	            myPoint = sumOfDice; // remember the point
	            System.out.printf("Point is %d%n", myPoint);
	            break;
	      } 
   }
   
   public void gameScore(int[] diceRoll)
   {
	   int[] dice = diceRoll;
	   System.out.println("enter method gameScore");
	   System.out.println(dice[0]);
	   System.out.println(dice[1]);
	   System.out.println(dice[2]);
	   
	   sumOfDice = dice[2];
	   
	   
	   // while game is not complete
       while (gameStatus == Status.CONTINUE) // not WON or LOST
       { 
          //sumOfDice = rollDice(); // roll dice again

		 // determine game status
          if (sumOfDice == myPoint) // win by making point
          {
        	  gameStatus = Status.WON;
          }
          else if (sumOfDice == SEVEN) // lose by rolling 7 before point
          {
        	  gameStatus = Status.LOST;
          }
                
       } 

       // display won or lost message
       if (gameStatus == Status.WON)
       {
    	   System.out.println("Player wins");
       }
       else
       {
    	   System.out.println("Player loses");
       }
          
   
   }
   
   public void gamePlay()
   {

	   // roll the dice
	   //sumOfDice = rollDice(); // first roll of the dice
	   // check roll to check the score
	   
	   scoring(rollDice());
	   // results
	   gameScore();

   }

   // plays one game of craps
   public static void main(String[] args)
   {
	   Craps game = new Craps();

	   int[] results = game.rollDice();
	   game.scoring(results);
	   game.gameScore(results);
      
   }

   
} // end class Craps


