import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.security.SecureRandom;
import java.util.Random;


public class ModifiedCraps extends JFrame
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
	
	//private CrapsData craps = new CrapsData();
	// JPanel config objects
	private JLabel dice1Label = new JLabel("Dice Roll 1:");
    private JLabel dice2Label = new JLabel("Dice Roll 2:");
    private JLabel sumOfDiceLabel = new JLabel("Total:");
    private JLabel pointLabel = new JLabel("Point:");
    private JLabel resultsLabel = new JLabel("Results:");
    private JTextField dice1Field = new JTextField("???");
    private JTextField dice2Field = new JTextField("???");
    private JTextField sumOfDiceField = new JTextField("???");
    private JTextField pointField = new JTextField("???");
    private JTextField resultsField = new JTextField("????");
    private JButton rollButton = new JButton("ROLL");
    
    public ModifiedCraps()
    {
       JPanel dataPanel = new JPanel(new GridLayout(2, 2, 12, 6));
       dataPanel.add(dice1Label);
       dataPanel.add(dice2Label);
       dataPanel.add(sumOfDiceLabel);
       dataPanel.add(pointLabel);
       dataPanel.add(resultsLabel);
       dataPanel.add(dice1Field);
       dataPanel.add(dice2Field);
       dataPanel.add(sumOfDiceField);
       dataPanel.add(pointField);
       dataPanel.add(resultsField);
       
    
       JPanel buttonPanel = new JPanel();
       buttonPanel.add(rollButton);
       Container container = getContentPane();
       container.add(dataPanel, BorderLayout.CENTER);
       container.add(buttonPanel, BorderLayout.NORTH);
       rollButton.addActionListener(new RollListener());
    }
	
    // roll dice, calculate sum and display results
    public static int[] rollDice()
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
 	   sumOfDice = dice[2];

 	   	
 	   System.out.println("total: " + sumOfDice);
 	   
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
    
    public void gameScore(int[] diceRoll )	
    {
 	   int[] dice = diceRoll;
 	   
 	   sumOfDice = dice[2];
 	   
 	   
 	   // while game is not complete
        while (gameStatus == Status.CONTINUE) // not WON or LOST
        { 
     	   System.out.println("\tgamescoreGameStatus " + gameStatus + " dice[2] " + sumOfDice);
     	   
     	   int[] anotherRoll = rollDice(); // roll dice again
     	   System.out.print("Your roll is " + anotherRoll[0] + " & " + anotherRoll[1]);
           sumOfDice = anotherRoll[2];

 		 // determine game status
           if (sumOfDice == myPoint) // win by making point
           {
         	  gameStatus = Status.WON;
         	  System.out.print(" Win" + "\n");
         	  
           }
           else if (sumOfDice == SEVEN) // lose by rolling 7 before point
           {
         	  gameStatus = Status.LOST;
           }     
        } 

        // display won or lost message
        if (gameStatus == Status.WON)
        {
     	   System.out.println(" Player wins");
     	   resultsField.setText(" Player wins");
        }
        else
        {
     	   System.out.println(" Player loses");
     	   resultsField.setText(" Player wins");
        }
           
    
    }
    
    private class RollListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
       {

          int[] sum = rollDice();
      	  
          
          dice1Field.setText(Integer.toString(sum[0]));
          dice2Field.setText(Integer.toString(sum[1]));
          sumOfDiceField.setText(Integer.toString(sum[2]));
          pointField.setText(Integer.toString(sum[2]));
         
          scoring(sum);
          gameScore(sum);	

       }
    }
 
    
    public static void main(String [] args)
   {
      ModifiedCraps theGUI = new ModifiedCraps();
      theGUI.setTitle("Modified Craps Game");
      theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      theGUI.pack();
      theGUI.setVisible(true);
   }
}
