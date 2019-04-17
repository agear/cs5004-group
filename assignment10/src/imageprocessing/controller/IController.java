package imageprocessing.controller;

import java.io.IOException;

import imageprocessing.view.IView;

/**
 * The controller parses input, and determines what the model and view should do with
 * what the user wants based on the input file. It passes control around.
 */
public interface IController {

  /**
   * Gives control to controller until the program ends.
   * @throws IOException if it is given an input file with invalid input (e.g tries to open a file
   *     that doesn't exist.
   */
  void goGo() throws IOException;
  void setView(IView view);
}
