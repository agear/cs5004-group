package imageprocessing;

public interface IModel {

  Image load(String ifile, String title);

  void save(Image i, String ofile);

  Image applyBlur(Image i);

  Image applySharpen(Image i);

  Image applySepia(Image i);

  Image applyGreyscale(Image i);

  Image applyDither(Image i);

  Image applyMosaic(Image i, int seed);

  Image drawRainbow(int height, int width, Orientation o);

  Image drawCheckerBoard(int squareSize);

  Image drawFlag(int width, Country c);
}
