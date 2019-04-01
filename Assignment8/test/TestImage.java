import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import imageprocessing.Model;


/**
 * Tests for the image processing class.
 */
public class TestImage {

//  @TestImage
//  public void testImageReading() throws IOException {
////    ImageUtil shadow = new ImageUtil();
////    int[][][] result = shadow.readImage("./images/shadow.jpg");
////
////    for (int i = 0; i < result.length; i++) {
////      for (int j = 0; j < result[i].length; j++) {
////        for (int k = 0; k < result[i][j].length; k++) {
////          System.out.println(result[i][j][k]);
////        }
////      }
////    }
////  }
////
////    double[][] blurKernel =  { {1.0/16.0, 1.0/8.0, 1.0/16.0}, {1.0/8.0, 1.0/4.0, 1.0/18.0},
////            {1.0/16.0, 1.0/8.0, 1.0/16.0} };
////    Filter blur = new Filter(blurKernel);
////
////
////  }
////
////
////
////  @TestImage
////  public void trivialTest() throws IOException {
////    double[][] blurKernel =  { {1.0/2.0, 1.0/2.0, 1.0/2.0}, {1.0/2.0, 1.0/2.0, 1.0/2.0},
////            {1.0/2.0, 1.0/2.0, 1.0/2.0} };
////    Filter blur = new Filter(blurKernel);
////
////    int[][][] testImageData = { {{10,10,10}, {20,20,20}, {30,30,30}},
////            {{40,40,40}, {50,50,50}, {60,60,60}},
////            {{70,70,70}, {80,80,80}, {90,90,90}}};
////
//////    Image testImage = new Image(testImageData);
//////
//////    System.out.println(testImage.toString());
//////    System.out.println("\n\n" + testImage.applyFilter(blur));
////
////
////    double[][] greenKernel =  { {1, 0, 1} };
////    Filter green = new Filter(greenKernel);
////    ImageUtil shadow = new ImageUtil();
////    int[][][] result = shadow.readImage("./images/shadowresize.jpg");
////    Image testImageShadow = new Image(result);
////    Image testImageShadowNotGreen = testImageShadow.applyFilter(green);
////
////    System.out.println(testImageShadowNotGreen.toString());
////
////    // Create an image from result:
////    ImageUtil imageUtilObject = new ImageUtil();
////
////
////    imageUtilObject.writeImage(testImageShadowNotGreen.get3Ddata(),
////            shadow.getWidth("./images/shadowresize.jpg"),
////            shadow.getHeight("./images/shadowresize.jpg"),
////            "makeShadowGreen.jpg");
////
////
////
//
//  //TODO commented out to speed up:
////      double[][] testFilterKernel =  { {2.0, 1.0, 2.0}, {-1.0, 0.0, 2.0},
////            {1.0, 1.0, 1.0} };
////      Filter testFilter = new Filter(testFilterKernel);
////
////
////      int[][][] testImageData = { {{1,1,1}, {6,6,6}, {4,4,4}, {5,5,5}},
////            {{8,8,8}, {7,7,7}, {9,9,9}, {0,0,0}},
////            {{43,43,43}, {54,54,54}, {36,36,36}, {76,76,76}},
////            {{65,65,65}, {43,43,43}, {123,123,123}, {32,32,32}}};
////      Image testImage = new Image(testImageData);
////
////
////      ImageUtil shadow = new ImageUtil();
////      int[][][] result = shadow.readImage("./images/shadow.jpg");
////      Image testImageShadow = new Image(result);
////
////      double[][] blurKernel =  { {1.0/16.0, 1.0/8.0, 1.0/16.0}, {1.0/8.0, 1.0/4.0, 1.0/18.0},
////            {1.0/16.0, 1.0/8.0, 1.0/16.0} };
////      Filter blur = new Filter(blurKernel);
////      testImageShadow = testImageShadow.applyFilter(blur);
////      testImageShadow = testImageShadow.applyFilter(blur);
////      testImageShadow = testImageShadow.applyFilter(blur);
////      testImageShadow = testImageShadow.applyFilter(blur);
////
////
////    ImageUtil imageUtilObject = new ImageUtil();
////    imageUtilObject.writeImage(testImageShadow.get3Ddata(),
////            shadow.getWidth("./images/shadow.jpg"),
////            shadow.getHeight("./images/shadow.jpg"),
////            "makeBigShadowBlurry.jpg");
////
////
////
////      double[][] sharpenKernel =  { {-1.0/8.0, -1.0/8.0,  -1.0/8.0, -1.0/8.0, -1.0/8.0},
////              {-1.0/8.0, 1.0/4.0, 1.0/4.0, 1.0/4.0, -1.0/8.0},
////              {-1.0/8.0, 1.0/4.0, 1.0, 1.0/4.0, -1.0/8.0},
////              {-1.0/8.0, 1.0/4.0, 1.0/4.0, 1.0/4.0, -1.0/8.0},
////              {-1.0/8.0, -1.0/8.0,  -1.0/8.0, -1.0/8.0, -1.0/8.0} };
////      Filter sharpen = new Filter(sharpenKernel);
////      testImageShadow = testImageShadow.applyFilter(sharpen);
////      imageUtilObject.writeImage(testImageShadow.get3Ddata(),
////              shadow.getWidth("./images/shadow.jpg"),
////              shadow.getHeight("./images/shadow.jpg"),
////              "makeBigShadowSharp.jpg");
////
////
////  }
//////
//
//  @TestImage
//  public void testManhattan() throws IOException {
//    ImageUtil manhattan = new ImageUtil();
//    int[][][] result = manhattan.readImage("./images/manhattan-small.png");
//    Image testImage = new Image(result);
//
//    double[][] sharpenKernel = {{-1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0},
//            {-1.0 / 8.0, 1.0 / 4.0, 1.0 / 4.0, 1.0 / 4.0, -1.0 / 8.0},
//            {-1.0 / 8.0, 1.0 / 4.0, 1.0, 1.0 / 4.0, -1.0 / 8.0},
//            {-1.0 / 8.0, 1.0 / 4.0, 1.0 / 4.0, 1.0 / 4.0, -1.0 / 8.0},
//            {-1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0}};
//    Filter sharpen = new Filter(sharpenKernel);
//    testImage = testImage.applyFilter(sharpen);
////      manhattan.writeImage(testImage.get3Ddata(),
////              manhattan.getWidth("./images/manhattan-small.png"),
////              manhattan.getHeight("./images/manhattan-small.png"),
////              "makeManhattanSharp.png");
//  }
//
//
////  @TestImage
////  public void testSepia() throws IOException {
////    ImageUtil manhattan = new ImageUtil();
////    int[][][] result = manhattan.readImage("./images/manhattan-small.png");
////    Image testImage = new Image(result);
////
////    double[][] sepiaMatrix =  { {0.393, 0.769, 0.189},
////            {0.349, 0.686, 0.168},
////            {0.272, 0.534, 0.131} };
////    Transformation sepia = new Transformation(sepiaMatrix);
////    testImage = testImage.Transform(sepia);
////    manhattan.writeImage(testImage.get3Ddata(),
////            manhattan.getWidth("./images/manhattan-small.png"),
////            manhattan.getHeight("./images/manhattan-small.png"),
////            "makeManhattanSepia.png");
////  }
////
//  @TestImage
//  public void testGreyScale() throws IOException {
//    ImageUtil manhattan = new ImageUtil();
//    int[][][] result = manhattan.readImage("./images/manhattan-small.png");
//    Image testImage = new Image(result);
//
//    double[][] grayscaleMatrix =  { {0.2126, 0.7152, 0.0722},
//            {0.2126, 0.7152, 0.0722},
//            {0.2126, 0.7152, 0.0722} };
//    Transformation greyscale = new Transformation(grayscaleMatrix);
//    testImage = testImage.Transform(greyscale);
//    manhattan.writeImage(testImage.get3Ddata(),
//            manhattan.getWidth("./images/manhattan-small.png"),
//            manhattan.getHeight("./images/manhattan-small.png"),
//            "makeManhattanGreyscale.png");
//  }
//  //TODO Uncomment above. and below
//
////  @TestImage
////  public void testHorizontalStripes() throws IOException {
////    Image testImage = new Image(500,500);
////    int[][][] newTestImageAllWhite = testImage.createWhiteImage(500,350);
////
////    testImage.writeImage(newTestImageAllWhite, 500, 350,
////            "rainbow.png");
////    testImage = testImage.horizontalStripes();
////
////    testImage.writeImage(testImage.get3Ddata(), 500, 350,
////            "rainbow.png");
////  }
//
//
////  @TestImage
////  public void testVerticalStripes() throws IOException {
////    Image testImage = new Image(500, 350);
////    int[][][] newTestImageAllWhite = testImage.createWhiteImage(500, 350);
////
////    testImage.writeImage(newTestImageAllWhite, 500, 350,
////            "rainbowv.png");
////    testImage = testImage.verticalStripes();
////
////    testImage.writeImage(testImage.get3Ddata(), 500, 350,
////            "rainbowv.png");
////  }
//
////  @TestImage
////  public void testGreece() throws IOException {
////    Image testImage = new Image(700, 700);
////    int[][][] newTestImageAllWhite = testImage.createWhiteImage(500, 450);
////
////    testImage.writeImage(newTestImageAllWhite, 500, 450,
////            "greece.png");
////    testImage = testImage.greece();
////
////    testImage.writeImage(testImage.get3Ddata(), 500, 450,
////            "greece.png");
////  }
////  @TestImage
////  public void testFilterArchitecture() throws IOException {
////    Filter blur = new Filter("blur");
////    Image shadowOriginal = new Image("./images/shadowresize.jpg");
////    Image shadowFiltered = blur.apply(shadowOriginal);
////    shadowFiltered = blur.apply(shadowFiltered);
////    shadowFiltered.writeImageToFile("./images/shadowResizeBlurred.jpg");
////  }
//
////  @TestImage
////  public void testGreece() throws IOException {
////    Image testImage = new Image(700,700);
////    int[][][] newTestImageAllWhite = testImage.createWhiteImage(500,450);
////
////    testImage.writeImage(newTestImageAllWhite, 500, 450,
////            "greece.png");
////    testImage = testImage.greece();
////
////    testImage.writeImage(testImage.get3Ddata(), 500, 450,
////            "greece.png");
////  }
////
////
////
////  @TestImage
////  public void testFilterArchitecture() throws IOException {
////    Adjustment blur = new Filter("blur");
////    Image shadowOriginal = new Image("./images/manhattan-small.png");
////    Image shadowFiltered = blur.apply(shadowOriginal);
////    shadowFiltered.writeImageToFile("./images/manhattan-blurry.jpg");
////  }
//
//
////  @TestImage
////  public void testCheckerboard() throws IOException {
////    CheckerBoard testChecker = new CheckerBoard(100);
////    testChecker.writeImage(testChecker.get3Ddata(), testChecker.getWidth(),
// testChecker.getHeight(), "testChecker2.png");
////
////  }
////
////  @TestImage
////  public void testCheckerboardSmall() throws IOException {
////    CheckerBoard testChecker = new CheckerBoard(5);
////    testChecker.writeImage(testChecker.get3Ddata(), testChecker.getWidth(),
// testChecker.getHeight(), "testCheckerSmall.png");
////
////  }
//
//  @TestImage
//  public void testRainbowHorizontal() throws IOException {
//    Rainbow testRainbow1 = new Rainbow(140, 140, "Horizontal");
//    testRainbow1.writeToFile("HorizontalRainbow.png");
//
//
//    testRainbow1.writeImage(testRainbow1.get3Ddata(), testRainbow1.getWidth(),
//    testRainbow1.getHeight(), "testRainbowHorizontal1.png");
//    Rainbow testRainbow2 = new Rainbow(140, 70, "Horizontal");
//    testRainbow2.writeImage(testRainbow2.get3Ddata(), testRainbow2.getWidth(),
//    testRainbow2.getHeight(), "testRainbowHorizontal2.png");
//    Rainbow testRainbow3 = new Rainbow(70, 140, "Horizontal");
//    testRainbow3.writeImage(testRainbow3.get3Ddata(), testRainbow3.getWidth(),
//    testRainbow3.getHeight(), "testRainbowHorizontal3.png");
//    Rainbow testRainbow4 = new Rainbow(100, 100, "Horizontal");
//    testRainbow4.writeImage(testRainbow4.get3Ddata(), testRainbow4.getWidth(),
//    testRainbow4.getHeight(), "testRainbowHorizontal4.png");
//  }
//
//  @TestImage
//  public void testRainbowHorizontalNonDiv() throws IOException {
//    Rainbow testRainbow1 = new Rainbow(704, 696, "Horizontal");
//    testRainbow1.writeImage(testRainbow1.get3Ddata(), testRainbow1.getWidth(),
//    testRainbow1.getHeight(), "testNonDivRainbowHorizontal1.png");
//    Rainbow testRainbow2 = new Rainbow(701, 699, "Horizontal");
//    testRainbow2.writeImage(testRainbow2.get3Ddata(), testRainbow2.getWidth(),
//    testRainbow2.getHeight(), "testNonDivRainbowHorizontal2.png");
//    Rainbow testRainbow3 = new Rainbow(702, 698, "Horizontal");
//    testRainbow3.writeImage(testRainbow3.get3Ddata(), testRainbow3.getWidth(),
//    testRainbow3.getHeight(), "testNonDivRainbowHorizontal3.png");
//    Rainbow testRainbow4 = new Rainbow(703, 697, "Horizontal");
//    testRainbow4.writeImage(testRainbow4.get3Ddata(), testRainbow4.getWidth(),
//    testRainbow4.getHeight(), "testNonDivRainbowHorizontal4.png");
//  }
//
//  @TestImage
//  public void testRainbowVertical() throws IOException {
//    Rainbow testRainbow1 = new Rainbow(140, 140, "Vertical");
//    testRainbow1.writeImage(testRainbow1.get3Ddata(), testRainbow1.getWidth(),
//    testRainbow1.getHeight(), "testRainbowVertical1.png");
//    Rainbow testRainbow2 = new Rainbow(140, 70, "Vertical");
//    testRainbow2.writeImage(testRainbow2.get3Ddata(), testRainbow2.getWidth(),
//    testRainbow2.getHeight(), "testRainbowVertical2.png");
//    Rainbow testRainbow3 = new Rainbow(70, 140, "Vertical");
//    testRainbow3.writeImage(testRainbow3.get3Ddata(), testRainbow3.getWidth(),
//    testRainbow3.getHeight(), "testRainbowVertical3.png");
//    Rainbow testRainbow4 = new Rainbow(500, 500, "Vertical");
//    testRainbow4.writeImage(testRainbow4.get3Ddata(), testRainbow4.getWidth(),
//    testRainbow4.getHeight(), "testRainbowVertical4.png");
//  }
//
//  @TestImage
//  public void testRainbowVerticalNonDiv() throws IOException {
//    Rainbow testRainbow1 = new Rainbow(300, 500, "Vertical");
//    testRainbow1.writeImage(testRainbow1.get3Ddata(), testRainbow1.getWidth(),
//    testRainbow1.getHeight(), "testNonDivRainbowVertical1.png");
//    Rainbow testRainbow2 = new Rainbow(305, 495, "Vertical");
//    testRainbow2.writeImage(testRainbow2.get3Ddata(), testRainbow2.getWidth(),
//    testRainbow2.getHeight(), "testNonDivRainbowVertical2.png");
//    Rainbow testRainbow3 = new Rainbow(310, 491, "Vertical");
//    testRainbow3.writeImage(testRainbow3.get3Ddata(), testRainbow3.getWidth(),
//    testRainbow3.getHeight(), "testNonDivRainbowVertical3.png");
//    Rainbow testRainbow4 = new Rainbow(316, 485, "Vertical");
//    testRainbow4.writeImage(testRainbow4.get3Ddata(), testRainbow4.getWidth(),
//    testRainbow4.getHeight(), "testNonDivRainbowVertical4.png");
//  }
//
//  @TestImage
//  public void testFlag() throws IOException {
//    Flag testFlagFrench = new Flag(500, "France");
//    testFlagFrench.writeFlagToFile("testFlagFrench.png");
//    Flag testFlagSwiss = new Flag(500, "Switzerland");
//    testFlagSwiss.writeImage(testFlagSwiss.get3Ddata(), testFlagSwiss.getWidth(),
//    testFlagSwiss.getHeight(), "testFlagSwiss.png");
//    Flag testFlagGreek = new Flag(500, "Greece");
//    testFlagGreek.writeImage(testFlagGreek.get3Ddata(), testFlagGreek.getWidth(),
//    testFlagGreek.getHeight(), "testFlagGreek.png");
//
//  }


//  @TestImage
//  public void readmeblur() throws IOException {
//    Image myImage = new Image("./images/manhattan-small.png");
//
//    //TestImage filters
//    Filter blur = new Filter(Filters.BLUR);
//    Image myBlurredImage = blur.apply(myImage);
//    myBlurredImage.writeImageToFile("manhattan-small-and-shadow_blurry.png");
//
//    Filter sharpen = new Filter(Filters.SHARPEN);
//    Image mySharpenedImage = sharpen.apply(myImage);
//    mySharpenedImage.writeImageToFile("manhattan-small-and-sharper.png");
//
//    //TestImage transformations
//    Transformation sepia = new Transformation(Transformations.SEPIA);
//    Image mySepiaImage = sepia.apply(myImage);
//    mySepiaImage.writeImageToFile("manhattan-small-and-vintage.png");
//
//    Transformation greyscale = new Transformation(Transformations.GREYSCALE);
//    Image myGreyscale = greyscale.apply(myImage);
//    myGreyscale.writeImageToFile("manhattan-small-and-greyscale.png");
//
//    //TestImage Rainbows
//    Rainbow verticalRainbow = new Rainbow(300,500, Orientation.VERTICAL);
//    verticalRainbow.writeToFile("VerticalRainbow.png");
//
//    Rainbow horizontalRainbow = new Rainbow(300,500, Orientation.HORIZONTAL);
//    horizontalRainbow.writeToFile("HorizontalRainbow.png");
//
//    //TestImage Checkerboards
//    CheckerBoard testChecker = new CheckerBoard(15);
//    testChecker.writeToFile("CheckerBoard.png");
//    }

  @Test
  public void mainTest() throws IOException {
    Model testModel = new Model();
    testModel.main();
    assertTrue(true);
  }
}
