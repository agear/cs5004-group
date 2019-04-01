package imageProcessing;

// TODO should this be an interface with b&w and sepia as concrete classes? I.e. each class should
//  do one thing only?
/**
 * This class represents a transformation to apply to an image. A transformation has a 2D 3x3
 * matrix.
 */
public class Transformation implements Adjustment {

  double matrix[][];

  /**
   * Constructs a transformation object. A transformation has a 2D 3x3 matrix.
   *
   * @param matrix A 2D 3x3 array of doubles.
   */
  public Transformation(double matrix[][]) {
    this.matrix = matrix;
  }


  /** This constructor makes the object by identifying the input string as a built-in
   * transformation, such as greyscale. If it finds it, then it creates it. If it does not
   * find the specified transformation, it throws an error.
   * It is a helper method used by the constructor.
   *
   * @param transformationName The name of the transformation to create.
   * @return The matrix of the filter specified
   * @throws IllegalArgumentException If the transformation is not found
   */
  private double[][] getFilterByName(String transformationName) throws IllegalArgumentException {
    if (transformationName == "greyscale") {
      double[][] grey =  { {0.2126, 0.7152, 0.0722},
              {0.2126, 0.7152, 0.0722},
              {0.2126, 0.7152, 0.0722} };
      return grey;
    }

    if (transformationName == "sepia") {
      double[][] blurKernel =  { {0.393, 0.769, 0.189},
            {0.349, 0.686, 0.168},
            {0.272, 0.534, 0.131} };
      return blurKernel;
    }

    throw new IllegalArgumentException("Filter name not recognized.");
  }


  /**
   * A transformation has a "matrix" which is a 2D array of doubles.
   * This constructor is for a filter object for common names (e.g., greyscale, sepia).
   * @param transformationName The transformation type
   * @throws IllegalArgumentException If the transformation isn't in the system/predefined.
   */
  public Transformation(String transformationName) throws IllegalArgumentException {
    this.matrix = getFilterByName(transformationName);
  }



  /**
   * Returns a copy of the matrix of this Transformation.
   *
   * @return A 2D array of doubles.
   */
  public double[][] getData() {
    return this.matrix.clone();
  }

  public Image apply(Image inputImage) {
    // Will do this later
    return new Image(300,300);
  }


}
