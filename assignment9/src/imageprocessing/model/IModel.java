package imageprocessing.model;

import java.io.IOException;

import imageprocessing.model.Image.Country;
import imageprocessing.model.Image.Orientation;

//TODO Javadoc.
public interface IModel {

  /** Takes as input a filename and a name for the file in the internal organization.
   *
   * @param ifile The name of the file in the OS
   * @param title The name of the image in the imageprocessing package
   * @throws IOException If the ifile doesn't exist/can't be found
   */
  void load(String ifile, String title) throws IOException;

  /**
   * Saves an image to the computer in a file. I.e., write the image to a file.
   *
   * @param title The goal name of the output file (+.png)
   * @throws IOException If there is an error with the specified file name
   */
  void save(String title) throws IOException;

  /**
   * Creates a filtered version of the current image with a blur using a built-in kernel.
   * Doesn't mutate the image.
   *
   * @param title the name of the image the user wants blurred
   */
  void applyBlur(String title);

  /**
   * Creates a filtered version of the current image -- sharpened -- using a built-in kernel.
   * Doesn't mutate the image.
   *
   * @param title the name of the image the user wants sharpened
   */
  void applySharpen(String title);

  /**
   * Creates a filtered version of the current image -- in sepia.
   * Doesn't mutate the image.
   *
   * @param title the name of the image the user wants in sepia
   */
  void applySepia(String title);

  /**
   * Creates a filtered version of the current image -- in greyscale.
   * Doesn't mutate the image.
   *
   * @param title the name of the image the user wants in greyscale
   */
  void applyGreyscale(String title);

  /**
   * Creates a filtered version of the current image -- in dithered format,
   * appropriate for dot-matrix printers.
   *
   * Doesn't mutate the image.
   *
   * @param title the name of the image the user wants dithered
   */
  void applyDither(String title);

  /**
   * Creates a mosaic of the current image using a simplified k-means. The user specifies the
   * number of seeds. The more seeds, the more fine the dots in the mosaic.
   *
   * Doesn't mutate the image.
   *
   * @param title the name of the image the user wants mosaic'ed
   * @param seed the number of seeds (chunks) of the desired mosaic
   */
  void applyMosaic(String title, int seed);

  /**
   * Initializes a rainbow image -- 7 stripes of color, with user specified orientation and size.
   *
   * @param height The height, in pixels, of the desired rainbow image
   * @param width The width, in pixels, of the desired rainbow image
   * @param o The orientation of the desired rainbow image (vertical or horizontal)
   */
  void drawRainbow(int height, int width, Orientation o);

  /**
   * Initializes a checkerboard image (alternating equally-sized black and white squares),
   * where the square size is user-specified. A checkerboard is 8 squares x 8 squares.
   *
   * @param squareSize the length/width of a square, in pixels
   */
  void drawCheckerBoard(int squareSize);


  /**
   * Initializes a flag image of a user-specified country and size.
   *
   * @param width the width of the desired flag, in pixels.
   * @param c the country of the desired flag. Currently supports France, Switzerland and Greece.
   */
  void drawFlag(int width, Country c);
}
