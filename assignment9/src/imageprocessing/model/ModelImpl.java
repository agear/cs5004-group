package imageprocessing.model;

import java.io.IOException;
import java.util.HashMap;

import imageprocessing.model.Image.CheckerBoard;
import imageprocessing.model.Image.Country;
import imageprocessing.model.adjustment.Dither;
import imageprocessing.model.adjustment.Filter;
import imageprocessing.model.adjustment.Filters;
import imageprocessing.model.Image.Flag;
import imageprocessing.model.Image.IImage;
import imageprocessing.model.Image.Image;
import imageprocessing.model.adjustment.Mosaic;
import imageprocessing.model.Image.Orientation;
import imageprocessing.model.Image.Rainbow;
import imageprocessing.model.adjustment.Transformation;
import imageprocessing.model.adjustment.Transformations;

/**
 * This is the model of the imageprocessing package. It can load and save images, apply
 * different types of filters to open images and draw flags, rainbows and checkerboards.
 * This class allows the users of this package to have a clean
 * interface -- they don't need to initialize filter objects, create images from files
 * in a cumbersome way, etc.
 */
public class ModelImpl implements IModel {
  private HashMap<String, IImage> openImages;
//  private int checkerBoardCount;
//  private int flagCount;

  /**
   * This is the constructor for the model of the imageprocessing package. It initializes
   * a library of openimages -- images the user has chosen to 'upload' to the system. It also
   * intiializes a count of rainbows, checkerboards, and flags the user has made, in order
   * to have a clean naming convention for creating them into files.
   */
  public ModelImpl() {
    this.openImages = new HashMap<>();
//    this.checkerBoardCount = 0;
//    this.flagCount = 0;
  }

  /** Checks if a filename is taken and takes the appropriate actions either way. If the filename
   * is taken and it can't be made, then it appends a number to the filename to make it unique.
   * Otherwise, the specified file name is given in the output and given the go-ahead to be used.
   * @param title  The questionable filename
   * @return The approved filename
   */
  private String isDuplicate(String title){
    String titleCopy = title;
    int count = 0;
    while(this.openImages.containsKey(titleCopy)) {
      titleCopy = title;
      count += 1;
      titleCopy = title+"-"+count;
    }
    return titleCopy;
  }

  /** Takes as input a filename and a name for the file in the internal organization.
   *
   * @param ifile The name of the file in the OS
   * @param title The name of the image in the imageprocessing package
   * @throws IOException If the ifile doesn't exist/can't be found
   */
  @Override
  public void load(String ifile, String title) throws IOException {
    IImage i = new Image(ifile);
    this.openImages.put(isDuplicate(title), i);
  }

  /**
   * Saves an image to the computer in a file. I.e., write the image to a file.
   *
   * @param title The goal name of the output file (+.png)
   * @throws IOException If there is an error with the specified file name
   */
  @Override
  public void save(String title) throws IOException {

    IImage currentImage = this.openImages.get(title);
    currentImage.writeImageToFile(title + ".png");

  }

  /**
   * Creates a filtered version of the current image with a blur using a built-in kernel.
   * Doesn't mutate the image.
   *
   * @param title the name of the image the user wants blurred
   */
  @Override
  public void applyBlur(String title) {
    Filter blur = new Filter(Filters.BLUR);
    IImage blurredImage = blur.apply(this.openImages.get(title));
    String newName = title + "-blur";
    this.openImages.put(isDuplicate(newName), blurredImage);
  }

  /**
   * Creates a filtered version of the current image -- sharpened -- using a built-in kernel.
   * Doesn't mutate the image.
   *
   * @param title the name of the image the user wants sharpened
   */
  @Override
  public void applySharpen(String title) {
    Filter sharpen = new Filter(Filters.SHARPEN);
    IImage sharpenedImage = sharpen.apply(this.openImages.get(title));
    String newName = title + "-sharpen";
    this.openImages.put(isDuplicate(newName), sharpenedImage);
  }

  /**
   * Creates a filtered version of the current image -- in sepia.
   * Doesn't mutate the image.
   *
   * @param title the name of the image the user wants in sepia
   */
  @Override
  public void applySepia(String title) {
    Transformation sepia = new Transformation(Transformations.SEPIA);
    IImage sepiaImage = sepia.apply(this.openImages.get(title));
    String newName = title + "-sepia";
    this.openImages.put(isDuplicate(newName), sepiaImage);
  }

  /**
   * Creates a filtered version of the current image -- in greyscale.
   * Doesn't mutate the image.
   *
   * @param title the name of the image the user wants in greyscale
   */
  @Override
  public void applyGreyscale(String title) {
    Transformation greyscale = new Transformation(Transformations.GREYSCALE);
    IImage greyscaleImage = greyscale.apply(this.openImages.get(title));
    String newName = title + "-greyscale";
    this.openImages.put(isDuplicate(newName), greyscaleImage);
  }

  /**
   * Creates a filtered version of the current image -- in dithered format,
   * appropriate for dot-matrix printers.
   *
   * Doesn't mutate the image.
   *
   * @param title the name of the image the user wants dithered
   */
  @Override
  public void applyDither(String title) {
    Dither dither = new Dither();
    IImage ditherImage = dither.apply(this.openImages.get(title));
    String newName = title + "-dither";
    this.openImages.put(isDuplicate(newName), ditherImage);
  }

  /**
   * Creates a mosaic of the current image using a simplified k-means. The user specifies the
   * number of seeds. The more seeds, the more fine the dots in the mosaic.
   *
   * Doesn't mutate the image.
   *
   * @param title the name of the image the user wants mosaic'ed
   * @param seed the number of seeds (chunks) of the desired mosaic
   */
  @Override
  public void applyMosaic(String title, int seed) {
    Mosaic mosaic = new Mosaic();
    IImage mosaicImage = mosaic.apply(this.openImages.get(title), seed);
    String newName = title + "-mosaic";
    this.openImages.put(isDuplicate(newName), mosaicImage);

  }

  /**
   * Initializes a rainbow image -- 7 stripes of color, with user specified orientation and size.
   *
   * @param height The height, in pixels, of the desired rainbow image
   * @param width The width, in pixels, of the desired rainbow image
   * @param o The orientation of the desired rainbow image (vertical or horizontal)
   */
  @Override
  public void drawRainbow(int height, int width, Orientation o) {
    Rainbow r = new Rainbow(height, width, o);
    String name = "rainbow";
    this.openImages.put(isDuplicate(name), r);
  }

  /**
   * Initializes a checkerboard image (alternating equally-sized black and white squares),
   * where the square size is user-specified. A checkerboard is 8 squares x 8 squares.
   *
   * @param squareSize the length/width of a square, in pixels
   */
  @Override
  public void drawCheckerBoard(int squareSize) {
    CheckerBoard cb = new CheckerBoard(squareSize);
    String name = "checkerboard";
    this.openImages.put(isDuplicate(name), cb);
  }

  /**
   * Initializes a flag image of a user-specified country and size.
   *
   * @param width the width of the desired flag, in pixels.
   * @param c the country of the desired flag. Currently supports France, Switzerland and Greece.
   */
  @Override
  public void drawFlag(int width, Country c) {
    Flag f = new Flag(width, c);
    String name = "flag";
    this.openImages.put(isDuplicate(name), f);
  }
}
