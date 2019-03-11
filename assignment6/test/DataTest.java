import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DataTest {

  Point a;
  Point b;
  Point c;


  @Before
  public void setUp() throws Exception {
  }

  // TODO 4. Write tests for these two methods:
// For the kmeans(int k) method you must test whether each point is assigned to the correct
// cluster (i.e. it is closest to the cluster to which it is assigned).
//
// For the fitLine() method you can test that when given data points that fit a line
// perfectly or nearly perfectly (start from a point that lies on a line and move it a
// little bit), this method returns the correct line.

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
  public void kmeans() {

    // Create a set of data made up of points
    Data dataOne = new Data();
    dataOne.addPoint(new Point(1,1));
    dataOne.addPoint(new Point(2,2));
    dataOne.addPoint(new Point(30,50));
    dataOne.addPoint(new Point(31,51));

    //dataOne.printCentroidAssignments(dataOne.kmeans(2));


  }



  @Test
  public void readFromFile() throws IOException {
    Data testData = new Data("./data/clusterdata-2.txt");
  }

}

