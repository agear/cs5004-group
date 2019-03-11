import java.util.LinkedList;
import java.lang.Math;
import java.util.Iterator;

/**
 * Represents a line on a 2D graph in the format ax + by + c = 0.
 */
public class Line {
  double a;
  double b;
  double c;

  /**
   * Creates a Line object using pre-defined inputs in the format
   * ax + by + c = 0.
   * @param a coefficient of x
   * @param b coefficient of y
   * @param c y-intercept of the function
   */
  public Line(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }


  /** Calculates the line of best fit and assigns the values in the format
   * ax + by + c = 0 to this object's attributes. Calculation done by minimizing
   *  the sum of the squares of distances of the points from the line.
   * @param inputData A list of points scattered on a grid
   */
  public Line(LinkedList<Point> inputData) throws IllegalArgumentException {

    // Throw exception if there's only one point in the data
    if (inputData.size() < 2 ) {
      throw new IllegalArgumentException("More data needed to create a line of best fit.");
    }


    // Setup initialized variables
    double sumX = 0;
    double sumY = 0;

    // Calculate n (number of points)
    double n = inputData.size();

    // For all points, iterate through them and get sum of all x and all y
    Iterator<Point> iterator = inputData.iterator();
    while (iterator.hasNext()) {

      // Access the current point's details
      Point currentPoint = iterator.next();
      double currentX = currentPoint.getX();
      double currentY = currentPoint.getY();

      // Compute sum
      sumX = sumX + currentX;
      sumY = sumY + currentY;

    }

    // Compute average for both
    double meanX = (sumX) / n;
    double meanY = (sumY) / n;

    double Sxx = 0;
    double Syy = 0;
    double Sxy = 0;


    // For all points, iterate through them and get sum of all x and all y
    Iterator<Point> iterator2 = inputData.iterator();
    while (iterator2.hasNext()) {

      // Access the current point's details
      Point currentPoint = iterator2.next();
      double currentX = currentPoint.getX();
      double currentY = currentPoint.getY();

      Sxx = Sxx + (currentX - meanX) * (currentX - meanX);
      Syy = Syy + (currentY - meanY) * (currentY - meanY);
      Sxy = Sxy + (currentX - meanX) * (currentY - meanY);

    }

    // Step 2: get the distance
    double distance = (2 * Sxy) / (Sxx - Syy);

    // Step 3: Get the theta
    double theta = Math.atan(distance);

    // Step 4: Compute f(t)
    double sqDiff = Syy - Sxx;
    double fta = sqDiff * Math.cos(theta) - 2 * Sxy * Math.sin(theta);
    double ftb = sqDiff * Math.cos(theta+Math.PI) - 2 * Sxy * Math.sin(theta+Math.PI);

    // Get the theta that made f(t) positive to use in final calculation
    double tPositive;
    if (fta > ftb){ tPositive = theta; }
    else { tPositive = theta + Math.PI; }

    // Step 5: Compute a,b,c to get the best fit line in standard form.
    double a = Math.cos(tPositive/2);
    double b = Math.sin(tPositive/2);
    double c = (-a * meanX) - (b * meanY);

    // Assign values to this line object
    this.a = a;
    this.b = b;
    this.c = c;
  }



  /** Creates a string of this line in the format "ax + by + c = 0".
   * a, b, and c are truncated to the thousands place
   * @return A printable string in the format ax + by + c = 0
   */
  @Override
  public String toString(){
    String aTrunc = String.format("%.3f", this.a);
    String bTrunc = String.format("%.3f", this.b);
    String cTrunc = String.format("%.3f", this.c);

    return aTrunc + "x + " + bTrunc + "y + " + cTrunc + " = 0";
  }



  public double solveLine(double x){
//    ax + by + c = 0.
    double ax = this.a * x;
    return (0 - ax - this.c)/this.b;

  }


}
