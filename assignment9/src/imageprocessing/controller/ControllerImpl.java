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
  //TODO Explain syntax
  //TODO Throw exceptions if incorrect syntax is given?
  public void go() throws IOException {
    Objects.requireNonNull(model);
    String command;
    String imageName;
    int flagNum = 0;
    int rainbowNum = 0;
    int checkerboardNum = 0;
    //TODO Should this be a Map<String, Method> ??? Is there a less cumbersome way to do this?
    Scanner scan = new Scanner(this.in);
    while (scan.hasNext()) {
      command = scan.next();
      switch (command) {
        case "load":
          String filename = scan.next();
          imageName = scan.next();
          this.model.load(filename, imageName);
          System.out.println("Loading " + filename + " as " + imageName + "...");
          break;
        case "dither":
          imageName = scan.next();
          this.model.applyDither(imageName);
          System.out.println("Dithering " + imageName + "...");
          break;
        case "blur":
          imageName = scan.next();
          this.model.applyBlur(imageName);
          System.out.println("Applying blur to " + imageName + "...");
          break;
        case "sharpen":
          imageName = scan.next();
          this.model.applySharpen(imageName);
          System.out.println("Applying sharpen to " + imageName + "...");
          break;
        case "sepia":
          imageName = scan.next();
          this.model.applySepia(imageName);
          System.out.println("Applying sepia transformation to " + imageName + "...");
          break;
        case "greyscale":
          imageName = scan.next();
          this.model.applyGreyscale(imageName);
          System.out.println("Applying greyscale transformation to " + imageName + "...");
          break;
        case "mosaic":
          imageName = scan.next();
          int seed = Integer.parseInt(scan.next());
          this.model.applyMosaic(imageName, seed);
          System.out.println("Applying mosaic transformation to " + imageName + "...");
          break;
        case "checkerboard":
          int squareSize = Integer.parseInt(scan.next());
          this.model.drawCheckerBoard(squareSize);
          checkerboardNum += 1;
          this.model.save("checkerboard-" + checkerboardNum);
          break;
        case "flag":
          String country = scan.next();
          int fWidth = Integer.parseInt(scan.next());
          if (country.equals("france")) {
            this.model.drawFlag(fWidth, Country.FRANCE);
            flagNum += 1;
          } else if (country.equals("switzerland")) {
            this.model.drawFlag(fWidth, Country.SWITZERLAND);
            flagNum += 1;
          } else if (country.equals("greece")) {
            this.model.drawFlag(fWidth, Country.GREECE);
            flagNum += 1;
          } else {
            System.out.println("Country " + command + " not found");
            break;
          }
          this.model.save("flag-" + flagNum);
          break;
        case "rainbow":
          String orientation = scan.next();
          int rWidth = Integer.parseInt(scan.next());
          int rHeight = Integer.parseInt(scan.next());
          if (orientation.equals("horizontal")) {
            this.model.drawRainbow(rHeight, rWidth, Orientation.HORIZONTAL);
            rainbowNum += 1;
          } else if (orientation.equals("vertical")) {
            this.model.drawRainbow(rHeight, rWidth, Orientation.VERTICAL);
            rainbowNum += 1;
          } else {
            System.out.println("Orientation " + orientation + " not found");
            break;
          }
          this.model.save("rainbow-" + rainbowNum);
          break;
        case "save":
          imageName = scan.next();
          System.out.println("Saving " + imageName + " to " + imageName + ".png");
          model.save(imageName);
          break;
        default:
          System.out.println("Command " + command + " not found");
      }
    }
  }
}
