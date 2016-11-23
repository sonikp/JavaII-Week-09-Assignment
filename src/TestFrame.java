// CrapsLayoutFrame.java
// This application plays a simple craps game.
// Based on application of Section 6.10 of the Deitel & Deitel textbook
// Michael Floerchinger






import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.SecureRandom;


public class TestFrame extends JFrame 
{
	/**
	 * Display panel items
	 */

	// JPanel and TitledBorder to contain dice
    private JPanel pointDiceJPanel;
    private TitledBorder pointDiceTitledBorder;
    private Container contentPane;
    
    // JLabels to display the die images in pointDiceJPanel
    private JLabel pointDice1JLabel;
    private JLabel pointDice2JLabel;
    private JLabel pointSumJLabel;
    private int pointPanelLocation = 0;
    
    // JLabels to display the die images from the rolls of the dice
    private JLabel dice1JLabel;
    private JLabel dice2JLabel;
    private JLabel diceTotalJLabel;
    
    // JTextFields
    private JTextField dice1Field = new JTextField( 6 );
    private JTextField dice2Field = new JTextField( 6 );
    private JTextField diceTotalField = new JTextField( 6 );
    
    // JButtons to allow user to interact with game
    private JButton playJButton;
    private JButton rollJButton;
    
    // JLabel and JTextField to show results of game
    private JLabel resultJLabel;
    private JTextField resultJTextField = new JTextField("   ");
    
    /**
     * Craps Game setup 
     */
    
    // constants that represent game configurations
 	private int sumOfDice = 0;
 	private Status gameStatus = null;
 	private int myPoint = 0;
 	private int[] diceArray = new int[3];
 	private int[] anotherRoll = new int[3];
    
 	// enum type with constants that represent the game status
 	private enum Status {CONTINUE, WON, LOST};
 	
 	// constants that represent common rolls of the dice
 	private static final int SNAKE_EYES = 2;
 	private static final int TREY = 3;
 	private static final int SEVEN = 7;
 	private static final int YO_LEVEN = 11;
 	private static final int BOX_CARS = 12;
 	
 	// create secure random number generator for use in method rollDice
    private static final SecureRandom randomNumbers = new SecureRandom();
    
    /**
     * Craps Game: Assignment 8
     * Modify the application of Section 6.10 of the Deitel & Deitel textbook to provide a GUI 
     * that enables the user to click a JButton to roll the dice.
     * 
     * @param Michael Floerchinger
     */
    
    ///////// constructor ///////////////
    public TestFrame(String title)
    {
 	   super( title );
 	   createUserInterface();
 	   setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 	   setSize( 350, 250 );
 	   setVisible( true );
 	   validate();
 	   repaint();
    }
    
    // create and position GUI components; register event handlers
    private void createUserInterface()
    {
    	// get content pane for attaching GUI components
        contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout( null );

        // set up pointDiceTitledBorder for use with pointDiceJPanel
        pointDiceTitledBorder = new TitledBorder( "Point" );
        
        // set up pointDiceJPanel
        pointDiceJPanel = new JPanel();
        pointDiceJPanel.setBounds( 122, 86, 200, 122 );	
        pointDiceJPanel.setLayout( null );
        pointDiceJPanel.setBorder( pointDiceTitledBorder );
        contentPane.add( pointDiceJPanel );
        
        // set up pointDice1JLabel
        pointDice1JLabel = new JLabel();
        pointDice1JLabel.setBounds( 24, 0, 64, 56 );
        pointDiceJPanel.add( pointDice1JLabel );
        
        // set up pointDice2JLabel
        pointDice2JLabel = new JLabel();
        pointDice2JLabel.setBounds( 64, 0, 64, 56 );
        pointDiceJPanel.add( pointDice2JLabel );
        
        // set up pointDice2JLabel
        pointSumJLabel = new JLabel();
        pointSumJLabel.setBounds( 110, 0, 64, 56 );		
        pointDiceJPanel.add( pointSumJLabel );
        
        // set up dice1JLabel
        dice1JLabel = new JLabel();
        dice1JLabel.setBounds( 125, 0, 64, 64 );		
        dice1JLabel.setText( "Dice 1: ");
        contentPane.add( dice1JLabel );
        
        // set up dice2JLabel
        dice2JLabel = new JLabel();
        dice2JLabel.setBounds( 182, 0, 64, 64 );		 
        dice2JLabel.setText( "Dice 2: ");
        contentPane.add( dice2JLabel );
        
        // set up dice2JLabel
        diceTotalJLabel = new JLabel();
        diceTotalJLabel.setBounds( 272, 0, 64, 64 );		
        diceTotalJLabel.setText( "Total: ");
        contentPane.add( diceTotalJLabel );
        
        // set up dice1Field
        dice1Field = new JTextField( 6 );
        dice1Field.setBounds( 125, 50, 48, 24 );		
        contentPane.add( dice1Field );
        
        // set up dice2Field
        dice2Field = new JTextField( 6 );
        dice2Field.setBounds( 182, 50, 48, 24 );		
        contentPane.add( dice2Field );
        
        // set up dice2Field
        diceTotalField = new JTextField( 6 );
        diceTotalField.setBounds( 272, 50, 48, 24 );		 
        contentPane.add( diceTotalField );
        
        // set up resultJLabel
        resultJLabel = new JLabel();
        resultJLabel.setBounds( 16, 96, 248, 16 );		
        resultJLabel.setText( "Result:" );
        contentPane.add( resultJLabel );
        
        // set up resultJTextField
        resultJTextField = new JTextField();
        resultJTextField.setBounds( 16, 112, 88, 24 );	
        resultJTextField.setHorizontalAlignment( JTextField.CENTER );
        contentPane.add( resultJTextField );
        
        // set up playJButton
        playJButton = new JButton();
        playJButton.setBounds( 16, 22, 88, 23 );			
        playJButton.setText( "Play" );
        contentPane.add( playJButton );
        playJButton.addActionListener(
           
           new ActionListener() // anonymous inner class
           {
               // event handler called when playJButton is clicked
               public void actionPerformed ( ActionEvent event )
               {
                  //playJButtonActionPerformed( event );
              	 diceArray = rollDice();
              	 
              	 //display dice and sum results
              	 dice1Field.setText( "    " + diceArray[0] );
              	 dice2Field.setText( "    " + diceArray[1] );
              	 diceTotalField.setText( "    " + diceArray[2] );
              	 scoring(diceArray);
              	
               }

           } // end anonymous inner class

        ); // end call to addActionListener      
        
        // set up rollJButton
        rollJButton = new JButton();
        rollJButton.setBounds( 16, 62, 88, 23 );	 
        rollJButton.setText( "Roll" );
        rollJButton.setEnabled( false );
        contentPane.add( rollJButton );
        rollJButton.addActionListener(
              
           new ActionListener() // anonymous inner class
           {
              // event handler called when rollJButton is clicked
              public void actionPerformed ( ActionEvent event )
              {
              	gameScore(diceArray);
              }
           
           } // end anonymous inner class

        ); // end call to addActionListener
                
        // set properties of application's window
        setTitle( "!Craps Game" ); // set title bar string
        setSize( 350, 250 );      // set window size
        setVisible( true );       // display window

    }	// end method createUserInterface
     
    // Status panel for playing the point games (this is not working correctly, hence the debug code still here)
    public void displayDicePointPanel()
    {
    	// Debug code
    	System.out.println("\n\ndisplayDice-Meth: " +  anotherRoll[0] + " " + anotherRoll[1] + " " + anotherRoll[2] + " - " + pointPanelLocation);
    	
		pointDice1JLabel.setText(" " + anotherRoll[0]);
		pointDice2JLabel.setText(" " + anotherRoll[1]);
		pointSumJLabel.setText("Total: " + anotherRoll[2]);

	    pointDice1JLabel.setBounds( 24, pointPanelLocation, 64, 56 );
	    pointDice2JLabel.setBounds( 64, pointPanelLocation, 64, 56 );
	    pointSumJLabel.setBounds( 110, pointPanelLocation, 64, 56 );		

        validate();
        repaint();

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
	
	// scoring
	public void scoring(int[] diceRoll)
	{

		int[] dice = diceRoll;
		sumOfDice = dice[2];

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
		       System.out.printf("myPoint is %d%n", myPoint); 	// debug code
		       break;
		 } 

	     // show results
		 if ( gameStatus == Status.CONTINUE)
		 {
			 resultJTextField.setText("Roll Again!");
			 rollJButton.setEnabled( true );
			 playJButton.setEnabled( false );
			 
             // update the border title
             pointDiceTitledBorder.setTitle( "Point is: " + sumOfDice );
             pointDiceJPanel.repaint();
		 }
		 else
		 {
			 resultJTextField.setText(" " + gameStatus);
	         rollJButton.setEnabled( false );
	         playJButton.setEnabled( false );
		 }
	}
	
	
	public void gameScore(int[] diceRoll )
	{


		// while game is not complete
		while (gameStatus == Status.CONTINUE) // not WON or LOST
		{
			anotherRoll = rollDice();
			sumOfDice = anotherRoll[2];
			displayDicePointPanel();
			pointPanelLocation = pointPanelLocation + 10;
			
			// Debug code
//			System.out.println("myPoint " + myPoint);
//			System.out.println("sumOfDice " + sumOfDice);
			
			// Debug code
			System.out.print("Your roll is " + anotherRoll[0] + " & " + anotherRoll[1] + "\t");
			
			// determine game status
			if (sumOfDice == myPoint) // win by making point
			{
				gameStatus = Status.WON;
				System.out.print(" Win" + "\n");
				resultJTextField.setText("  " + gameStatus);
				rollJButton.setEnabled( false );
			 }
			 else if (sumOfDice == SEVEN) // lose by rolling 7 before point
			 {
				 gameStatus = Status.LOST;
				 System.out.print(" Lost" + "\n");
				 resultJTextField.setText("  " + gameStatus);
				 rollJButton.setEnabled( false );
			 }  
		}
	}
   


} // end class TestFrame
