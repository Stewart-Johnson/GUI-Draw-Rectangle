package Stewart;


//Name:Stewart Johnson
//
//
//Description: Rect class creates the rect
//method and the draw method to be used to draw rectangles on canvas

import java.awt.Color;
import java.awt.Graphics;

public class Rect
{
//creates var to be used in constructor	
private int x,y,height,width;
private Color color;
//creates rectangle object that takes the following arguments
public Rect(int x1, int y1, int width, int height, Color color)
{
this.x = x1;
this.y = y1;
this.height = height;
this.color = color;
this.width = width;
}
//draws solid rect obj
public void draw(Graphics page)
{
page.setColor(color);
page.fillRect(x, y, width, height);
}






}