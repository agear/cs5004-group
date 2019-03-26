public class GoodStanding implements Observer{

  private double GPA;

  public GoodStanding() {
      
  }

  /**
   * TODO Javadoc
   */
  @Override
  public void notifyObserver() {
    this.GPA = GradeRecord.getGPA();
  }

  //the cumulative GPA must be at 3.0 or above at any point in the program to be in good academic standing
  /**
   * TODO Javadoc
   * @return
   */
  public boolean getStatus() {

    return (this.GPA >= 3.0);
  }
}
