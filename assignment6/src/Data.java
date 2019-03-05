import java.util.LinkedList;

/**
 * Stores and operates upon data in a 2D graph space.
 */
public class Data {
  private LinkedList<Point> dataList;


  /**
   * A constructor with no parameters that initializes a data object.
   * A data object is a list of points.
   */
  public Data() {
    this.dataList = new LinkedList();
  }

  /**
   * A method to add a single point to the data list
   *
   * @param x position of the point.
   * @param y position of the point.
   */
  public void addPoint(int x, int y) {
    Point datum = new Point(x, y);
    this.dataList.add(datum);
  }

  /**
   * An alternative method to add a single point to the data list
   *
   * @param input the Point to add
   */
  public void addPoint(Point input) {
    this.dataList.add(input);
  }

  /**
   * A method that returns the data entered thus far, as a list.
   *
   * @return data entered thus far, as a list of points.
   */
  public LinkedList getData() {
    return this.dataList;
  }

  /**
   * Returns a best-fit line. You will need to represent a line suitably.
   *
   * @return a line representing the best-fit of the data.
   */
  public Line fitLine() {
// TODO 2. Write a method fitLine() in the above class that returns a best-fit line.
//  You will need to represent a line suitably.

    Line bestFit = new Line(this.dataList);

    return bestFit;
  }

  /**
   * Verifies that it is positive, performs k-means clustering on the data and returns a list of
   * integers. The ith element of this list is the cluster number assigned to the ith data point.
   * This list should align with the list of data points returned above.
   */
  LinkedList kmeans(int k) throws IllegalArgumentException {
    if (k < 0) {
      throw new IllegalArgumentException("K must be positive.");
    }
    // TODO 3. Write method for kmeans. Think through how you will implement the algorithm before you
    //  write code. It will help you work through the various loops you may need.

    // TODO When planning think about whether having helper methods or other classes will help you
    //  to implement it. All helper methods must be private.

    // TODO Compute the distance between two points as the Euclidean distance:
    //  d(p, q) = Math.sqrt((p_x - q_x)^2 + (p_y - q_y)^2)

    // TODO Use 0.01% as the error threshold in the algorithm.

    // TODO Use a total of 10 RANSAC iterations. One iteration of RANSAC is an entire
    //  k-means clustering algorithm. Run it 10 times and choose the best of the 10 results
    //  as your final result.

    // TODO A drawback of the above k-means clustering algorithm is that it may take too long to
    //  converge. In your implementation, you should stop the algorithm it has not converged in
    //  100 iterations.

    // TODO You may find Math.random() useful to implement the algorithm.

    // TODO You can represent infinity in Java as Double.POSITIVE_INFINITY.
    //  Look at the Double and Integer classes.

    return new LinkedList();
  }
}
