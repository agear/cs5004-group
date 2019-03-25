package imageProcessing;

// TODO should this be an interface with b&w and sepia as concrete classes? I.e. each class should
//  do one thing only?
/**
 * This class represents a transformation to apply to an image. A transformation has a 2D 3x3
 * matrix.
 */
public class Transformation {

  double matrix[][];

  /**
   * Constructs a transformation object. A transformation has a 2D 3x3 matrix.
   *
   * @param matrix A 2D 3x3 array of doubles.
   */
  public Transformation(double matrix[][]) {
    this.matrix = matrix;
  }

  /**
   * Returns a copy of the matrix of this Transformation.
   *
   * @return A 2D array of doubles.
   */
  public double[][] getData() {
    return this.matrix.clone();
  }


}
