import dice.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         startScreen();
    }
    
    public static void startScreen() {
         Scanner scan = new Scanner(System.in);
         System.out.print("\nWelcome to Three to Twenty Three: ");
         System.out.println("A simple dice game inspired by Blackjack.");
         
         int input = 0;
         boolean continueGame = true;
         
         do {
            System.out.println("\nSelect an option below: ");
            System.out.println("1. How to play");
            System.out.println("2. Play");
            System.out.println("3. Leaderboard");
            System.out.println("4. Statistics");
            System.out.println("5. Quit");
            
            input = getIntInput();
            
            switch(input) {
               case 1:
                  howToPlay();
                  break;
               case 2:
                  play();
                  break;
               case 3:
                  leaderboard();
                  break;
               case 4:
                  statistics();
                  break;
               case 5:
                  System.out.println("\nThanks for playing!");
                  continueGame = false;
                  break;
               default:
                  System.out.println("\nError: Invalid option, try again!");
                  break;
            }
         } while (continueGame);
    }
    
    public static void howToPlay() {
         System.out.println("\n- How to play -");
         
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
         //Prompt for initials
         String name = getInitials();
         DiceGame game = null;
         
         try {
            game = DiceGame.create(name);
         } catch (InvalidUsernameException e) {
            System.out.println("Error: " + e.getMessage());
         }
         
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
                  RollResult result;
                  
                  try {
                     result = game.roll(numDice);
                     rollTotal = result.sum();
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
                  System.out.println("\nError: Invalid option, try again!");
                  break;
            }
            
            if (game.getCurrentTotal() >= 23) {
               continueGame = false;
            }
         } while (continueGame);
         
         System.out.print("\nGame over! With a total of " + game.getCurrentTotal());
         System.out.println(", your final score is: " + game.getScore());
    }
    
    public static void leaderboard() {
      //Need to finish
      System.out.println("\nUnder Construction, come back soon!");
    }
    
    public static void statistics() {
       boolean invalidInput = false;
       int input;
       
       do {
         System.out.println("\nSelect an option below:");
         System.out.println("1. Player Statistics");
         System.out.println("2. All Statistics");
         
         input = getIntInput();
         
         switch(input) {
            case 1:
               playerStatistics();
               break;
            case 2:
               allStatistics();
               break;
            default:
               System.out.println("\nError: Invalid option, try again!");
               invalidInput = true;
               break;
         }
      } while (invalidInput);
    }
    
    public static void playerStatistics() {
      StatsProcessor stats = StatsProcessor.create();
      String[] playerNames = stats.getPlayerList();
      int input;
      
      //Select from a list of player names
      do {
         System.out.println("\nSelect a player:");
         for (int index = 0; index < playerNames.length; index++) {
            System.out.println((index + 1) + ". " + playerNames[index]);
         }
         
         input = getIntInput() - 1;
         
      } while (!validIntInput(input, 0, (playerNames.length - 1)));
      
      //Select chosen player
      StatsData playerStats = stats.getPlayerStats(playerNames[input]);
      
      //Display player's statistics
      System.out.println("\n- Statistics for " + playerNames[input] + "-");
      displayStatistics(playerStats);
    }
    
    public static void allStatistics() {
      StatsProcessor stats = StatsProcessor.create();
      StatsData allStats = stats.getAllStats();
      
      //Display aggregate statistics
      System.out.println("\n- All Statistics -");
      displayStatistics(allStats);
    }
    
    public static void displayStatistics(StatsData stats) {
      //Header
      System.out.printf("%-20s %-20s %-20s %-20s %-20s %n",
                        "Total Rolls",
                        "Avg Rolls Per Game",
                        "Cumulative Score",
                        "Avg Score",
                        "Avg # Of Dice Used");
      //Data
      System.out.printf("%-20s %-20s %-20s %-20s %-20s %n",
                        stats.getTotalRolls(),
                        stats.getAvgRollsPerGame(),
                        stats.getCumulativeScore(),
                        stats.getAvgScore(),
                        stats.getAvgNumDiceUsed());
    }
    
    public static int changeDice() {
         Scanner scan = new Scanner(System.in);
         int numDice = 0;
         
         do {
            System.out.print("\nEnter number of dice (1-3): ");
            
            numDice = getIntInput();
            
         } while (!validIntInput(numDice, 1, 3));
         
         return numDice;
    }
    
    public static int getIntInput() {
      Scanner scan = new Scanner(System.in);
      int input = 0;
      
      while (!scan.hasNextInt()) {
         System.out.println("\nError: Input must be an integer, please try again!");
         scan.next(); //Clears the new line character
      }
      
      input = scan.nextInt();
      
      return input;
    }
    
    public static String getInitials() {
      Scanner scan = new Scanner(System.in);
      String input;
      
      do {
         System.out.println("\nEnter your initials (3 characters): ");
         input = scan.nextLine();
         if (input.length() != 3) {
            System.out.println("\nError: Initials must contain 3 letters.");
         }
      } while (input.length() != 3);
      
      return input;
    }
    
    public static boolean validIntInput(int input, int min, int max) {
      if (input < min || input > max) {
         System.out.println("\nError: Invalid option, try again!");
         return false;
      }
      return true;
    }
}
