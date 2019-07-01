import java.util.*;
/** A program that allows a variable sized collection of non-negative integer 
  * values to be stored
  * 
  * @author Irem Ecem Yelkanat
  * @version 6/11/18
  */ 
public class IntBag implements Iterable
{
   // Properties
   private int[] bag;
   
   // Constructor
   public IntBag()
   {
      bag = new int[4];
      bag [0] = -1;
   }
   
   // Methods
   /**
    * Adds a value to the end of the collection
    * @param value the value that will be added
    */ 
   public void add (int value)
   {
      // Varibles
      int size;
      
      // Initialize the variables
      size = size();
      
      // if there is no room for a new integer, expand the size of the array
      if (size >= bag.length - 1)
      {
         int [] newBag = Arrays.copyOf (bag, 2 * bag.length);
         bag = newBag;
      }
      
      // Add the value
      bag [size] = value;
      bag [size + 1] = -1;   
   }
   
   /** Adds a value to a particular index
     * @param index the index that the value will be inserted
     * @param value the value that will be added
     */ 
   public void add (int index, int value)
   {
      if (index > size() + 1)
      {
         System.out.println ("Index out of bounds!");
      }
      
      else
      {
         // if there is no room for a new integer, expand the size of the array
         if (size() + 1 >= bag.length)
         {
            int [] newBag = Arrays.copyOf (bag, 2 * bag.length);
            bag = newBag;
         }
         
         // Insert the element
         for (int i = size() + 1; i > index; i--)
         {
            bag [i] = bag [i - 1];
         }
         bag [index] = value; 
      }
   }
   
   /**
    * Removes the value at a given index and places the last element into that index
    * @param index the index at which the value will be removed
    */ 
   public void remove (int index)
   {
      bag [index] = bag [size() - 1];
      bag [size() - 1] = -1;
      bag [size()] = 0;
      
      if ((size() + 1) <= (bag.length / 2))
      {
         int [] newBag = Arrays.copyOf (bag, bag.length / 2);
         bag = newBag;
      }
   }
   
   /** 
    * Checks whether the collection contains a given value
    * @param value the value that will be searched
    * @return whether the collection contains a given value
    */ 
   public boolean contains (int value)
   {
      // Variables
      boolean check;
      
      // Initialize the variables
      check = false;
      
      // Search the given value
      for (int i = 0; i < size(); i++)
      {
         if (bag [i] == value)
         {
            check = true;
         }
      }
      return check;
   }
   
   /**
    * Returns a string representation of the collection
    * @return string representation of the collection
    */
   public String toString()
   {
      // Variables
      String result;
      int i;
      
      // Initialize the variables
      result = "[";
      
      for (i = 0; i < size() - 1; i++)
      {
         result += bag [i] + ", ";
      }
      result += bag [i] + "]";
      
      return result;
   }
   
   /**
    * Returns the number of values currently in the collection
    * @return the number of values in the collection
    */ 
   public int size()
   {
      // Variables
      int count;
      
      // Inıtialize the variables
      count = 0;
      
      // Find the num of elements in the array
      while (bag [count] > 0)
      {
         count++;
      }
      return count;
   }
   
   /**
    * Gets the value in the specified index
    * @param index the index in which the value will be gotten
    * @return the value in the specified index
    */
   public int getValue (int index)
   {
      // Variables
      int value;
      
      // Initialize the variables
      value = -1;
      
      if (index < size())
      {
         value = bag [index];
      }
      else
      {
         System.out.println ("Index out of bounds!");
      }
      return value;
   }
   
   /**
    * Removes all instances of a given value in the collection
    * @param value the value that will be removed
    */
   public void removeAll (int value)
   {
      for (int i = 0; i < size(); i++)
      {
         if (bag [i] == value)
         {
            remove(i);
            i--;
         }
      }
   }
   
   /** Creates an instance of IntBagIterator and return it as the interface type
     * @return an instance of IntBagIterator as the interface type
     */ 
   public Iterator iterator()
   {
      // Variables
      IntBag newBag;
      Iterator intIterate;
      
      // Initialize the variables
      newBag = new IntBag();
      newBag.bag = bag;
      intIterate = new IntBagIterator(newBag);
      
      return intIterate;
   } 
}