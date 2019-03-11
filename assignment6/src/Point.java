// Write a class that stores and operates upon the data. Again, the data for this assignment is in
// the form of (x,y) points.

/**
 * Represents a point on a 2D graph as an x and y coordinate.
 */
public class Point {
  double x;
  double y;

  /**
   * Initializes a 2D point on a graph.
   *
   * @param x The x-coordinate
   * @param y The y-coordinate
   */
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Getter method for the x-coordinate.
   *
   * @return The x-coordinate.
   */
  public double getX() {
    return this.x;
  }

  /**
   * Getter method for the y-coordinate.
   *
   * @return The y-coordinate.
   */
  public double getY() {
    return this.y;
  }


  /**
   * Gets the Euclidian Distance between two points. Euclidian distance is calculated as the square
   * root of the sum of the squares of the differences between coordinates.
   * @param other point object.
   * @return The Euclidian Distance between this point and another point.
   */
  public double getDistance(Point other) {
    return Math.sqrt(Math.pow((this.getX() - other.getX()), 2) + Math.pow((this.getY() - other.getY()), 2));
  }

  /** Creates a string of this point in the format "(x, y)".
   * x and y are truncated to the thousandths place.
   * @return A printable string in the format (x, y).
   */
  @Override
  public String toString(){
    String xTrunc = String.format("%.3f", this.x);
    String yTrunc = String.format("%.3f", this.y);
    return "(" + xTrunc + ", " + yTrunc + ")";
  }


}
