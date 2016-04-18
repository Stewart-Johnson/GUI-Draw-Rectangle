package Stewart;
// Assignment #: 7
//         Name: Stewart Johnson
//    StudentID: 1206027923
//      Lecture: TTH 3-4:15
//  Description: The Assignment 7 creates a WholePanel that is
//  an extension of JPanel, add it to its content, and set
//  a size for the applet.


import javax.swing.*;

public class main extends JApplet
{

 public void init()
  {
    // create a WholePanel object and add it to the applet
    wholePanel wholePanel = new wholePanel();
    getContentPane().add(wholePanel);

    //set applet size to 400 X 400
    setSize (400, 400);
  }

}
