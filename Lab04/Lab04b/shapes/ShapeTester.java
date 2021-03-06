package shapes;
import java.util.*;
/** A class to test Shapes
  * 
  * @author Irem Ecem Yelkanat
  * @version 6/11/18
  */ 
public class ShapeTester
{
   public static void main (String [] args)
   {
      // Variables
      ShapeContainer container;
      int choice;
      int shapeChoice;
      int radius;
      int height;
      int width;
      int side;
      int sideA;
      int sideB;
      int xCoordinate;
      int yCoordinate;
      
      // Initialize the variables
      container = new ShapeContainer();
      
      Scanner in = new Scanner (System.in);
      
      do 
      {
         System.out.println ("1 - Create an empty set of shapes");
         System.out.println ("2 - Add a shape");
         System.out.println ("3 - Compute and print out the total surface area of the intire set of shapes");
         System.out.println ("4 - Print out information about all of the shapes in container");
         System.out.println ("5 - Find the first Shape that contains a given x, y point");
         System.out.println ("6 - Remove all selected shapes from the set of shapes");
         System.out.println ("7 - Quit");
         
         // Ask the choice from the user
         System.out.print ("Enter choice: ");
         choice = in.nextInt();
         
         if (choice == 1)
         {
            // Create a new shape container
            container = new ShapeContainer();
         }
         else if (choice == 2)
         {
            // Read the coordinates from the user
            System.out.print ("Enter x coordinate: ");
            xCoordinate = in.nextInt();
            System.out.print ("Enter y coordinate: ");
            yCoordinate = in.nextInt();
            
            // Read the shape type from the user
            System.out.println ("Select the shape you want to add");
            System.out.println ("1 - Rectangle  2 - Square  3 - Circle  4 - Ellipse");
            shapeChoice = in.nextInt();
            
            if (shapeChoice == 1)
            {
               // Read height and width from the user
               System.out.print ("Enter height: ");
               height = in.nextInt();
               System.out.print ("Enter width: ");
               width = in.nextInt();
               
               // Create rectangle and add to ShapeContainer
               Rectangle rectangle = new Rectangle(width, height);
               rectangle.setLocation(xCoordinate, yCoordinate);
               container.add(rectangle);
            }
            else if (shapeChoice == 2)
            {
               // Read size from the user
               System.out.print ("Enter side: ");
               side = in.nextInt();
               
               // Create square and add to ShapeContainer
               Square square = new Square(side);
               square.setLocation(xCoordinate, yCoordinate);
               container.add(square);
            }
            else if (shapeChoice == 3)
            {
               // Read radius from the user
               System.out.print ("Enter radius: ");
               radius = in.nextInt();
               
               // Create circle and add to ShapeContainer
               Circle circle = new Circle(radius);
               circle.setLocation(xCoordinate, yCoordinate);
               container.add(circle);
            }
            else if (shapeChoice == 4)
            {
               // Read sides from the user
               System.out.print ("Enter side A: ");
               sideA = in.nextInt();
               System.out.print ("Enter side B: ");
               sideB = in.nextInt();
               
               // Create ellipse and add to ShapeContainer
               Ellipse ellipse = new Ellipse(sideA, sideB);
               ellipse.setLocation(xCoordinate, yCoordinate);
               container.add(ellipse);
            }
            else
            {
               System.out.println ("Invalid Choice!");
            }
         }
         else if (choice == 3)
         {
            // Print the total area
            System.out.println ("Total area of the shapes is " + container.getArea());
         }
         else if (choice == 4)
         {
            // Print out the info about all shapes
            System.out.println (container.toString());
         }
         else if (choice == 5)
         {
            // Read the coordinates from user
            System.out.print ("Enter x coordinate: ");
            xCoordinate = in.nextInt();
            System.out.print ("Enter y coordinate: ");
            yCoordinate = in.nextInt();
            
            // Find the shape
            if (container.findFirstShape (xCoordinate, yCoordinate) != null)
            {
               // Call the method again so that change the toggle situation again
               container.findFirstShape (xCoordinate, yCoordinate);
               
               // Print the shape if it exits
               System.out.println ("The shape is " + container.findFirstShape (xCoordinate, yCoordinate));
            }
            else
            {
               System.out.println ("No shape found");
            }
         }
         else if (choice == 6)
         {
            // Remove all selected shapes
            container.removeAllSelected();
         }
         else if (choice == 7)
         {
            // Exit the program
            System.out.println ("GoodBye!");
         }
         else
         {
            System.out.println ("Invalid Choice!");
         }
      } while (choice != 7);  
      
   }
}
