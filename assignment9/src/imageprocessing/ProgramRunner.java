package imageprocessing;

import java.io.IOException;

/**
 * This class is a driver for the imageprocessing package.
 */
public class ProgramRunner {

  /**
   * Main method of a driver. Imports images, manipulates them and outputs the result. Also
   * generates images such as rainbows and flags.
   */
  public static void main() throws IOException {
    IModel model = new ModelImpl();

    model.drawFlag(500, Country.GREECE);
    model.applyBlur("flag_1");
    model.applyBlur("flag_1-blur");
    model.applyBlur("flag_1-blur-blur");
    model.applyBlur("flag_1-blur-blur-blur");
    model.applyDither("flag_1-blur-blur-blur");
    model.save("flag_1");
    model.save("flag_1-blur");
    model.save("flag_1-blur-blur");
    model.save("flag_1-blur-blur-blur");
    model.save("flag_1-blur-blur-blur-dither");


//    //Import image to manipulate.
//    model.load("./res/shadowresize.jpg", "shadow");
//    model.load("./res/santaferesized.jpg", "santafe");
//
//    //Apply filters
//    model.applyBlur("shadow");
//    model.save("shadow-blur");
//
//    model.applySharpen("shadow");
//    model.save("shadow-sharp");
//
//    //Apply transformations
//    model.applySepia("shadow");
//    model.save("shadow-sepia");
//
//    model.applyGreyscale("shadow");
//    model.save("shadow-greyscale");
//
//    //Apply filters
//    model.applyBlur("santafe");
//    model.save("santafe-blur");
//
//    model.applySharpen("santafe");
//    model.save("santafe-sharp");
//
//    //Apply transformations
//    model.applySepia("santafe");
//    model.save("santafe-sepia");
//
//    model.applyGreyscale("santafe");
//    model.save("santafe-greyscale");
//
//    //Draw Flags
//    model.drawFlag(908,Country.GREECE);
//    model.save("flag_1");
//
//    model.drawFlag(777,Country.SWITZERLAND);
//    model.save("flag_2");
//
//    model.drawFlag(800, Country.FRANCE);
//    model.save("flag_3");
//
//    //Draw Rainbows
//    model.drawRainbow(300, 500, Orientation.VERTICAL);
//    model.save("rainbow_1");
//
//    model.drawRainbow(300,500,Orientation.HORIZONTAL);
//    model.save("rainbow_2");
//
//    //Draw
//    model.drawCheckerBoard(100);
//    model.save("checkerboard_1");
  }
}
