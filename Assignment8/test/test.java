import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import imageProcessing.*;

public class test {

//  @Test
//  public void testImageReading() throws IOException {
//    ImageUtil shadow = new ImageUtil();
//    int[][][] result = shadow.readImage("./images/shadow.jpg");
//
//    for (int i = 0; i < result.length; i++) {
//      for (int j = 0; j < result[i].length; j++) {
//        for (int k = 0; k < result[i][j].length; k++) {
//          System.out.println(result[i][j][k]);
//        }
//      }
//    }
//  }
//
//    double[][] blurKernel =  { {1.0/16.0, 1.0/8.0, 1.0/16.0}, {1.0/8.0, 1.0/4.0, 1.0/18.0},
//            {1.0/16.0, 1.0/8.0, 1.0/16.0} };
//    Filter blur = new Filter(blurKernel);
//
//
//  }
//
//
//
  @Test
  public void trivialTest() throws IOException {
//    double[][] blurKernel =  { {1.0/2.0, 1.0/2.0, 1.0/2.0}, {1.0/2.0, 1.0/2.0, 1.0/2.0},
//            {1.0/2.0, 1.0/2.0, 1.0/2.0} };
//    Filter blur = new Filter(blurKernel);
//
//    int[][][] testImageData = { {{10,10,10}, {20,20,20}, {30,30,30}},
//            {{40,40,40}, {50,50,50}, {60,60,60}},
//            {{70,70,70}, {80,80,80}, {90,90,90}}};
//
////    Image testImage = new Image(testImageData);
////
////    System.out.println(testImage.toString());
////    System.out.println("\n\n" + testImage.applyFilter(blur));
//
//
//    double[][] greenKernel =  { {1, 0, 1} };
//    Filter green = new Filter(greenKernel);
//    ImageUtil shadow = new ImageUtil();
//    int[][][] result = shadow.readImage("./images/shadowresize.jpg");
//    Image testImageShadow = new Image(result);
//    Image testImageShadowNotGreen = testImageShadow.applyFilter(green);
//
//    System.out.println(testImageShadowNotGreen.toString());
//
//    // Create an image from result:
//    ImageUtil imageUtilObject = new ImageUtil();
//
//
//    imageUtilObject.writeImage(testImageShadowNotGreen.get3Ddata(),
//            shadow.getWidth("./images/shadowresize.jpg"),
//            shadow.getHeight("./images/shadowresize.jpg"),
//            "makeShadowGreen.jpg");
//
//
//

      double[][] testFilterKernel =  { {2.0, 1.0, 2.0}, {-1.0, 0.0, 2.0},
            {1.0, 1.0, 1.0} };
      Filter testFilter = new Filter(testFilterKernel);


      int[][][] testImageData = { {{1,1,1}, {6,6,6}, {4,4,4}, {5,5,5}},
            {{8,8,8}, {7,7,7}, {9,9,9}, {0,0,0}},
            {{43,43,43}, {54,54,54}, {36,36,36}, {76,76,76}},
            {{65,65,65}, {43,43,43}, {123,123,123}, {32,32,32}}};
      Image testImage = new Image(testImageData);


      ImageUtil shadow = new ImageUtil();
      int[][][] result = shadow.readImage("./images/shadow.jpg");
      Image testImageShadow = new Image(result);

      double[][] blurKernel =  { {1.0/16.0, 1.0/8.0, 1.0/16.0}, {1.0/8.0, 1.0/4.0, 1.0/18.0},
            {1.0/16.0, 1.0/8.0, 1.0/16.0} };
      Filter blur = new Filter(blurKernel);
      testImageShadow = testImageShadow.applyFilter(blur);
      testImageShadow = testImageShadow.applyFilter(blur);
      testImageShadow = testImageShadow.applyFilter(blur);
      testImageShadow = testImageShadow.applyFilter(blur);


    ImageUtil imageUtilObject = new ImageUtil();
    imageUtilObject.writeImage(testImageShadow.get3Ddata(),
            shadow.getWidth("./images/shadow.jpg"),
            shadow.getHeight("./images/shadow.jpg"),
            "makeBigShadowBlurry.jpg");



      double[][] sharpenKernel =  { {-1.0/8.0, -1.0/8.0,  -1.0/8.0, -1.0/8.0, -1.0/8.0},
              {-1.0/8.0, 1.0/4.0, 1.0/4.0, 1.0/4.0, -1.0/8.0},
              {-1.0/8.0, 1.0/4.0, 1.0, 1.0/4.0, -1.0/8.0},
              {-1.0/8.0, 1.0/4.0, 1.0/4.0, 1.0/4.0, -1.0/8.0},
              {-1.0/8.0, -1.0/8.0,  -1.0/8.0, -1.0/8.0, -1.0/8.0} };
      Filter sharpen = new Filter(sharpenKernel);
      testImageShadow = testImageShadow.applyFilter(sharpen);
      imageUtilObject.writeImage(testImageShadow.get3Ddata(),
              shadow.getWidth("./images/shadow.jpg"),
              shadow.getHeight("./images/shadow.jpg"),
              "makeBigShadowSharp.jpg");


  }


  @Test
  public void testManhattan() throws IOException {
      ImageUtil manhattan = new ImageUtil();
      int[][][] result = manhattan.readImage("./images/manhattan-small.png");
      Image testImage = new Image(result);

      double[][] sharpenKernel =  { {-1.0/8.0, -1.0/8.0, -1.0/8.0, -1.0/8.0, -1.0/8.0},
                                    {-1.0/8.0, 1.0/4.0, 1.0/4.0, 1.0/4.0, -1.0/8.0},
                                    {-1.0/8.0, 1.0/4.0, 1.0, 1.0/4.0, -1.0/8.0},
                                    {-1.0/8.0, 1.0/4.0, 1.0/4.0, 1.0/4.0, -1.0/8.0},
                                    {-1.0/8.0, -1.0/8.0,  -1.0/8.0, -1.0/8.0, -1.0/8.0} };
      Filter sharpen = new Filter(sharpenKernel);
      testImage = testImage.applyFilter(sharpen);
      manhattan.writeImage(testImage.get3Ddata(),
              manhattan.getWidth("./images/manhattan-small.png"),
              manhattan.getHeight("./images/manhattan-small.png"),
              "makeManhattanSharp.png");
  }




}
