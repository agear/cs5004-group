import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a student's transcript. A student can add a course, as long as it is
 * in the course directory (CREDITHOURS). They add a course with a letter grade.
 */
public class GradeRecord implements Subject {

  private List<Observer> observerList;
  private List<String> courses;
  private double gpa;
  private double coreGPA;
  private double totalHours;
  private HashMap<String, String> studentGrades;
  private final HashMap<String, Double> CREDITHOURS;
  private final HashMap<String, Double> GRADEVALUES;
  private final List<String> CORECOURSESALIGN;
  private final List<String> CORECOURSES;



  /**
   * Initializes a grade record. It stores the default values for credit hours,
   * for the relationship between a grade letter and a GPA value, and lists of the
   * core MSCS and ALIGN program courses.
   */
  public GradeRecord() {


    this.observerList = new ArrayList<Observer>();
    this.courses = new ArrayList<String>();
    this.studentGrades = new HashMap<String, String>();

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
    this.CREDITHOURS.put("CS5011", 4.0);
    this.CREDITHOURS.put("CS5012", 4.0);
    this.CREDITHOURS.put("CS5013", 4.0);
    this.CREDITHOURS.put("CS5014", 4.0);
    this.CREDITHOURS.put("CS5005", 4.0);
    this.CREDITHOURS.put("CS5006", 2.0);
    this.CREDITHOURS.put("CS5007", 2.0);

    // Map letter grades to numerical equivalents.
    this.GRADEVALUES = new HashMap<>();
    this.GRADEVALUES.put("A", 4.000);
    this.GRADEVALUES.put("A-", 3.667);
    this.GRADEVALUES.put("B+", 3.333);
    this.GRADEVALUES.put("B", 3.000);
    this.GRADEVALUES.put("B-", 2.667);
    this.GRADEVALUES.put("C+", 2.333);
    this.GRADEVALUES.put("C", 2.000);
    this.GRADEVALUES.put("C-", 1.667);
    this.GRADEVALUES.put("D+", 1.333);
    this.GRADEVALUES.put("D", 1.000);
    this.GRADEVALUES.put("D-", 0.667);
    this.GRADEVALUES.put("F", 0.000);

    this.CORECOURSESALIGN = new ArrayList<String>();
    this.CORECOURSESALIGN.add("CS5004");
    this.CORECOURSESALIGN.add("CS5800");
    this.CORECOURSESALIGN.add("CS5600");
    this.CORECOURSESALIGN.add("CS5500");

    this.CORECOURSES = new ArrayList<String>();
    this.CORECOURSES.add("CS5010");
    this.CORECOURSES.add("CS5800");
    this.CORECOURSES.add("CS5600");
    this.CORECOURSES.add("CS5500");

  }

//TODO What happens if the object is already in the list?
  /**
   * Signs up an observer object to be notified when the state of this GradeRecord changes.
   * @param registree The object that wants to know what's going on.
   */
  public void register(Observer registree) {
    this.observerList.add(registree);
  }

  //TODO what happens if the object isn't in the list?
  /**
   * Removes an observer from the observer list so they don't get notified about
   * state changes to this grade record anymore.
   * @param deregistree the object that will be removed from observer list.
   */
  public void remove(Observer deregistree) {
    this.observerList.remove(deregistree);
  }

  /**
   * Sends an update to all observers when this GradeRecord's state changes.
   */
  public void notifyObservers() {
    for (Observer observer : observerList) {
      observer.update();
    }
  }

  /** //TODO What if the course has already been taken? Do we update the grade?
   * Adds a course grade to this object, and recalculates GPA. Notifies observers that the state
   * has changed.
   * @param course The course that has been taken.
   * @param grade The grade earned in that course.
   * @throws IllegalArgumentException if the course doesn't exist at NEU.
   */
  public void addCourseGrade(String course, String grade) throws IllegalArgumentException {

    // If the course doesn't exist (i.e., have a # of hours), a student can't take it
    if (!this.CREDITHOURS.containsKey(course)) {
      throw new IllegalArgumentException("That course doesn't exist in our system.");
    }


    // Add the course to the list of taken courses if they haven't taken it before
    if (!this.courses.contains(course)) {
      this.courses.add(course);
    }

    // Add this student's grade to their transcript.
    this.studentGrades.put(course, grade);

    // Calculate and update GPA.
    this.gpa = this.calculateGPA();

    //Calculate and update Core GPA.
    this.coreGPA = this.calculateCoreGPA();

    // Inform observers of state change.
    notifyObservers();
  }

  //TODO return void instead?
  /** Calculates the student's GPA based on their grade and the weight of the course.
   *
   * @return the student's GPA (in a numeric value).
   */
  public double calculateGPA() {

    // Accumulate a list of courses with grades
    List<String> eligibleCourses = new ArrayList<String>();


    // For each course, add it to the list of eligible courses
    for (String course : this.courses) {

      // Get the student's grade
      String thisGrade = studentGrades.get(course);

      // If the student has a valid grade, add it to eligible list.
      if (GRADEVALUES.keySet().contains(thisGrade)) {
        eligibleCourses.add(course);
      }

    }
    //TODO Duplicate code to new function
    // Initialize variable to store total GPA points earned
    double totalHours = 0;
    double qualityPoints = 0;

    // For each course, accumulate # hours and the grade value
    for (String course : eligibleCourses) {

      // Get # of credit hours the course is worth and accumulate that value
      double hours = this.CREDITHOURS.get(course);
      totalHours += hours;

      // Convert the letter grade to a number grade
      String letterGrade = this.studentGrades.get(course);

      // Calculate GPA points
      qualityPoints += hours * this.GRADEVALUES.get(letterGrade);

    }

    // Calculate GPA, save it, return it
    double gpa = qualityPoints / totalHours;
    this.totalHours = totalHours;
    this.gpa = gpa;
    return this.gpa; //TODO return gpa?
  }

  /** The core courses for a regular MS student are: CS 5010, CS 5800 and one of CS 5500 and
   * CS 5600. For ALIGN students, CS 5004 substitutes CS 5010 as a core course.
   * These are the required courses for graduation with a GPA of 3.0+. This method
   * calculates that GPA based on these courses.
   *
   * @return the GPA of these core courses
   */ //TODO Void return?
  public double calculateCoreGPA() {

    // Accumulate a list of courses with grades
    List<String> eligibleCourses = new ArrayList<String>();

    // For each course, maybe add it to the list of eligible courses
    for (String course : this.courses ) {

      // Get the student's grade
      String thisGrade = studentGrades.get(course);

      // If the student has a valid grade, add the course to eligible list.
      if ( GRADEVALUES.keySet().contains(thisGrade)
              && (this.CORECOURSESALIGN.contains(course)
              || this.CORECOURSES.contains(course))) {
        eligibleCourses.add(course);
      }

    }
  //TODO Duplicate code.
    // Initialize variable to store total GPA points earned
    double totalHours = 0;
    double totalQualityPoints = 0;

    // For each course, accumulate # hours and the grade value
    for (String course : eligibleCourses) {

      // Get # of credit hours the course is worth and accumulate that value
      double hours = this.CREDITHOURS.get(course);
      totalHours += hours;

      // Convert the letter grade to a number grade
      String letterGrade = this.studentGrades.get(course);


      // Calculate GPA points
      totalQualityPoints += hours * this.GRADEVALUES.get(letterGrade);


    }

    // If the student has done 0 core course hours, then their core GPA is 0.
    if (totalHours == 0 ) {
      return 0.0;
    }

    // Calculate core GPA, save it, return it
    double coreGPA = totalQualityPoints / totalHours;
    this.coreGPA = coreGPA;
    return coreGPA;
  }

  /**
   * Method to get this Grade Records GPA.
   *
   * @return A double representing this Grade Records GPA.
   */
  public double getGPA() {

    // Make sure it is updated before returning the value.
    this.gpa = this.calculateGPA();
    //TODO Return duplicate.
    return this.gpa;
  }

  /**
   * Method to get this Grade Records Core GPA.
   *
   * @return A double representing this Grade Records Core GPA.
   */
  public double getCoreGPA() {

    // Make sure it is updated before returning the value.
    this.coreGPA = this.calculateCoreGPA();
    //TODO Return duplicate.
    return this.coreGPA;
  }

  /**
   * Method to get this Grade Records total hours.
   *
   * @return A double representing this Grade Records total hours.
   */
  public double getTotalHours() {
    //TODO Return duplicate.
    return this.totalHours;
  }

}
