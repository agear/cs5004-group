package imageprocessing.controller;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

import imageprocessing.model.IModel;
import imageprocessing.model.image.Country;
import imageprocessing.model.image.Orientation;

/**
 * The controller takes input from the user and decides what to do. It is the client of the model
 * and it controls how and when the model is used. It also controls what must be shown by the view
 * and when. This controller applies filters and transformations onto any sort of image.
 */
public class ControllerImpl implements IController {
  final Readable in;
  //  final Appendable out;
  IModel model;
  // IView view;

  Map<Character, Runnable> commands = new HashMap<>();


  /** Initializes the controller of the imageprocessing package.
   * The controller takes input from the user and decides what to do. It also controls what must
   * be shown by the view and when.
   *
   * @param model the model associated with this controller.
   * @param in an object implementing the Readable interface to parse.
   */
  public ControllerImpl(IModel model, Readable in) {
    this.in = in;
    this.model = model;
  }

  /** The goGo method gives control to the controller (this class) until the program ends.
   * It parses a text file, and has a switch-case design to determine which model method
   * should be run to complete the user's intended action.
   *
   * @throws IOException If the input file to be parsed can not be found
   * @throws IllegalArgumentException If the input has an unrecognized command
   * @throws NullPointerException If the model can't be found
   */
  public void goGo() throws IOException, IllegalArgumentException, NullPointerException {

    // Checks that the specified model is not null (if it is, throws null pointer exception)
    Objects.requireNonNull(model);

    // Initialize command and object of command
    String command;
    String imageName;

    // Parse the input file
    Scanner scan = new Scanner(this.in);
    while (scan.hasNext()) {
      command = scan.next();

      // Switch-case design to parse input
      switch (command) {

        // Loading a file adds it to our open, available images, with a readable name
        case "load":
          String filename = scan.next();
          imageName = scan.next();
          this.model.load(filename, imageName);
          break;

          // Each of the next cases is a 'verb' to apply to the next image
        case "dither":
          imageName = scan.next();
          this.model.applyDither(imageName);
          break;
        case "blur":
          imageName = scan.next();
          this.model.applyBlur(imageName);
          break;
        case "sharpen":
          imageName = scan.next();
          this.model.applySharpen(imageName);
          break;
        case "sepia":
          imageName = scan.next();
          this.model.applySepia(imageName);
          break;
        case "greyscale":
          imageName = scan.next();
          this.model.applyGreyscale(imageName);
          break;
        case "mosaic":
          imageName = scan.next();
          int seed = Integer.parseInt(scan.next());
          this.model.applyMosaic(imageName, seed);
          break;
        case "checkerboard":
          int squareSize = Integer.parseInt(scan.next());
          this.model.drawCheckerBoard(squareSize);
          break;

        case "flag":
          String country = scan.next().toLowerCase();
          int fWidth = Integer.parseInt(scan.next());

          // Only France, Greece, and Switzerland are included in this package.
          if (country.equals("france")) {
            this.model.drawFlag(fWidth, Country.FRANCE);
          } else if (country.equals("switzerland")) {
            this.model.drawFlag(fWidth, Country.SWITZERLAND);
          } else if (country.equals("greece")) {
            this.model.drawFlag(fWidth, Country.GREECE);
          } else {
            throw new IllegalArgumentException("Sorry, that country (" + country
                    + ") hasn't been installed yet."
                    + "Maybe in version 4.0?");
          }
          break;
        case "rainbow":
          String orientation = scan.next();
          int rWidth = Integer.parseInt(scan.next());
          int rHeight = Integer.parseInt(scan.next());
          if (orientation.equals("horizontal")) {
            this.model.drawRainbow(rHeight, rWidth, Orientation.HORIZONTAL);
          } else if (orientation.equals("vertical")) {
            this.model.drawRainbow(rHeight, rWidth, Orientation.VERTICAL);
          } else {
            throw new IllegalArgumentException("Sorry, that orientation hasn't been installed yet."
                    + "Maybe in version 4.0?");
          }
          break;

          // This case saves an image, based on its english name (not path) to a file
        case "save":
          imageName = scan.next();
          model.save(imageName);
          break;

        default:
          throw new IllegalArgumentException("Sorry, that command hasn't been installed yet."
                  + "Maybe in version 4.0?");
      }
    }
  }
}
