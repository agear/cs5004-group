package imageprocessing;

import java.io.IOException;

/**
 * This class creates and represents a Rainbow image object, with 7 colored stripes.
 */
public class Rainbow extends ImageUtil implements IImage {
  private Pixel[][] data;
  private int height;
  private int width;

  /** Creates an image of the rainbow with user-specified dimension and orientation. Does not
   * write to a file, but can.
   *
   * @param height The height, in px, of the desired rainbow image
   * @param width The width, in px, of the desired rainbow image
   * @param orientation The desired direction of the rainbow's stripes
   */
  public Rainbow(int height, int width, Orientation orientation) {
    this.height = height;
    this.width = width;
    Orientation thisOrientation = orientation;
    this.data = new Pixel[this.height][this.width];

    //Initialize canvas.
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        Pixel uninitPixel = new Pixel(0, 0, 255);
        this.data[j][i] = uninitPixel;
      }
    }

    if (thisOrientation.equals(Orientation.HORIZONTAL)) {
      this.drawHorizontal();
    }
    else if (thisOrientation.equals(Orientation.VERTICAL)) {
      this.drawVertical();
    }

  }

  /**
   * Creates a horizontal rainbow object.
   */
  private void drawHorizontal() {
    double height = (double)this.height;
    int stripeWidth = (int)Math.ceil(height / 7.0);
    int lastStripe = this.height - (stripeWidth * 6);

    //Red Stripe
    for (int x = 0; x < stripeWidth; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 0, 0);
        this.data[x][y] = newPixel;
      }
    }
    //Orange Stripe
    for (int x = stripeWidth; x < stripeWidth * 2; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 165, 0);
        this.data[x][y] = newPixel;
      }
    }

    //Yellow Stripe
    for (int x = stripeWidth * 2; x < stripeWidth * 3; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 255, 0);
        this.data[x][y] = newPixel;
      }
    }

    //Green Stripe
    for (int x = stripeWidth * 3; x < stripeWidth * 4; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(0, 128, 0);
        this.data[x][y] = newPixel;
      }
    }

    //Blue Stripe
    for (int x = stripeWidth * 4; x < stripeWidth * 5; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(0, 0, 255);
        this.data[x][y] = newPixel;
      }
    }

    //Indigo Stripe
    for (int x = stripeWidth * 5; x < stripeWidth * 6; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(75, 0, 130);
        this.data[x][y] = newPixel;
      }
    }
    //Violet Stripe
    for (int x = stripeWidth * 6; x < stripeWidth * 6 + lastStripe; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(238, 130, 238);
        this.data[x][y] = newPixel;
      }
    }
  }

  /**
   * Creates a vertically-striped rainbow image object.
   */
  private void drawVertical() {
    double width = (double)this.width;
    int stripeWidth = (int)Math.ceil(width / 7.0);
    int lastStripe = this.width - (stripeWidth * 6);

    //Red Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = 0; y < stripeWidth; y++) {
        Pixel newPixel = new Pixel(255, 0, 0);
        this.data[x][y] = newPixel;
      }
    }
    //Orange Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = stripeWidth; y < stripeWidth * 2; y++) {
        Pixel newPixel = new Pixel(255, 165, 0);
        this.data[x][y] = newPixel;
      }
    }

    //Yellow Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = stripeWidth * 2; y < stripeWidth * 3; y++) {
        Pixel newPixel = new Pixel(255, 255, 0);
        this.data[x][y] = newPixel;
      }
    }

    //Green Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = stripeWidth * 3; y < stripeWidth * 4; y++) {
        Pixel newPixel = new Pixel(0, 128, 0);
        this.data[x][y] = newPixel;
      }
    }

    //Blue Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = stripeWidth * 4; y < stripeWidth * 5; y++) {
        Pixel newPixel = new Pixel(0, 0, 255);
        this.data[x][y] = newPixel;
      }
    }

    //Indigo Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = stripeWidth * 5; y < stripeWidth * 6; y++) {
        Pixel newPixel = new Pixel(75, 0, 130);
        this.data[x][y] = newPixel;
      }
    }

    //Violet Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = stripeWidth * 6; y < stripeWidth * 6 + lastStripe; y++) {
        Pixel newPixel = new Pixel(238, 130, 238);
        this.data[x][y] = newPixel;
      }
    }
  }

  /**
   * Returns the height in pixels of this rainbow image object.
   * @return the height in pixels of this rainbow image object
   */
  public int getHeight() {
    int heightClone = this.height;
    return heightClone;
  }

  /**
   * Returns the width in pixels of this rainbow image object.
   * @return the width in pixels of this rainbow image object
   */
  public int getWidth() {
    int widthClone = this.width;
    return widthClone;
  }

  /** Returns the data of this Flag image, by converting a 2D array of Pixel objects
   * into a 3D array of int objects. The purpose of this method is to make the data readable
   * by the ImageUtil class, or any 'outsiders' who do not have Pixel objects.
   * @return A 3D array of values representing RGB values of this image
   */
  public int[][][] get3Ddata() {
    int[][][] output = new int[this.data.length][this.data[0].length][3];
    for (int i = 0; i < this.data.length - 1; i++) {
      for (int j = 0; j < this.data[0].length - 1; j++) {
        output[i][j][0] = this.data[i][j].getRed();
        output[i][j][1] = this.data[i][j].getGreen();
        output[i][j][2] = this.data[i][j].getBlue();
      }
    }
    return output;
  }


  public Pixel[][] getData() {
    return this.data.clone();
  }

  /** Writes the image to a file.
   * @param filename The desired file path.
   * @throws IOException If there is an error creating a file with that path name.
   */
  public void writeImageToFile(String filename) throws IOException {
    this.writeImage(this.get3Ddata(), this.getWidth(), this.getHeight(), filename);
  }

  /** This applies a transformation to the image without modifying the image.
   *
   * @param inputTransformation The transformation to be applied
   * @return The Image after the filter has been applied.
   */
  public IImage transform(Transformation inputTransformation) {

    // Initialize output object
    Pixel[][] output = new Pixel[this.data.length][this.data[0].length];

    // For each pixel in the image, apply the transformation. Add that new value to the
    // corresponding value
    // in a new set of data, and then create a new Image object from that. Return the resulting obj.
    for (int x = 0; x < data.length; x++) {
      for (int y = 0; y < data[x].length; y++) {

        //Pixel filteredPixel = new Pixel(data[i][j].red, 0, data[i][j].blue);

        // Apply the transformation, and receive new value
        Pixel transformedPixel = this.transformPixel(inputTransformation, data[x][y], x, y);

        // Put the new pixel in the output image
        output[x][y] = transformedPixel;
      }
    }

    IImage transformedImage = new Image(output);
    return transformedImage;
  }

  /**
   * Applies a transformation to a pixel object using linear algebra.
   * @param  inputTransformation The transformation to be applied.
   * @param  inputPixel the pixel it should be applied to
   * @param x the x-coordinate in this image of that pixel
   * @param y the y-coordinate in this image of that pixel
   * @return A new pixel object that is the result of applying this filter to a pixel.
   */
  private Pixel transformPixel(Transformation inputTransformation, Pixel inputPixel, int x, int y) {

    // Get the matrix of the transformation.
    double[][] matrix = inputTransformation.getData();

    double redPrime = (matrix[0][0] * inputPixel.getRed() + matrix[0][1] * inputPixel.getGreen()
            + matrix[0][2] * inputPixel.getBlue());
    double greenPrime = (matrix[1][0] * inputPixel.getRed() + matrix[1][1] * inputPixel.getGreen()
            + matrix[1][2] * inputPixel.getBlue());
    double bluePrime = (matrix[2][0] * inputPixel.getRed() + matrix[2][1] * inputPixel.getGreen()
            + matrix[2][2] * inputPixel.getBlue());

    // Round double values and cast to ints.
    Pixel newPixel = new Pixel((int) Math.round(redPrime), (int) Math.round(greenPrime),
            (int) Math.round(bluePrime));
    return newPixel;

  }

  /**
   * Applies the given filter to this image.
   *
   * @param inputFilter The filter to apply to this image.
   * @return A copy of this image with the given filter applied.
   */
  public IImage applyFilter(Filter inputFilter) {

    // Initialize output object
    Pixel[][] output = new Pixel[this.data.length][this.data[0].length];

    // For each pixel in the image, apply the filter. Add that new value to the corresponding value
    // in a new set of data, and then create a new Image object from that. Return the resulting obj.
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {

        //Pixel filteredPixel = new Pixel(data[i][j].red, 0, data[i][j].blue);

        // Apply the filter, and receive new value
        Pixel filteredPixel = this.applyFilterToPixel(inputFilter, i, j);

        // Put the new pixel in the output image
        output[i][j] = filteredPixel;
      }
    }

    Image filteredImage = new Image(output);
    return filteredImage;

  }

  /** Applies a filter object to a specified pixel in this specified image. Helper method used by
   * apply.
   *
   * @param inputFilter The filter to apply.
   * @param x The x-coordinate of this pixel.
   * @param y The y-coordinate of this pixel.
   * @return A new pixel object that is the result of applying this filter to a pixel.
   */
  private Pixel applyFilterToPixel(Filter inputFilter, int x, int y) {

    // Get the kernel of the filter
    double[][] filterKernel = inputFilter.getData();
    int filterLength = (filterKernel.length - 1) / 2;
    int yStart = y - filterLength;

    double redSum = 0;
    double greenSum = 0;
    double blueSum = 0;


    // For each entry in the filter kernel
    for (int b = 0; b < filterKernel.length; b++) {
      int xStart = x - filterLength;
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
}

