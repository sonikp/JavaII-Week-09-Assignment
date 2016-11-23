import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tutorial extends JFrame
{	
	JPanel jp = new JPanel();
	JTextArea jt = new JTextArea(10,40);
	
	
	private JButton buttonSubmit;
	
	private JTextArea textArea;
	private JButton buttonClear;
	
	private JTextField fieldMessage;
	private JButton submitMessage;
	
	public Tutorial()
	{
		setTitle("Tutorial");
		setVisible(true);
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jp.add(jt);
		
		add(jp);
		
	}
	
	private void createView()
	{
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		JLabel label = new JLabel("Enter text");
		panel.add(label);
		
		buttonSubmit = new JButton("Submit");
		panel.add(buttonSubmit);
		
		fieldMessage = new JTextField(22);
		panel.add(fieldMessage);
		
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setPreferredSize(new Dimension(350,90));
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);
		
		buttonClear = new JButton("Clear Text Area");
		panel.add(buttonClear);
		
	}
	
	public static void main(String[] args)
	{
		Tutorial t = new Tutorial();
	}
	
}