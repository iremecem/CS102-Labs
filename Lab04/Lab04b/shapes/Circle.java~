/** Circle class, subclass of the shape class
  * 
  * @author Irem Ecem Yelkanat
  * @version 6/11/18
  */ 
public class Circle extends Shape implements Selectable
{
   // Properties
   private int radius;
   private boolean selected;
   
   /** Constructs a Circle object with the given parameters
     * @param radius the radius of the rectangle
     */ 
   public Circle (int radius)
   {
      super();
      this.radius = radius;
      selected = false;
   }
   
   /** Return the area
     * @return area
     */ 
   public double getArea()
   {
      return Math.PI * radius * radius;
   }
   
   /** Returns if the circle is selected or not
     * @return if the circle is selected or not
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
     * @param x the x location
     * @param y the y location
     * @return the shape if it contains
     */ 
   public Shape contains (int x, int y) 
   {
      // Variables
      int centerX;
      int centerY;
      
      // Initialize the variables
      centerX = getX() + radius;
      centerY = getY() + radius;
      
      // Find if it contains
      if ((Math.sqrt(((centerX - x) * (centerX - x)) + ((centerY - y) * (centerY - y)))) <= radius)
      {
         return this;
      }
      else 
      {
         return null;
      } 
   }
   
   /** Returns the string representation of Circle
     * @return string representation of Circle
     */
   public String toString()
   {
      return "A **Circle** with radius " + radius + ", Its area is " + getArea()
         + " Selected situation is " + getSelected(); 
   }
}
