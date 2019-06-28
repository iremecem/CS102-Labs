import java.util.*;
/**
 * A class, subclass of the HTMLFilteredReader class
 * 
 * @author Irem Ecem Yelkanat
 * @version 23/10/18
 */ 
public class SuperHTMLFilteredReader extends HTMLFilteredReader 
{
   // Counstructor
   /** Constructs a new SuperHTMLFilteredReader object with the given parameters
     * @param urlString the url
     */ 
   public SuperHTMLFilteredReader(String urlString)
   {
      super(urlString);
   }
   
   // Methods
   /**
    * Computes the overhead due to the html code
    * @return overhead
    */
   public double calculateOverhead()
   {
      return (getUnfilteredPageContents().length() - getPageContents().length())  * 100 / getPageContents().length();
   }
   
   /**
    * Returns a list of the url's that the page links to
    * @return an ArrayList of links
    */
   public ArrayList<String> getLinks()
   {
      // Variables
      ArrayList<String> links;
      String url;
      int index;
      
      // Initialize the variables
      links = new ArrayList<String>();
      
      for (int i = 0; i < super.getUnfilteredPageContents().length(); i++)
      {
         if (super.getUnfilteredPageContents().indexOf("href=\"", i) != -1)
         {
            // Find the index of " after href
            index = super.getUnfilteredPageContents().indexOf("href=", i);
            index = super.getUnfilteredPageContents().indexOf("\"", index);
            
            // Initialize the url according to index
            url = super.getUnfilteredPageContents().substring(index + 1, super.getUnfilteredPageContents().indexOf("\"", index + 2));
            
            // Add url to ArrayList
            links.add(url);
            
            i = super.getUnfilteredPageContents().indexOf("\"", index + 2);
         }
      }
      return links; 
   }
   
}