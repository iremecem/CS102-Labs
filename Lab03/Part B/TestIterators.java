import java.util.Iterator;
/** A class to test IntBagIterator
  * 
  * @author Irem Ecem Yelkanat
  * @version 6/11/18
  */ 
public class TestIterators
{
   public static void main (String[] args) 
   {
      // Variables
      Iterator i, j;
      IntBag bag;
      
      // Initialize the variables
      bag = new IntBag();
      i = new IntBagIterator (bag);
      
      // Add values to bag
      for (int k = 1; k < 10; k++)
      {
         bag.add(k);
      }
      
      // Test iterators
      while (i.hasNext()) 
      {
         System.out.println (i.next());
         
         j = new IntBagIterator (bag);
         // j = bag.iterator();
         
         while (j.hasNext())
         {
            System.out.println( "--" + j.next() );
         }
      }
   }
}