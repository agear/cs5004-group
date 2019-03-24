package imageProcessing;

import java.util.Arrays;
import java.io.IOException;

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

  // Alternate way of creating data
  public Image(Pixel[][] data) {
    this.data = data;
  }

  private boolean isValidPixelPosition(int x, int y) {

    if (x < this.data.length && y < this.data[0].length && x > 0 && y > 0 ) {
      return true;
    }

    return false;

  }


  private Pixel applyFilterToPixel(Filter inputFilter, Pixel inputPixel, int x, int y) {

    System.out.println("Filter: " + Arrays.deepToString(inputFilter.kernel));


    // Get the kernel of the filter
    double[][] filterKernel = inputFilter.kernel;
    int filterLength = filterKernel.length;
    int xStart = x - (filterLength/2) - 1;
    int yStart = y - filterLength - 1;
    double redSum = 0;
    double greenSum = 0;
    double blueSum = 0;

    // For each slot in the filter
    for (int a = 0; a < filterKernel.length; a++) {
      for (int b = 0; b < filterKernel[a].length; b++) {

        // Gets the current filter
        double currentFilter = filterKernel[a][b];
        System.out.println("Current filter: " + currentFilter);
        System.out.println("With coordinate in data: "  + xStart +  " " + yStart);

        // Get the pixel to be altered
        if (this.isValidPixelPosition(xStart,yStart)) {
          Pixel currentPixel = this.data[xStart][yStart];
          System.out.println("Valid pixel position, adding sum");
          redSum = redSum + (currentPixel.vectorRed(currentFilter));
          greenSum = greenSum + (currentPixel.vectorGreen(currentFilter));
          blueSum = blueSum + (currentPixel.vectorBlue(currentFilter));
        }

        yStart++;
      }
      xStart++;
    }

    Pixel newPixel = new Pixel((int)redSum,(int)greenSum,(int)blueSum);
    return newPixel;

  }


  public Image applyFilter(Filter inputFilter) {

    // Initialize output object
    Pixel[][] output = new Pixel[this.data.length][this.data[0].length];

    // For each pixel in the image, apply the filter. Add that new value to the corresponding value
    // in a new set of data, and then create a new Image object from that. Return the resulting obj.
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {

        // Apply the filter, and receive new value
        Pixel filteredPixel = this.applyFilterToPixel(inputFilter, data[i][j], i, j);

        // Put the new pixel in the output image
        output[i][j] = filteredPixel;


      }
    }

    Image filteredImage = new Image(output);
    return filteredImage;

  }



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


}
