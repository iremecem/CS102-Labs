import cs1.SimpleURLReader;
/**
 * A class, subclass of the MySimpleURLReader class
 * 
 * @author Irem Ecem Yelkanat
 * @version 23/10/18
 */ 
public class HTMLFilteredReader extends MySimpleURLReader 
{
   /** Constructs a new HTMLFilteredReader object with the given parameters
     * @param urlString the url
     */ 
   public HTMLFilteredReader (String urlString) 
   {
      super (urlString);
   }
   
   /** Return only the text, without the html
     * @return text
     */ 
   public String getPageContents() 
   {
      // Variables
      String unfilteredText;
      String withoutHTML;
      boolean check;
      
      // Initialize the variables
      unfilteredText = getUnfilteredPageContents();
      withoutHTML = "";
      check = true;
      
      // Find the text without HTML
      for (int i = 0; i < unfilteredText.length(); i++)
      {
         if (unfilteredText.charAt(i) != '<' && check)
         {
            withoutHTML += unfilteredText.charAt(i);
         }
         if (unfilteredText.charAt(i) == '<')
         {
            check = false;
         }
         if (unfilteredText.charAt(i) == '>')
         {
            check = true;
         }
      }
      return withoutHTML;
   }
   
   /** Returns the original page complete with html codes
     * @return the original page complete with html codes
     */ 
   public String getUnfilteredPageContents() 
   {
      return super.getPageContents();
   }
   
}