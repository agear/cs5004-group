// Write a class that stores and operates upon the data. Again, the data for this assignment is in
// the form of (x,y) points.

/**
 * TODO Write Java doc.
 */
public class Point {
  double x;
  double y;

  /** Initializes a 2D point on a graph.
   * @param x The x-coordinate
   * @param y The y-coordinate
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /** Getter method for the x-coordinate.
   * @return The x-coordinate.
   */
  public double getX(){
    return this.x;
  }

  /** Getter method for the y-coordinate.
   * @return The y-coordinate.
   */
  public double getY(){
    return this.y;
  }


}
