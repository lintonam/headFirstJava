import java.util.ArrayList;
import java.util.List;

public class BattleShipTestDrive {

  public static void main(String[] args) {
    BattleShip battleShip = new BattleShip();

    List<String> locations = new ArrayList<>();
    locations.add("a2");
    locations.add("a3");
    locations.add("a4");

    battleShip.setLocationCells(locations);

    String userGuess = "a2";
    String result = battleShip.checkYourself(userGuess);
    String testResult = "failed";
    if (result.equals("hit")) {
      testResult = "passed";
    }

    System.out.println(testResult);
  }
}
