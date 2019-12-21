import java.util.List;

public class BattleShip {

  private List<String> locationCells;
  private int numOfHits = 0;
  private String name;

  public BattleShip() {
  }

  public String checkYourself(String userInput) {
    //Initialize the result variable to fale, aka "miss"
    String result = "miss";
    int index = locationCells.indexOf(userInput);
    if (index >= 0) {
      locationCells.remove(index);

      if (locationCells.isEmpty()) {
        result = "kill";
      } else {
        result = "hit";
      }
    }
    System.out.println(result);
    return result;
  }

  public void setLocationCells(List<String> locationCells) {
    this.locationCells = locationCells;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
