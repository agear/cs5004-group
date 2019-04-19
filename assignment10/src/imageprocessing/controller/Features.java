package imageprocessing.controller;

/**
 * This interface has each //TODO can you javadoc this? I haven't wrapped my mind around the features architecture :(
 */
public interface Features {

  //File menu functions
  /**
   * Loads an image from a path to the display of the view, and stored in the model.
   */
  void load();


  /**
   * TODO figure out how we are doing this and then javadoc it
   */
  void save();


  /**
   * Exits the program.
   */
  void quit();


  /**
   * Loads up a .txt file with a series of commands, then processes them sequentially, without
   * changing the display at all.
   */
  void batchLoad();

  //Edit menu functions


  /**
   * Reverts to the last image in the display.
   */
  void undo();

  /**
   * Cancels out the previous undo.
   */
  void redo();

  //Adjustment menu functions
  void blur();
  void sharpen();
  void dither();
  void mosaic(int seed);
  void sepia();
  void greyscale();

  //Draw menu functions
  void flag();
  void rainbow();
  void checkerboard();

}
