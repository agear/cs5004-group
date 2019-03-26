package imageProcessing;

//TODO Should this be an interface with Blur and Sharpen as concrete classes? I.e. each class
// should do one thing only?
/**
 * This class represents a filter to apply to an image. A filter has a "Kernel" which is a 2D array
 * of numbers with odd dimensions (3x3, 5x5, etc).
 */
public class Filter extends AbstractAdjustment {

  double kernel[][];
  double[][] blurKernel =  { {1.0/16.0, 1.0/8.0, 1.0/16.0}, {1.0/8.0, 1.0/4.0, 1.0/18.0},
          {1.0/16.0, 1.0/8.0, 1.0/16.0} };


  /**
   * Constructs a filter object. A filter has a "Kernel" which is a 2D array of doubles with odd
   * dimensions (3x3, 5x5, etc).
   *
   * @param kernel A 2D array of doubles with odd dimensions (3x3, 5x5, etc).
   */
  public Filter(double kernel[][]) throws IllegalArgumentException {

    if ( (kernel.length % 2) == 0 || kernel.length != kernel[0].length ) {
      throw new IllegalArgumentException("Kernel must be nxn matrix where n is odd.");
    }

    this.kernel = kernel;
  }


  private double[][] getFilterByName(String filterName) throws IllegalArgumentException {
    if (filterName == "blur") {
      double[][] blurKernel =  { {1.0/16.0, 1.0/8.0, 1.0/16.0}, {1.0/8.0, 1.0/4.0, 1.0/18.0},
              {1.0/16.0, 1.0/8.0, 1.0/16.0} };
      return blurKernel;
    }
    throw new IllegalArgumentException("Filter name not recognized.");
  }

  public Filter(String filterType ) throws IllegalArgumentException {

    this.kernel = getFilterByName(filterType);

  }


  /**
   * Returns a copy of the Kernel of this Filter.
   *
   * @return A 2D array of doubles.
   */
  public double[][] getData() {
    return this.kernel.clone();
  }

  /**
   * Checks if the image contains the given pixel position.
   *
   * @param x Position of the pixel to check.
   * @param y Position of the pixel to check.
   * @return True if x, and y values exist in this image. False otherwise.
   */
  private boolean isValidPixelPosition(Image image, int x, int y) {

    return (x < image.get3Ddata().length && y < image.get3Ddata()[0].length && x >= 0 && y >= 0);
  }



  private Pixel applyToPixel(Image inputImage, int x, int y) {
    //System.out.println("APPLYING TO PIXEL......................");

    // Get the kernel of the filter
    double[][] filterKernel = this.getData();
    int filterLength = (filterKernel.length - 1) / 2;
    int xStart;
    int yStart = y - filterLength;

    double redSum = 0;
    double greenSum = 0;
    double blueSum = 0;


    // For each entry in the filter kernel
    for (int b = 0; b < filterKernel.length; b++) {
      xStart = x - filterLength;

      for (int a = 0; a < filterKernel.length; a++) {
        //System.out.println("a = " + a + ". b=" + b + ". kern size:" + filterKernel.length);

        // Gets the current filter
        double currentFilter = filterKernel[a][b];

        // Get the pixel to be altered
        if (this.isValidPixelPosition(inputImage, xStart, yStart)) {

          Pixel currentPixel = inputImage.getData()[xStart][yStart];
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




  public Image apply(Image input) {

    // Initialize output object
    Pixel[][] output = new Pixel[input.get3Ddata().length][input.get3Ddata()[0].length];

    // For each pixel in the image, apply the filter. Add that new value to the corresponding value
    // in a new set of data, and then create a new Image object from that. Return the resulting obj.
    for (int i = 0; i < input.get3Ddata().length; i++) {
      //System.out.println("Applying filter to image...." + i);
      for (int j = 0; j < input.get3Ddata()[i].length; j++) {

        // Apply the filter, and receive new value
        // Put the new pixel in the output image
        output[i][j] = this.applyToPixel(input, i, j);
        System.out.println("Created a filtered pixel. i,j = " + i + "  " +j);

      }

    }
    System.out.println("Created a filtered pixel. ");

    Image filteredImage = new Image(output);
    return filteredImage;

  }


}
