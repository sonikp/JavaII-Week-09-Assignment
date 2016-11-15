// DrawControlApp.java
import java.awt.Color;
import javax.swing.JFrame;

/**
 * Java swing assignment. Week 07 Java II
 * Create a class called DrawImageControlPanel.  Modify the code presented in the Module 5 slides (also posted separately on the Resources page) 
 * such that this new JPanel is integrated as part of the application. You are integrating the new functionality, not replacing!
 * 
 * @author sonikp
 *
 */

public class TestCrapsApp
{
   public static void main( String args[] )
   {
      //JFrame frame = new TestCrapsControlFrame( "Assignment 8 Craps..." );
      JFrame frame = new TestCrapsNewFrame( "Assignment 8 Craps..." );
   }
}