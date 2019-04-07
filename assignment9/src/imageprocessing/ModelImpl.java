package imageprocessing;

import java.io.IOException;
import java.util.HashMap;

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

  @Override
  public void load(String ifile, String title) throws IOException {
    Image i = new Image(ifile);
    //TODO check if image already has that name??
    this.openImages.put(title, i);
  }

  @Override
  public void save(String title) throws IOException {
  this.openImages.get(title).writeImageToFile(title + ".png");
  }

  @Override
  public void applyBlur(String title) {
    Filter blur = new Filter(Filters.BLUR);
    IImage blurredImage = blur.apply(this.openImages.get(title));
    String newName = title + "-blur";
    this.openImages.put(newName, blurredImage);
  }

  @Override
  public void applySharpen(String title) {
    Filter sharpen = new Filter(Filters.SHARPEN);
    IImage sharpenedImage = sharpen.apply(this.openImages.get(title));
    String newName = title + "-sharp";
    this.openImages.put(newName, sharpenedImage);
  }

  @Override
  public void applySepia(String title) {
    Transformation sepia = new Transformation(Transformations.SEPIA);
    IImage sepiaImage = sepia.apply(this.openImages.get(title));
    String newName = title + "-sepia";
    this.openImages.put(newName, sepiaImage);
  }

  @Override
  public void applyGreyscale(String title) {
    Transformation greyscale = new Transformation(Transformations.GREYSCALE);
    IImage greyscaleImage = greyscale.apply(this.openImages.get(title));
    String newName = title + "-greyscale";
    this.openImages.put(newName, greyscaleImage);
  }

  @Override
  public void applyDither(String title) {
  //TODO
  }

  @Override
  public void applyMosaic(String title, int seed) {
  //TODO
  }

  @Override
  public void drawRainbow(int height, int width, Orientation o) {
    Rainbow r = new Rainbow(height, width, o);
    this.rainbowCount += 1;
    String name = "rainbow_"  + this.rainbowCount;
    this.openImages.put(name, r);
  }

  @Override
  public void drawCheckerBoard(int squareSize) {
    CheckerBoard cb = new CheckerBoard(squareSize);
    this.checkerBoardCount += 1;
    String name = "checkerboard_" + this.checkerBoardCount;
    this.openImages.put(name, cb);
  }

  @Override
  public void drawFlag(int width, Country c) {
    Flag f = new Flag(width, c);
    this.flagCount += 1;
    String name = "flag_" + this.flagCount;
    this.openImages.put(name, f);
  }
}
