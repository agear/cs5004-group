import org.junit.Before;
import org.junit.Test;

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


    // Create the set of data made up of points
    Data dataOne = new Data();
    dataOne.addPoint(new Point(1,1));
    dataOne.addPoint(new Point(2,2));
    dataOne.addPoint(new Point(3,3));
    dataOne.addPoint(new Point(4,4));
    dataOne.addPoint(new Point(5,5));

    // Calculate line of best fit

    assertEquals("-1x + 1y + 0 = 0", dataOne.fitLine().toString());

  }

  @org.junit.Test
  public void kmeans() {
  }
}

