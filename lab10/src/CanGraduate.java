public class CanGraduate implements Observer {

  private double CoreGPA;

  /**
   * TODO Javadoc
   */
  @Override
  public void notifyObserver() {

  }

  //A student must have a GPA of at least 3.0 in all core courses combined
  // (CS 5010, CS 5800 and one of CS 5500 and CS 5600) in order to graduate.
  // For ALIGN students, CS 5004 substitutes CS 5010 as a core course

  /**
   * TODO Javadoc
   */
  public boolean getStatus() {
    return (CoreGPA >= 3.0);
  }
}
