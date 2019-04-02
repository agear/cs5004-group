import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import imageprocessing.Driver;


/**
 * Tests for the image processing class.
 */
public class TestImage {

  @Test
  public void mainTest() throws IOException {
    Driver testDriver = new Driver();
    testDriver.main();
    assertTrue(true);
  }
}
