import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/** A potluck game
  *
  * @author Irem Ecem Yelkanat
  * @version 13/11/2018
  */
public class PotLuck extends JFrame 
{   
   // Properties
   private static JButton[] buttons;
   private static ArrayList<Integer> luckyCounts;
   private int buttonNumber;
   private JLabel topLabel;
   private static int clickCount;
   private static int buttonCount;
   private JPanel buttonsPanel; 
   private JPanel topPanel;
   
   /** Construcks a new potluck
     */ 
   public PotLuck() 
   {
      // Initialize the variables
      buttonsPanel = new JPanel();
      topPanel = new JPanel();
      topLabel = new JLabel();
      
      // Construct game
      constructGame();
      
      // Set layouts
      buttonsPanel.setLayout(new GridLayout(5, 5));
      setLayout(new BorderLayout());
      
      // Add buttons
      addButtons();
      
      // Set Frame Layout
      topPanel.setLayout(new BorderLayout());
      topPanel.add(topLabel, BorderLayout.WEST);
      add(buttonsPanel, BorderLayout.CENTER);
      add(topPanel, BorderLayout.NORTH);
      setBounds(600,300,500,400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   /** Starts a new game
     */ 
   public void constructGame()
   {
      setLuckyCounts();
      clickCount = 0;
      buttonCount = 0;
      topLabel.setText(clickCount + " tries made!" + "  " + buttonCount + "/" + buttonNumber);
   }
   
   /** Add buttons to array
     */ 
   public void addButtons()
   {
      // Initialize the variables
      buttons = new JButton[25];
      
      // Add buttons
      for (int i = 0; i < 25; i++) 
      {
         buttons[i] = new JButton("Click!");
         buttonsPanel.add(buttons[i]);
         buttons[i].addActionListener(new PotLuckListener());
      }
   }
   
   public void setLuckyCounts()
   {
      // Variables
      int count;
      
      // Initialize the variables
      luckyCounts = new ArrayList<Integer>();
      
      // Ask for numbers from the user
      Scanner in = new Scanner (System.in);
      
      do
      {
         System.out.println ("Please enter number less than 25");
         buttonNumber = in.nextInt();
      } while (buttonNumber > 25);
      
      // Add random numbers
      for (int i = 0; i < buttonNumber; i++)
      {
         count = (int) (Math.random() * 25);
         while (luckyCounts.contains (count))
         {
            count = (int) (Math.random() * 25);
         }
         luckyCounts.add(count);
      } 
   }
   
   /** A listener class, subclassing ActionListener
     */ 
   public class PotLuckListener implements ActionListener 
   {
      public void actionPerformed(ActionEvent e) 
      {
         // Variables
         boolean contain;
         
         // Initialize the variables
         contain = false;
         
         // Set the button enabled
         ((JButton)e.getSource()).setEnabled(false);
         clickCount++;
         
         // Find if the button hides a prize
         for (int i = 0; i < luckyCounts.size(); i++)
         {
            if (e.getSource() == buttons[luckyCounts.get(i)])
            {
               contain = true;
            }
         }
         // If hides
         if (contain)
         {
            buttonCount++;
         }
         
         // Set the label
         topLabel.setText(clickCount + " tries made!" + "  " + buttonCount + "/" + buttonNumber); 
         
         // Find if the game is over
         if (buttonCount == buttonNumber) 
         {
            clickCount++;
            new WinScreen();
         } 
      } 
   }
   
   /** A class, subclassing JFrame
     */ 
   public class WinScreen extends JFrame 
   {
      // Properties
      JLabel win;
      
      /** Constructs a WinScreen object
        */ 
      public WinScreen() 
      {
         // Set the properties of the winscreen
         setLayout(new FlowLayout());
         win = new JLabel(" YOU HAVE FOUND IT IN " + (clickCount - 1) + " TRIES!");
         add(win);
         setBounds(650, 450, 250, 150);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
      }
   }
   
   public static void main(String[] args) 
   { 
      // Start a game
      new PotLuck(); 
   } 
}