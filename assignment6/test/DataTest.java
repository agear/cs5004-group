import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DataTest {

  Point a;
  Point b;
  Point c;


  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void fitLine() {

    // TEST ONE: Positive slope
    // Create the set of data made up of points
    Data dataOne = new Data();
    dataOne.addPoint(new Point(1,5));
    dataOne.addPoint(new Point(2,10));
    dataOne.addPoint(new Point(3,15));
    dataOne.addPoint(new Point(4,25));
    dataOne.addPoint(new Point(5,40));

    // Calculate line of best fit
    assertEquals("0.994x + -0.110y + -0.895 = 0", dataOne.fitLine().toString());

    // TEST TWO: Negative slope
    // Create the set of data made up of points
    dataOne = new Data();
    dataOne.addPoint(new Point(-20,15));
    dataOne.addPoint(new Point(-15,10));
    dataOne.addPoint(new Point(-10,7));
    dataOne.addPoint(new Point(-5,9));
    dataOne.addPoint(new Point(0,5));
    dataOne.addPoint(new Point(10,-15));

    // Calculate line of best fit
    assertEquals("0.694x + 0.720y + 0.902 = 0", dataOne.fitLine().toString());


    // TEST THREE: Horizontal line
    // Create the set of data made up of points
    dataOne = new Data();
    dataOne.addPoint(new Point(-20,1));
    dataOne.addPoint(new Point(-15,1));
    dataOne.addPoint(new Point(-10,1));
    dataOne.addPoint(new Point(-5,1));
    dataOne.addPoint(new Point(0,1));
    dataOne.addPoint(new Point(10,1));

    // Calculate line of best fit
    assertEquals("0.000x + 1.000y + -1.000 = 0", dataOne.fitLine().toString());



    // TEST FOUR: Linear data
    // Create the set of data made up of points
    dataOne = new Data();
    dataOne.addPoint(new Point(5,5));
    dataOne.addPoint(new Point(4,4));
    dataOne.addPoint(new Point(3,3));
    dataOne.addPoint(new Point(2,2));
    dataOne.addPoint(new Point(1,1));
    dataOne.addPoint(new Point(0,0));

    // Calculate line of best fit
    assertEquals("-0.707x + 0.707y + -0.000 = 0", dataOne.fitLine().toString());

    assertEquals(10, dataOne.fitLine().solveLine(10), 0.001);


  }

  // TEST FIVE: One point (illegal data)
  @Test(expected=IllegalArgumentException.class)
  public void bestFitOnePoint(){

    // Create the set of data made up of points
    Data dataOne = new Data();
    dataOne.addPoint(new Point(1,5));
    dataOne.fitLine();

  }



  @Test
  public void getDistanceTest(){
  Point point1 = new Point(1,1);
  Point point2 = new Point(1,1);
  Point point3 = new Point(2,1);
  assertEquals(0, point1.getDistance(point2), 0.001);
  assertEquals(1, point1.getDistance(point3), 0.001);

  }



  @org.junit.Test
  public void kmeans() throws IOException {

    // Create a set of data made up of points and get the centroids
    Data testData = new Data("./data/clusterdata-6.txt");
    HashMap<Point,Integer> centroidAssignments = testData.kmeans(6);

    /*
    For the kmeans(int k) method you must test whether each point is assigned to the
    correct cluster (i.e. it is closest to the cluster to which it is assigned).
     */

    // For each point,
    for (Point p : testData.getData()){
      System.out.println("Testing point ..." + p.toString());

      // Get the centroid it is assigned to and this point's distance from it
      Integer centroidAssigned = centroidAssignments.get(p);
      TreeMap<Integer,Point> clusters = testData.getClusters();
      Point centroidPoint = clusters.get(centroidAssigned);
      double distanceFromCentroidAssignment = p.getDistance(centroidPoint);

      // Get the distance between this point and all centroids
      for (Map.Entry<Integer,Point> centroid : clusters.entrySet()) {

        double currentDistance = p.getDistance(centroid.getValue());

        // The distance between this point and any other point
        // is greater or equal to the centroid it is assigned to...hopefully!!
        assertTrue(distanceFromCentroidAssignment <= currentDistance);
      }


    }


  }



  @Test
  public void readFromFile() throws IOException {
    Data testData = new Data("./data/clusterdata-2.txt");

  }

}

