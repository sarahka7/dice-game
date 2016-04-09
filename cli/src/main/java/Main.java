import dice.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         startScreen();
    }
    
    public static void startScreen() {
         Scanner scan = new Scanner(System.in);
         System.out.print("\nWelcome to Three to Twenty Three: ");
         System.out.println("A simple dice game inspired by Blackjack.\n");
         
         int input = 0;
         boolean continueGame = true;
         
         do {
            System.out.println("Select an option below: ");
            System.out.println("1. How to play");
            System.out.println("2. Play");
            System.out.println("3. Quit");
            
            input = getIntInput();
            
            switch(input) {
               case 1:
                  howToPlay();
                  break;
               case 2:
                  play();
                  break;
               case 3:
                  System.out.println("\nThanks for playing!");
                  continueGame = false;
                  break;
               default:
                  System.out.println("\nError: Invalid option, try again!\n");
                  break;
            }
         } while (continueGame);
    }
    
    public static void howToPlay() {
         System.out.println("\n- HOW TO PLAY -");
         
         System.out.print("The goal of the game is to reach a total of ");
         System.out.println("23, or get as close as you can without going over.\n");
         System.out.println("You reach the total by adding the sum of each roll.\n");
         
         System.out.print("You have the choice to use 1, 2, or 3 ");
         System.out.print("dice to increase your overall total ");
         System.out.println("and achieve the goal of 23.\n");
         
         System.out.println("If you go over 23, it's game over and your score is 0.\n");
         System.out.println("Stopping before 23, your total is recorded as your score.\n");
         System.out.println("If you reach 23, your score doubles to 46.\n");
    }
    
    public static void play() {
         DiceGame game = new DiceGame();
         Scanner scan = new Scanner(System.in);
         
         int input = 0;
         boolean continueGame = true;
         int numDice = 3;
         
         do {
            System.out.println("\nCurrent total: " + game.getCurrentTotal());
            System.out.println("Number of dice: " + numDice);
            System.out.println("\n1. Roll");
            System.out.println("2. Change number of dice");
            System.out.println("3. Stop rolling");
            
            input = getIntInput();
                  
            switch(input) {
               case 1:
                  int rollTotal = 0;
                  
                  try {
                     rollTotal = game.roll(numDice);
                  } catch (RollAfterGameOverException e) {
                     System.out.println("Error: " + e.getMessage());
                  }
                  
                  System.out.println("\nYou rolled " + numDice + " dice, for a total of " + rollTotal);
                  
                  break;
               case 2:
                  numDice = changeDice();
                  break;
               case 3:
                  continueGame = false;
                  break;
               default:
                  System.out.println("Error: Invalid option, try again!\n");
                  break;
            }
            
            if (game.getCurrentTotal() >= 23) {
               continueGame = false;
            }
         } while (continueGame);
         
         System.out.print("\nGame over! With a total of " + game.getCurrentTotal());
         System.out.println(", your final score is: " + game.getScore() + "\n");
    }
    
    public static int changeDice() {
         Scanner scan = new Scanner(System.in);
         int numDice = 0;
         
         do {
            System.out.print("\nEnter number of dice (1-3): ");
            
            numDice = getIntInput();
            
         } while (numDice < 1 || numDice > 3);
         
         return numDice;
    }
    
    public static int getIntInput() {
      Scanner scan = new Scanner(System.in);
      int input = 0;
      
      while (!scan.hasNextInt()) {
         System.out.println("\nError: Input must be an integer, please try again!\n");
         scan.next(); //Clears the new line character
      }
      
      input = scan.nextInt();
      
      return input;
    }
}