package shapes;
/** A shape class with an abstract method
  * 
  * @author Irem Ecem Yelkanat
  * @version 6/11/18
  */ 
public abstract class Shape implements Locatable
{
   // Properties
   int xLocation;
   int yLocation;
   
   /** Constructs a shape object
     */ 
   public Shape()
   {
      xLocation = 0;
      yLocation = 0;
   }
   
   /** Return the area
     * @return area
     */ 
   public abstract double getArea();
   
   /** Gets the x location of the shape
     * @return x location
     */ 
   public int getX()
   {
      return xLocation;
   }
   
   /** Gets the y location of the shape
     * @return y location
     */ 
   public int getY()
   {
      return yLocation;
   }
   
   /** Sets the shape's location
     * @param x the x location of the shape
     * @param y the y location of the shape
     */
   public void setLocation (int x, int y)
   {
      xLocation = x;
      yLocation = y;
   }
   
}