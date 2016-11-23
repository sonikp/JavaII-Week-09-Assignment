import javax.swing.JFrame;
import javax.swing.JTextArea;

public class testJTextArea{
   @SuppressWarnings("deprecation")
public static void main(String args[])
{
       JFrame aFrame = new JFrame();       
        
       JTextArea jta = new JTextArea(10,10);
       TextAreaOutputStream taos = TextAreaOutputStream.getInstance(jta);
       aFrame.getContentPane().add(jta);
       aFrame.pack();
       aFrame.show();
        
       System.out.println("Test 1");       
   }
}


/*
https://coderanch.com/t/276993/java/Reassigning-System-display-JTextArea
https://coderanch.com/t/555193/java/Redirect-System-println-JTextArea-JTextPane

http://www.johnloomis.org/ece538/notes/TextFile/TextDemo_java.html


*/