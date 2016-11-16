// ControlFrame.java
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.security.SecureRandom;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

//import ModifiedCraps.Status;

//import ModifiedCraps.Status;

import javax.swing.event.ChangeEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class TestCrapsNewFrame extends JFrame
{ 
	
	/////////////////Original////////////////////////////////////////////////////////////////////
	  private JPanel mainPanel;
	  private final JPanel calcPanel;
	  private JSlider widthJSlider;
	  private JTextField xValTextField;
	  private JTextField yValTextField;
	  private JLabel calcJLabel;
	  private JButton calcJButton;
	  
	  private String xStr;
	  private String yStr;
	  
	  private final JPanel crapsPanel;
	  private JLabel crapsJLabel;
	  private JButton crapsJButton;
	  private JButton rollJButton;
	  private JButton quitButton;
//	  private JLabel dice1Label = new JLabel("Dice Roll One:");
//	  private JTextField dice1Field = new JTextField( 6 );
//	  private JLabel dice2Label = new JLabel("Dice Roll Two:");
//	  private JTextField dice2Field = new JTextField( 6 );
	  private JLabel sumLabel = new JLabel("Sum");
	  private JTextField sumField = new JTextField( 6 );

		/////////////////NEW////////////////////////////////////////////////////////////////////
	  

  
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
	  
		
	    

		  
  public TestCrapsNewFrame(String title)
  {
    super( title );
    mainPanel = new JPanel( new BorderLayout() );
    mainPanel.setSize(200, 250);  
    // set in center of screen
    //setLocationRelativeTo(null);
    
    // Craps Panel
    crapsPanel = new JPanel( new FlowLayout() );    // original
    crapsPanel.setSize(40, 40);
    //testPanel = new JPanel( new GridLayout(2, 2, 12, 6) );	// didn't work
    
    //gameScore();
    
    calcPanel = new JPanel( new FlowLayout() );    
    calcPanel.setSize(200, 200);    

    final DrawControlPanel drawPanel = new DrawControlPanel();
    drawPanel.setSize(200, 200);    
    
    int[] foo = rollDice();
    System.out.println("foo " + foo[0]);

    
    Craps gameCraps = new Craps();
    
    
    this.setContentPane( mainPanel );
    
    JMenu fileMenu = new JMenu( "File" );
    fileMenu.setMnemonic( 'F' );
    
      
    final JMenuBar bar = new JMenuBar();  // Create a JMenuBar so we can attach menus to it.
    setJMenuBar( bar );  // Attach the JMenuBar to the ControlFrame.
    bar.add( fileMenu );  // Add the file menu to the JMenuBar.
    
    JMenuItem aboutItem = new JMenuItem( "About..." );
    aboutItem.setMnemonic( 'A' );
    fileMenu.add( aboutItem );
    aboutItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
          JOptionPane.showMessageDialog( TestCrapsNewFrame.this,
                                      "Experimental Craps Application.",
                                      "About", JOptionPane.PLAIN_MESSAGE );
        }
     }  // End of anonymous inner class
    );
    
    JMenuItem crapsAPanelItem = new JMenuItem( "New Craps Panel (A)" );
    crapsAPanelItem.setMnemonic( 'C' );
    fileMenu.add( crapsAPanelItem );
    crapsAPanelItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
            mainPanel.remove( drawPanel );
            mainPanel.add(crapsPanel, BorderLayout.CENTER );
            validate();
            repaint();
        }
      }
    );


    JMenuItem crapsPanelItem = new JMenuItem( "Original Craps Panel" );
    crapsPanelItem.setMnemonic( 'C' );
    fileMenu.add( crapsPanelItem );
    crapsPanelItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
            mainPanel.remove( drawPanel );
            mainPanel.add(crapsPanel, BorderLayout.CENTER );
            validate();
            repaint();
        }
      }
    );
    
    
    crapsJLabel = new JLabel();
    crapsPanel.add( crapsJLabel, BorderLayout.CENTER );
    crapsPanel.add(sumLabel);
    crapsPanel.add(sumField);
    

    // calculate at the push of a button
    rollJButton = new JButton( "Roll" );   
    rollJButton.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
        	int sum[] = gameCraps.rollDice();
        	sumLabel.setText("Sum is: " + sum[2]);
        	dice1Label.setText("Dice 1: " + sum[0]);
        	dice2Label.setText("Dice 2: " + sum[1]);
        	
        	crapsPanel.add(dice1Label);
        	crapsPanel.add(dice2Label);
        	crapsPanel.add(sumLabel);
        	gameCraps.scoring(sum);   	
        }
      }
    );
    
  
    crapsPanel.add( rollJButton );
    crapsJLabel = new JLabel();
    crapsPanel.add( crapsJLabel, BorderLayout.CENTER );
   

     
    JMenuItem exitItem = new JMenuItem( "Exit" );
    exitItem.setMnemonic( 'x' );
    fileMenu.add( exitItem );
    exitItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          System.exit( 0 );
        }
      }
    );
    
    /////////////////////NEW/////////////////////////////////////////
    
    
    
                                                                      

    


    

    
    /////////////////////NEW/////////////////////////////////////////
    
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    setSize( 300, 300 );
    setVisible( true );
    validate();
  }
  
  /////////////////////NEW/////////////////////////////////////////
  
/////////////////NEW////////////////////////////////////////////////////////////////////
  
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


/////////////////NEW////////////////////////////////////////////////////////////////////   
  
  

  


  

  
  /////////////////////NEW/////////////////////////////////////////
  
}  