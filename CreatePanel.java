package Stewart1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CreatePanel extends JPanel
{    
// add your instance variables including all the components used in this panel
 	  private Vector bankList;
 	  private JButton button1,BT1;
 	  private SelectPanel sPanel;
 	  private JPanel JPmain, JP1, JP2, JP3;
 	  private JTextArea TA1,TA2;
 	  private JTextField TF1,TF2;
 	  private JLabel JL1,JL2;
 	  
//create panel tab GUI pane
 	  public CreatePanel(Vector bankList, SelectPanel sPanel)
 	  {
    		this.bankList = bankList;//instantiating vector to class
   			this.sPanel = sPanel;
   			//creating new panel objects
   			JPmain = new JPanel();
   			JP1 = new JPanel();
   			JP2 = new JPanel();
   			
   			//instantiating new textfield and text area objects
   			TA1 = new JTextArea("No Bank");
   			TF1 = new JTextField(2);
   			
   			//creating new button and adding a listener method to it
   			button1 = new JButton("Add a Bank");
   			button1.addActionListener(new ButtonListener());
   			
   			//J Labels for error message set color to red
   			JL1 = new JLabel("Enter a Bank Name");
   			JL2 = new JLabel("");
   			JL2.setForeground(Color.RED);
   			
   			//instantiating grid layout for panels
   			JPmain.setLayout(new GridLayout(1,2));
   			JP1.setLayout(new GridLayout(1,2));	
   			JP2.setLayout(new GridLayout(3,1));
   		
   			//adding JPmain panel to be displayed under create panel tab
   			this.add(JPmain);//instantiating main panel to class
   			
   			//adding componets to panels to get GUI looking like teachers example
   			
   			JP1.add(JL1);//JP1
   			JP1.add(TF1);
   			
   			
   			JP2.add(JL2);//JP2
   			JP2.add(JP1);
   			JP2.add(button1);
   			
   			
   			
   			JPmain.add(JP2);//JPmain
   			JPmain.add(TA1);
   			JPmain.setPreferredSize(new Dimension(500,180));
   			}

 //class to control actions of buttons 		
 	  private class ButtonListener implements ActionListener
  		{
 		  //method that controls the actions of button and checks for errors and delivers
 		  //approite response to user
  	  			public void actionPerformed(ActionEvent event)
     			{  	  	
  	  				//create new boolean var. and set to false
  	  				Boolean Dupe = false;
     				
  	  				//nexted IF statement thats going to check for duplicate, correct and no user input
  	  				//then give the aprroprite response
  	  				if(TF1.getText().equals("") )
     				{
     					JL2.setText("Please enter a Bank's name.");
     				}		
     				
     				else
     				{
     					for(int i = 0;i < bankList.size(); i++)//for loop checking vector list for = text 
     					{
     						if(bankList.get(i).equals(TF1.getText()))
     						Dupe = true;
     					}
     					if(Dupe)
     						JL2.setText("The bank already exists.");
     					else
     					{
     						bankList.add(TF1.getText());
     						JL2.setText("The bank name is added.");
     					}
     				}	
  	  				TA1.setText("");
     				if(bankList.isEmpty())
     					TA1.setText("No Bank");//if statement handling no text when button is pushed
     				else
     				{
     					for(int i = 0;i < bankList.size(); i++)			//adding bank to list at top of list 
  	  					TA1.setText(TA1.getText()+bankList.get(i)+"\n");
  	  				}
  	  					TF1.setText("");
  	  				//refresh list	
  	  				sPanel.updateBankList();
  	  					
    				  //when the button is pushed, the bank
    			     //should be added to the list. This is also where
    			     //errors are handled.

    			 } //end of actionPerformed method
  			} //end of ButtonListener class

} //end of CreatePanel class