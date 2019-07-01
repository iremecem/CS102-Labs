import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import shapes.ShapeContainer;
import java.util.*;
/** Balloon game implementation
  * 
  * @author Irem Ecem Yelkanat
  * @version 13/11/18
  */ 
public class Lab04b extends JFrame
{
   /** Constructs a new lab04 game
     */ 
   public Lab04b()
   {
      // Set the properties of the frame
      setTitle("Balloon Game");
      setLayout(new FlowLayout());
      add (new BalloonsGamePanel());
      pack();
      
      // Set the close operation and display
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   public static void main (String [] args)
   {
      // Initialize a new game
      new Lab04b();
   }
}
