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

public class ModelImpl implements IModel {
  private HashMap<String, IImage> openImages;
  private int rainbowCount;
  private int checkerBoardCount;
  private int flagCount;

  /**
   * //TODO Constructor
   */
  public ModelImpl() {
    this.openImages = new HashMap<>();
    this.rainbowCount = 0;
    this.checkerBoardCount = 0;
    this.flagCount = 0;
  }

  private String isDuplicate(String title){
    String titleCopy = title;
    int count = 0;
    while(this.openImages.containsKey(titleCopy)) {
      System.out.println("The name "+titleCopy+" was already taken...");
      titleCopy = title;
      count += 1;
      titleCopy = title+"-"+count;
      System.out.println("Trying "+titleCopy+" instead");
    }
    return titleCopy;
  }


  @Override
  public void load(String ifile, String title) throws IOException {
    IImage i = new Image(ifile);
    this.openImages.put(isDuplicate(title), i);
  }

  @Override
  public void save(String title) throws IOException {

    IImage currentImage = this.openImages.get(title);
//    System.out.println("Saving " + title);
    currentImage.writeImageToFile(title + ".png");
  }

  @Override
  public void applyBlur(String title) {
    Filter blur = new Filter(Filters.BLUR);
    IImage blurredImage = blur.apply(this.openImages.get(title));
    String newName = title + "-blur";
    this.openImages.put(isDuplicate(newName), blurredImage);
  }

  @Override
  public void applySharpen(String title) {
    Filter sharpen = new Filter(Filters.SHARPEN);
    IImage sharpenedImage = sharpen.apply(this.openImages.get(title));
    String newName = title + "-sharpen";
    this.openImages.put(isDuplicate(newName), sharpenedImage);
  }

  @Override
  public void applySepia(String title) {
    Transformation sepia = new Transformation(Transformations.SEPIA);
    IImage sepiaImage = sepia.apply(this.openImages.get(title));
    String newName = title + "-sepia";
    this.openImages.put(isDuplicate(newName), sepiaImage);
  }

  @Override
  public void applyGreyscale(String title) {
    Transformation greyscale = new Transformation(Transformations.GREYSCALE);
    IImage greyscaleImage = greyscale.apply(this.openImages.get(title));
    String newName = title + "-greyscale";
    this.openImages.put(isDuplicate(newName), greyscaleImage);
  }

  @Override
  public void applyDither(String title) {
    Dither dither = new Dither();
    IImage ditherImage = dither.apply(this.openImages.get(title));
    String newName = title + "-dither";
    this.openImages.put(isDuplicate(newName), ditherImage);
  }

  @Override
  public void applyMosaic(String title, int seed) {
    Mosaic mosaic = new Mosaic();
    IImage mosaicImage = mosaic.apply(this.openImages.get(title), seed);
    String newName = title + "-mosaic";
    this.openImages.put(isDuplicate(newName), mosaicImage);

  }

  @Override
  public void drawRainbow(int height, int width, Orientation o) {
    Rainbow r = new Rainbow(height, width, o);
    this.rainbowCount += 1;
    String name = "rainbow-"  + this.rainbowCount;
    this.openImages.put(isDuplicate(name), r);
  }

  @Override
  public void drawCheckerBoard(int squareSize) {
    CheckerBoard cb = new CheckerBoard(squareSize);
    this.checkerBoardCount += 1;
    String name = "checkerboard-" + this.checkerBoardCount;
    this.openImages.put(isDuplicate(name), cb);
  }

  @Override
  public void drawFlag(int width, Country c) {
    Flag f = new Flag(width, c);
    this.flagCount += 1;
    String name = "flag-" + this.flagCount;
    System.out.println("Name put into open images: " + name);
    this.openImages.put(isDuplicate(name), f);
  }
}
