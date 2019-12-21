import java.util.ArrayList;

public class BattleShipGame {

  private int numOfGuess = 0;
  private ArrayList<BattleShip> battleShips = new ArrayList<>();
  private GameHelper helper = new GameHelper();

  public static void main(String[] args) {
    BattleShipGame game = new BattleShipGame();
    game.setUpGame();
    game.startPlaying();
  }

  private void setUpGame() {
    BattleShip one = new BattleShip();
    one.setName("Nimitz");
    BattleShip two = new BattleShip();
    two.setName("Enterprise");
    BattleShip three = new BattleShip();
    three.setName("Kennedy");

    battleShips.add(one);
    battleShips.add(two);
    battleShips.add(three);

    System.out.println("Your goal is to sink three battleships.");
    System.out.println(one.getName() + ", " + two.getName() + ", and " + three.getName() + ".");
    System.out.println("Try to sink them all in the fewest number of guesses.");

    for (BattleShip battleShip : battleShips) {
      ArrayList<String> location = helper.placeShip(3);
      battleShip.setLocationCells(location);
    }
  }

  private void startPlaying() {
    while (!battleShips.isEmpty()) {
      String userGuess = helper.getUserInput("Enter a guess.");
      checkUserGuess(userGuess);
    }
    finishGame();
  }

  private void checkUserGuess(String userGuess) {
    numOfGuess++;
    String result = "miss";
    for (BattleShip battleShip : battleShips) {
      result = "miss";
      result = battleShip.checkYourself(userGuess);
      if (result.equals("hit")) {
        break;
      }
      if (result.equals("kill")) {
        battleShips.remove(battleShip);
        break;
      }
    }
    System.out.println(result);
  }

  private void finishGame() {
    System.out.println("You sunk all of the Battleships!");
    if (numOfGuess <= 18) {
      System.out.println("It only took you " + numOfGuess + " guesses.");
    } else {
      System.out.println("Took you long enough. " + numOfGuess + " guesses.");
    }
  }


}
