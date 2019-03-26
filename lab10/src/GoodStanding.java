public class GoodStanding implements Observer{

  private double GPA;
  private Subject gradeRecord;

  /** Constructor.
   * TODO Javadoc
   * @param gradeRecord
   */
  public GoodStanding(Subject gradeRecord) {
  this.gradeRecord = gradeRecord;
  gradeRecord.add(this);
  }

  /**
   * TODO Javadoc
   */
  @Override
  public void update() {
    this.GPA = this.gradeRecord.getGPA();
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
