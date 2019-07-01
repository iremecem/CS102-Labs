/** Rectangle class, subclass of the shape class
  * 
  * @author Irem Ecem Yelkanat
  * @version 6/11/18
  */ 
public class Rectangle extends Shape implements Selectable
{
   // Properties
   private int width;
   private int height;
   private boolean selected;
   
   /** Constructs a Rectangle object with the given parameters
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */ 
   public Rectangle (int width, int height)
   {
      super();
      this.width = width;
      this.height = height;
      selected = false;
   }
   
   /** Returns the area
     * @return area
     */ 
   public double getArea()
   {
      return width * height;
   }
   
   /** Returns if the rectangle is selected or not
     * @return if the rectangle is selected or not
     */ 
   public boolean getSelected() 
   {
      return selected;
   }
   
   /** Sets the selected situation of an object
     * @param selected the selected situation
     */ 
   public void setSelected (boolean selected) 
   {
      this.selected = selected;
   }
   
   /** Finds if the shape contains given location
     * @return the shape if it contains
     */ 
   public Shape contains (int x, int y) 
   {
      // Variables
      boolean insideX;
      boolean insideY;
      
      // Initialize the variables
      insideX = false;
      insideY = false;
      
      // Find if it contains
      if (x <= (getX() + width) && x >= getX())
      {
         insideX = true;
      }   
      if (y <= (getY() + height) && y >= getY())
      {
         insideY = true;
      }
      if (insideX && insideY)
      {
         return this;
      }
      else
      {
         return null;
      }
   }
   
   /** Returns the string representation of Rectangle
     * @return string representation of Rectangle
     */
   public String toString()
   {
      return "A **Rectangle** with width " + width + ", with height "  + height + 
         ", Its area is " + getArea() + " Selected situation is " + getSelected(); 
   }
   
}