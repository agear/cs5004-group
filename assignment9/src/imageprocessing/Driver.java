package imageprocessing;

import java.io.IOException;

/**
 * This class is a driver for the imageprocessing package.
 */
public class Driver {

  /**
   * Construct a driver object.
   */
  public Driver() {
    //Driver is only used to run the main method.
  }

  /**
   * Main method of a driver. Imports images, manipulates them and outputs the result. Also
   * generates images such as rainbows and flags.
   */
  public boolean main() throws IOException {
    //Import image to manipulate.
    IImage myImage1 = new Image("./res/shadowresize.jpg");
    IImage myImage2 = new Image("./res/santaferesized.jpg");

    //Apply filters
    Filter blur = new Filter(Filters.BLUR);
    IImage myBlurredImage = blur.apply(myImage1);
    myBlurredImage.writeImageToFile("shadow_blurry.png");

    Filter sharpen = new Filter(Filters.SHARPEN);
    IImage mySharpenedImage = sharpen.apply(myImage1);
    mySharpenedImage.writeImageToFile("shadow_sharpen.png");

    //Apply transformations
    Transformation sepia = new Transformation(Transformations.SEPIA);
    IImage mySepiaImage = sepia.apply(myImage1);
    mySepiaImage.writeImageToFile("shadow_sepia.png");

    Transformation greyscale = new Transformation(Transformations.GREYSCALE);
    IImage myGreyscale = greyscale.apply(myImage1);
    myGreyscale.writeImageToFile("shadow_greyscale.png");

    //Apply filters
    IImage myBlurredImage2 = blur.apply(myImage2);
    myBlurredImage2.writeImageToFile("santafe_blurry.png");

    IImage mySharpenedImage2 = sharpen.apply(myImage2);
    mySharpenedImage2.writeImageToFile("santafe_sharpen.png");

    //Apply transformations
    IImage mySepiaImage2 = sepia.apply(myImage2);
    mySepiaImage2.writeImageToFile("santafe_sepia.png");

    IImage myGreyscale2 = greyscale.apply(myImage2);
    myGreyscale2.writeImageToFile("santafe_greyscale.png");

    //Draw Flags
    Flag greekFlag = new Flag(908, Country.GREECE);
    greekFlag.writeImageToFile("FlagGreek.png");

    Flag swissFlag = new Flag(777, Country.SWITZERLAND);
    swissFlag.writeImageToFile("FlagSwiss.png");

    Flag frenchFlag = new Flag(800, Country.FRANCE);
    frenchFlag.writeImageToFile("FlagFrench.png");

    //Draw Rainbows
    Rainbow verticalRainbow = new Rainbow(300, 500, Orientation.VERTICAL);
    verticalRainbow.writeImageToFile("RainbowVertical.png");

    Rainbow horizontalRainbow = new Rainbow(300, 500, Orientation.HORIZONTAL);
    horizontalRainbow.writeImageToFile("RainbowHorizontal.png");

    //Draw Checkerboard
    CheckerBoard testChecker = new CheckerBoard(15);
    testChecker.writeImageToFile("CheckerBoard.png");
    return true;
  }
}
