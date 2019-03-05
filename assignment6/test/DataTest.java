public class DataTest {
  @org.junit.Before
  public void setUp() throws Exception {
  }

  // TODO 4. Write tests for these two methods:
// For the kmeans(int k) method you must test whether each point is assigned to the correct
// cluster (i.e. it is closest to the cluster to which it is assigned).
//
// For the fitLine() method you can test that when given data points that fit a line
// perfectly or nearly perfectly (start from a point that lies on a line and move it a
// little bit), this method returns the correct line.

  @org.junit.Test
  public void fitLine() {

    Point a = new Point(1,1);
    Point b = new Point(2,2);
    Point c = new Point(3,3);

    Data linearData = new Data();




  }

  @org.junit.Test
  public void kmeans() {
  }
}

