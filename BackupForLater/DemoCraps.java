

    // Arman Majumder
    // Game of Craps GUI
    // Requires Craps Data Class <CrapsData.java>  Included in bottom
       import javax.swing.*;
       import java.awt.*;
       import java.awt.event.*;
       import java.util.*;
       import java.io.*;
       import java.util.Random;
       
        @SuppressWarnings("serial")
		public class DemoCraps extends JFrame
       {
          private CrapsData craps = new CrapsData();
          
          private JLabel moneyLabel = new JLabel("Total Money");
          private JLabel betLabel = new JLabel("Bet Amount");
          private JTextField moneyField = new JTextField("$$$");
          private JTextField betField = new JTextField("$$$");
          private JButton rollButton = new JButton("ROLL");
          
           public DemoCraps()
          {
             JPanel dataPanel = new JPanel(new GridLayout(2, 2, 12, 6));
             dataPanel.add(moneyLabel);
             dataPanel.add(betLabel);
             dataPanel.add(moneyField);
             dataPanel.add(betField);
          
             JPanel buttonPanel = new JPanel();
             buttonPanel.add(rollButton);
             Container container = getContentPane();
             container.add(dataPanel, BorderLayout.CENTER);
             container.add(buttonPanel, BorderLayout.SOUTH);
             rollButton.addActionListener(new RollListener());
          }
       	
           private class RollListener implements ActionListener
          {
              public void actionPerformed(ActionEvent e)
             {
                int play = 0;
                int win = 0;
                int loss = 0;
                int total = 0;
                boolean playAgain = true;
                   
                while (playAgain && play==0)
                {       
                   try
                   {
                      String input = moneyField.getText();
                      double money = Double.parseDouble(input);
                      craps.setMoney(money);
                   
                      String input2 = betField.getText();
                      double bet = Double.parseDouble(input2);
                      craps.setBet(bet);
                              
                      if(bet > money)
                      {
                         JOptionPane.showMessageDialog(null, "Bet is greater than total Money", "ERROR", JOptionPane.ERROR_MESSAGE);         
                         System.exit(0);
                      }
                   
                      for (int count = 1; count>-1 ; count++)
                      {
                         Random generator = new Random();
                         int dice = generator.nextInt(12) + 2;
                      
                         if(dice == 7 || dice == 11)
                         {
                            win++;
                            money += bet;
                            JOptionPane.showMessageDialog(null, "WIN!!! \n" + "You rolled a " + dice); 
                            play++; 	
                            moneyField.setText("" + money);   
                            break;
                         }
                            
                         else if(dice == 2 || dice == 3 || dice == 12)
                         {
                            loss++;
                            money -= bet;
                            JOptionPane.showMessageDialog(null, "Loss \n" + "You rolled a " + dice); 
                            play++;
                            moneyField.setText("" + money);
                            if(money == 0)
                               JOptionPane.showMessageDialog(null, "Out of Money", "ERROR", JOptionPane.WARNING_MESSAGE);  
                            break; 	
                         }	
                         
                         else 
                         {  
                            JOptionPane.showMessageDialog(null, "Roll Again \n" + "You rolled a " + dice); 
                           
                            int dice2 = generator.nextInt(12) + 2;
                            
                            if (dice2 == dice)
                            {
                               win++;
                               money += bet;
                               JOptionPane.showMessageDialog(null, "WIN!!! \n" + "You rolled a " + dice2); 
                               play++;
                               moneyField.setText("" + money);
                               count++;
                               break;
                            }
                               
                            else if (dice2 == 7)
                            {
                               loss++;
                               money -= bet;
                               JOptionPane.showMessageDialog(null, "Loss \n" + "You rolled a " + dice2); 
                               play++;
                               moneyField.setText("" + money);
                               if(money < bet)
                                  JOptionPane.showMessageDialog(null, "Out of Money", "ERROR", JOptionPane.WARNING_MESSAGE);  
                               count++;
                               break;
                            }
                            
                            else
                            {
                            
                            }                     	
                         
                            int option = JOptionPane.showConfirmDialog(null, "Are you ready to quit?", "select an option", JOptionPane.YES_NO_OPTION);
                         
                            if (option == 0)
                            {
                               JOptionPane.showMessageDialog(null, "High Roller Status\n" + "Total Money : $" + money);
                               System.exit(0);
                            }
                            
                            else
                            {
                               play = 0;
                               break;
                            }
                         }
                         break;
                      }
                   }
                       catch(Exception ex)
                      {
                         JOptionPane.showMessageDialog(null, "ERROR: Input Syntax", "ERROR", JOptionPane.ERROR_MESSAGE);         
                         break;
                      }
                }   
             }
          }
           public static void main(String [] args)
          {
             DemoCraps theGUI = new DemoCraps();
             theGUI.setTitle("Craps Game");
             theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             theGUI.pack();
             theGUI.setVisible(true);
          }
       }
    
