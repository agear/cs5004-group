package imageProcessing;

import java.util.Arrays;
import java.io.IOException;


/**
 * TODO Javadoc.
 */
public class Image {

  public Pixel[][] data;

  // Takes data of the type outputted by ImageUtil class (TODO describe better)
  public Image(int[][][] data)  {

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
   * TODO Javadoc.
   * @param data
   */
  // Alternate way of creating data
  public Image(Pixel[][] data) {
    this.data = data;
  }

  /**
   * TODO Javadoc.
   * @param x
   * @param y
   * @return
   */
  private boolean isValidPixelPosition(int x, int y) {

    if (x < this.data.length && y < this.data[0].length && x >= 0 && y >= 0 ) {
      return true;
    }

    return false;

  }

  /**
   * TODO Javadoc.
   * @param inputFilter
   * @param inputPixel
   * @param x
   * @param y
   * @return
   */
  private Pixel applyFilterToPixel(Filter inputFilter, Pixel inputPixel, int x, int y) {

    // Get the kernel of the filter
    double[][] filterKernel = inputFilter.getData();
    int filterLength = (filterKernel.length - 1 ) / 2;
    int xStart = x-filterLength;
    int yStart = y-filterLength;

    double redSum = 0;
    double greenSum = 0;
    double blueSum = 0;


    // For each entry in the filter kernel
    for (int b = 0; b < filterKernel.length; b++) {
      xStart = x-filterLength;
      for (int a = 0; a < filterKernel.length; a++) {

        // Gets the current filter
        double currentFilter = filterKernel[a][b];

        // Get the pixel to be altered
        if (this.isValidPixelPosition(xStart,yStart)) {
          Pixel currentPixel = this.data[xStart][yStart];
          redSum = redSum + (currentPixel.vectorRed(currentFilter));
          greenSum = greenSum + (currentPixel.vectorGreen(currentFilter));
          blueSum = blueSum + (currentPixel.vectorBlue(currentFilter));
        }
        xStart++;

      }
      yStart++;

    }

    Pixel newPixel = new Pixel((int)Math.round(redSum),(int)Math.round(greenSum),(int)Math.round(blueSum));
    return newPixel;

  }

  /**
   * TODO Javadoc.
   * @param inputFilter
   * @return
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


  /**
   * TODO Javadoc.
   * @return
   */
  public String toString(){
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
   * TODO Javadoc.
   * @return
   */
  public int[][][] get3Ddata() {
    int[][][] output = new int[data.length][data[0].length][3];
    for (int i = 0; i < data.length; i++ ) {
      for (int j = 0; j < data[0].length; j++ ) {
        output[i][j][0] = this.data[i][j].red;
        output[i][j][1] = this.data[i][j].green;
        output[i][j][2] = this.data[i][j].blue;
      }
    }
    return output;
  }



}
