package imageProcessing;

//TODO delete?

/**
 * This class represents and image. An image is 2D array of pixel objects.
 */
public class Image {

  public Pixel[][] data;

  // Takes data of the type outputted by ImageUtil class (TODO describe better)

  /**
   * Constructs an image object using 3D array of integer values.
   *
   * @param data A 3D array of integer values.
   */
  public Image(int[][][] data) {

    // Initialize data field to input length
    this.data = new Pixel[data.length][data[0].length];

    // Loop through input, creating pixels and creating data field
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {

        // Create a pixel with data
        Pixel newPixel = new Pixel(data[i][j][0], data[i][j][1], data[i][j][2]);
        this.data[i][j] = newPixel;
      }
    }

  }

  /**
   * Constructs an image a 2D array of pixel objects.
   *
   * @param data A 2D array of pixel objects.
   */
  // Alternate way of creating data
  public Image(Pixel[][] data) {
    this.data = data;
  }

  /**
   * Checks if the image contains the given pixel position.
   *
   * @param x Position of the pixel to check.
   * @param y Position of the pixel to check.
   * @return True if x, and y values exist in this image. False otherwise.
   */
  private boolean isValidPixelPosition(int x, int y) {

    return (x < this.data.length && y < this.data[0].length && x >= 0 && y >= 0);
  }

  // TODO Delete?
//    if (x < this.data.length && y < this.data[0].length && x >= 0 && y >= 0 ) {
//      return true;
//    }
//
//    return false;
//
//  }

  /**
   * TODO Javadoc. and general clean up. Helper method for applyFilter()? Move to Filter class?
   *
   * @return A new pixel object that is the result of applying this filter to a pixel.
   */
  private Pixel applyFilterToPixel(Filter inputFilter, Pixel inputPixel, int x, int y) {

    // Get the kernel of the filter
    double[][] filterKernel = inputFilter.getData();
    int filterLength = (filterKernel.length - 1) / 2;
    int xStart = x - filterLength;
    int yStart = y - filterLength;

    double redSum = 0;
    double greenSum = 0;
    double blueSum = 0;


    // For each entry in the filter kernel
    for (int b = 0; b < filterKernel.length; b++) {
      xStart = x - filterLength;
      for (int a = 0; a < filterKernel.length; a++) {

        // Gets the current filter
        double currentFilter = filterKernel[a][b];

        // Get the pixel to be altered
        if (this.isValidPixelPosition(xStart, yStart)) {
          Pixel currentPixel = this.data[xStart][yStart];
          redSum = redSum + (currentPixel.vectorRed(currentFilter));
          greenSum = greenSum + (currentPixel.vectorGreen(currentFilter));
          blueSum = blueSum + (currentPixel.vectorBlue(currentFilter));
        }
        xStart++;

      }
      yStart++;

    }

    // Round double values and cast to ints.
    Pixel newPixel = new Pixel((int) Math.round(redSum), (int) Math.round(greenSum),
            (int) Math.round(blueSum));
    return newPixel;

  }

  // TODO Move to filter class? I.e. public Image applyFilter(Image unfilteredImage)?
  /**
   * Applies the given filter to this image.
   *
   * @param inputFilter The filter to apply to this image.
   * @return A copy of this image with the given filter applied.
   */
  public Image applyFilter(Filter inputFilter) {

    // Initialize output object
    Pixel[][] output = new Pixel[this.data.length][this.data[0].length];

    // For each pixel in the image, apply the filter. Add that new value to the corresponding value
    // in a new set of data, and then create a new Image object from that. Return the resulting obj.
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {

        //Pixel filteredPixel = new Pixel(data[i][j].red, 0, data[i][j].blue);

        // Apply the filter, and receive new value
        Pixel filteredPixel = this.applyFilterToPixel(inputFilter, data[i][j], i, j);

        // Put the new pixel in the output image
        output[i][j] = filteredPixel;
      }
    }

    Image filteredImage = new Image(output);
    return filteredImage;

  }

  // TODO Move to Transformation class? I.e. public Image Transform(Image untransformedImage)?
  /**
   * // TODO Java doc
   * @param inputTransformation
   * @return
   */
  public Image Transform(Transformation inputTransformation) {

    // Initialize output object
    Pixel[][] output = new Pixel[this.data.length][this.data[0].length];

    // For each pixel in the image, apply the transformation. Add that new value to the
    // corresponding value
    // in a new set of data, and then create a new Image object from that. Return the resulting obj.
    for (int x = 0; x < data.length; x++) {
      for (int y = 0; y < data[x].length; y++) {

        //Pixel filteredPixel = new Pixel(data[i][j].red, 0, data[i][j].blue);

        // Apply the transformation, and receive new value
        Pixel transformedPixel = this.TransformPixel(inputTransformation, data[x][y], x, y);

        // Put the new pixel in the output image
        output[x][y] = transformedPixel;
      }
    }

    Image transformedImage = new Image(output);
    return transformedImage;
  }
  /**
   * TODO Javadoc. Helper method for Transform()? Move to Transformation class?
   *
   * @return A new pixel object that is the result of applying this filter to a pixel.
   */
  private Pixel TransformPixel(Transformation inputTransformation, Pixel inputPixel, int x, int y) {

    // Get the matrix of the transformation.
    double[][] matrix = inputTransformation.getData();

    double redPrime = (matrix[0][0]*inputPixel.getRed() + matrix[0][1]*inputPixel.getGreen()
            + matrix[0][2]*inputPixel.getBlue());
    double greenPrime = (matrix[1][0]*inputPixel.getRed() + matrix[1][1]*inputPixel.getGreen()
            + matrix[1][2]*inputPixel.getBlue());
    double bluePrime = (matrix[2][0]*inputPixel.getRed() + matrix[2][1]*inputPixel.getGreen()
            + matrix[2][2]*inputPixel.getBlue());

    // Round double values and cast to ints.
    Pixel newPixel = new Pixel((int) Math.round(redPrime), (int) Math.round(greenPrime),
            (int) Math.round(bluePrime));
    return newPixel;

  }

  /**
   * TODO Javadoc. Are we using this or just for trouble shooting?
   */
  public String toString() {
    String output = "";
    for (int i = 0; i < this.data.length; i++) {
      for (int j = 0; j < this.data[i].length; j++) {
        output += this.data[i][j] + " ";
      }
      output += "\n";
    }
    return output;
  }

  /**
   * Method to return this image as a 3D array of integers. // TODO More detailed explanation? I.e. what is stored in each dimension of the array?
   *
   * @return This image as a 3D array of integers.
   */
  public int[][][] get3Ddata() {
    int[][][] output = new int[data.length][data[0].length][3];
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[0].length; j++) {
        output[i][j][0] = this.data[i][j].getRed();
        output[i][j][1] = this.data[i][j].getGreen();
        output[i][j][2] = this.data[i][j].getBlue();
      }
    }
    return output;
  }


}
