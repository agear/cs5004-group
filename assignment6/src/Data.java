import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.lang.Math;
import java.util.Iterator;
import java.util.HashMap;


/**
 * Stores and operates upon data in a 2D graph space.
 */
public class Data {
  private LinkedList<Point> dataList;
  private Line bestFitLine;
  private TreeMap<Integer,Point> clusters;
  private ArrayList distances;

  /**
   * A constructor with no parameters that initializes a data object.
   * A data object is a list of points.
   */
  public Data() {
    this.dataList = new LinkedList<Point>();
  }

  /**
   * A method to add a single point to the data list
   *
   * @param x position of the point.
   * @param y position of the point.
   * @throws IllegalArgumentException If the x-coordinate already exists in the data
   */
  public void addPoint(int x, int y) throws IllegalArgumentException {

    // For each point, check to see if the x already exists
    for (Point p : dataList){
      if (p.getX() == x) {
        throw new IllegalArgumentException("That x-coordinate already exists in this dataset.");
      }
    }

    Point datum = new Point(x, y);
    this.dataList.add(datum);
  }

  /**
   * An alternative method to add a single point to the data list
   *
   * @param input the Point to add
   * @throws IllegalArgumentException If the x-coordinate already exists in the data
   */
  public void addPoint(Point input) throws IllegalArgumentException {

    // For each point, check to see if the x already exists
    for (Point p : dataList){
      if (p.getX() == input.getX()) {
        throw new IllegalArgumentException("That x-coordinate already exists in this dataset.");
      }
    }

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
   * @throws IllegalArgumentException if there's < 2 points in the data
   */
  public Line fitLine() throws IllegalArgumentException {

    // Calculates best fit line and saves it as an attribute
    this.bestFitLine = new Line(this.dataList);

    // Returns the line of best fit
    return this.bestFitLine;
  }




  private HashMap<Point,Integer> findClosestCentroids(int numCentroids){

    // Initialize closest cluster list
    HashMap<Point,Integer> clusterAssignments = new HashMap<>();

    // Get the number of data points
    int numData = this.dataList.size();

    // Compare each data point to each cluster center and make a list
    for (int i = 0; i < numData; i++) {
      // Capture datapoint
      Point currentDataPoint = this.dataList.get(i);

      // Initialize variable that contains the smallest distance for this datapoint
      double smallestDistance = currentDataPoint.getDistance(this.clusters.get(0));
      Integer closestCentroid = 0;

      // For each centroid, calculate the distance between current point and that centroid
      for (int j = 0; j < numCentroids; j++) {

        Point currentClusterPoint = this.clusters.get(j);
        double currentDistance = currentDataPoint.getDistance(currentClusterPoint);

        // If this distance is smaller than saved distance, than update the smallest distance
        if (currentDistance < smallestDistance) {
          smallestDistance = currentDistance;
          closestCentroid = j;
        }

      }

      // After finding the smallest distance for the current point, assign it
      clusterAssignments.put(currentDataPoint, closestCentroid);
    }

    return clusterAssignments;

  }

  private double findAverageDistance(HashMap<Point,Integer> centroidAssignments) {

    // Initialize average distance
    double totalDistance = 0;

    // For each point in the assignment, find the distance
    for (Map.Entry<Point, Integer> entry : centroidAssignments.entrySet()){
      Point currentPoint = entry.getKey();
      Integer currentCentroid = entry.getValue();
      Point currentCentroidCoordinates = clusters.get(currentCentroid);

      double currentDistance = currentPoint.getDistance(currentCentroidCoordinates);
      totalDistance += currentDistance;
    }

    // Return the average distance
    return totalDistance/centroidAssignments.size();

  }

  /**
   * Verifies that it is positive, performs k-means clustering on the data and returns a list of
   * integers. The ith element of this list is the cluster number assigned to the ith data point.
   * This list should align with the list of data points returned above.
   */
  private HashMap<Point,Integer> kmeans(int k) throws IllegalArgumentException {

    if (k < 0) {
      throw new IllegalArgumentException("K must be positive.");
    }

    // Get the number of data points
    int numData = this.dataList.size();

    // Select k random centers
    for (int i = 0; i < k; i++ ){
      int centerIndex = (int)(Math.random() * ((numData + 1)));
      clusters.put(i, this.dataList.get(centerIndex));
    }

    // One iteration of centroid assignment
    HashMap<Point,Integer> centroidAssignments = findClosestCentroids(k);

    // Do up to 100 iterations of centroid assignments.
    for (int i = 0; i < 100; i++){

      // One iteration of centroid assignment
      centroidAssignments = findClosestCentroids(k);

      // One average-distance calculation
      double averageDistance = findAverageDistance(centroidAssignments);

      // If the percentage error is less than a small amount, then finish.
      double errorDelta = .01;

      double percentageError = (Math.abs(averageDistance - Double.POSITIVE_INFINITY))
              /Double.POSITIVE_INFINITY;

      if (percentageError < errorDelta) {
        return centroidAssignments;
      }


    }
    // If we go through all 100 iterations and still have too-high error-delta,
    // return current assignment anyway
    return centroidAssignments;
  }
}
