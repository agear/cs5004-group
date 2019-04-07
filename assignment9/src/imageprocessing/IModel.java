package imageprocessing;

public interface IModel {

  Image load(String ifile, String title);

  void save(String title, String ofile);

  void applyBlur(String title);

  void applySharpen(String title);

  void applySepia(String title);

  void applyGreyscale(String title);

  void applyDither(String title);

  void applyMosaic(String title, int seed);

  void drawRainbow(int height, int width, Orientation o);

  void drawCheckerBoard(int squareSize);

  void drawFlag(int width, Country c);
}
