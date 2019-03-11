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
    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(400);
    plotter.setHeight(400);

    Data data = new Data();
    plotter.setDimensions(-300, 300, -350, 350);
//    for (int x = -200; x < 200; x += 20) {
//      for (int y = 0; y <= x; y += 20) {
//        plotter.addCircle(x, y, 10);
//        plotter.addPoint(x, y);
//        plotter.addLine(x, y, x + 20, y);
//        plotter.addLine(x, y, x, y + 20);
//      }
//    }

    // Creating a line and data

    plotter.addPoint(1, 5);
    plotter.addPoint(2, 10);
    plotter.addPoint(3, 15);
    plotter.addPoint(4, 25);
    plotter.addPoint(5, 40);
    data.addPoint(1, 5);
    data.addPoint(2, 10);
    data.addPoint(3, 15);
    data.addPoint(4, 25);
    data.addPoint(5, 40);
    Line fit = data.fitLine();
    plotter.addLine(-300, (int) Math.round(fit.solveLine(-300)), 300, (int) Math.round(fit.solveLine(300)));


    try {
      plotter.write("example.png");
    } catch (IOException e) { }






    ImagePlotter plotter2 = new ImagePlotter();
    plotter2.setWidth(600);
    plotter2.setHeight(600);
    plotter2.setDimensions(-300, 300, -300, 300);



    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/clusterdata-2.txt");

      // For each point in the data, add it to the image
      for (Point p : testData.getData() ){

        int x = (int)Math.round(p.getX());
        int y = (int)Math.round(p.getX());
        plotter2.addPoint(x,y);

      }
      plotter2.addPoint(0,0);

    }
    catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter2.write("example2.png");
    } catch (IOException e) { }


  }
}

