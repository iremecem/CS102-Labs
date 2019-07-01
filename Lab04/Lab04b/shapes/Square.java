package shapes;
/** Square class, subclass of the rectangle class
  * 
  * @author Irem Ecem Yelkanat
  * @version 6/11/18
  */ 
public class Square extends Rectangle
{
   // Properties
   private int side;
   
   /** Constructs a Square object with the given parameters
     * @param side the side of the square
     */ 
   public Square (int side)
   {
      super (side, side);
      this.side = side;
   }
   
   /** Returns the string representation of Square
     * @return string representation of Square
     */
   public String toString()
   {
      return "A **Square** with side " + side + ", Its area is " + getArea()
         + " Selected situation is " + getSelected(); 
   }
}