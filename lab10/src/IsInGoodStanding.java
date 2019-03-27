/**
 * Moniters if a student is in good standing at the university. They are if
 * they have maintained a GPA of at least 3.0.
 */
public class IsInGoodStanding implements Observer {

  private double gpa;
  private GradeRecord gradeRecord;

  /**
   * Creates an observer that keeps track of the student's grade record
   * in order to monitor if they need to retake a course, improve GPA,
   * etc., in order to be in good academic standing.
   * @param gradeRecord The student in question's record
   */
  public IsInGoodStanding(GradeRecord gradeRecord) {
    this.gradeRecord = gradeRecord;
    gradeRecord.register(this);
  }

  /**
   * This method updates the fields relevant to good academic standing,
   * which is only the GPA.
   */
  @Override
  public void update() {
    this.gpa = this.gradeRecord.getGPA();
  }



  /**
   * Returns true if the student is in good academic standing, i.e., a GPA of 3.0+.
   * @return true if the student is in good academic standing, false otherwise.
   */
  public boolean getStatus() {
    return (this.gpa >= 3.0);
  }
}
