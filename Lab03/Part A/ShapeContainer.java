import java.util.*;
/** Holds a set of shapes
  * 
  * @author Irem Ecem Yelkanat
  * @version 6/11/18
  */ 
public class ShapeContainer
{
   // Properties
   ArrayList<Selectable> shapes;
   
   /** Constructs a ShapeContainer object
     */ 
   public ShapeContainer()
   {
      shapes = new ArrayList<Selectable>();
   }
   
   /** Adds a shape to ShapeContainer
     * @param shape the shape that will be added
     */
   public void add (Selectable shape)
   {
      shapes.add(shape);
   }
   
   /** Gets the area of all the shapes
     * @return total area
     */
   public double getArea()
   {
      // Variables
      double totalArea;
      
      // Initialize the variables
      totalArea = 0;
      
      // Calculate total area
      for (int i = 0; i < shapes.size(); i++)
      {
         totalArea += ((Shape)shapes.get(i)).getArea();
      }
      return totalArea;  
   }
   
   /** Removes all selected shapes from the set of shapes
     */ 
   public void removeAllSelected()
   {
      for (int i = 0; i < shapes.size(); i++) 
      {
         if ((shapes.get(i)).getSelected()) 
         {
            shapes.remove(i);
            i--;
         }
      }  
   }
   
   /** Finds the first Shape that contains a given x, y point and, 
     * afterwards, toggle its selected state
     * @param x the x location
     * @param y the y location
     * @return the first shape it contains
     */ 
   public Selectable findFirstShape (int x, int y)
   {
      for (int i = 0; i < shapes.size(); i++) 
      {
         if (shapes.get(i).contains(x, y) != null) 
         {
            if (shapes.get(i).getSelected())
            {
               shapes.get(i).setSelected(false);
               return shapes.get(i);
            }
            else
            {
               shapes.get(i).setSelected(true);
               return shapes.get(i);
            }
         } 
      }
      return null;
   }
   
   /** Returns string representations of all the shapes
     * @return string representations of all the shapes
     */
   public String toString()
   {
      // Variables
      String shapeInfo;
      
      // Initialize the variables
      shapeInfo = "";
      
      // Find shape info
      for (int i = 0; i < shapes.size(); i++)
      {
         shapeInfo += shapes.get(i).toString() + "\n";
      }
      
      return "***The shapes in the shape container*** \n" + shapeInfo;
   }  
}