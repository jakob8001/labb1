import java.util.Random;

public class Die{

  int sides;
  int value;
  int coin;
  int horse;

  static Random rollDie = new Random();

  public Die(int sides){
    this.sides = sides;
  }
  public void roll(){
    value = rollDie.nextInt(sides) +1;
  }
}
