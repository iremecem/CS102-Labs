/**
 * Generates and adds fibonacci numbers into IntBag instance
 * 
 * @author Irem Ecem Yelkanat
 * @version 09/10/18
 */ 
public class FibonacciTest
{
   public static void main (String args[])
   {
      // Variables
      int fib1;
      int fib2;
      int fib3;
      IntBag fibonacci;
      
      // Initialize the variables
      fib1 = 0;
      fib2 = 1;
      fibonacci = new IntBag();
      
      // Add first two fibonacci numbers to IntBag instance fibonacci
      fibonacci.add (fib1);
      fibonacci.add (fib2);
      
      // Generate fibonacci numbers and them to IntBag instance fibonacci
      for (int i = 0; i < 39; i++)
      {
         fib3 = fib1 + fib2;
         fib1 = fib2;
         fib2 = fib3;
         fibonacci.add (fib3);
      }
      
      // Print out the fibonacci numbers
      System.out.println (fibonacci.toString()); 
   }  
}