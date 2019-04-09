package imageprocessing.model;

import java.io.IOException;

import imageprocessing.model.Image.Country;
import imageprocessing.model.Image.Orientation;

public interface IModel {

  void load(String ifile, String title) throws IOException;

  void save(String title) throws IOException;

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
