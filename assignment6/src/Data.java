import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.lang.Math;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * Stores and operates upon data in a 2D graph space.
 */
public class Data {
  private LinkedList<Point> dataList = new LinkedList<Point>();
  private Line bestFitLine;
  private TreeMap<Integer,Point> clusters = new TreeMap<>();
  private ArrayList distances;

  /**
   * A constructor with no parameters that initializes a data object.
   * A data object is a list of points.
   */
  public Data() {
    this.dataList = new LinkedList<Point>();
  }


  /** Constructor to create data from a file set up in x,y columns.
   * @param filePath The path to the nicely-formatted data
   * @throws IOException If the path cannot be found
   * @throws IllegalArgumentException If the file contains an odd amount of numbers
   */
  public Data(String filePath) throws IOException,IllegalArgumentException {

    try {
      Scanner sc = new Scanner(new FileInputStream(filePath));

      while (sc.hasNextDouble()) {

        double x = sc.nextDouble();

        if (!sc.hasNextDouble()) {
          throw new IllegalArgumentException("File has uneven number of x,y coordinates.");
        }
        double y = sc.nextDouble();

        this.addPoint(x,y);

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * A method to add a single point to the data list
   *
   * @param x position of the point.
   * @param y position of the point.
   * @throws IllegalArgumentException If the x-coordinate already exists in the data
   */
  public void addPoint(double x, double y) {
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
  public LinkedList<Point> getData() {
    return this.dataList;
  }

  /**
   * Returns a best-fit line.
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


  //Compute the center of each cluster by taking the average of all data points assigned
  // to that cluster (the average of x-coordinates, the average of y-coordinates)
  private void updateClusterPoints(HashMap<Point,Integer> centroidAssignments) {

    // For each centroid-
    for (Map.Entry<Integer,Point> entry : clusters.entrySet()) {
      Integer currentCentroid = entry.getKey();

      // Initialize sums and number of points assigned to it
      double sumX = 0;
      double sumY = 0;
      int numPointsAssigned = 0;

      // Find all data points assigned to it (key=?find this. value=currentCentroid)
      // Iterate through every data point.
      // then add x and y.
      for (Map.Entry<Point,Integer> dataEntry : centroidAssignments.entrySet()) {

        // If the current datapoint is assigned to the current centroid,
        if (dataEntry.getValue() == currentCentroid){
          numPointsAssigned++;

          // Accumulate this point's X and Y values
          sumX = sumX + dataEntry.getKey().getX();
          sumY = sumY + dataEntry.getKey().getY();
        }

      }

      // When finished iterating through each data point, the mean of X and Y can be calculated
      double meanX = sumX/numPointsAssigned;
      double meanY = sumY/numPointsAssigned;
      Point newCenter = new Point(meanX, meanY);

      // Update the centroid's new location!
      this.clusters.put(currentCentroid, newCenter);

    }
  }


  private double findAverageDistance(HashMap<Point,Integer> centroidAssignments) {

    // Initialize average distance
    double totalDistance = 0;

    // For each data point, find the distance from its assignment
    for (Point p : this.dataList){
      Integer currentCentroid = centroidAssignments.get(p);
      Point currentCentroidCoordinates = clusters.get(currentCentroid);

      double currentDistance = p.getDistance(currentCentroidCoordinates);
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
  public HashMap<Point,Integer> kmeans(int k) throws IllegalArgumentException {

    if (k < 0) {
      throw new IllegalArgumentException("k must be positive.");
    }

    // Get the number of data points
    int numData = this.dataList.size();

    // Select k random centers
    for (int i = 0; i < k; i++ ){

      // Finds a random index between 0 and # of data points
      int centerIndex = (int)(Math.random() * ((numData)));
      Point centroidPoint = this.dataList.get(centerIndex);

      // Assigns it to our cluster list
      this.clusters.put(i, centroidPoint);
    }

    // One iteration of centroid assignment
    HashMap<Point,Integer> centroidAssignments = findClosestCentroids(k);

    // Do up to 100 iterations of centroid assignments.
    for (int i = 0; i < 100; i++){

      // One iteration of centroid assignment
      centroidAssignments = findClosestCentroids(k);

      // Update the cluster point coordinates to be the average of x and y of assignments
      updateClusterPoints(centroidAssignments);

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

  // TODO Is this needed? <<  I just did this for our convenience; I made it private
  //  but maybe we can delete later
  private String printCentroidAssignments(HashMap<Point,Integer> assignments){

    String currentAssignment = "";
    for(Map.Entry<Point,Integer> assignment : assignments.entrySet()){
      Point currentPoint = assignment.getKey();
      Integer currentCentroid = assignment.getValue();
      Point currentCentroidCoordinates = clusters.get(currentCentroid);
      currentAssignment+= "\n" + currentPoint.toString() + "is assigned to" + currentCentroidCoordinates.toString();
    }
    return currentAssignment;
  }



}
