public class CoOp implements Observer {

  private double GPA;
  private double credits;
  GradeRecord gradeRecord;

  /**
   * Constructor. TODO Javadoc
   */
  public CoOp(GradeRecord gradeRecord){
    this.gradeRecord = gradeRecord;
    gradeRecord.register(this);
  }
  /**
   * TODO Javadoc
   */
  @Override
  public void update() {
    this.GPA = this.gradeRecord.getGPA();
    this.credits = this.gradeRecord.getTotalHours();
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
