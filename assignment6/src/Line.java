import java.util.LinkedList;
import java.util.Math;


/**
 * Class that represents a line in the format ax + by + c = 0.
 */
public class Line {
  double a;
  double b;
  double c;

  /**
   * TODO Write Java Doc.
   */
  public Line(double a, double x, double b, double y) {
    this.a = a;
    this.x = x;
    this.b = b;
    this.y = y;
  }


  // TODO write javadoc
  public Line(LinkedList<Point> inputData) {

    // Setup initialized variables
    double sumX = 0;
    double meanX = 0;
    double sumY = 0;
    double meanX = 0;
    double Syy = 0;
    double Sxx = 0;
    double Sxy = 0;
    int n = 0;


    // For all points, iterate through them and get totals
    Iterator<String> iterator = linkedList.iterator();
    while (iterator.hasNext()) {
      // Increment total # of points
      n++;

      // Access the current point's details
      Point currentPoint = iterator.next();
      double currentX = currentPoint.getX();
      double currentY = currentPoint.getY();

      // Compute new means
      meanX = (sumX + currentX)/n;
      sumX = sumX + currentX;
      meanY = (sumY + currentY)/n;
      sumY = sumY + currentY;

      Syy = (currentY - meanY) * (currentY - meanY);
      Sxx = (currentX - meanX) * (currentX - meanX);
      Sxy = (currentX - meanX) * (currentY - meanY);

    }

    // Step 2: get the distance
    double distance = (2 * Sxy) / (Sxx - Syy);

    // Step 3: Get the theta
    double theta = 1.0/Math.tan(distance);

    // Step 4: Compute f(t)
    double fta = (Syy - Sxx) * (Math.cos(theta) - 2) * Sxy * Math.sin(theta);
    double ftb = (Syy - Sxx) * (Math.cos(theta+180) - 2) * Sxy * Math.sin(theta+180);

    double tPositive;

    if (fta > ftb){
      tPositive = fta;
    }

    else {
      tPositive = ftb;
    }

    // Step 5: Compute a,b,c to get the best fit line.
    double a = Math.cos(tPositive/2);
    double b= sin(tPositive/2);
    double c = (-a*meanX) - (b*meanY);

    this.a = a;
    this.b = b;
    this.c = c;


  }

}
