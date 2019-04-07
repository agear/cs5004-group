package imageprocessing;

/**
 * This class is a type of adjustment that can be applied to an image. It uses the Floyd-Steinberg
 * algorithm to make an image suitable for dot-matrix printers.
 *
 */
public class Dither implements Adjustment {


  /**
   * Takes as input an integer color between 0 and 255. Converts it to
   * white or black (0 or 255), whichever it is closest to.
   * @param old_color
   * @return
   */
  private int convertToBW(int old_color) {
    if (old_color <= 127) {
      return 0;
    }
    return 255;
  }



  /**
   * Applies this object onto an image input without mutating it, and outputs a new image object
   * with the adjustment.
   *
   * @param input Image to change
   * @return Altered cloned image
   */
  @Override
  public IImage apply(IImage input) {

    // Get the data of input image
    Pixel[][] dataOriginal = input.getData();
    Pixel[][] data = dataOriginal.clone();

    // Initialize output image and pixels
    //Pixel[][] newData = new Pixel[data.length][data[0].length];
    for (int r = 0; r < data.length; r++) {
      for (int c = 0; c < data[0].length; c++) {
        data[r][c] = new Pixel(0,0,0);
      }
    }


    // for each position r,c in image,
    for (int r = 0; r < data.length; r++) {
      for(int c = 0; c < data[0].length; c++) {

        // old_color = color-component of pixel (r,c)
        int old_color_red = data[r][c].getRed();
//        int old_color_green = data[r][c].getGreen();
//        int old_color_blue = data[r][c].getBlue();

        // Convert each channel to white or black, whichever it is closest to
        int new_color_red = convertToBW(old_color_red);
//        int new_color_blue = convertToBW(old_color_blue);
//        int new_color_green = convertToBW(old_color_green);

        // Calculate the error for each channel
        int error_red = old_color_red - new_color_red;
//        int error_green = old_color_green - new_color_green;
//        int error_blue = old_color_blue - new_color_blue;

        //System.out.println("Red original: " + data[r][c].toString());


        // Set color of new pixel at current position
        data[r][c].add("red", new_color_red);
        data[r][c].add("green", new_color_red);
        data[r][c].add("blue", new_color_red);

        //System.out.println("Red init: " + newData[r][c].toString());
        //System.out.println("Red new: " + newData[r][c].toString());

        // ADJUST SURROUNDING PIXELS
        // add (7/16 * error) to pixel on the right (r,c+1)
        if (c != data[0].length - 1 ) {
          data[r][c + 1].add("red", 7 / 16 * error_red);
          data[r][c + 1].add("green", 7 / 16 * error_red);
          data[r][c + 1].add("blue", 7 / 16 * error_red);
        }

        // add (3/16 * error) to pixel on the next-row-left (r+1,c-1)
        if (c != 0 && r != data.length - 1 ) {
          data[r + 1][c - 1].add("red", 3 / 16 * error_red);
          data[r + 1][c - 1].add("green", 3 / 16 * error_red);
          data[r + 1][c - 1].add("blue", 3 / 16 * error_red);
        }

        // add (5/16 * error) to pixel below in next row (r+1,c)
        if (r != data.length - 1 ) {
          data[r + 1][c].add("red", 5 / 16 * error_red);
          data[r + 1][c].add("green", 5 / 16 * error_red);
          data[r + 1][c].add("blue", 5 / 16 * error_red);
        }

        // add (1/16 * error) to pixel on the next-row-right (r+1,c+1)
        if (r != data.length - 1 && c != data[0].length - 1 ) {
          data[r + 1][c + 1].add("red", 1 / 16 * error_red);
          data[r + 1][c + 1].add("green", 1 / 16 * error_red);
          data[r + 1][c + 1].add("blue", 1 / 16 * error_red);
        }

      }
    }

    Image ditheredImage = new Image(data);
    System.out.println("Dithering complete");
    return ditheredImage;
  }

//  /**
//   * Applies this object onto an image input without mutating it, and outputs a new image object
//   * with the adjustment.
//   *
//   * @param input Image to change
//   * @param channel The channel to get error calculation from
//   * @return Altered cloned image
//   */
//  public IImage applyChannel(IImage input, String channel) {
//    // Get the data of input image
//    Pixel[][] data = input.getData();
//
//    // Initialize output image
//    Pixel[][] newData = new Pixel[data.length][data[0].length];
//
//    for (int r = 0; r < data.length; r++) {
//      for (int c = 0; c < data[0].length; c++) {
//        newData[r][c] = new Pixel(0,0,0);
//      }
//    }
//
//
//    // for each position r,c in image,
//    for (int r = 0; r < data.length; r++) {
//      for(int c = 0; c < data[0].length; c++) {
//
//        // old_color = color-component of pixel (r,c)
//        int old_color;
//        if (channel.equals("red")) {
//          old_color = data[r][c].getRed();
//        }
//
//        else if (channel.equals("green")) {
//          old_color = data[r][c].getGreen();
//        }
//
//        else {
//          old_color = data[r][c].getBlue();
//        }
//
//        // Convert each channel to white or black, whichever it is closest to
//        int new_color = convertToBW(old_color);
//
//        // Calculate the error for each channel
//        int error = old_color - new_color;
//
//
//        // Set color of new pixel
//        newData[r][c].add("red", new_color);
//        newData[r][c].add("green", new_color);
//        newData[r][c].add("blue", new_color);
//
//        // Adjust surrounding pixels
//
//        // Pixel on right ....     add (7/16 * error) to pixel on the right (r,c+1)
//        if (c != data[0].length - 1 ) {
//          newData[r][c + 1].add("red", 7 / 16 * error);
//          newData[r][c + 1].add("green", 7 / 16 * error);
//          newData[r][c + 1].add("blue", 7 / 16 * error);
//        }
//
//        // add (3/16 * error) to pixel on the next-row-left (r+1,c-1)
//        if (c != 0 && r != data.length - 1 ) {
//          newData[r + 1][c - 1].add("red", 3 / 16 * error);
//          newData[r + 1][c - 1].add("green", 3 / 16 * error);
//          newData[r + 1][c - 1].add("blue", 3 / 16 * error);
//        }
//
//        // add (5/16 * error) to pixel below in next row (r+1,c)
//        if (r != data.length - 1 ) {
//          newData[r + 1][c].add("red", 5 / 16 * error);
//          newData[r + 1][c].add("green", 5 / 16 * error);
//          newData[r + 1][c].add("blue", 5 / 16 * error);
//        }
//
//        // add (1/16 * error) to pixel on the next-row-right (r+1,c+1)
//        if (r != data.length - 1 && c != data[0].length - 1 ) {
//          newData[r + 1][c + 1].add("red", 1 / 16 * error);
//          newData[r + 1][c + 1].add("green", 1 / 16 * error);
//          newData[r + 1][c + 1].add("blue", 1 / 16 * error);
//        }
//
//      }
//    }
//
//    Image ditheredImage = new Image(newData);
//    return ditheredImage;
//
//  }
//

}
