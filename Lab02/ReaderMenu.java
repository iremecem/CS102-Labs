import java.util.*;
/**
 * Asimple menu-driven program that will maintain 
 * a collection of MySimpleURLReader objects
 * 
 * @author Irem Ecem Yelkanat
 * @version 23/10/18
 */ 
public class ReaderMenu {
   
   public static void main (String[] args) 
   {
      Scanner in = new Scanner (System.in);
      
      // Variables
      String url;
      int choice;
      ArrayList<MySimpleURLReader> list;
      int indexNum;
      
      // Initialize the variables
      list = new ArrayList<MySimpleURLReader>();
      
      do 
      { 
         // Print out the choices
         System.out.println("Choices are;");
         System.out.println("(1) Enter the url of poem to add to collection");
         System.out.println("(2) List all poems in the collection ");
         System.out.println("(3) Quit ");
         
         System.out.print ("\nEnter choice: ");
         choice = in.nextInt();
         
         // Process choice
         if (choice == 1) 
         {
            // Ask for url
            in.nextLine();
            System.out.print ("Enter url: ");
            url = in.nextLine();
            
            // Add readers to list
            if (url.indexOf("htm") != -1) 
            {
               MySimpleURLReader reader = new HTMLFilteredReader(url);
               list.add(reader);
            }
            else 
            {
               MySimpleURLReader reader = new MySimpleURLReader(url);
               list.add(reader);
            }
         }
         else if (choice == 2)
         {
            // List the poems
            for (int i = 0; i < list.size(); i++)
            {
               System.out.println ("Poem " + i + "--- " + list.get(i).getFileName());
            }
            
            // Read the index from the user
            System.out.print ("Enter index: ");
            indexNum = in.nextInt();
            
            if (indexNum < list.size() && indexNum >= 0)
            {
               // View poem
               System.out.println(list.get(indexNum).getPageContents());
               System.out.println();
            }
            else if (indexNum == list.size())
            {  
            }
            else
            {
               System.out.println ("Invalid index!");
            } 
         } 
      } while (choice != 3);
      
   }
   
}