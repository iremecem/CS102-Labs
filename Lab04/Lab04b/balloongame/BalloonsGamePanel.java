import java.awt.*;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.event.*;
import shapes.ShapeContainer;
import shapes.ShapeContainer.ShapeContainerIterator;
import java.util.*;
import java.util.Iterator;
/** Balloon Game Panel
  * 
  * @author Irem Ecem Yelkanat
  * @version 13/11/18
  */    
public class BalloonsGamePanel extends JPanel
{
   // Properties
   private ShapeContainer balloons;
   private int elapsedTime;
   private int points;
   private JLabel pointLabel;
   private MouseListener listener;
   Timer timer;
   
   /** Constructs a new BallonsGamePanel
     */ 
   public BalloonsGamePanel()
   {
      // Set the features of the panel
      setPreferredSize(new Dimension(600, 600));
      setBackground(Color.YELLOW);
      
      // Initialize the label and add to panel
      pointLabel = new JLabel();
      add(pointLabel);
      
      // Start the game panel
      constructGame();
   }
   
   /** Starts a new game
     */ 
   public void constructGame()
   {
      // Initialize the properties
      elapsedTime = 0;
      points = 0;
      balloons = new ShapeContainer();
      listener = new MouseListener();
      
      // Set the label text
      pointLabel.setText("Points: " + points);
      
      // Add balloons and listener
      addBalloons(25);
      addMouseListener(listener);
      
      // Initialize the times and start
      timer = new Timer(100, new BalloonListener());
      timer.start();
   }
   
   /** Draw the balloons onto screen
     * @param g the default parameter
     */ 
   public void paintComponent(Graphics g)
   {
      // Call super to erase whatever is currently drawn on the panel
      super.paintComponent(g);
      
      // Variables
      Iterator balloonIterate;
      
      // Inıtialize the variables
      balloonIterate = balloons.iterator();
      
      // Draw each balloon in container
      while (balloonIterate.hasNext())
      {
         Balloon balloon = (Balloon) balloonIterate.next();
         balloon.draw(g);
      }
   }
   
   /** Add balloons to array
     * @param number the number of balloons that will be added
     */ 
   public void addBalloons(int number)
   {
      // Variables
      int xCoordinate;
      int yCoordinate;
      Balloon balloon;
      
      for (int i = 0; i < number; i++)
      {
         xCoordinate = (int)(Math.random() * 600);
         yCoordinate = (int)(Math.random() * 600);
         balloon = new Balloon(xCoordinate, yCoordinate);
         balloons.add(balloon);
      }
   }
   
   /** A listener class, subclassing ActionListener
     */ 
   class BalloonListener implements ActionListener
   {
      /** Constructs a new BalloonListener object
        */ 
      public BalloonListener() {}
      
      /** Processes the action performed event
        * @param e the default event
        */ 
      public void actionPerformed(ActionEvent e)
      {
         // Variables
         Iterator iterate;
         
         // Initialize the variables
         iterate = balloons.iterator();
         
         // Grow each balloon
         while (iterate.hasNext())
         {
            ((Balloon)iterate.next()).grow();
         }
         
         // Remove all selected balloons
         balloons.removeAllSelected();
         
         // Add a balloon if balloons are less than or equals to 15
         if (balloons.size() <= 15)
         {
            BalloonsGamePanel.this.addBalloons(1);
         }
         
         // Repaint the balloons
         repaint();
         
         // Increment elapsed time
         elapsedTime++;
         
         // If elapsed time is reached end the game and show options pane
         if (elapsedTime >= 300) 
         {
            timer.stop();
            removeMouseListener (listener);
            
            int choice = JOptionPane.showConfirmDialog(BalloonsGamePanel.this,
                                                       "Play Again?" ,"Game Over", 0 ,1);
            // Process choice
            if (choice == 0) 
            {
               BalloonsGamePanel.this.constructGame();
            }
            if (choice == 1) 
            {
               System.exit(0);
            }
         }
      }
   }
   
   /** A class, subclassing MouseAdapter
     */ 
   class MouseListener extends MouseAdapter
   {
      /** Constructs a new mouseListener object
        */ 
      public MouseListener() {}
      
      /** Processes the mouse press event
        * @param e the default event
        */ 
      public void mousePressed (MouseEvent e)
      {
         // Variables
         int balloonNumber;
         int smallBalloonPoint;
         int largeBalloonPoint;
         
         // Variables
         Iterator balloonIterate;
         
         // Inıtialize the variables
         balloonIterate = balloons.iterator();
         
         // Initialize the variables
         balloonNumber = balloons.selectAllAt(e.getX(),e.getY());
         smallBalloonPoint = 5;
         largeBalloonPoint = 2;
         
         // If selected are greater than or equal to 2 then increment points
         if (balloonNumber >= 2)
         {
            while (balloonIterate.hasNext())
            {
               Balloon temp = (Balloon)(balloonIterate.next());
               if (temp.getSelected())
               {
                  if (temp.getRadius() < 50)
                  {
                     points += smallBalloonPoint;
                  }
                  else 
                  {
                     points += largeBalloonPoint;
                  }
               }
            }
            
            // Update Label
            pointLabel.setText("Points: " + points);
         }
      }
   }
}