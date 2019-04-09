package imageprocessing;

import java.io.IOException;

/**
 * This class represents an image. An image is 2D array of pixel objects. It can be filtered or
 * transformed. It can be created by a file (.jpg, .png, etc).
 */
public class Image extends AbstractImage implements IImage {
  private String filename;

  /** Constructor for an image object, if the filename is given.
   *
   * @param filename The name of the file to be turned into an Image file
   * @throws IOException If the file cannot be found
   */
  public Image(String filename) throws IOException {


    int[][][] imageRGBMap = this.readImage(filename);
    super.data = new Pixel[imageRGBMap.length][imageRGBMap[0].length];
    super.width = this.getWidth(filename);
    super.height = this.getHeight(filename);

    // Initialize data field to input length
    //this.data = new Pixel[data.length][data[0].length];

    // Loop through input, creating pixels and creating data field
    for (int i = 0; i < super.data.length; i++) {
      for (int j = 0; j < super.data[i].length; j++) {

        // Create a pixel with data
        Pixel newPixel = new Pixel(imageRGBMap[i][j][0], imageRGBMap[i][j][1],
                imageRGBMap[i][j][2]);
        super.data[i][j] = newPixel;
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
    super.data = new Pixel[data.length][data[0].length];

    // Loop through input, creating pixels and creating data field
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {

        // Create a pixel with data
        Pixel newPixel = new Pixel(data[i][j][0], data[i][j][1], data[i][j][2]);
        super.data[i][j] = newPixel;
      }
    }

    super.height = data.length;
    super.width = data[0].length;

  }

  /**
   * Constructs an image with a 2D array of pixel objects.
   *
   * @param data A 2D array of pixel objects.
   */
  // Alternate way of creating data
  public Image(Pixel[][] data) {
    super.data = data;
    super.height = data.length;
    super.width = data[0].length;
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
    super.data = new Pixel[width][height];
    super.width = width;
    super.height = height;

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Pixel newPixel = new Pixel(data[x][y][0], data[x][y][1], data[x][y][2]);
        super.data[x][y] = newPixel;
      }
    }
  }

  //TODO Delete?
//  /**
//   * Creates a String representation of this image, which is a matrix of RGB values.
//   *
//   * @return String representation of this image's RGB values
//   */
//  public String toString() {
//    String output = "";
//    for (int i = 0; i < super.data.length; i++) {
//      for (int j = 0; j < super.data[i].length; j++) {
//        output += super.data[i][j] + " ";
//      }
//      output += "\n";
//    }
//    return output;
//  }

  //TODO Does this break anything?
//  /** Writes the image to a file.
//   * @param filename The desired file path.
//   * @throws IOException If there is an error creating a file with that path name.
//   */
//  @Override
//  public void writeImageToFile(String filename) throws IOException {
//
//    // If the image was originally created with a file ...
//    if (this.filename != null) {
//      this.writeImage(this.get3Ddata(), this.getWidth(this.filename),
//              this.getHeight(this.filename), filename);
//    }
//
//    // If the image was originally created by the computer (e.g., a flag)...
//    else {
//      this.writeImage(this.get3Ddata(), super.width, super.height, filename);
//    }
//  }
}
