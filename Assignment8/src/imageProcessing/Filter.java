package imageProcessing;

/**
 * This class represents a filter to apply to an image. A filter has a "Kernel" which is a 2D array
 * of numbers with odd dimensions (3x3, 5x5, etc).
 */
public class Filter {

  double kernel[][];


  // TODO Throw exception if kernel is not odd x odd

  /**
   * Constructs a filter object. A filter has a "Kernel" which is a 2D array of doubles with odd
   * dimensions (3x3, 5x5, etc).
   *
   * @param kernel A 2D array of numbers with odd dimensions (3x3, 5x5, etc).
   */
  public Filter(double kernel[][]) {
    this.kernel = kernel;
  }

  /**
   * Returns a copy of the Kernel of this Filter.
   *
   * @return A 2D array of doubles.
   */
  public double[][] getData() {
    return this.kernel.clone();
  }

}
