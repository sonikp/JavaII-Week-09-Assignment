import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JTextAreaTest {
  public static void main(String[] args) 
  {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("JTextArea Test");
    frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    String text = "A JTextArea object represents a multiline area for displaying text. "
        + "You can change the number of lines that can be displayed at a time, "
        + "as well as the number of columns. You can wrap lines and words too. "
        + "You can also put your JTextArea in a JScrollPane to make it scrollable.";
    
    JTextArea textAreal = new JTextArea(text, 5, 10);
    textAreal.setPreferredSize(new Dimension(100, 100));
    JTextArea textArea2 = new JTextArea(text, 5, 10);
    textArea2.setPreferredSize(new Dimension(100, 100));
    JScrollPane scrollPane = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    textAreal.setLineWrap(true);
    textArea2.setLineWrap(true);
    frame.add(textAreal);
    frame.add(scrollPane);
    frame.pack();
    frame.setVisible(true);
  }
}