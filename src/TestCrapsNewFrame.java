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
  private JLabel dice1Label = new JLabel("first dice");
  private JTextField dice1Field = new JTextField("1");
  private JLabel dice2Label = new JLabel("second dice");
  private JTextField dice2Field = new JTextField("2");
  private JLabel sumLabel = new JLabel("Sum");
  private JTextField sumField = new JTextField("1 + 2");


  

  
  public TestCrapsNewFrame(String title)
  {
    super( title );
    mainPanel = new JPanel( new BorderLayout() );
    mainPanel.setSize(200, 250);  
    // set in center of screen
    //setLocationRelativeTo(null);
    
    // Craps Panel
    crapsPanel = new JPanel( new FlowLayout() );    // original
    crapsPanel.setSize(400, 400);
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
    
    final JMenu colorMenu = new JMenu( "Color" );
    colorMenu.setMnemonic( 'C' );
    
    
    // ---START---------test panel-----------------
    JMenuItem crapsPanelItem = new JMenuItem( "Craps Panel" );
    crapsPanelItem.setMnemonic( 'C' );
    fileMenu.add( crapsPanelItem );
    crapsPanelItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
            bar.remove( colorMenu );
            mainPanel.remove( drawPanel );
            mainPanel.remove( widthJSlider );
            
//            sumLabel = new JLabel("Total Money");
//            sumField = new JTextField("$$$");
            gameCraps.rollDice();
            
            crapsPanel.add(dice1Label);

            crapsPanel.add(dice2Label);
            
//            xValTextField.setText("");
//            yValTextField.setText("");
//            crapsJLabel.setText( "" );
            mainPanel.add(crapsPanel, BorderLayout.CENTER );
            validate();
            repaint();
        }
      }
    );
    
//    testPanel.add( rollJButton );
    
    crapsJLabel = new JLabel();
    crapsPanel.add( crapsJLabel, BorderLayout.CENTER );
    
    crapsPanel.add(sumLabel);
    crapsPanel.add(sumField);
    

    
    
    // input field1
    xValTextField = new JTextField( 3 );
    xValTextField.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          xStr = event.getActionCommand();
        }
      }
    );                                                                       

    crapsPanel.add( xValTextField );
    
    // input field2
    yValTextField = new JTextField( 3 );
    yValTextField.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          yStr = event.getActionCommand();
        }
      }
    );     

    crapsPanel.add( yValTextField );
    

    
    // calculate at the push of a button
    rollJButton = new JButton( "Roll" );   
    rollJButton.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
        	int sum = gameCraps.rollDice();
        	crapsJLabel.setText("Sum is " + sum);
//        	JOptionPane.showMessageDialog( TestCrapsNewFrame.this, "Press this button!", "Invalid Input", JOptionPane.ERROR_MESSAGE );         
        	
        	
          
        	
//        	try {       
//            int x = Integer.parseInt( xStr );
//            int y = Integer.parseInt( yStr );
//            int result = x + y;
//            crapsJLabel.setText(xStr + " + " + yStr + " = " + result);
//          }
//          catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog( TestCrapsNewFrame.this, "You must enter a valid number and then <ENTER> for each textbox!", "Invalid Input", JOptionPane.ERROR_MESSAGE );
//            e.printStackTrace();
//          }
        }
      }
    );
    
    // calculate at the push of a button
    crapsJButton = new JButton( "Crapulate" );   
    crapsJButton.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
        	
          
        	
//        	try {       
//            int x = Integer.parseInt( xStr );
//            int y = Integer.parseInt( yStr );
//            int result = x + y;
//            crapsJLabel.setText(xStr + " + " + yStr + " = " + result);
//          }
//          catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog( TestCrapsNewFrame.this, "You must enter a valid number and then <ENTER> for each textbox!", "Invalid Input", JOptionPane.ERROR_MESSAGE );
//            e.printStackTrace();
//          }
        }
      }
    );
    
    
    crapsPanel.add( crapsJButton );
    crapsPanel.add( rollJButton );
    
    crapsJLabel = new JLabel();
    crapsPanel.add( crapsJLabel, BorderLayout.CENTER );
    // ---END---------test panel-----------------
    
    
    
 //////////////////backup of Test Panel code/////////////////////////////////////////////////////////////////////////////////////////////////// 
 /*
    
    
    // ---START---------test panel-----------------
    JMenuItem testPanelItem = new JMenuItem( "Test Panel" );
    testPanelItem.setMnemonic( 'C' );
    fileMenu.add( testPanelItem );
    testPanelItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
            bar.remove( colorMenu );
            mainPanel.remove( drawPanel );
            mainPanel.remove( widthJSlider );
            xValTextField.setText("");
            yValTextField.setText("");
            calcJLabel.setText( "" );
            mainPanel.add(testPanel, BorderLayout.CENTER );
            validate();
            repaint();
        }
      }
    );
    
    // input field1
    xValTextField = new JTextField( 3 );
    xValTextField.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          xStr = event.getActionCommand();
        }
      }
    );                                                                       

    testPanel.add( xValTextField );
    
    // input field2
    yValTextField = new JTextField( 3 );
    yValTextField.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          yStr = event.getActionCommand();
        }
      }
    );     

    testPanel.add( yValTextField );
    
    // calculate at the push of a button
    testJButton = new JButton( "Crapulate" );   
    testJButton.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          try {       
            int x = Integer.parseInt( xStr );
            int y = Integer.parseInt( yStr );
            int result = x + y;
            testJLabel.setText(xStr + " + " + yStr + " = " + result);
          }
          catch (NumberFormatException e) {
            JOptionPane.showMessageDialog( TestCrapsNewFrame.this, "You must enter a valid number and then <ENTER> for each textbox!", "Invalid Input", JOptionPane.ERROR_MESSAGE );
            e.printStackTrace();
          }
        }
      }
    );
    
    
    testPanel.add( testJButton );
    
    testJLabel = new JLabel();
    testPanel.add( testJLabel, BorderLayout.CENTER );
    // ---END---------test panel-----------------
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
*/
 //////////////////unused code below here///////////////////////////////////////////////////////////////////////////////////////////////////   
    ///////JUNK//////////////
    /*
    
        JButton quitButton = new JButton("Quit");
    quitButton.setBounds(0, 0, 20, 20);
    quitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
       }
    });
    mainPanel.add(quitButton);
    
    
    
    
    
    
    
    
    
    
    
    
    */
    
    /*
    // copy of clean test panel
    JMenuItem testPanelItem = new JMenuItem( "Test Panel" );
    testPanelItem.setMnemonic( 'C' );
    fileMenu.add( testPanelItem );
    testPanelItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          bar.remove( colorMenu );
          mainPanel.remove( drawPanel );
          mainPanel.remove( widthJSlider );
          xValTextField.setText("");
          yValTextField.setText("");
          calcJLabel.setText( "" );
          mainPanel.add( calcPanel, BorderLayout.CENTER );
          validate();
          repaint();
        }
      }
    );
    */
    
    
    
    JMenuItem aboutItem = new JMenuItem( "About..." );
    aboutItem.setMnemonic( 'A' );
    fileMenu.add( aboutItem );
    aboutItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
          JOptionPane.showMessageDialog( TestCrapsNewFrame.this,
                                      "This application provides enhanced\n control over multimedia projects.",
                                      "About", JOptionPane.PLAIN_MESSAGE );
        }
     }  // End of anonymous inner class
    );
    
  

    
    JMenuItem redItem = new JMenuItem( "Red" );
    colorMenu.add( redItem );
    redItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
          drawPanel.setFillColor( Color.RED );
          repaint();
        }
     }  // End of anonymous inner class
    );
    
    JMenuItem blueItem = new JMenuItem( "Blue" );
    colorMenu.add( blueItem );
    blueItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
          drawPanel.setFillColor( Color.BLUE );
          repaint();
        }
     }  // End of anonymous inner class
    );
    
    JMenuItem magentaItem = new JMenuItem( "Magenta" );
    colorMenu.add( magentaItem );
    magentaItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
          drawPanel.setFillColor( Color.MAGENTA );
          repaint();
        }
     }  // End of anonymous inner class
    );
    
    JMenuItem cyanItem = new JMenuItem( "Cyan" );
    colorMenu.add( cyanItem );
    cyanItem.addActionListener(
      new ActionListener()  // Beginning of anonymous inner class
      {
        public void actionPerformed( ActionEvent event )
        {
          drawPanel.setFillColor( Color.CYAN );
          repaint();
        }
     }  // End of anonymous inner class
    );
    

    
    
    
    JMenuItem calcPanelItem = new JMenuItem( "Calculate" );
    calcPanelItem.setMnemonic( 'C' );
    fileMenu.add( calcPanelItem );
    calcPanelItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          bar.remove( colorMenu );
          mainPanel.remove( drawPanel );
          mainPanel.remove( widthJSlider );
          xValTextField.setText("");
          yValTextField.setText("");
          calcJLabel.setText( "" );
          mainPanel.add( calcPanel, BorderLayout.CENTER );
          validate();
          repaint();
        }
      }
    );
    
    JMenuItem drawPanelItem = new JMenuItem( "DrawPanel" );
    drawPanelItem.setMnemonic( 'D' );
    fileMenu.add( drawPanelItem );
    drawPanelItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          bar.add( colorMenu );         
          mainPanel.remove( calcPanel );
          drawPanel.setBackground( Color.WHITE );
          mainPanel.add( drawPanel, BorderLayout.CENTER );
          mainPanel.add( widthJSlider, BorderLayout.SOUTH );          
          validate();
          repaint();
        }
      }
    );
     
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
    
    widthJSlider = new JSlider( SwingConstants.HORIZONTAL, 0, 100, drawPanel.getOvalWidth() );
    widthJSlider.setMajorTickSpacing( 10 );
    widthJSlider.setPaintTicks( true );
    
    widthJSlider.addChangeListener(
      new ChangeListener()
      {
        public void stateChanged( ChangeEvent e )
        {
          drawPanel.setOvalWidth( widthJSlider.getValue() );
          repaint();
        }
      }
    );
        
    xValTextField = new JTextField( 3 );
    xValTextField.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          xStr = event.getActionCommand();
        }
      }
    );                                                                       

    calcPanel.add( xValTextField );

    yValTextField = new JTextField( 3 );
    yValTextField.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          yStr = event.getActionCommand();
        }
      }
    );     

    calcPanel.add( yValTextField );
    
    calcJButton = new JButton( "Calculate" );   
    calcJButton.addActionListener(
      new ActionListener()
      {
        public void actionPerformed( ActionEvent event )
        {
          try {       
            int x = Integer.parseInt( xStr );
            int y = Integer.parseInt( yStr );
            int result = x + y;
            calcJLabel.setText(xStr + " + " + yStr + " = " + result);
          }
          catch (NumberFormatException e) {
            JOptionPane.showMessageDialog( TestCrapsNewFrame.this, "You must enter a valid number and then <ENTER> for each textbox!", "Invalid Input", JOptionPane.ERROR_MESSAGE );
            e.printStackTrace();
          }
        }
      }
    );
    calcPanel.add( calcJButton );
    
    calcJLabel = new JLabel();
    calcPanel.add( calcJLabel, BorderLayout.CENTER );
    

    
    
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    setSize( 200, 250 );
    setVisible( true );
    validate();
  }
}  