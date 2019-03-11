/**
 * Created by ashesh on 2/19/2017.
 */

import java.io.IOException;

/**
 * Created by ashesh on 2/16/2017.
 */
public class PlotterExample {
// TODO 5. Use the provided ImagePlotter.java to plot your results! Look at the provided
//  PlotterExample.java to see an example of how to use the ImagePlotter class.
//  You can visualize the clusters by giving all points in a cluster the same color.

  // TODO 6. Modify the main method so that it reads the data from one of the provided files
  //  instead of hardcoding it. Look at the format of the provided files by opening them in a
  //  text editor. It just contains x and y coordinates. Note that it does not contain the number of
  //  points it has. You can use a Scanner object to read from a file. To connect a Scanner object
  //  to a file, use Scanner sc = new Scanner(new FileInputStream("file path")); replacing the file
  //  path with the path to one of the data files. If you put the file directly within your IntelliJ
  //  project folder you can refer to it only by its file name (the path names are relative to your
  //  IntelliJ project folder. Read the data points, use line fitting or k-means clustering (as the
  //  file name hints) and plot the results! For the provided files, “clusterdata-x.txt” means you
  //  should find x clusters for the data in it.

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
    } catch (IOException e) {

    }


  }
}

