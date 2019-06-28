import cs1.SimpleURLReader;
/**
 * A test program for SimpleURLReader
 * 
 * @author Irem Ecem Yelkanat
 * @version 23/10/18
 */ 
public class SimpleURLReaderTest
{
   public static void main(String[] args)
   {
      // Variables
      SimpleURLReader reader1;
      MySimpleURLReader reader2;
      HTMLFilteredReader reader3;
      SuperHTMLFilteredReader reader4;
      
      // Initialize the variables
      reader1 = new SimpleURLReader ("http://www.cs.bilkent.edu.tr/~adayanik/courses/cs102/docs/housman.txt");
      reader2 = new MySimpleURLReader ("http://www.cs.bilkent.edu.tr/~adayanik/courses/cs102/docs/housman.txt");
      reader3 = new HTMLFilteredReader ("http://www.cs.bilkent.edu.tr/~david/housman.htm");
      reader4 = new SuperHTMLFilteredReader ("https://docs.oracle.com/javase/tutorial/");
      
      // Test Simple URL Reader
      System.out.println ("*******Simple URL Reader*******");
      System.out.println(reader1.getPageContents() + "\n");
      System.out.println(reader1.getLineCount()); 
      System.out.println ("************************");
      
      // Test My Simple URL Reader
      System.out.println ("******* My Simple URL Reader*******");
      System.out.println(reader2.getURL() + "\n");
      System.out.println(reader2.getFileName() + "\n");
      System.out.println(reader2.getPageContents() + "\n");
      System.out.println ("*************************");
      
      // Test HTML Filtered Reader
      System.out.println ("******* HTML Filtered Reader*******");
      System.out.println(reader3.getPageContents() + "\n");
      System.out.println ("*************************");
      
      // Test Super HTML Filtered Reader
      System.out.println ("******* Super HTML Filtered Reader*******");
      System.out.println(reader4.getLinks() + "\n");
      System.out.println ("*************************");
      
   }
   
}