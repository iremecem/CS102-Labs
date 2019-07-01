/** Selectable interface
  * 
  * @author Irem Ecem Yelkanat
  * @version 6/11/18
  */ 
public interface Selectable
{
   /** Returns if selected or not
     * @return if selected or not
     */ 
   public boolean getSelected();
   
   /** Sets the selected situation of an object
     * @param selected the selected situation
     */ 
   public void setSelected (boolean selected);
   
   /** Finds if the shape contains given location
     * @param x the x location
     * @param y the y location
     * @return the shape if it contains
     */ 
   public Shape contains (int x, int y);
}