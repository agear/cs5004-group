package imageprocessing.controller;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import imageprocessing.model.IModel;


public class ControllerImpl implements IController {
  final Readable in;
  //  final Appendable out;
  IModel model;
  // IView view;

  public ControllerImpl(IModel model, Readable in) {
    this.in = in;
//    this.out = out;
    this.model = model;
  }

  //TODO Add more functionality
  public void go() throws IOException {
    Objects.requireNonNull(model);
    String command;
    String filename;
    String imageName = "";

    Scanner scan = new Scanner(this.in);
    while (scan.hasNext()) {
      command = scan.next();
      switch (command) {
        case "load":
          filename = scan.next();
          imageName = scan.next();
          this.model.load(filename, imageName);
          System.out.println("Loading " + filename + " as " + imageName + "...");
          break;
        case "dither":
          this.model.applyDither(imageName);
          System.out.println("Dithering " + imageName + "...");
          break;
        case "blur":
          this.model.applyBlur(imageName);
          System.out.println("Applying blur to " + imageName + "...");
          break;
        case "sepia":
          this.model.applySepia(imageName);
          System.out.println("Applying sepia transformation to " + imageName + "...");
          break;
        case "greyscale":
          this.model.applyGreyscale(imageName);
          System.out.println("Applying greyscale transformation to " + imageName + "...");
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
