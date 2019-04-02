package imageprocessing;

import java.io.IOException;

public class Driver {

  public Driver() {
  }

  public void main() throws IOException {
    //Import image to manipulate.
    Image myImage1 = new Image("./res/shadowresize.jpg");
    Image myImage2 = new Image("./res/santaferesized.jpg");

    //Apply filters
    Filter blur = new Filter(Filters.BLUR);
    Image myBlurredImage = blur.apply(myImage1);
    myBlurredImage.writeImageToFile("shadow_blurry.png");

    Filter sharpen = new Filter(Filters.SHARPEN);
    Image mySharpenedImage = sharpen.apply(myImage1);
    mySharpenedImage.writeImageToFile("shadow_sharpen.png");

    //Apply transformations
    Transformation sepia = new Transformation(Transformations.SEPIA);
    Image mySepiaImage = sepia.apply(myImage1);
    mySepiaImage.writeImageToFile("shadow_sepia.png");

    Transformation greyscale = new Transformation(Transformations.GREYSCALE);
    Image myGreyscale = greyscale.apply(myImage1);
    myGreyscale.writeImageToFile("shadow_greyscale.png");

    //Apply filters
    Image myBlurredImage2 = blur.apply(myImage2);
    myBlurredImage2.writeImageToFile("santafe_blurry.png");

    Image mySharpenedImage2 = sharpen.apply(myImage2);
    mySharpenedImage2.writeImageToFile("santafe_sharpen.png");

    //Apply transformations
    Image mySepiaImage2 = sepia.apply(myImage2);
    mySepiaImage2.writeImageToFile("santafe_sepia.png");

    Image myGreyscale2 = greyscale.apply(myImage2);
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
    verticalRainbow.writeToFile("RainbowVertical.png");

    Rainbow horizontalRainbow = new Rainbow(300, 500, Orientation.HORIZONTAL);
    horizontalRainbow.writeToFile("RainbowHorizontal.png");

    //Draw Checkerboard
    CheckerBoard testChecker = new CheckerBoard(15);
    testChecker.writeToFile("CheckerBoard.png");
  }
}
