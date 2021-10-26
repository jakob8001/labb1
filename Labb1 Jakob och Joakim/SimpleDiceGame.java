import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SimpleDiceGame{

  static ArrayList<Player> Players = new ArrayList<Player>();

  public static void main(String[] args) {

    initialize();

    for (int i = 0;i<5;i++ ) {
      takeTurn(Players);
    }
    getWinners(Players);

  }
  public static ArrayList<Player> initialize(){
    Scanner userInput = new Scanner(System.in);

    System.out.println("Welcome to SUPER POWER DICE Remasterd");
    System.out.println("Enter how meny players:");
    int nrOfPlayers = userInput.nextInt(); userInput.nextLine();
    System.out.println("Enter names of Players:");
    for (int i = 0;i < nrOfPlayers ; i++ ) {
      System.out.println("Player" +(i+1)+":");
      String name = userInput.nextLine();
      Player p = new Player(name);
      Players.add(p);
    }
    System.out.println("Enter number of dice");
    int nrOfDice = userInput.nextInt();
    System.out.println("Enter sides of dice");
    int sidesOnDice = userInput.nextInt();
    for (Player pl: Players) {
      for (int j = 0;j<nrOfDice ;j++ ) {
        pl.addDie(sidesOnDice);
      }
    }
    return Players;
  }
  public static void takeTurn(ArrayList<Player> Players){
    Scanner userInput = new Scanner(System.in);

    for (Player pl: Players) {
      pl.rollDie();
      int answer = pl.getDieValue();

      System.out.println(pl.name + ", Guess the combined die value");
      int guess = userInput.nextInt();

      if (guess == answer) {
        pl.increaseScore();
      }
    }
  }
  public static ArrayList<Player> getWinners(ArrayList<Player> Players){
    Collections.sort(Players, new Comparator<Player>(){
      public int compare(Player p1, Player p2){
        return Integer.valueOf(p2.points).compareTo(p1.points);
      }
    });
    System.out.println("The final result is:");
    for (Player winners:Players) {
      System.out.println(winners.name);
      System.out.println("The final score is:"+winners.points);
    }
    return Players;
  }
}
