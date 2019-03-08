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
    System.out.println("meanX is " + meanX);
    System.out.println("meanY is " + meanY);


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

    System.out.println("Syy is " + Syy);
    System.out.println("Sxx is " + Sxx);
    System.out.println("Sxy is " + Sxy);


    // Step 2: get the distance (radians)
    double distance = (2 * Sxy) / (Sxx - Syy);
    System.out.println("distance is " + distance);

    // Step 3: Get the theta
    double theta = Math.atan(distance);
    System.out.println("theta is " + theta);


    // Step 4: Compute f(t)
    double fta = (Syy - Sxx) * (Math.cos(theta)) - 2 * (Sxy * Math.sin(theta));
    double ftb = (Syy - Sxx) * (Math.cos(theta+Math.PI)) - 2 * (Sxy * Math.sin(theta+Math.PI));

    // Get the positive one to use in final calculation
    double tPositive;

    if (fta > ftb){
      tPositive = fta;
    }

    else {
      tPositive = ftb;
    }

    System.out.println("tPositive is " + tPositive);


    // Step 5: Compute a,b,c to get the best fit line.
    double a = Math.cos(tPositive/2);
    double b = Math.sin(tPositive/2);
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
