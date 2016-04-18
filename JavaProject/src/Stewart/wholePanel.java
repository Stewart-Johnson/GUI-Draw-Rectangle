package Stewart;

//Name:Stewart Johnson
// 
//  
// Description: The whole panel creates components for the whole panel
// of this applet. It also contains CanvasPanel, ButtonListener, ColorListener,
// and PointListner classes.

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
//creates new panel for applet
public class wholePanel extends JPanel
{
	//declaring private var.
   private Color currentColor;
   private Canvas canvas;
   private JPanel primary, buttonPanel, leftPanel;
   private JButton erase, undo;
   private ArrayList rectList, tempList;
   private JRadioButton[] colorRButtons;
   private Color[] colors;
   private int x1, y1, x2, y2, x3, y3;
   private boolean mouseDragged = false;
   private Rect rect1,rect2,rect3;
   private boolean erased;

   //Constructor to instantiate components
   public wholePanel()
   {
	  //default color to draw rectangles is black
      currentColor  = Color.black;
	  rectList = new ArrayList();

	  
      //create buttons
	  erase = new JButton("Erase");
	  erase.addActionListener(new ButtonListener());
	  
	  undo = new JButton("Undo");
	  undo.addActionListener(new ButtonListener());
	  
	  






      //create radio buttons for 5 colors
      //black will be chosen by default
	  colorRButtons = new JRadioButton[5];
	  colorRButtons[0] = new JRadioButton("black", true);
	  colorRButtons[1] = new JRadioButton("red");
	  colorRButtons[2] = new JRadioButton("blue");
	  colorRButtons[3] = new JRadioButton("green");
	  colorRButtons[4] = new JRadioButton("orange");
	  

      //store 5 colors in an array
	  colors = new Color[5];
	  colors[0] = Color.black;
	  colors[1] = Color.red;
	  colors[2] = Color.blue;
	  colors[3] = Color.green;
	  colors[4] = Color.orange;
 
      //group radio buttons so that when one is selected,
      //others will be unselected.
	  ButtonGroup group = new ButtonGroup();
	  for (int i=0; i<colorRButtons.length; i++)
	    group.add(colorRButtons[i]);

      //add ColorListener to radio buttons
      ColorListener listener = new ColorListener();
      for (int i=0; i<colorRButtons.length; i++)
        colorRButtons[i].addActionListener(listener);

      //primary panel contains all radiobuttons
      primary = new JPanel(new GridLayout(5,1));
      for (int i=0; i<colorRButtons.length; i++)
        primary.add(colorRButtons[i]);
      //instantiating button panel to hold primary panel and erase and undo buttons
      buttonPanel = new JPanel(new GridLayout(3,1));
      buttonPanel.add(primary);
      buttonPanel.add(erase);
      buttonPanel.add(undo);
     // leftPanel = new JPanel(new GridLayout(1,1));
    //  leftPanel.add(buttonPanel);

      //canvas panel is where rectangles will be drawn, thus
      //it will be listening to a mouse.
      canvas = new Canvas();
      canvas.setBackground(Color.white);
      canvas.addMouseListener(new PointListener());
      canvas.addMouseMotionListener(new PointListener());

      JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, canvas);
      
	  setLayout(new BorderLayout());
	//sp.add(buttonPanel);
	
	 	
	 	this.add(sp);
    }

   //ButtonListener defined actions to take in case "Create",
   //"Undo", or "Erase" is chosed.
   private class ButtonListener implements ActionListener
    {
      public void actionPerformed (ActionEvent event)//button pushed action event method
      {
    	  Object action = event.getSource();
    		
    	  if(action == erase)//if erased button is pushed create a huge white rect to cover canvas and add to array
    		{
    	    	 rect3 = new Rect(0,0,1000,1000,Color.WHITE);
    	    	 rectList.add(rect3);
    	    	 erased = true;
    	    	 repaint();
    		}
    	if(action == undo)	//if undo button is pressed and rectlist array is not empty remove last object entered in array
    	{
    		if(!rectList.isEmpty())
    			rectList.remove(rectList.size()-1);
    		repaint();
    	}








      }
   } // end of ButtonListener

   // listener class to set the color chosen by a user using
   // the radio buttons.
   private class ColorListener implements ActionListener
    {
	   //sets apropiate colors to jradio buttons
		public void actionPerformed(ActionEvent event)
		 {
		
            if (event.getSource() == colorRButtons[0])
             currentColor = colors[0];
            else if (event.getSource() == colorRButtons[1])
             currentColor = colors[1];
            else if (event.getSource() == colorRButtons[2])
             currentColor = colors[2];
            else if (event.getSource() == colorRButtons[3])
             currentColor = colors[3];
            else if (event.getSource() == colorRButtons[4])
             currentColor = colors[4];
	     }
    }


 //CanvasPanel is the panel where rectangles will be drawn
 private class Canvas extends JPanel
  {
     //this method draws all rectangles specified by a user
	 public void paintComponent(Graphics page)
      {
   	   super.paintComponent(page);

          //draw all rectangles
		  for (int i=0; i < rectList.size(); i++)
	   	    {
		      ((Rect) rectList.get(i)).draw(page);
		    }

          //draw an outline of the rectangle that is currently being drawn.
          if (mouseDragged == true)
           {
			page.setColor(currentColor);
			//Assume that a user will move a mouse only to left and down from
			//the first point that was pushed.
			page.drawRect(x1, y1, x3-x1, y3-y1);
	       }

	  }
    } //end of CanvasPanel class

   // listener class that listens to the mouse
   public class PointListener implements MouseListener, MouseMotionListener
    {
	 //in case that a user presses using a mouse,
	 //record the point where it was pressed.
     public void mousePressed (MouseEvent event)
      {
    	//after "create" button is pushed.
    	 Point prd = event.getPoint();//gets point where mouse is pressed and sets each point to a var.
    	  x1 = prd.x;
    	  y1 = prd.y; 
    	 if(erased)//if the boolean erased is true clear rect array list and set erased to false
    		 rectList.clear();
    		 erased = false;
			//rect(10, 10, 10, 10);





      }

     //mouseReleased method takes the point where a mouse is released,
     //using the point and the pressed point to create a rectangle,
     //add it to the ArrayList "rectList", and call paintComponent method.
     public void mouseReleased (MouseEvent event)
      {
    	 Point rls = event.getPoint();//gets points where mouse is released and sets each point to a var. 
    	 x2 = rls.x;//rls.x = x2;
    	 y2 = rls.y; //= y2;
    	 rect1 = new Rect(x1,y1,x2-x1,y2-y1,currentColor);//instantiate rect object
    	 //rectList = new ArrayList();
    	 rectList.add(rect1);//adding rectangle drawn after button is released to rectlist array
    	 repaint();



	  }

     //mouseDragged method takes the point where a mouse is dragged
     //and call paintComponent method
	 public void mouseDragged(MouseEvent event)
	  {
		 Point drg = event.getPoint();//getiing points where mouse is dragged and creating sub rectangles until it is released
		 x3 = drg.x;// = x3;//assigning the points to var.
		 y3 = drg.y;// = y3;
		 rect2 = new Rect(x3,y3,x3-x1,y3-y1,currentColor);
	     repaint();
	  }

     public void mouseClicked (MouseEvent event) {}
     public void mouseEntered (MouseEvent event) {}
     public void mouseExited (MouseEvent event) {}
     public void mouseMoved(MouseEvent event) {}

    } // end of PointListener

} // end of Whole Panel Class
