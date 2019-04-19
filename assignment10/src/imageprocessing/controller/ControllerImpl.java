package imageprocessing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;
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
public class ControllerImpl implements IController, ActionListener, Features {
  final Readable in;
  //  final Appendable out;
  IModel model;
  IView view;

  int flagCount, rainbowCount, checkerboardCount;
  String currentImage;
  Stack<String> undoStack;
  Stack<String> redoStack;


  /**
   * Initializes the controller of the imageprocessing package. The controller takes input from the
   * user and decides what to do. It also controls what must be shown by the view and when.
   *
   * @param model the model associated with this controller.
   * @param in    an object implementing the Readable interface to parse.
   */
  public ControllerImpl(IModel model, Readable in) {
    this.in = in;
    this.model = model;
//    this.view = view;
    this.undoStack = new Stack<>();
    this.redoStack = new Stack<>();
    this.flagCount = 0;
    this.checkerboardCount = 0;
    this.rainbowCount = 0;
    this.currentImage = "./res/welcome.jpeg";

  }

  public void setView(IView v) {
    view = v; // provide view with all the callbacks
    view.addFeatures(this);
    view.toggleAdjustments(false);
  }

  public void goBatch(String inputFilePath) throws IOException {
    File file = new File(inputFilePath);
    Scanner scan = new Scanner(file);
    this.goUniversal(scan);
  }

  /**
   * The goGo method gives control to the controller (this class) until the program ends. It sends
   * the input stream to goUniversal, which parses a text file, and has a switch-case design to
   * determine which model method should be run to complete the user's intended action.
   *
   * @throws IOException              If the input file to be parsed can not be found
   * @throws IllegalArgumentException If the input has an unrecognized command
   * @throws NullPointerException     If the model can't be found
   */
  public void goGo() throws IOException, IllegalArgumentException, NullPointerException {
    Scanner scan = new Scanner(this.in);
    this.goUniversal(scan);
  }

  /**
   * The goGo method gives control to the controller (this class) until the program ends. It parses
   * any type of text input, and has a switch-case design to determine which model method should be
   * run to complete the user's intended action.
   *
   * @throws IOException              If the input file to be parsed can not be found
   * @throws IllegalArgumentException If the input has an unrecognized command
   * @throws NullPointerException     If the model can't be found
   */
  private void goUniversal(Scanner scan) throws IOException, IllegalArgumentException,
          NullPointerException {
    // Checks that the specified model is not null (if it is, throws null pointer exception)
    Objects.requireNonNull(model);

    // Initialize command and object of command
    String command;
    String imageName;


    // Parse the input file
    //Scanner scan = new Scanner(filepath);
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
          } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the path of the file to load.");
          }

          // Get the image name:
          try {
            imageName = scan.next();
          } catch (NoSuchElementException e) {
            // If they don't specify, then just call it the same name as the file
            imageName = filename;
          }

          // Load the file name as the image name:
          this.model.load(filename, imageName);
          this.currentImage = imageName;
          break;

        // Each of the next cases is a 'verb' to apply to the next image
        case "dither":

          try {
            imageName = scan.next();
          } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to adjust.");
          }

          this.model.applyDither(imageName);
          break;
        case "blur":

          try {
            imageName = scan.next();
          } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to adjust.");
          }
          this.model.applyBlur(imageName);
          break;


        case "sharpen":
          try {
            imageName = scan.next();
          } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to adjust.");
          }
          this.model.applySharpen(imageName);
          break;


        case "sepia":
          try {
            imageName = scan.next();
          } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to adjust.");
          }
          this.model.applySepia(imageName);
          break;


        case "greyscale":
          try {
            imageName = scan.next();
          } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to adjust.");
          }
          this.model.applyGreyscale(imageName);
          break;


        case "mosaic":
          try {
            imageName = scan.next();
          } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to adjust.");
          }

          int seed;
          try {
            seed = Integer.parseInt(scan.next());
          } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify number of seeds for mosaic'ing.");
          }


          this.model.applyMosaic(imageName, seed);
          break;


        case "checkerboard":
          int squareSize;
          try {
            squareSize = Integer.parseInt(scan.next());
          } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the size of the squares.");
          }
          this.model.drawCheckerBoard(squareSize);
          break;

        case "flag":
          String country;
          try {
            country = scan.next().toLowerCase();
          } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the country to generate.");
          }

          int fWidth;
          try {
            fWidth = Integer.parseInt(scan.next());
          } catch (NoSuchElementException e) {
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
          } catch (NoSuchElementException e) {
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
          } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Must specify the name of the image to save.");
          }

          model.save(imageName);
          break;

        default:
          throw new IllegalArgumentException("Sorry, that command hasn't been installed yet."
                  + " Maybe in version 4.0?");
      }
    }
  }


  @Override
  public void actionPerformed(ActionEvent e) throws IllegalArgumentException {
    switch (e.getActionCommand()) {

      case "save":
        this.view.openSaveDialogue();
        String spath = this.view.getFilePath();
        System.out.println("Controller save path: " + spath);
        break;

      case "sharpen":
        //TODO should this be in a higher order function since this is basically going to be the
        // same template for all adjustments? applyAdjustment(e->applyBlur) ???
        this.undoStack.push(currentImage);
        updateUndoRedo();
        try {
          this.model.applySharpen(currentImage);
          this.currentImage = this.currentImage + "-sharpen";
          BufferedImage buffer = this.model.getImage(currentImage);
          view.displayImage(buffer);
          this.redoStack.clear();
          updateUndoRedo();
        } catch (NullPointerException exc) {
          System.out.println("Can't sharpen the background image. Must load your own image first.");
        }
        break;
      case "dither":
        //TODO should this be in a higher order function since this is basically going to be the
        // same template for all adjustments? applyAdjustment(e->applyBlur) ???
        System.out.println("dither has been received by the controller");
        this.undoStack.push(currentImage);
        updateUndoRedo();
        System.out.println("current image:" + this.currentImage);
        try {
          this.model.applyDither(currentImage);
          this.currentImage = this.currentImage + "-dither";
          BufferedImage buffer = this.model.getImage(currentImage);
          view.displayImage(buffer);
          this.redoStack.clear();
          updateUndoRedo();
        } catch (NullPointerException exc) {
          System.out.println("Can't dither the background image. Must load your own image first.");
        }
        break;
      case "mosaic":
        //TODO should this be in a higher order function since this is basically going to be the
        // same template for all adjustments? applyAdjustment(e->applyBlur) ???
        System.out.println("mosaic has been received by the controller");
        this.undoStack.push(currentImage);
        updateUndoRedo();
        this.model.applyMosaic(currentImage, 100);
        this.currentImage = this.currentImage + "-mosaic";
        BufferedImage bufferM = this.model.getImage(currentImage);
        view.displayImage(bufferM);
        this.redoStack.clear();
        updateUndoRedo();
        break;
      case "sepia":
        //TODO should this be in a higher order function since this is basically going to be the
        // same template for all adjustments? applyAdjustment(e->applyBlur) ???
        System.out.println("sepia has been received by the controller");
        this.undoStack.push(currentImage);
        updateUndoRedo();
        System.out.println("current image:" + this.currentImage);
        try {
          this.model.applySepia(currentImage);
          this.currentImage = this.currentImage + "-sepia";
          BufferedImage buffer = this.model.getImage(currentImage);
          view.displayImage(buffer);
          this.redoStack.clear();
          updateUndoRedo();
        } catch (NullPointerException exc) {
          System.out.println("Can't sepia the background image. Must load your own image first.");
        }
        break;
      case "greyscale":
        //TODO should this be in a higher order function since this is basically going to be the
        // same template for all adjustments? applyAdjustment(e->applyBlur) ???
        System.out.println("greyscale has been received by the controller");
        this.undoStack.push(currentImage);
        updateUndoRedo();
        System.out.println("current image:" + this.currentImage);
        try {
          this.model.applyGreyscale(currentImage);
          this.currentImage = this.currentImage + "-greyscale";
          BufferedImage buffer = this.model.getImage(currentImage);
          view.displayImage(buffer);
          this.redoStack.clear();
          updateUndoRedo();
        } catch (NullPointerException exc) {
          System.out.println("Can't greyscale the background image. Must load your own image first.");
        }
        break;
      default:
        System.out.println(e.getActionCommand() + " was received by the controller");
    }
  }


  /**
   * Converts a string from the view into a Country -- parsing user input to pass to the model.
   *
   * @param input The name of the country from the button
   * @return The name of the country in a Country enum
   * @throws IllegalArgumentException If the country in the button isn't found
   */
  private Country stringToCountry(String input) throws IllegalArgumentException {
    try {

      if (input.equals("Switzerland")) {
        return Country.SWITZERLAND;
      } else if (input.equals("France")) {
        return Country.FRANCE;
      } else if (input.equals("Greece")) {
        return Country.GREECE;
      }
      throw new IllegalArgumentException("Country not installed yet. Bonus pack is $19.99.");
    }

    // If the user hits 'cancel' , it's no big deal!
    catch (NullPointerException e) {
      return null;
    }
  }


  /**
   * Converts a string from the view into an Orientation -- parsing user input to pass to the
   * model.
   *
   * @param input The name of the orientation from the view
   * @return The name of the orientation in an Orientation enum
   * @throws IllegalArgumentException If the orientation in the button isn't found
   */
  private Orientation stringToOrientation(String input) throws IllegalArgumentException {
    try {
      if (input.equals("Horizontal")) {
        return Orientation.HORIZONTAL;
      } else if (input.equals("Vertical")) {
        return Orientation.VERTICAL;
      }
      throw new IllegalArgumentException("Orientation not installed yet. Bonus pack is $14.99.");
    }

    // If the user hits 'cancel' , it's no big deal!
    catch (NullPointerException e) {
      return null;
    }

  }

  // File menu functions
  public void load() {
    // When the user clicks on the 'load' button, load the image in the model
    view.openLoadDialogue();
    String lpath = view.getFilePath();
    System.out.println(lpath);
    try {
      this.model.load(lpath, lpath);
    } catch (IOException exception) {
      throw new IllegalArgumentException("There was a problem loading that image.");
    }
    this.currentImage = lpath;
    // Creates a BufferedImage of the image specified by the path.
    BufferedImage buffered = this.model.getImage(lpath);
    // Supposed to rezie the window to the size of the new image. //TODO Doesn't work properly.
    view.setSize(buffered.getWidth(), buffered.getHeight());
    // Displays the image in the view.
    view.displayImage(buffered);

    // Since you have opened an image you can now apply adjustments
    this.view.toggleAdjustments(true);

  }

  public void batchLoad() {
    System.out.println("Calling batch load function");

    // When the user clicks on the 'load' button, get the script and run it
    view.openBatchLoadDialogue();

    String lpath = view.getFilePath();
    System.out.println("User chose: " + lpath);
    try {
      this.goBatch(lpath);
    } catch (IOException exception) {
      throw new IllegalArgumentException("There was a problem loading that file.");
    }
    // Since you have opened an image you can now apply adjustments
    this.view.toggleAdjustments(true);

  }


  public void save() {
    //TODO
  }

  public void quit() {
    System.exit(0);
  }

  // Edit menu functions

  public void undo() {
    // Start by pushing the current image onto the redo stack.
    this.redoStack.push(this.currentImage);
    // Next make the current image the top item on the undo stack.
    this.currentImage = this.undoStack.pop();
    // Update the display.
    BufferedImage bufferedU = this.model.getImage(this.currentImage);
    this.view.displayImage(bufferedU);
    // Update the undo/redo state.
    updateUndoRedo();
  }

  public void redo() {
    // Start by pushing the current image onto the undo stack.
    this.undoStack.push(this.currentImage);
    // Next make the current image the top item on the redo stack.
    this.currentImage = this.redoStack.pop();
    // Update the display.
    BufferedImage bufferedR = this.model.getImage(this.currentImage);
    this.view.displayImage(bufferedR);
    // Update the undo/redo state.
    updateUndoRedo();
  }

  /**
   * Toggles undo/redo availability in the view on state changes.
   */
  private void updateUndoRedo() {
    if (this.undoStack.empty()) {
      view.toggleUndo(false);
    } else {
      view.toggleUndo(true);
    }
    if (this.redoStack.empty()) {
      view.toggleRedo(false);
    } else {
      view.toggleRedo(true);
    }
  }

// Adjustment menu functions

  public void blur(){

        System.out.println("Calling blur function");
        // Push the current image to the undo stack before anything else
        this.undoStack.push(currentImage);

        // Apply the blur to the model.
        this.model.applyBlur(currentImage);

        // Update and display the current image.
        this.currentImage = this.currentImage + "-blur";
        BufferedImage buffer = this.model.getImage(currentImage);
        view.displayImage(buffer);

        // If you apply an adjustment, the redo stack is cleared.
        this.redoStack.clear();
        updateUndoRedo();
  }

  public void sharpen(){

    System.out.println("Calling sharpen function");
    // Push the current image to the undo stack before anything else
    this.undoStack.push(currentImage);

    // Apply sharpen to the model.
    this.model.applySharpen(currentImage);

    // Update and display the current image.
    this.currentImage = this.currentImage + "-sharpen";
    BufferedImage buffer = this.model.getImage(currentImage);
    view.displayImage(buffer);

    // If you apply an adjustment, the redo stack is cleared.
    this.redoStack.clear();
    updateUndoRedo();
  }

  public void dither(){

    System.out.println("Calling dither function");
    // Push the current image to the undo stack before anything else
    this.undoStack.push(currentImage);

    // Apply dither to the model.
    this.model.applyDither(currentImage);

    // Update and display the current image.
    this.currentImage = this.currentImage + "-dither";
    BufferedImage buffer = this.model.getImage(currentImage);
    view.displayImage(buffer);

    // If you apply an adjustment, the redo stack is cleared.
    this.redoStack.clear();
    updateUndoRedo();
  }

  public void mosaic(int seed){

    System.out.println("Calling mosaic function");
    // Push the current image to the undo stack before anything else
    this.undoStack.push(currentImage);

    // Apply mosaic to the model.
    this.model.applyMosaic(currentImage, seed);

    // Update and display the current image.
    this.currentImage = this.currentImage + "-mosaic";
    BufferedImage buffer = this.model.getImage(currentImage);
    view.displayImage(buffer);

    // If you apply an adjustment, the redo stack is cleared.
    this.redoStack.clear();
    updateUndoRedo();
  }

  public void sepia(){

    System.out.println("Calling sepia function");
    // Push the current image to the undo stack before anything else
    this.undoStack.push(currentImage);

    // Apply sepia to the model.
    this.model.applySepia(currentImage);

    // Update and display the current image.
    this.currentImage = this.currentImage + "-sepia";
    BufferedImage buffer = this.model.getImage(currentImage);
    view.displayImage(buffer);

    // If you apply an adjustment, the redo stack is cleared.
    this.redoStack.clear();
    updateUndoRedo();
  }

  public void greyscale(){

    System.out.println("Calling greyscale function");
    // Push the current image to the undo stack before anything else
    this.undoStack.push(currentImage);

    // Apply greyscale to the model.
    this.model.applyGreyscale(currentImage);

    // Update and display the current image.
    this.currentImage = this.currentImage + "-greyscale";
    BufferedImage buffer = this.model.getImage(currentImage);
    view.displayImage(buffer);

    // If you apply an adjustment, the redo stack is cleared.
    this.redoStack.clear();
    updateUndoRedo();
  }

  //Draw menu functions

  /**
   * TODO Javadoc
   */
  public void flag() {

    String chosenFlagString = view.flagDialog();

    // If they click 'cancel', do not continue prompting them.
    if (chosenFlagString == null) {
      return;
    }

    // Convert the string to a Country (which is what our model is expecting)
    Country chosenFlag = stringToCountry(chosenFlagString);

    int chosenWidth = view.widthDialog();

    // If they click 'cancel', do not make anything.
    if (chosenWidth == 0) {
      return;
    }

    System.out.println("In the controller, the user has chosen this width:" + chosenWidth);

    model.drawFlag(chosenWidth, chosenFlag);
    this.flagCount++;

    // Load the flag into the open images in the model, and save it as a file.
    BufferedImage bufferedFlag;
    if (this.flagCount == 1) {
      bufferedFlag = this.model.getImage("flag");
      view.displayImage(bufferedFlag);
      this.currentImage = "flag";
      this.undoStack.push(currentImage);
      this.view.toggleAdjustments(true);
    }

    // If this isn't the first flag, the name is "flag" with a number appended
    else {
      bufferedFlag = this.model.getImage("flag-" + (flagCount - 1));
      view.displayImage(bufferedFlag);
      this.currentImage = "flag-" + (flagCount - 1);
      this.undoStack.push(currentImage);
      this.view.toggleAdjustments(true);
    }

  }
  /**
   * //TODO javadoc.
   */
  public void rainbow() {
    String chosenRainbowOrientation = view.rainbowDialog();

        // If they click 'cancel', do not continue prompting them.
        if (chosenRainbowOrientation == null) {
          return;
        }

        Orientation chosenOrientation = stringToOrientation(chosenRainbowOrientation);

        int chosenWidth = view.widthDialog();

        // If they click 'cancel', do not make anything.
        if (chosenWidth == 0) {
          return;
        }

        int chosenHeight = view.heightDialog();

        // If they click 'cancel', do not make anything.
        if (chosenHeight == 0) {
          return;
        }

        model.drawRainbow(chosenHeight, chosenWidth, chosenOrientation);
        this.rainbowCount++;

    // Load the flag into the open images in the model

    BufferedImage bufferedRainbow;
    // If this is the first rainbow, the name of it is "rainbow"
    if (this.rainbowCount == 1) {
      bufferedRainbow = this.model.getImage("rainbow");
      view.displayImage(bufferedRainbow);
      this.currentImage = "rainbow";
      this.undoStack.push(currentImage);
      this.view.toggleAdjustments(true);
    }

    // If this isn't the first rainbow, the name is "rainbow" with a number appended
    else {
      bufferedRainbow = this.model.getImage("rainbow-" + (rainbowCount - 1));
      view.displayImage(bufferedRainbow);
      this.currentImage = "rainbow-" + (rainbowCount - 1);
      this.undoStack.push(currentImage);
      this.view.toggleAdjustments(true);
    }
  }

  public void checkerboard() {
    int checkerboardSize = view.checkerboardDialog();

    // If they click 'cancel', do not make anything.
    if (checkerboardSize == 0) {
      return;
    }

    model.drawCheckerBoard(checkerboardSize);
    this.checkerboardCount++;


    BufferedImage bufferedCheckerboard;
    // If this is the first checkerboard, the name of it is "checkerboard"
    if (this.checkerboardCount == 1) {
      bufferedCheckerboard = this.model.getImage("checkerboard");
      view.displayImage(bufferedCheckerboard);
      this.currentImage = "checkerboard";
      this.undoStack.push(currentImage);
      this.view.toggleAdjustments(true);
    }

    // If this isn't the first checkerboard, the name is "checkerboard" with a number appended
    else {
      bufferedCheckerboard = this.model.getImage("checkerboard-" + (checkerboardCount - 1));
      view.displayImage(bufferedCheckerboard);
      this.currentImage = "checkerboard-" + (checkerboardCount - 1);
      this.undoStack.push(currentImage);
      this.view.toggleAdjustments(true);

    }

  }

}
