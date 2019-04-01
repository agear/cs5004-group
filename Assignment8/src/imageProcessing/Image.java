package imageProcessing;

import java.io.IOException;

/**
 * This class represents an image. An image is 2D array of pixel objects. It can be filtered or
 * transformed. It can be created by a file (.jpg, .png, etc).
 */
public class Image extends ImageUtil {

  public Pixel[][] data;
  private String filename;
  private int height;
  private int width;

  /** Constructor for an image object, if the filename is given.
   *
   * @param filename The name of the file to be turned into an Image file
   * @throws IOException If the file cannot be found
   */
  public Image(String filename) throws IOException {


    int[][][] imageRGBMap = this.readImage(filename);
    this.data = new Pixel[imageRGBMap.length][imageRGBMap[0].length];
    this.width = this.getWidth(filename);
    this.height = this.getHeight(filename);

    // Initialize data field to input length
    //this.data = new Pixel[data.length][data[0].length];

    // Loop through input, creating pixels and creating data field
    for (int i = 0; i < this.data.length; i++) {
      for (int j = 0; j < this.data[i].length; j++) {

        // Create a pixel with data
        Pixel newPixel = new Pixel(imageRGBMap[i][j][0], imageRGBMap[i][j][1], imageRGBMap[i][j][2]);
        this.data[i][j] = newPixel;
      }
    }
    this.filename = filename;
  }


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

    this.height = data.length;
    this.width = data[0].length;

  }

  /**
   * Constructs an image with a 2D array of pixel objects.
   *
   * @param data A 2D array of pixel objects.
   */
  // Alternate way of creating data
  public Image(Pixel[][] data) {
    this.data = data;
//    System.out.println("Creating an image with 2D pixel data!");
    this.height = data.length;
    this.width = data[0].length;
  }


  /**
   * Constructor for an empty image. Use for generative images (i.e., user-specified size, not
   * coming from a file).
   *
   * @param width The width of the new image
   * @param height The height of the new Image
   */
  public Image(int width, int height) {

    int[][][] data = this.createWhiteImage(width, height);
    this.data = new Pixel[width][height];
    this.width = width;
    this.height = height;

    for (int x = 0; x < width; x++)
      for (int y = 0; y < height; y++) {
        Pixel newPixel = new Pixel(data[x][y][0], data[x][y][1], data[x][y][2]);
        this.data[x][y] = newPixel;
      }

  }



  /** Creates an image with horizontal stripes.
   *
   * @return The image of horizontal stripes.
   */
  public Image horizontalStripes() {
    //Pixel[][] rainbow;

    for (int x = 0; x < 50; x++)
      for (int y = 0; y < 500; y++) {
        Pixel newPixel = new Pixel(255, 0, 0);
        this.data[x][y] = newPixel;
      }
    for (int x = 51; x < 100; x++)
      for (int y = 0; y < 500; y++) {
        Pixel newPixel = new Pixel(255, 165, 0);
        this.data[x][y] = newPixel;
      }
    for (int x = 101; x < 150; x++)
      for (int y = 0; y < 500; y++) {
        Pixel newPixel = new Pixel(255, 255, 0);
        this.data[x][y] = newPixel;
      }
    for (int x = 151; x < 200; x++)
      for (int y = 0; y < 500; y++) {
        Pixel newPixel = new Pixel(0, 128, 0);
        this.data[x][y] = newPixel;
      }
    for (int x = 201; x < 250; x++)
      for (int y = 0; y < 500; y++) {
        Pixel newPixel = new Pixel(0, 0, 255);
        this.data[x][y] = newPixel;
      }
    for (int x = 251; x < 300; x++)
      for (int y = 0; y < 500; y++) {
        Pixel newPixel = new Pixel(75, 0, 130);
        this.data[x][y] = newPixel;
      }
    for (int x = 301; x < 350; x++)
      for (int y = 0; y < 500; y++) {
        Pixel newPixel = new Pixel(238, 130, 238);
        this.data[x][y] = newPixel;
      }
    Image generatedImage = new Image(this.data);
    return generatedImage;
  }

  /** Creates an image with horizontal stripes.
   *
   * @return The image of horizontal stripes.
   */
  public Image verticalStripes() {
    //Pixel[][] rainbow;

    for (int x = 0; x < 350; x++)
      for (int y = 0; y < 50; y++) {
        Pixel newPixel = new Pixel(255, 0, 0);
        this.data[x][y] = newPixel;
      }
    for (int x = 0; x < 350; x++)
      for (int y = 51; y < 100; y++) {
        Pixel newPixel = new Pixel(255, 165, 0);
        this.data[x][y] = newPixel;
      }
    for (int x = 0; x < 350; x++)
      for (int y = 101; y < 150; y++) {
        Pixel newPixel = new Pixel(255, 255, 0);
        this.data[x][y] = newPixel;
      }
    for (int x = 0; x < 350; x++)
      for (int y = 151; y < 200; y++) {
        Pixel newPixel = new Pixel(0, 128, 0);
        this.data[x][y] = newPixel;
      }
    for (int x = 0; x < 350; x++)
      for (int y = 201; y < 250; y++) {
        Pixel newPixel = new Pixel(0, 0, 255);
        this.data[x][y] = newPixel;
      }
    for (int x = 0; x < 350; x++)
      for (int y = 251; y < 300; y++) {
        Pixel newPixel = new Pixel(75, 0, 130);
        this.data[x][y] = newPixel;
      }
    for (int x = 0; x < 350; x++)
      for (int y = 301; y < 350; y++) {
        Pixel newPixel = new Pixel(238, 130, 238);
        this.data[x][y] = newPixel;
      }
    Image generatedImage = new Image(this.data);
    return generatedImage;
  }

  // TODO Delete? Because moved to flag class?
  public Image greece() {

    for (int x = 0; x < 50; x++)
      for (int y = 0; y < 700; y++) {
        Pixel newPixel = new Pixel(13, 94, 175);
        this.data[x][y] = newPixel;
      }
    for (int x = 51; x < 100; x++)
      for (int y = 0; y < 700; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
    for (int x = 101; x < 150; x++)
      for (int y = 0; y < 700; y++) {
        Pixel newPixel = new Pixel(13, 94, 175);
        this.data[x][y] = newPixel;
      }
    for (int x = 151; x < 200; x++)
      for (int y = 0; y < 700; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
    for (int x = 201; x < 250; x++)
      for (int y = 0; y < 700; y++) {
        Pixel newPixel = new Pixel(13, 94, 175);
        this.data[x][y] = newPixel;
      }
    for (int x = 251; x < 300; x++)
      for (int y = 0; y < 700; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
    for (int x = 301; x < 350; x++)
      for (int y = 0; y < 700; y++) {
        Pixel newPixel = new Pixel(13, 94, 175);
        this.data[x][y] = newPixel;
      }
    for (int x = 351; x < 400; x++)
      for (int y = 0; y < 700; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
    for (int x = 401; x < 450; x++)
      for (int y = 0; y < 700; y++) {
        Pixel newPixel = new Pixel(13, 94, 175);
        this.data[x][y] = newPixel;
      }
    Image generatedImage = new Image(this.data);
    return generatedImage;
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
        Pixel filteredPixel = this.applyFilterToPixel(inputFilter, i, j);

        // Put the new pixel in the output image
        output[i][j] = filteredPixel;
      }
    }

    Image filteredImage = new Image(output);
    return filteredImage;

  }


  /**
   * Takes as input a transformation (such as greyscale or sepia), and returns that tranformation
   * applied to this image object, without mutating the image.
   * @param inputTransformation The tranformation to apply
   * @return The image after transformation
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
   * A helper method for Transform which transforms a single pixel using linear algebra.
   * @param inputTransformation The transformation to apply to this image
   * @param inputPixel The pixel to be transformed
   * @param x The x coordinate of that pixel in the image
   * @param y The y coordinate of that pixel in the image
   * @return A new pixel object that is the result of applying this filter to a pixel.
   */
  private Pixel TransformPixel(Transformation inputTransformation, Pixel inputPixel, int x, int y) {

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
   * Creates a String representation of this image, which is a matrix of RGB values.
   *
   * @return String representation of this image's RGB values
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
   * Method to return this image as a 3D array of integers. // TODO More detailed explanation? I.e.
   * what is stored in each dimension of the array?
   *
   * @return This image as a 3D array of integers.
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


  /** Returns the data (RGB values) associated with this image.
   * @return The data
   */
  public Pixel[][] getData() {
    return this.data.clone();
  }


  /** Writes the image to a file.
   * @param filename The desired file path.
   * @throws IOException If there is an error creating a file with that path name.
   */
  public void writeImageToFile(String filename) throws IOException {

    // If the image was originally created with a file ...
    if (this.filename != null) {
      this.writeImage(this.get3Ddata(), this.getWidth(this.filename), this.getHeight(this.filename), filename);
    }

    // If the image was originally created by the computer (e.g., stripes)...
    else {
      this.writeImage(this.get3Ddata(), this.width, this.height, filename);
    }
  }


}
