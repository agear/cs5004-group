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
    dataOne.addPoint(new Point(2,20));
    dataOne.addPoint(new Point(3,38));
    dataOne.addPoint(new Point(4,50));
    dataOne.addPoint(new Point(5,80));

    // Calculate line of best fit

    assertEquals("-18.8x + 1y + 18.6 = 0", dataOne.fitLine().toString());

  }

  @org.junit.Test
  public void kmeans() {
  }
}

