package imageprocessing;

import java.util.Set;

public class ModelImpl implements IModel {
  Set<IImage> openImages;

  @Override
  public Image load(String ifile, String title) {
    return null;
  }

  @Override
  public void save(Image i, String ofile) {

  }

  @Override
  public Image applyBlur(Image i) {
    Filter blur = new Filter(Filters.BLUR);
    openImages.add(blur.apply(i));
    return null;
  }

  @Override
  public Image applySharpen(Image i) {
    Filter sharpen = new Filter(Filters.SHARPEN);
    openImages.add(sharpen.apply(i));
    return null;
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
