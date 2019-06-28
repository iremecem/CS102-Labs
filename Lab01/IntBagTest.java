import java.util.*;
/** A program that a that presents the user with a menu 
  * having the options using IntBag methods
  * 
  * @author Irem Ecem Yelkanat
  * @version 09/10/18
  */ 
public class IntBagTest
{
   public static void main (String args[])
   {
      Scanner in = new Scanner (System.in);
      
      // Variables
      IntBag collection;
      int choice;
      int value;
      int location;
      
      // Initialize the variables
      value = 1; // so that the condition of the second option will be true
      collection = new IntBag();
      
      do
      {
         // Present the options
         System.out.println ("Here are the options, what do you wanna do?" +
                             "\n 1. Create a new empty collection(any previous values are lost!)" +
                             "\n 2. Read a set of positive values into the collection (use zero" +
                             "to indicate all the values have been entered.)" +
                             "\n 3. Print the collection of values." +
                             "\n 4. Add a value to the collection of values at a specified location" +
                             "\n 5. Remove the value at a specified location from the collection of values" +
                             "\n 6. Remove all instances of a value within the collection" +
                             "\n 7. Quit the program");
         
         // Read the choice from the user
         choice = in.nextInt();
         
         if (choice == 1)
         {
            // Create a new empty collection
            IntBag newCollection = new IntBag();
            collection = newCollection;
         }
         else if (choice == 2)
         {
            System.out.println ("Enter set of positive values - 0 to end");
            
            // Read the values and add them to the collection
            do
            {
               if (value > 0)
               {   
                  value = in.nextInt();
                  collection.add (value);
               }
            } while (value > 0);
         }
         else if (choice == 3)
         {
            // Print out the values
            System.out.println ("The values are: " + collection.toString());
         }
         else if (choice == 4)
         {
            // Read the value and the location from the user
            System.out.print ("Enter value: ");
            value = in.nextInt();
            System.out.print ("\nEnter location: ");
            location = in.nextInt();
            
            // Add the value to the collection
            collection.add (location, value);
         }
         else if (choice == 5)
         {
            // Read the location from the user
            System.out.print ("Enter the location to remove the value from it");
            location = in.nextInt();
            
            // Remove the value in the location
            collection.remove (location);
         }
         else if (choice == 6)
         {
            // Read the value from the user
            System.out.print ("Enter the value you want to be remove all of it's instances");
            value = in.nextInt();
            
            // Remove all of the instances of that value
            collection.removeAll (value); 
         }
         else if (choice == 7)
         {
            System.out.println ("Goodbye!");
         }
         else
         {
            System.out.println ("Invalid Choice!");
         }
      }while (choice != 7);
      
   }
}