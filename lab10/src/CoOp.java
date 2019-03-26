public class CoOp implements Observer {

  private double GPA;
  private int credits;
  Subject gradeRecord;

  /** Constructor.
   * TODO Javadoc
   * @param gradeRecord
   */
  public CoOp(Subject gradeRecord){
    this.gradeRecord = gradeRecord;
    gradeRecord.add(this);
  }
  /**
   * TODO Javadoc
   */
  @Override
  public void update() {
    this.GPA = GradeRecord.getGPA();
    this.credits = GradeRecord.getTotalHours();
  }

  //A student is eligible to go on co-op at any time after taking at least 16 credits and maintaining
  // a cumulative GPA of at least 3.0.
  /**
   * TODO Javadoc
   * @return
   */
  public boolean getStatus() {
    return (this.credits >= 16 && this.GPA >= 3.0);
  }
}
