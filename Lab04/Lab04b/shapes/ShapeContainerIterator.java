package shapes;
import java.util.Iterator;
import java.util.*;
public class ShapeContainerIterator implements Iterator 
   {
      // Properties
      ShapeContainer balloons;
      int index;
      
      /** Constructs a IntBagIterator object with the given parameters
        * @param bag an instance of IntBag
        */ 
      public ShapeContainerIterator(ShapeContainer balloons) 
      {
         this.balloons = balloons;
         index = 0;
      }
      
      /** Returns true if the iteration has more elements
        * @return true if the iteration has more elements
        */ 
      public boolean hasNext() 
      {
         if (index < balloons.shapes.size())
         {
            return true;
         }
         else
         {
            return false;
         }
      }
      
      /** Returns the next element in the iteration
        * @return the next element in the iteration
        */ 
      public int nextInt() 
      {
         // Variables
         int value;
         
         // Initialize the variables
         value = new Integer(bag.getValue(index));
         index++;
         
         return value;
      }
      
      /** Returns the next element in the iteration
        * @return the next element in the iteration
        */ 
      public Object next() 
      {
//         // Variables
//         Integer value;
//         
//         // Initialize the variables
//         value = new Integer(bag.getValue(index));
//         index++;
         
         return bag.getValue(index);
      }
      
   }