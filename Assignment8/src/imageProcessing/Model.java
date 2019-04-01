package imageProcessing;

import java.io.IOException;

public class Model {

  public Model() {
  }

  public void main() throws IOException {
    //TODO Add another picture
    //Import image to manipulate.
    Image myImage1 = new Image("./images/shadowresize.jpg");
    Image myImage2 = new Image("./images/santafe.JPG");

    //Apply filters
    Filter blur = new Filter(Filters.BLUR);
    Image myBlurredImage = blur.apply(myImage1);
    myBlurredImage.writeImageToFile("blurry.png");

    Filter sharpen = new Filter(Filters.SHARPEN);
    Image mySharpenedImage = sharpen.apply(myImage1);
    mySharpenedImage.writeImageToFile("sharpen.png");

    //Apply transformations
    Transformation sepia = new Transformation(Transformations.SEPIA);
    Image mySepiaImage = sepia.apply(myImage1);
    mySepiaImage.writeImageToFile("sepia.png");

    Transformation greyscale = new Transformation(Transformations.GREYSCALE);
    Image myGreyscale = greyscale.apply(myImage1);
    myGreyscale.writeImageToFile("greyscale.png");

    //Apply filters
    Image myBlurredImage2 = blur.apply(myImage2);
    myBlurredImage2.writeImageToFile("blurry2.png");

    Image mySharpenedImage2 = sharpen.apply(myImage2);
    mySharpenedImage2.writeImageToFile("sharpen2.png");

    //Apply transformations
    Image mySepiaImage2 = sepia.apply(myImage2);
    mySepiaImage2.writeImageToFile("sepia2.png");

    Image myGreyscale2 = greyscale.apply(myImage2);
    myGreyscale2.writeImageToFile("greyscale2.png");

    //Draw Flags
    Flag greekFlag = new Flag(908, Country.GREECE);
    greekFlag.writeFlagToFile("GreekFlag.png");

    Flag swissFlag = new Flag(777, Country.SWITZERLAND);
    swissFlag.writeFlagToFile("SwissFlag.png");

    Flag frenchFlag = new Flag(800, Country.FRANCE);
    frenchFlag.writeFlagToFile("FrenchFlag.png");

    //Draw Rainbows
    Rainbow verticalRainbow = new Rainbow(300, 500, Orientation.VERTICAL);
    verticalRainbow.writeToFile("VerticalRainbow.png");

    Rainbow horizontalRainbow = new Rainbow(300, 500, Orientation.HORIZONTAL);
    horizontalRainbow.writeToFile("HorizontalRainbow.png");

    //Draw Checkerboard
    CheckerBoard testChecker = new CheckerBoard(15);
    testChecker.writeToFile("CheckerBoard.png");
  }
}
