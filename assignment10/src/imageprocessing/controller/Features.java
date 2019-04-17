package imageprocessing.controller;

public interface Features {
  //File menu functions
  void load();
  void save();
  void quit();

  //Edit menu functions
  void undo();
  void redo();

  //Adjustment menu functions
  void blur();
  void sharpen();
  void dither();
  void mosaic(int seed);
  void sepia();
  void greyscale();

  //Draw menu functions
}
