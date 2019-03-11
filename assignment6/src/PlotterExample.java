/**
 * Created by ashesh on 2/19/2017.
 */

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by ashesh on 2/16/2017.
 */
public class PlotterExample {

  public static void main(String[] args) {

    // I've commented them all out to save time when calculating
    //clusterData2();
    //clusterData3();
    //clusterData4();
    //clusterData6();
    //lineData1();
    //lineData2();
    lineData3();


  }
  //TODO Repeated code???

  /**
   * Reads linedata-1 from a file, and creates an image of it in the format linedata-1.png.
   */
  private static void lineData1() {


    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(800);
    plotter.setHeight(700);
    plotter.setDimensions(-400, 400, -300, 400);


    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/linedata-1.txt");
      Line line;
      line = testData.fitLine();

      // For each point in the data, add it to the image
      for (Point p : testData.getData()) {

        int x = (int) Math.round(p.getX());
        int y = (int) Math.round(p.getY());
        plotter.addPoint(x, y);
        plotter.addLine(-400, (int) Math.round(line.solveLine(-400)), 400, (int) Math.round(line.solveLine(400)));

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter.write("linedata-1.png");
    } catch (IOException e) {
    }
  }

  /**
   * Reads linedata-2 from a file, and creates an image of it in the format linedata-2.png.
   */
  private static void lineData2() {


    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(800);
    plotter.setHeight(500);
    plotter.setDimensions(-400, 400, -100, 400);


    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/linedata-2.txt");
      Line line;
      line = testData.fitLine();

      // For each point in the data, add it to the image
      for (Point p : testData.getData()) {

        int x = (int) Math.round(p.getX());
        int y = (int) Math.round(p.getY());
        plotter.addPoint(x, y);
        plotter.addLine(-400, (int) Math.round(line.solveLine(-400)), 400, (int) Math.round(line.solveLine(400)));

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter.write("linedata-2.png");
    } catch (IOException e) {
    }
  }

  /**
   * Reads linedata-3 from a file, and creates an image of it in the format linedata-3.png.
   */
  private static void lineData3() {


    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(800);
    plotter.setHeight(200);
    plotter.setDimensions(-400, 400, -0, 200);


    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/linedata-3.txt");
      Line line;
      line = testData.fitLine();

      // For each point in the data, add it to the image
      for (Point p : testData.getData()) {

        int x = (int) Math.round(p.getX());
        int y = (int) Math.round(p.getY());
        plotter.addPoint(x, y);
        plotter.addLine(-400, (int) Math.round(line.solveLine(-400)), 400, (int) Math.round(line.solveLine(400)));

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter.write("linedata-3.png");
    } catch (IOException e) {
    }
  }

  /**
   * Reads clusterdata-2 from a file, and creates an image of it in the format clusterdata-2.png.
   */
  private static void clusterData2() {


    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(600);
    plotter.setHeight(600);
    plotter.setDimensions(-100, 500, -420, 180);


    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/clusterdata-2.txt");
      HashMap<Point, Integer> centroidAssignments;
      centroidAssignments = testData.kmeans(2);

      // For each point in the data, add it to the image
      for (Point p : testData.getData()) {

        Integer centroidNum = centroidAssignments.get(p);
        Color col;
        if (centroidNum == 0) {
          col = Color.RED;
        } else {
          col = Color.GREEN;
        }

        int x = (int) Math.round(p.getX());
        int y = (int) Math.round(p.getY());
        plotter.addPoint(x, y, col);

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter.write("clusterdata-2.png");
    } catch (IOException e) {
    }

  }

  /**
   * Reads clusterdata-3 from a file, and creates an image of it in the format clusterdata-3.png.
   */
  private static void clusterData3() {


    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(600);
    plotter.setHeight(400);
    plotter.setDimensions(0, 600, 0, 400);


    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/clusterdata-3.txt");
      HashMap<Point, Integer> centroidAssignments = testData.kmeans(3);

      // For each point in the data, add it to the image
      for (Point p : testData.getData()) {

        // Find the centroid it is assigned to choose color
        Integer centroidNum = centroidAssignments.get(p);
        Color col = Color.BLACK;
        if (centroidNum == 0) {
          col = Color.ORANGE;
        } else if (centroidNum == 1) {
          col = Color.MAGENTA;
        } else {
          col = Color.BLUE;
        }

        int x = (int) Math.round(p.getX());
        int y = (int) Math.round(p.getY());
        plotter.addPoint(x, y, col);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter.write("clusterdata-3.png");
    } catch (IOException e) {
    }

  }


  /**
   * Reads clusterdata-4 from a file, and creates an image of it in the format clusterdata-4.png in
   * the current directory.
   */
  private static void clusterData4() {


    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(600);
    plotter.setHeight(400);
    plotter.setDimensions(0, 600, 0, 400);


    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/clusterdata-4.txt");
      HashMap<Point, Integer> centroidAssignments = testData.kmeans(4);

      // For each point in the data, add it to the image
      for (Point p : testData.getData()) {

        // Find the centroid it is assigned to choose color
        Integer centroidNum = centroidAssignments.get(p);
        Color col = Color.BLACK;
        if (centroidNum == 0) {
          col = Color.ORANGE;
        } else if (centroidNum == 1) {
          col = Color.MAGENTA;
        } else if (centroidNum == 2) {
          col = Color.CYAN;
        } else {
          col = Color.BLUE;
        }

        int x = (int) Math.round(p.getX());
        int y = (int) Math.round(p.getY());
        plotter.addPoint(x, y, col);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter.write("clusterdata-4.png");
    } catch (IOException e) {
    }

  }


  /**
   * Reads clusterdata-6 from a file, and creates an image of it in the format clusterdata-6.png in
   * the current directory.
   */
  private static void clusterData6() {


    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(600);
    plotter.setHeight(400);
    plotter.setDimensions(0, 600, 0, 400);


    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/clusterdata-6.txt");
      HashMap<Point, Integer> centroidAssignments = testData.kmeans(6);

      // For each point in the data, add it to the image
      for (Point p : testData.getData()) {

        // Find the centroid it is assigned to choose color
        Integer centroidNum = centroidAssignments.get(p);
        Color col;
        if (centroidNum == 0) {
          col = Color.ORANGE;
        } else if (centroidNum == 1) {
          col = Color.MAGENTA;
        } else if (centroidNum == 2) {
          col = Color.CYAN;
        } else if (centroidNum == 3) {
          col = Color.GREEN;
        } else if (centroidNum == 4) {
          col = Color.PINK;
        } else {
          col = Color.BLUE;
        }

        int x = (int) Math.round(p.getX());
        int y = (int) Math.round(p.getY());
        plotter.addPoint(x, y, col);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter.write("clusterdata-6.png");
    } catch (IOException e) {
    }

  }
}

