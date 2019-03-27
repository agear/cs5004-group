/**
 * Monitors if a student is eligible to go on co-op. They are eligible if
 * they've taken 16+ credits(hours) and have maintained a gpa of at least 3.0.
 */
public class CoOp implements Observer {

  private double gpa;
  private double credits;
  private GradeRecord gradeRecord;

  /**
   * Creates an observer that keeps track of the student's grade record
   * in order to monitor if they need to retake a course, improve gpa, etc
   * in order to be eligible for co-op.
   * @param gradeRecord The student in question's record
   */
  public CoOp(GradeRecord gradeRecord) {
    this.gradeRecord = gradeRecord;
    gradeRecord.register(this);
  }

  /**
   * This method updates the fields relevant to co-op eligibility, the # hours
   * and the gpa.
   */
  public void update() {
    this.gpa = this.gradeRecord.getGPA();
    this.credits = this.gradeRecord.getTotalHours();
  }

  /**
   * Returns true if the student can go on co-op, i.e., if they have 16+ credits
   * and a gpa of 3.0+. Returns false otherwise.
   * @return true if the student can go on co-op, false otherwise
   */
  public boolean getStatus() {
    return (this.credits >= 16 && this.gpa >= 3.0);
  }
}
