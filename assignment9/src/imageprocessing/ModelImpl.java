package imageprocessing;

import java.util.HashMap;

public class ModelImpl implements IModel {
  private HashMap<String, IImage> openImages;

  @Override
  public Image load(String ifile, String title) {
    return null;
  }

  @Override
  public void save(String title, String ofile) {

  }

  @Override
  public void applyBlur(String title) {
    Filter blur = new Filter(Filters.BLUR);
    IImage blurredImage = blur.apply(openImages.get(title));
    String newName = title + "_blur";
    openImages.put(newName, blurredImage);
  }

  @Override
  public void applySharpen(String title) {
    Filter sharpen = new Filter(Filters.SHARPEN);
    IImage sharpenedImage = sharpen.apply(openImages.get(title));
    String newName = title + "_sharp";
    openImages.put(newName, sharpenedImage);
  }

  @Override
  public void applySepia(String title) {
    Transformation sepia = new Transformation(Transformations.SEPIA);
    openImages.add(sepia.apply(i));
  }

  @Override
  public void applyGreyscale(String title) {
    Transformation greyscale = new Transformation(Transformations.GREYSCALE);
    openImages.add(greyscale.apply(i));
  }

  @Override
  public void applyDither(String title) {

  }

  @Override
  public void applyMosaic(String title, int seed) {

  }

  @Override
  public void drawRainbow(int height, int width, Orientation o) {
    Rainbow r = new Rainbow(height, width, o);
    openImages.add(r);
  }

  @Override
  public void drawCheckerBoard(int squareSize) {
    CheckerBoard cb = new CheckerBoard(squareSize);
    openImages.add(cb);
  }

  @Override
  public void drawFlag(int width, Country c) {
    Flag f = new Flag(width, c);
    openImages.add(f);
  }
}
