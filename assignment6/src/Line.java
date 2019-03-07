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
  public Line(LinkedList<Point> inputData) {

    // Setup initialized variables
    double sumX = 0;
    double meanX = 0;
    double sumY = 0;
    double meanY = 0;
    double Syy = 0;
    double Sxx = 0;
    double Sxy = 0;

    // Calculate n (number of points)
    double n = inputData.size();


    // For all points, iterate through them and get sum of each
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

    // Compute means
    meanX = (sumX)/n;
    meanY = (sumY)/n;


    // Compute squares to find minimum
    Syy = (sumY - meanY) * (sumY - meanY);
    Sxx = (sumX - meanX) * (sumX - meanX);
    Sxy = (sumX - meanX) * (sumY - meanY);


    // Step 2: get the distance
    double distance = (2 * Sxy) / (Sxx - Syy);

    // Step 3: Get the theta
    double theta = 1.0/Math.tan(distance);

    // Step 4: Compute f(t)
    double fta = (Syy - Sxx) * (Math.cos(theta)) - 2 * (Sxy * Math.sin(theta));
    double ftb = (Syy - Sxx) * (Math.cos(theta+180)) - 2 * (Sxy * Math.sin(theta+180));

    double tPositive;

    // Get the positive one to use in final calculation
    if (fta > ftb){
      tPositive = fta;
    }

    else {
      tPositive = ftb;
    }

    // Step 5: Compute a,b,c to get the best fit line.
    double a = Math.cos(tPositive/2);
    double b= Math.sin(tPositive/2);
    double c = (-a * meanX) - (b * meanY);


    // Assign values to this line object
    this.a = a;
    this.b = b;
    this.c = c;
  }


  /** Creates a string of this line in the format "ax + by + c = 0".
   * @return
   */
  @Override
  public String toString(){
    return this.a + "x + " + this.b + "y + " + this.c + " = 0";
  }


}
