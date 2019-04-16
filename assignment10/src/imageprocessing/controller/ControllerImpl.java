package imageprocessing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import imageprocessing.model.IModel;
import imageprocessing.model.image.Country;
import imageprocessing.model.image.Orientation;
import imageprocessing.view.IView;

/**
 * The controller takes input from the user and decides what to do. It is the client of the model
 * and it controls how and when the model is used. It also controls what must be shown by the view
 * and when. This controller applies filters and transformations onto any sort of image.
 */
public class ControllerImpl implements IController, ActionListener {
  final Readable in;
//  final Appendable out;
  IModel model;
  IView view;
  String currentImage;
  Stack<String> undoStack;

  //TODO Delete?
//  Map<Character, Runnable> commands = new HashMap<>();


  /** Initializes the controller of the imageprocessing package.
   * The controller takes input from the user and decides what to do. It also controls what must
   * be shown by the view and when.
   *
   * @param model the model associated with this controller.
   * @param in an object implementing the Readable interface to parse.
   */
  public ControllerImpl(IModel model, IView view, Readable in){
    this.in = in;
    this.model = model;
    this.view = view;
    this.undoStack = new Stack<>();
    /*
     During initialization, the controller passes itself as the listener for all the view’s buttons.
     The effect of this design is that when the program is run and the button is clicked,
     a method inside the controller is called.
     Thus the controller gets control over what to do next.
     */
    try {
      this.view.setListener(this);
    }
    catch (NullPointerException e) {
      System.out.println("There's an exception, idk why");
    }

    //TODO Based on the Lecture code: ??
//    this.view.display();
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

          // When loading, get the file name:
          String filename;
          try {
            filename = scan.next();
          }
          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the path of the file to load.");
          }

          // Get the image name:
          try {
            imageName = scan.next();
          }
          catch (NoSuchElementException e) {
            // If they don't specify, then just call it the same name as the file
            imageName = filename;
          }

          // Load the file name as the image name:
          this.model.load(filename, imageName);
          break;

          // Each of the next cases is a 'verb' to apply to the next image
        case "dither":

          try {
            imageName = scan.next();
          }

          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to adjust.");
          }

          this.model.applyDither(imageName);
          break;
        case "blur":

          try {
            imageName = scan.next();
          }
          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to adjust.");
          }


          this.model.applyBlur(imageName);
          break;
        case "sharpen":
          try {
            imageName = scan.next();
          }
          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to adjust.");
          }
          this.model.applySharpen(imageName);
          break;
        case "sepia":
          try {
            imageName = scan.next();
          }
          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to adjust.");
          }
          this.model.applySepia(imageName);
          break;
        case "greyscale":
          try {
            imageName = scan.next();
          }
          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to adjust.");
          }
          this.model.applyGreyscale(imageName);
          break;
        case "mosaic":
          try {
            imageName = scan.next();
          }
          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to adjust.");
          }

          int seed;
          try {
            seed = Integer.parseInt(scan.next());
          }
          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify number of seeds for mosaic'ing.");
          }


          this.model.applyMosaic(imageName, seed);
          break;
        case "checkerboard":
          int squareSize;
          try {
            squareSize = Integer.parseInt(scan.next());
          }
          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the size of the squares.");
          }
          this.model.drawCheckerBoard(squareSize);
          break;

        case "flag":
          String country;
          try {
            country = scan.next().toLowerCase();
          }
          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the country to generate.");
          }

          int fWidth;
          try {
            fWidth = Integer.parseInt(scan.next());
          }
          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the size of the flag to generate.");
          }

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

          String orientation;
          int rWidth;
          int rHeight;
          try {
            orientation = scan.next();
            rHeight = Integer.parseInt(scan.next());
            rWidth = Integer.parseInt(scan.next());
          }
          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the rainbow's orientation, "
                    + "width, and height.");
          }

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
          try {
            imageName = scan.next();
          }
          catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to save.");
          }

          model.save(imageName);
          break;

        default:
          throw new IllegalArgumentException("Sorry, that command hasn't been installed yet."
                  + "Maybe in version 4.0?");
      }
    }
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "load":
        this.view.openLoadDialogue();
        String path = this.view.getFilePath();
        System.out.println("Controller: "+ path);
        try {
          this.model.load(path, path);
        }
        catch (IOException exception) {
          throw new IllegalArgumentException("Nope!!!");
        }
        this.currentImage = path;
        BufferedImage buffered = this.model.getImage(path);
        this.view.displayImage(buffered);
        break;
      case "undo":
        //TODO throw exception if stack is empty?
        this.currentImage = this.undoStack.pop();
        BufferedImage bufferedU = this.model.getImage(this.currentImage);
        this.view.displayImage(bufferedU);
        break;
        case "flag":
        System.out.println("flag has been recieved by the controller");
        model.drawFlag(100, Country.GREECE);
        try {
          BufferedImage bufferedFlag = this.model.getImage("flag");
          view.displayImage(bufferedFlag);
          model.save("flag");
        }
        catch (IOException exception) {
          throw new IllegalArgumentException("No such element");
        }
        break;
      case "blur":
        //TODO should this be in a higher order function since this is basically going to be the
        // same template for all adjustments? applyAdjustment(e->applyBlur) ???
        System.out.println("blur has been received by the controller");
        this.undoStack.push(currentImage);
        this.model.applyBlur(currentImage);
        this.currentImage = this.currentImage+"-blur";
        BufferedImage buffer = this.model.getImage(currentImage);
        view.displayImage(buffer);
        break;
      default:
        System.out.println(e.getActionCommand() + " was received by the controller");
    }
//    System.out.println(e.getActionCommand() + " was received by the controller");

  }


}
