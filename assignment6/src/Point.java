// Write a class that stores and operates upon the data. Again, the data for this assignment is in
// the form of (x,y) points.

/**
 * TODO Write Java doc.
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
}
