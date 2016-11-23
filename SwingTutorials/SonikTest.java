
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class SonikTest
{
	public static void main(String[] args)
	{

		
		// Creating instance of JFrame
		JFrame myFrame = new JFrame("Test JTextArea JFrame");
		myFrame.setSize(350,200);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Creating panel
		JPanel myPanel = new JPanel();
		// add panel to frame
		myFrame.add(myPanel);
		placeComponents(myPanel);
		
		// needs to be last item
		myFrame.setVisible(true);

	}
	
	public static void placeComponents(JPanel myPanel)
	{
		
		// define layout
		myPanel.setLayout(null);
		
		
		// create JLabel
		JLabel textLabelOne = new JLabel("Field1");
		
		// specifies location and size of component
		textLabelOne.setBounds(10,20,80,25);
		myPanel.add(textLabelOne);
		
		// creating a user field
		JTextField textFieldOne = new JTextField(20);
		textFieldOne.setBounds(100,20,165,25);
		myPanel.add(textFieldOne);
		
		JLabel textLabelTwo = new JLabel("Field2");
		textLabelTwo.setBounds(10,50,80,25);	// // 100,20,165,25
		myPanel.add(textLabelTwo);
		
		// creating a password field		
		JTextField textFieldTwo = new JTextField(20);
		textFieldTwo.setBounds(100,50,165,25);
		myPanel.add(textFieldTwo);
		
		
		 // Creating login button
        JButton rollButton = new JButton("Roll");
        rollButton.setBounds(10,80,80,25);
        myPanel.add(rollButton);
        rollButton.addActionListener(
        new ActionListener() // anonymous inner class
        {
           // event handler called when rollJButton is clicked
           public void actionPerformed ( ActionEvent event )
           {
        	   System.out.println("message on click");
           		
           }
        
        } // end anonymous inner class

        ); // end call to addActionListener
		
        JTextArea myTextArea = new JTextArea(10,40);		//24, 80 
        myPanel.add(myTextArea);
	}
	
}