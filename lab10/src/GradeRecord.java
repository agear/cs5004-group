import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GradeRecord implements Subject {

  private List<Observer> observerList;
  private List<String> courses;
  private double GPA;
  private double CoreGPA;
  private double totalHours;
  private double totalQualityPoints;
  private final HashMap<String, Double> CREDITHOURS;
  private final HashMap<String, Double> GRADES;

  /**
   * TODO Javadoc.
   */
  public GradeRecord() {
    this.observerList = new ArrayList<Observer>();
    this.courses = new ArrayList<String>();
    // Map courses to their number of credit hours.
    this.CREDITHOURS = new HashMap<>();
    this.CREDITHOURS.put("CS5010", 4.0);
    this.CREDITHOURS.put("CS5800", 4.0);
    this.CREDITHOURS.put("CS5500", 4.0);
    this.CREDITHOURS.put("CS5600", 4.0);
    this.CREDITHOURS.put("CS5001", 4.0);
    this.CREDITHOURS.put("CS5002", 4.0);
    this.CREDITHOURS.put("CS5003", 4.0);
    this.CREDITHOURS.put("CS5004", 4.0);
    this.CREDITHOURS.put("CS5005", 4.0);
    this.CREDITHOURS.put("CS5006", 2.0);
    this.CREDITHOURS.put("CS5007", 2.0);
    // Map letter grades to numerical equivalents.
    this.GRADES = new HashMap<>();
    this.GRADES.put("A", 4.000);
    this.GRADES.put("A-", 3.667);
    this.GRADES.put("B+", 3.333);
    this.GRADES.put("B", 3.000);
    this.GRADES.put("B-", 2.667);
    this.GRADES.put("C+", 2.333);
    this.GRADES.put("C", 2.000);
    this.GRADES.put("C-", 1.667);
    this.GRADES.put("D+", 1.333);
    this.GRADES.put("D", 1.000);
    this.GRADES.put("D-", 0.667);
    this.GRADES.put("F", 0.000);


  }


  /**
   * TODO Javadoc.
   */
  public void register(Observer registree) {
    this.observerList.add(registree);
  }

  /**
   * TODO probably not strictly necessary for this assignment. TODO javadoc
   */
  public void remove(Observer deregistree) {
    this.observerList.remove(deregistree);
  }

  /**
   * TODO Javadoc.
   */
  public void notifyObservers() {
    for (Observer observer : observerList) {
      observer.update();
    }
  }

  /**
   * TODO Javadoc.
   */
  public void addCourseGrade(String course, String grade) {
    // TODO Add course grade data
    this.courses.add(course);
    double hours = this.CREDITHOURS.get(course);
    this.totalHours += hours;
    double qualityPoints = hours * this.GRADES.get(grade);
    totalQualityPoints += qualityPoints;
    this.GPA = totalQualityPoints / totalHours;
    notifyObservers();
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

  public double calculateCoreGPA() {
    //A student must have a GPA of at least 3.0 in all core courses combined
    // (CS 5010, CS 5800 and one of CS 5500 and CS 5600) in order to graduate.
    // For ALIGN students, CS 5004 substitutes CS 5010 as a core course

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

  /**
   * Method to get this Grade Records GPA.
   *
   * @return A double representing this Grade Records GPA.
   */
  public double getGPA() {
    return this.GPA;
  }

  /**
   * Method to get this Grade Records Core GPA.
   *
   * @return A double representing this Grade Records Core GPA.
   */
  public double getCoreGPA() {
    return this.CoreGPA;
  }

  /**
   * Method to get this Grade Records total hours.
   *
   * @return A double representing this Grade Records total hours.
   */
  public double getTotalHours() {
    return this.totalHours;
  }
}
