package imageprocessing;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class is a driver for the imageprocessing package.
 */
public class ProgramRunner {

  /**
   * Main method of a driver. Imports images, manipulates them and outputs the result. Also
   * generates images such as rainbows and flags.
   */
  public static void main(String[] args) throws IOException {
    IModel model = new ModelImpl();
    FileReader in = new FileReader(args[0]);
    IController controller = new ControllerImpl(model, in);
//    controller.go();
    model.drawCheckerBoard(100);
    model.save("checkerboard_1");
    model.applySepia("checkerboard_1");
    model.save("checkerboard_1-sepia");

  }
}
