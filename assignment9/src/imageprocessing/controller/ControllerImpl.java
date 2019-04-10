package imageprocessing.controller;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

import imageprocessing.model.IModel;
import imageprocessing.model.Image.Country;
import imageprocessing.model.Image.Orientation;

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
//    this.out = out;
    this.model = model;
//    this.view = view;
  }

  //TODO Need another input.txt file for spec. From Piazza: They are to show us what features are supported. Two files are recommended so that you don't have one file with everything in it. - Amit
  //TODO Remove print debugging commands, add better comments.
  //TODO Java doc.
  //TODO Explain syntax--  command, argument1, argument2 etc
  //TODO Throw exceptions if incorrect syntax is given?
  public void go() throws IOException {
    Objects.requireNonNull(model);
    String command;
    String imageName;
    //TODO Should this be a Map<String, Method> ??? Is there a less cumbersome way to do this?
    Scanner scan = new Scanner(this.in);
    while (scan.hasNext()) {
      command = scan.next();
      switch (command) {
        case "load":
          String filename = scan.next();
          imageName = scan.next();
          this.model.load(filename, imageName);
          break;
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
          String country = scan.next();
          int fWidth = Integer.parseInt(scan.next());
          if (country.equals("france")) {
            this.model.drawFlag(fWidth, Country.FRANCE);
          } else if (country.equals("switzerland")) {
            this.model.drawFlag(fWidth, Country.SWITZERLAND);
          } else if (country.equals("greece")) {
            this.model.drawFlag(fWidth, Country.GREECE);
          } else {
            // TODO Throw exception?
            break;
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
            //TODO throw exception?
            break;
          }
          break;
        case "save":
          imageName = scan.next();
          model.save(imageName);
          break;
        default:
          //TODO throw exception
      }
    }
  }
}
