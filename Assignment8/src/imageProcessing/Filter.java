package imageProcessing;

/**
 * TODO Javadoc.
 */
public class Filter {

  double kernel[][];


  /**
   * TODO Javadoc.
   * @param kernel
   */
  public Filter(double kernel[][]){
    this.kernel = kernel;
  }

  /**
   * TODO Javadoc.
   * @return
   */
  public double[][] getData() {
    return this.kernel.clone();
  }

}
