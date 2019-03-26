public class CoOp implements Observer {

  private double GPA;
  private int credits;
  /**
   * TODO Javadoc
   */
  @Override
  public void notifyObserver() {

  }

  //A student is eligible to go on co-op at any time after taking at least 16 credits and maintaining
  // a cumulative GPA of at least 3.0.
  /**
   * TODO Javadoc
   * @return
   */
  public boolean getStatus() {
    return (credits >= 16 && GPA >= 3.0);
  }
}
