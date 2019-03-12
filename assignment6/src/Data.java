import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.lang.Math;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Stores and operates upon data in a 2D graph space.
 */
public class Data {
  private LinkedList<Point> dataList = new LinkedList<Point>();
  private Line bestFitLine;
  private TreeMap<Integer,Point> clusters = new TreeMap<>();

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
   */
  public void addPoint(double x, double y) {
    Point datum = new Point(x, y);
    this.dataList.add(datum);
  }


  /**
   * An alternative method to add a single point to the data list, using Point objects
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
   * Returns a best-fit line in the format ax+by+c=0 using a List object.
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


  /** Pairs up a list of data points to the centroids that each one is closest to
   * using the Euclid distance formula.
   *
   * @param numCentroids The number of centroids to assign data points to
   * @return A key,value set of the assignments
   */
  private HashMap<Point,Integer> findClosestCentroids(int numCentroids){

    // Initialize cluster assignment list
    HashMap<Point,Integer> clusterAssignments = new HashMap<>();

    // Get the number of data points
    int numData = this.dataList.size();

    // Compare each data point to each cluster center
    for (int i = 0; i < numData; i++) {

      // Capture data point
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


  /**
   * Compute the center of each cluster by taking the average of all data points assigned
   * to that cluster (the average of x-coordinates, the average of y-coordinates)
   *
   * @param centroidAssignments The key-value pair of every point to a cluster
   */
  private void updateClusterPoints(HashMap<Point,Integer> centroidAssignments) {

    // For each centroid,
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

  /** Returns the current clusters associated with the data.
   * @return A list of clusters and their coordinates
   */
  public TreeMap<Integer,Point> getClusters(){
    return this.clusters;
  }

  /** Computes the new error 'ne' as the average distance of each data point from
   * the new center of its cluster
   * @param centroidAssignments The pairings of data points and centroids
   * @return ne, the avg distance
   */
  private double findAverageDistance(HashMap<Point,Integer> centroidAssignments) {

    // Initialize average distance
    double totalDistance = 0;

    // For each data point, find the distance from its assignment
    for (Point p : this.dataList){
      Integer currentCentroid = centroidAssignments.get(p);
      Point currentCentroidCoordinates = clusters.get(currentCentroid);

      // Add the distance to the total distance
      double currentDistance = p.getDistance(currentCentroidCoordinates);
      totalDistance += currentDistance;
    }

    // Return the average distance
    return totalDistance/centroidAssignments.size();

  }

  /**
   * Performs k-means clustering on the data, using RANSAC
   *
   * @param k The number of clusters
   * @return A map of every point and its assigned cluster
   */
  public HashMap<Point,Integer> kmeansMapOutput(int k) throws IllegalArgumentException {

    // Verifies that k (num clusters) is positive
    if (k < 0) {
      throw new IllegalArgumentException("k must be positive.");
    }

    // Get the number of data points
    int numData = this.dataList.size();

    // Initialize centroidAssignments and error
    HashMap<Point, Integer> centroidAssignments;
    LinkedList<Double> percentageErrorList = new LinkedList<Double>();
    LinkedList<HashMap<Point,Integer>> assignmentList = new LinkedList<HashMap<Point,Integer>>();


    // Do kmeansMapOutput 10 times (RANSAC method)
    for (int l = 0; l < 10; l++ ) {

      // Select k random centers
      for (int i = 0; i < k; i++) {

        // Finds a random index between 0 and # of data points
        int centerIndex = (int) (Math.random() * ((numData)));
        Point centroidPoint = this.dataList.get(centerIndex);

        // Assigns it to our cluster list
        this.clusters.put(i, centroidPoint);
      }

      // One iteration of centroid assignment
      centroidAssignments = findClosestCentroids(k);

      double e = Double.POSITIVE_INFINITY;

      // Do up to 100 iterations of centroid assignments.
      for (int i = 0; i < 100; i++) {

        // One iteration of centroid assignment
        centroidAssignments = findClosestCentroids(k);

        // Update the cluster point coordinates to be the average of x and y of assignments
        updateClusterPoints(centroidAssignments);

        // One average-distance calculation
        double averageDistance = findAverageDistance(centroidAssignments);

        // If the percentage error is less than a small amount, then finish.
        double errorDelta = .01;
        double percentageError = (Math.abs(averageDistance - e)) / e;


        // If the percentage error is less than .01, stop here
        if (percentageError < errorDelta) {
          // Add current percentage error and centroid to lists for RANSAC
          percentageErrorList.add(percentageError);
          assignmentList.add(centroidAssignments);
          continue;
        }
        else {
          e = averageDistance;
        }


      }
      // If we go through all 100 iterations and still have too-high error-delta,
      // return current assignment anyway
      // Add current percentage error and centroid to lists for RANSAC
      percentageErrorList.add((Math.abs(findAverageDistance(centroidAssignments) - e)) / e);
      assignmentList.add(centroidAssignments);
      continue;
    }

    // Find the smallest percentage error
    double smallestPercentageError = percentageErrorList.get(0);
    int smallestErrorIndex = 0;

    for (int m = 0; m < percentageErrorList.size(); m++){
      if (percentageErrorList.get(m) < smallestPercentageError){
        smallestErrorIndex = m;
      }
    }

    return assignmentList.get(smallestErrorIndex);
  }


  /** Uses kmeans to assign every data point to a cluster/centroid.
   *
   * @param k the number of clusters
   * @return An ArrayList of cluster assignments
   * @throws IllegalArgumentException If k is less than 2
   */
  public LinkedList<Integer> kmeans(int k) throws IllegalArgumentException {


    // Do kmeans on data
    HashMap<Point,Integer> mappedOutput = this.kmeansMapOutput(k);

    // Initialize output
    LinkedList<Integer> output = new LinkedList<>();


    // Convert Hashmap to arraylists with just the integers
    for (Point p : this.dataList) {
      Integer assignedCentroid = mappedOutput.get(p);
      output.add(assignedCentroid);
    }


//    for (Map.Entry<Point,Integer> entry : mappedOutput.entrySet()){
//      Integer currentInt = entry.getValue();
//      output.add(currentInt);
//    }

    // Return the list of integers that maps data to cluster assignments
    return output;

  }




  }
