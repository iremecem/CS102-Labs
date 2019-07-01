import java.util.Iterator;
/**
 * An interface subclassing Iterator
 * 
 * @author Irem Ecem Yelkanat
 * @version 6/11/18
 */ 
public interface IntIterator extends Iterator 
{
   /** Returns the next integer element in the iteration
     * @return the next integer element in the iteration
     */ 
   public int nextInt();
}