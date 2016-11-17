// Tutorial 15: CrapsGame.java
// This application plays a simple craps game.

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.*;

public class CrapsGame extends JFrame 
{
   // JPanel and TitledBorder to contain dice
   private JPanel pointDiceJPanel;
   private TitledBorder pointDiceTitledBorder;
   
   // JLabels to display the die images in pointDiceJPanel
   private JLabel pointDie1JLabel;
   private JLabel pointDie2JLabel;

   // JLabels to display the die images from the rolls of the dice
   private JLabel die1JLabel;
   private JLabel die2JLabel;

   // JButtons to allow user to interact with game
   private JButton playJButton;
   private JButton rollJButton;

   // JLabel and JTextField to show results of game
   private JLabel resultJLabel;
   private JTextField resultJTextField;

   // constants representing winning dice rolls
   private final int LUCKY_SEVEN = 7;
   private final int YO_LEVEN = 11;

   // constants representing losing dice rolls
   private final int SNAKE_EYES = 2;
   private final int TREY = 3;
   private final int BOX_CARS = 12;
   private final int CRAPS = 7;

   // file name and directory constants
   private final String FILE_PREFIX = "Images/die";
   private final String FILE_SUFFIX = ".png";

   // instance variables
   private int myPoint = 0;
   private Random randomObject = new Random();
   
   // no-argument constructor
   public CrapsGame()
   {
      createUserInterface();
   }
   
   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null );

      // set up pointDiceTitledBorder for use with pointDiceJPanel
      pointDiceTitledBorder = new TitledBorder( "Point" );
      
      // set up pointDiceJPanel
      pointDiceJPanel = new JPanel();
      pointDiceJPanel.setBounds( 16, 16, 200, 116 );
      pointDiceJPanel.setLayout( null );
      pointDiceJPanel.setBorder( pointDiceTitledBorder );
      contentPane.add( pointDiceJPanel );
      
      // set up pointDie1JLabel
      pointDie1JLabel = new JLabel();
      pointDie1JLabel.setBounds( 24, 34, 64, 56 );
      pointDiceJPanel.add( pointDie1JLabel );
      
      // set up pointDie2JLabel
      pointDie2JLabel = new JLabel();
      pointDie2JLabel.setBounds( 120, 34, 64, 56 );
      pointDiceJPanel.add( pointDie2JLabel );
      
      // set up die1JLabel
      die1JLabel = new JLabel();
      die1JLabel.setBounds( 40, 150, 64, 64 );
      contentPane.add( die1JLabel );
      
      // set up die2JLabel
      die2JLabel = new JLabel();
      die2JLabel.setBounds( 136, 150, 64, 56 );
      contentPane.add( die2JLabel );
      
      // set up playJButton
      playJButton = new JButton();
      playJButton.setBounds( 232, 16, 88, 23 );
      playJButton.setText( "Play" );
      contentPane.add( playJButton );
      playJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when playJButton is clicked
             public void actionPerformed ( ActionEvent event )
             {
                playJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener      
      
      // set up rollJButton
      rollJButton = new JButton();
      rollJButton.setBounds( 232, 56, 88, 23 );
      rollJButton.setText( "Roll" );
      rollJButton.setEnabled( false );
      contentPane.add( rollJButton );
      rollJButton.addActionListener(
            
         new ActionListener() // anonymous inner class
         {
            // event handler called when rollJButton is clicked
            public void actionPerformed ( ActionEvent event )
            {
               rollJButtonActionPerformed( event );
            }
         
         } // end anonymous inner class

      ); // end call to addActionListener

      // set up resultJLabel
      resultJLabel = new JLabel();
      resultJLabel.setBounds( 232, 90, 48, 16 );
      resultJLabel.setText( "Result:" );
      contentPane.add( resultJLabel );
      
      // set up resultJTextField
      resultJTextField = new JTextField();
      resultJTextField.setBounds( 232, 106, 88, 24 );
      resultJTextField.setHorizontalAlignment( JTextField.CENTER );
      resultJTextField.setEditable( false );
      contentPane.add( resultJTextField );
      
      // set properties of application's window
      setTitle( "Craps Game" ); // set title bar string
      setSize( 350, 250 );      // set window size
      setVisible( true );       // display window
      
   } // end method createUserInterface
   
   // start new game of craps
   private void playJButtonActionPerformed( ActionEvent event )
   {
      // clear point icons
      pointDie1JLabel.setIcon( null );
      pointDie2JLabel.setIcon( null );

      // reset title of border
      pointDiceTitledBorder.setTitle( "Point" );
      pointDiceJPanel.repaint();

      int sumOfDice = rollDice(); // roll dice
      
      // check results of the first dice roll
      switch ( sumOfDice )
      {
         // win on first roll
         case LUCKY_SEVEN:
         case YO_LEVEN:
            resultJTextField.setText( "You win!!!" );
            break;
            
         // lose on first roll
         case SNAKE_EYES:
         case TREY:
         case BOX_CARS:
            resultJTextField.setText( "Sorry, you lose." );
            break;
         
         // remember point in instance variable
         default:

            // set the point and output result
            myPoint = sumOfDice;
            resultJTextField.setText( "Roll again!" );

            // show the dice images
            pointDie1JLabel.setIcon( die1JLabel.getIcon() );
            pointDie2JLabel.setIcon( die2JLabel.getIcon() );

            // update the border title
            pointDiceTitledBorder.setTitle(
               "Point is " + sumOfDice );
            pointDiceJPanel.repaint();

            // change the state of the JButtons
            playJButton.setEnabled( false );
            rollJButton.setEnabled( true );
                     
      } // end switch statement
   
   } // end method playJButtonActionPerformed

   // continue the game
   private void rollJButtonActionPerformed( ActionEvent event )
   {
      int sumOfDice = rollDice();  // roll dice
         
      // determine outcome of roll, player matches point
      if ( sumOfDice == myPoint )
      {
         resultJTextField.setText( "You win!!!" );
         rollJButton.setEnabled( false );
         playJButton.setEnabled( true );
      }
      // determine outcome of roll, player loses
      else if ( sumOfDice == CRAPS )
      {
         resultJTextField.setText( "Sorry, you lose." );
         rollJButton.setEnabled( false );
         playJButton.setEnabled( true );
      }
      
   } // end method rollJButtonActionPerformed
   
   // generate random die rolls
   private int rollDice()
   {
      // generate random die values
      int die1 = 1 + randomObject.nextInt( 6 );
      int die2 = 1 + randomObject.nextInt( 6 );
      
      // display the dice images
      displayDie( die1JLabel, die1 );
      displayDie( die2JLabel, die2 );
      
      return die1 + die2; // return sum of dice values
      
   } // end method rollDice
   
   // displays the die image
   private void displayDie( JLabel picDieJLabel, int face )
   {
      ImageIcon image = 
         new ImageIcon( FILE_PREFIX + face + FILE_SUFFIX );

      // display die images in picDieJLabel      
      picDieJLabel.setIcon( image );

   } // end method displayDie
   
   // main method
   public static void main( String args[] )
   {
      CrapsGame application = new CrapsGame();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class CrapsGame
