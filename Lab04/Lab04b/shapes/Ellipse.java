package shapes;
/** Ellipse class, subclass of the shape class
  * 
  * @author Irem Ecem Yelkanat
  * @version 6/11/18
  */ 
public class Ellipse extends Shape implements Selectable
{
   // Properties
   private int sideA;
   private int sideB;
   private boolean selected;
   
   /** Constructs a Circle object with the given parameters
     * @param radius the radius of the rectangle
     */ 
   public Ellipse (int sideA, int sideB)
   {
      super();
      this.sideA = sideA;
      this.sideB = sideB;
      selected = false;
   }
   
   /** Return the area
     * @return area
     */ 
   public double getArea()
   {
      return Math.PI * sideA * sideB;
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
      centerX = getX() + sideA;
      centerY = getY() + sideB;
      
      // Find if it contains
      if (((Math.pow((x - centerX), 2) / Math.pow(sideA, 2)) + (Math.pow((y - centerY), 2) / Math.pow(sideB, 2))) <= 1)
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
      return "A **Ellipse** with radius a " + sideA + " radius b " + sideB + 
         ", Its area is " + getArea() + " Selected situation is " + getSelected(); 
   }
}
