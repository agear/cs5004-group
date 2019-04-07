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
  public Image applySepia(Image i) {
    Transformation sepia = new Transformation(Transformations.SEPIA);
    openImages.add(sepia.apply(i));
    return null;
  }

  @Override
  public Image applyGreyscale(Image i) {
    Transformation greyscale = new Transformation(Transformations.GREYSCALE);
    openImages.add(greyscale.apply(i));
    return null;
  }

  @Override
  public Image applyDither(Image i) {
    return null;
  }

  @Override
  public Image applyMosaic(Image i, int seed) {
    return null;
  }

  @Override
  public Image drawRainbow(int height, int width, Orientation o) {
    Rainbow r = new Rainbow(height, width, o);
    openImages.add(r);
    return null;
  }

  @Override
  public Image drawCheckerBoard(int squareSize) {
    CheckerBoard cb = new CheckerBoard(squareSize);
    openImages.add(cb);
    return null;
  }

  @Override
  public Image drawFlag(int width, Country c) {
    Flag f = new Flag(width, c);
    openImages.add(f);
    return null;
  }
}
