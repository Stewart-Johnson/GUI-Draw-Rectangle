package Stewart1;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

//Selected panel class 
public class SelectPanel extends JPanel
{      //declare instance variables and components
       private Vector<String> bankList,selList;
       private JList cList,sList;
       private JButton Add,Remove;
       private SelectPanel sPanel;
       private JPanel SBmain, SB1, SB2, SB3,SB4,SB5;
       private JScrollPane AB1,AB2;
      private JLabel AB3;
       private JTextField TF1,TF2;
       private int count;
 
       //Selected panel tab of the Pane 
       public SelectPanel(Vector<String> bankList)
        {
 		    //instantiate vector banklist
    	   	this.bankList = bankList;
 		     
    	   	count = 0;//set var. int to 0
 		     
    	   	 selList = new Vector<String>();//instantiate vector
 		     cList = new JList(bankList);//instantiate JList and set Selection mode
			 cList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			 sList = new JList(selList);//instantiate Jlist
			 //create main Jpanel and sun panels
			 SBmain = new JPanel();
	   			SB1 = new JPanel();
	   			SB2 = new JPanel();
	   			SB3 = new JPanel();
	   			SB4 = new JPanel(); 
	   			SB5 = new JPanel();
	   			
	   			//instantiating class componets and text
	   			AB1 = new JScrollPane(cList);
	   			AB1.setColumnHeaderView(new JLabel("Available Bank(s)"));
	   			AB2 = new JScrollPane(sList);
	   			AB2.setColumnHeaderView(new JLabel("Selected Bank(s)"));
	   			AB3 = new JLabel();
	   			AB3.setText("The number of selected banks: "+ count);
	   			AB3.setVerticalAlignment(1);
	   			
	   			//creating buttons and calling button listener method for them
	   			Add = new JButton("Add");
	   			Add.addActionListener(new ButtonListener());
	   			Remove = new JButton("Remove");
	   			Remove.addActionListener(new ButtonListener());
	   			
	   			//setting grip layout for all class Jpanels
	   			SBmain.setLayout(new GridLayout(1,1));
	   			SB1.setLayout(new GridLayout(2,1));	
	   			SB2.setLayout(new GridLayout(4,4));
	   			SB3.setLayout(new GridLayout(2,1));
	   			SB4.setLayout(new GridLayout(1,3));
	   			SB5.setLayout(new GridLayout(1,1));
	   			this.add(SBmain);
	   			
	   			//adding class componets to jpanels
	   			SB1.add(AB1);
	   			SB1.add(AB3);
	   			SB2.add(Add);
	   			SB2.add(Remove);
	   			
	   			SB3.add(AB2);
	   			//anding sub panels to new panel
	   			SB4.add(SB1);
	   			SB4.add(SB2);
	   			SB4.add(SB3);
	   			
	   			
	   			SBmain.add(SB4);//main panel format
	   			
	   			this.add(SBmain);//instantiating main panel	
			//setting main panels size
	   	     SBmain.setPreferredSize (new Dimension(600, 400));

        	}  
 		
 		//This method can refresh the appearance of the list of banks
		//by calling updateUI() method for the JList.
		//It can be called from the CreatePanel class whenever a new bank name
 	     //is added to the vector and the JList appearence needs to be refreshed.
 		public void updateBankList()
 	    {
			cList.setListData(bankList);

        }

 		//instantiating class that will control button actions
 		private class ButtonListener implements ActionListener
 		{
 			//this method will add a bank to a jlist if the add button is selected
 			//if the remove button is selected it will remove the selected bsnk from the jlist
 			// it will also keep track of # of banks added to jlist and subtracted from the jlist
 			public void actionPerformed(ActionEvent event)
 			      {
            			Object action = event.getSource();
            			if(action == Add)
            			{ 
            				selList.add(bankList.get(cList.getSelectedIndex()));
            				count ++;
            			}
            			else if(action == Remove)
            				{
            				selList.remove((sList.getSelectedIndex()));
            				count --;
            				}
            			
            			sList.updateUI();
        	   			AB3.setText("The number of selected banks: "+ count);

            			
            		}
        } //end of ButtonListener class

} //end of SelectPanel class
