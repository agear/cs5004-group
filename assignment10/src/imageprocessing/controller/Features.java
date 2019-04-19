package imageprocessing.controller;

import java.io.IOException;

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
  void save() throws IOException;


  /**
   * Exits the program.
   */
  void quit() throws IOException;


  /**
   * Loads up a .txt file with a series of commands, then processes them sequentially, without
   * changing the display at all.
   */
  void batchLoad();


  /**
   * TODO javadoc
   */
  void batchWrite(String script);

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

  /**
   * Applies a blur adjustment to an image.
   */
  void blur();

  /**
   * Applies a sharpen adjustment to an image.
   */
  void sharpen();

  /**
   * Applies a dither adjustment to an image.
   */
  void dither();

  /**
   * Applies a mosiac adjustment to an image.
   * @param seed The number of seeds/clusters to mosaic
   */
  void mosaic(int seed);

  /**
   * Applies a sepia adjustment to an image.
   */
  void sepia();

  /**
   * Applies a greyscale adjustment to an image.
   */
  void greyscale();

  //Draw menu functions

  /**
   * Draws a flag object.
   */
  void flag();

  /**
   * Draws a rainbow object.
   */
  void rainbow();

  /**
   * Draws a checkerboard object.
   */
  void checkerboard();

}
