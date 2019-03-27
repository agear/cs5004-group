/**
 * A student can graduate if they have a core GPA of 3.0+.
 * This class keeps track of this metric.
 * If the student has taken 0 core courses, they aren't eligible for graduation.
 */
public class CanGraduate implements Observer {

  private double coreGPA;
  GradeRecord gradeRecord;

  /**
   * Creates an observer that keeps track of the student's grade record
   * in order to notify them if they need to retake a course, improve GPA, etc.
   * @param gradeRecord The student in question's record.
   */
  public CanGraduate(GradeRecord gradeRecord) {
    this.gradeRecord = gradeRecord;
    gradeRecord.register(this);
  }

  /**
   * This method updates the only field relevant to graduation, the coreGPA.
   */
  @Override
  public void update() {
    this.coreGPA = this.gradeRecord.getCoreGPA();
  }

  //TODO must the student have taken all the core courses to graduate also?
  /**
   * Returns true if the student can graduate, ie if their coreGPA is at least 3.0.
   * Returns false otherwise.
   * @return true if the student can graduate, false otherwise
   */
  public boolean getStatus() {
    return (this.coreGPA >= 3.0);
  }
}
