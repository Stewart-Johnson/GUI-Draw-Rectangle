package Stewart1;

//Name: Stewart Johnson
//Description: The Assignment 6 class creates a Tabbed Pane with
//two tabs, one for adding Banks and one for
//Selecting a bank, and adds it as its Applet content
//and also sets its size.

import javax.swing.*;
import java.util.*;

public class mainFile extends JApplet
{
private int APPLET_WIDTH = 500, APPLET_HEIGHT = 200;

private JTabbedPane tPane;
private CreatePanel createPanel;
private SelectPanel selectPanel;
private Vector bankList;

//The method init initializes the Applet with a Pane with two tabs
public void init()
{
	 //list of banks to be used in both panel
	  bankList = new Vector();

	 //select panel uses the list of banks
    selectPanel = new SelectPanel(bankList);
    //bank list is passed to CraetPanel constructor
	 createPanel = new CreatePanel(bankList, selectPanel);

	//create a tabbed pane with two tabs
	tPane = new JTabbedPane();
	tPane.addTab("Add Banks Name", createPanel);
	tPane.addTab("Select Bank", selectPanel);

	getContentPane().add(tPane);
	setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
}//end init method
}

