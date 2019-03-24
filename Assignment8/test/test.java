import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import imageProcessing.*;

public class test {

  @Test
  public void testImageReading() throws IOException {
    ImageUtil shadow = new ImageUtil();
    int[][][] result = shadow.readImage("./images/shadow.jpg");

    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        for (int k = 0; k < result[i][j].length; k++) {
          System.out.println(result[i][j][k]);
        }
      }
    }
  }
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
//  @Test
//  public void trivialTest() throws IOException {
//    double[][] blurKernel =  { {1.0/2.0, 1.0/2.0, 1.0/2.0}, {1.0/2.0, 1.0/2.0, 1.0/2.0},
//            {1.0/2.0, 1.0/2.0, 1.0/2.0} };
//    Filter blur = new Filter(blurKernel);
//
//    int[][][] testImageData = { {{10,10,10}, {20,20,20}, {30,30,30}},
//            {{40,40,40}, {50,50,50}, {60,60,60}},
//            {{70,70,70}, {80,80,80}, {90,90,90}}};
//
//    Image testImage = new Image(testImageData);
//
//    System.out.println(testImage.toString());
//    System.out.println("\n\n" + testImage.applyFilter(blur));
//
//    ImageUtil shadow = new ImageUtil();
//    int[][][] result = shadow.readImage("./images/shadow.jpg");
//    Image testImageShadow = new Image(result);
//
//
//    System.out.println(testImageShadow.toString());
//
//
//  }
}
