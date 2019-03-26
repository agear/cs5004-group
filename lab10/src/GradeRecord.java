import java.util.List;

public class GradeRecord implements Subject {

  private List<Observer> observerList;
  private List<String> courses;
  private double GPA;

  public GradeRecord() {
  }

  /**
   * TODO javadoc
   */
  @Override
  public void register(Observer registree) {
    this.observerList.add(registree);
  }

  public void addCourseGrade(String course, String grade) {
    // TODO Add course grade data

    // Notify all observers of update
    for (Observer observer : observerList) {
      observer.notify();
    }
  }

  public double calculateGPA() {
    // 2. Cross out courses in which you received S, U, X, I, L, or W grades.
    // Also, cross out courses with an E in the R column. These do not calculate into your QPA.

    // 3. Write the numerical equivalent of the grade beside it on the transcript:
    // A  = 4.000
    // A- = 3.667
    // B+ = 3.333
    // B  = 3.000
    // B- = 2.667
    // C+ = 2.333
    // C  = 2.000
    // C- = 1.667
    // D+ = 1.333
    // D  = 1.000
    // D- = 0.667
    // F  = 0.000

    // 4. Multiply the hours of each course by the numerical equivalent of the letter grade.
    //   This is the quality-point number for the course.

    // 5. Add all valid quality-point numbers.

    // 6. Add all hours taken at Northeastern—do not include transfer credit hours.

    // 7. Divide total quality points by total hours taken at Northeastern.

    // 8. Result is your GPA or QPA.

    return 0;
  }

}
