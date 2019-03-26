public class CanGraduate implements Observer {

  private double CoreGPA;
  Subject gradeRecord;

  /** Constructor.
   * TODO Javadoc
   * @param gradeRecord
   */
  public CanGraduate(Subject gradeRecord) {
    this.gradeRecord = gradeRecord;
    gradeRecord.add(this);
  }
  /**
   * TODO Javadoc
   */
  @Override
  public void update() {
    this.CoreGPA = GradeRecord.getCoreGPA();
  }

  //A student must have a GPA of at least 3.0 in all core courses combined
  // (CS 5010, CS 5800 and one of CS 5500 and CS 5600) in order to graduate.
  // For ALIGN students, CS 5004 substitutes CS 5010 as a core course

  /**
   * TODO Javadoc
   */
  public boolean getStatus() {
    return (this.CoreGPA >= 3.0);
  }
}
