import java.util.ArrayList;

public class Player{
  String name;
  int points;
  ArrayList<Die> listOfDie = new ArrayList<Die>();

  public Player(String name){
    this.name = name;
  }
  public void rollDie(){
    for(Die d: listOfDie){
      d.roll();
    }
  }
  public int getDieValue(){
    int sumOfDie = 0;
    for (Die valueDie: listOfDie ) {
      sumOfDie = sumOfDie + valueDie.value;
    }
    return sumOfDie;
  }
  public void increaseScore(){
    points += 1;
  }
  public void addDie(int sides){
    Die die = new Die(sides);
    listOfDie.add(die);
  }
}
