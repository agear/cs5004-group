package imageProcessing;

import java.io.IOException;

/**
 * This class represents and image. An image is 2D array of pixel objects.
 */
public class Image extends ImageUtil {

  public Pixel[][] data;
  private String filename;
  private int height;
  private int width;

  // Takes data of the type outputted by ImageUtil class (TODO describe better)


  public Image(String filename) throws IOException {


    int[][][] imageRGBMap = this.readImage(filename);
    this.data = new Pixel[imageRGBMap.length][imageRGBMap[0].length];
    this.width = this.getWidth(filename);
    this.height = this.getHeight(filename);

    // Initialize data field to input length
    //this.data = new Pixel[data.length][data[0].length];

    // Loop through input, creating pixels and creating data field
    for (int i = 0; i < this.data.length; i++) {
      System.out.println("Creating an image....." + i);
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
    System.out.println("Creating an image with 2D pixel data!");
    this.height = data.length;
    this.width = data[0].length;
  }

  //TODO This creates a NullPointerException.

  /**
   * Constructor for an empty image. Use for generative images.
   */
  public Image(int width, int height) {

    int[][][] data = this.createWhiteImage(width, height);
    this.data = new Pixel[width][height];

    for (int x = 0; x < width; x++)
      for (int y = 0; y < height; y++) {
        Pixel newPixel = new Pixel(data[x][y][0], data[x][y][1], data[x][y][2]);
        this.data[x][y] = newPixel;
      }

  }

  //TODO This creates a NullPointerException.
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
   * Method to return this image as a 3D array of integers. // TODO More detailed explanation? I.e.
   * what is stored in each dimension of the array?
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


  public Pixel[][] getData() {
    return this.data.clone();
  }



  public void writeImageToFile(String filename) throws IOException {
    if (this.filename != null) {
      this.writeImage(this.get3Ddata(), this.getWidth(this.filename), this.getHeight(this.filename), filename);
//<<<<<<< HEAD
//    } else {
//      System.out.println("Howd u make this image?");
//      throw new IOException("???");
//=======
    }
    else {
      this.writeImage(this.get3Ddata(), this.width, this.height, filename);
    }
  }


}
