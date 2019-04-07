package imageprocessing;

import java.io.IOException;

/**
 * This class represents a checkerboard image. It can create the checkerboard, and return
 * information about the object. It is a type of Image, which means it can have adjustments
 * applied to it.
 */
public class CheckerBoard extends ImageUtil implements IImage {
  private Pixel[][] data;
  private int height;
  private int width;
  private int squareSize;

  /**
   * Creates a Checkerboard based on a user-specified square size.
   * @param squareSize The width/height dimension of the square, in pixels
   */
  public CheckerBoard(int squareSize) {
    this.height = (squareSize * 8);
    this.width = (squareSize * 8);
    this.squareSize = squareSize;
    this.data = new Pixel[this.width][this.height];
    this.draw();
  }

  /**
   * Draws the checkerboard object - a helper method used by the constructor.
   */
  private void draw() {
    int left = 0;
    //int top = 0;


    // Initializes this.data by creating a pixel in each spot.
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        Pixel uninitPixel = new Pixel(0, 0, 255);
        this.data[j][i] = uninitPixel;
      }
    }

    // For each row,
    for (int horizontal = 0; horizontal < 8; horizontal++) {
      int top = 0;

      // For each column,
      for (int vertical = 0; vertical < 4; vertical++) {
        if (horizontal % 2 == 0) {
          drawWhiteSquare(left, top);
        } else {
          drawBlackSquare(left, top);
        }
        top += this.squareSize;
        if ((horizontal + 1) % 2 == 0) {
          drawWhiteSquare(left, top);
        } else {
          drawBlackSquare(left, top);
        }
        top += this.squareSize;
      }
      left += this.squareSize;
    }
  }


  /** Creates a white square object in this.data, - a helper method used by draw.
   * @param left The x-coordinate of the top left corner of the new square.
   * @param top The y-coordinate of the top left corner of the new square.
   */
  private void drawWhiteSquare(int left, int top) {
    for (int x = left; x < left + this.squareSize; x++) {
      for (int y = top; y < top + this.squareSize; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
    }
  }

  /** Creates a black square object in this.data, - a helper method used by draw.
   * @param left The x-coordinate of the top left corner of the new square.
   * @param top The y-coordinate of the top left corner of the new square.
   */
  private void drawBlackSquare(int left, int top) {
    for (int x = left; x < left + this.squareSize; x++) {
      for (int y = top; y < top + this.squareSize; y++) {
        Pixel newPixel = new Pixel(0, 0, 0);
        this.data[x][y] = newPixel;
      }
    }
  }


  /** Returns the height, in Pixels, of this checkerboard image.
   * @return height in Pixels of image
   */
  public int getHeight() {
    int heightClone = this.height;
    return heightClone;
  }

  /** Returns the width, in Pixels, of this checkerboard image.
   * @return width in Pixels of image
   */
  public int getWidth() {
    int widthClone = this.width;
    return widthClone;
  }

  /** Returns the data of this checkerboard image, by converting a 2D array of Pixel objects
   * into a 3D array of int objects. The purpose of this method is to make the data readably
   * by the ImageUtil class, or any 'outsiders' who do not have Pixel objects.
   * @return A 3D array of values representing RGB values of this image
   */
  public int[][][] get3Ddata() {
    int[][][] output = new int[this.data.length][this.data[0].length][3];
    for (int i = 0; i < this.data.length; i++) {
      for (int j = 0; j < this.data[0].length; j++) {
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
