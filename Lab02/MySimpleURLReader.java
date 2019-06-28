import cs1.SimpleURLReader;

/**
 * A class, subclass of the SimpleURLReader class
 * 
 * @author Irem Ecem Yelkanat
 * @version 23/10/18
 */ 
public class MySimpleURLReader extends SimpleURLReader 
{
   // Properties
   private String url;
   
   /** Constructs a new MySimpleURLReader object with the given parameters
     * @param urlString the url
     */ 
   public MySimpleURLReader (String urlString)
   {
      super (urlString);
      url = urlString;
   }
   
   /** Returns the url
     * @return url
     */
   public String getURL()
   {
      return url;
   }
   
   /**
    * Returns the name of the file
    * @return file name
    */
   public String getFileName()
   {
      // Variables
      int lastIndex;
      
      // Initialize the variables
      lastIndex = url.lastIndexOf('/');
      
      return url.substring (lastIndex + 1, url.length());
   }
   
   /**
    * Fixes the bug in SimpleURLReader's getPageContents() method
    * @return page contents
    */
   public String getPageContents() 
   {
      return removeSpecial (super.getPageContents().substring (4, super.getPageContents().length()));
   }
   
   /** Removes &quot; and &nbsp; from text
     * @param str the String that will be searched for those substrings
     * @return removed String
     */ 
   public String removeSpecial (String str)
   {
      // Variables
      int index;
      
      // Find special substrings and delete from string
      if (str.indexOf("&quot;") != -1)
      {
         while (str.indexOf("&quot;") != -1)
         {
            index = str.indexOf("&quot;");
            str = str.substring(0, index) + str.substring(index + 6, str.length());
         }
      }
      
      if (str.indexOf("&nbsp;") != -1)
      {
         while (str.indexOf("&nbsp;") != -1)
         {
            index = str.indexOf("&nbsp;");
            str = str.substring(0, index) + str.substring(index + 6, str.length()); 
         }
      }
      return str;
   }
}