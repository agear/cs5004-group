package imageprocessing.controller;

import java.io.IOException;

//TODO Javadoc.
public interface IController {

  /**
   * Gives control to controller until the program ends.
   * @throws IOException if it is given an input file with invalid input (e.g tries to open a file
   * that doesn't exist.
   */
  void go() throws IOException;
}
