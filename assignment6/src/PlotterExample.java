/**
 * Created by ashesh on 2/19/2017.
 */

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by ashesh on 2/16/2017.
 */
public class PlotterExample {
// TODO 5. Use the provided ImagePlotter.java to plot your results! Look at the provided
//  PlotterExample.java to see an example of how to use the ImagePlotter class.
//  You can visualize the clusters by giving all points in a cluster the same color.


  public static void main(String[] args) {

    clusterData2();

  }

  private static void clusterData2(){


    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(600);
    plotter.setHeight(600);
    plotter.setDimensions(-100, 500, -420, 180);


    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/clusterdata-2.txt");

      // For each point in the data, add it to the image
      for (Point p : testData.getData() ){

        int x = (int)Math.round(p.getX());
        int y = (int)Math.round(p.getY());
        plotter.addPoint(x,y);

      }
      plotter.addPoint(0,0);

    }
    catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter.write("clusterdata-2.png");
    } catch (IOException e) { }

  }



}

