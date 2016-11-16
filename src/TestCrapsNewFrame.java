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
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class TestCrapsNewFrame extends JFrame
{ 
  private JPanel mainPanel;
  private final JPanel calcPanel;
  private JSlider widthJSlider;
  private JTextField xValTextField;
  private JTextField yValTextField;
  private JLabel calcJLabel;
  private JButton calcJButton;
  
  private String xStr;
  private String yStr;
  
  // test
  private final JPanel crapsPanel;
  private JLabel crapsJLabel;
  private JButton crapsJButton;
  private JButton rollJButton;
  private JButton quitButton;
  private JLabel dice1Label = new JLabel("Dice Roll One:");
  private JTextField dice1Field = new JTextField( 6 );
  private JLabel dice2Label = new JLabel("Dice Roll Two:");
  private JTextField dice2Field = new JTextField( 6 );
  private JLabel sumLabel = new JLabel("Sum");
  private JTextField sumField = new JTextField( 6 );


  

  
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
    
    
    calcPanel = new JPanel( new FlowLayout() );    
    calcPanel.setSize(200, 200);    

    final DrawControlPanel drawPanel = new DrawControlPanel();
    drawPanel.setSize(200, 200);    
    
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
}  