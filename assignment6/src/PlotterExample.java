/**
 * Created by ashesh on 2/19/2017.
 */

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by ashesh on 2/16/2017.
 */
public class PlotterExample {
// TODO 5. Use the provided ImagePlotter.java to plot your results! Look at the provided
//  PlotterExample.java to see an example of how to use the ImagePlotter class.
//  You can visualize the clusters by giving all points in a cluster the same color.


  public static void main(String[] args) {

    // I've commented them all out to save time when calculating
    //clusterData2();
    //clusterData3();
    //clusterData4();
    clusterData6();




  }

  private static void clusterData2(){


    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(600);
    plotter.setHeight(600);
    plotter.setDimensions(-100, 500, -420, 180);


    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/clusterdata-2.txt");
      HashMap<Point,Integer> centroidAssignments;
      centroidAssignments = testData.kmeans(2);

      // For each point in the data, add it to the image
      for (Point p : testData.getData() ){

        Integer centroidNum = centroidAssignments.get(p);
        Color col;
        if (centroidNum == 0){
          col = Color.RED;
        }
        else {
          col = Color.GREEN;
        }

        int x = (int)Math.round(p.getX());
        int y = (int)Math.round(p.getY());
        plotter.addPoint(x,y,col);

      }

    }
    catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter.write("clusterdata-2.png");
    } catch (IOException e) { }

  }

  /**
   * Reads clusterdata-3 from a file, and creates an image of it
   * in the format clusterdata-3.png.
   */
  private static void clusterData3(){


    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(600);
    plotter.setHeight(400);
    plotter.setDimensions(0, 600, 0, 400);


    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/clusterdata-3.txt");
      HashMap<Point,Integer> centroidAssignments = testData.kmeans(3);

      // For each point in the data, add it to the image
      for (Point p : testData.getData() ){

        // Find the centroid it is assigned to choose color
        Integer centroidNum = centroidAssignments.get(p);
        Color col = Color.BLACK;
        if (centroidNum == 0){
          col = Color.ORANGE;
        }
        else if (centroidNum == 1){
          col = Color.MAGENTA;
        }
        else {
          col = Color.BLUE;
        }

        int x = (int)Math.round(p.getX());
        int y = (int)Math.round(p.getY());
        plotter.addPoint(x,y,col);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter.write("clusterdata-3.png");
    } catch (IOException e) { }

  }


  /**
   * Reads clusterdata-4 from a file, and creates an image of it
   * in the format clusterdata-4.png in the current directory.
   */
  private static void clusterData4(){


    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(600);
    plotter.setHeight(400);
    plotter.setDimensions(0, 600, 0, 400);


    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/clusterdata-4.txt");
      HashMap<Point,Integer> centroidAssignments = testData.kmeans(4);

      // For each point in the data, add it to the image
      for (Point p : testData.getData() ){

        // Find the centroid it is assigned to choose color
        Integer centroidNum = centroidAssignments.get(p);
        Color col = Color.BLACK;
        if (centroidNum == 0){
          col = Color.ORANGE;
        }
        else if (centroidNum == 1){
          col = Color.MAGENTA;
        }
        else if (centroidNum == 2){
          col = Color.CYAN;
        }
        else {
          col = Color.BLUE;
        }

        int x = (int)Math.round(p.getX());
        int y = (int)Math.round(p.getY());
        plotter.addPoint(x,y,col);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter.write("clusterdata-4.png");
    } catch (IOException e) { }

  }



  /**
   * Reads clusterdata-6 from a file, and creates an image of it
   * in the format clusterdata-6.png in the current directory.
   */
  private static void clusterData6(){


    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(600);
    plotter.setHeight(400);
    plotter.setDimensions(0, 600, 0, 400);


    try {

      // Gets data from file and initializes data variable with it
      Data testData = new Data("./data/clusterdata-6.txt");
      HashMap<Point,Integer> centroidAssignments = testData.kmeans(6);

      // For each point in the data, add it to the image
      for (Point p : testData.getData() ){

        // Find the centroid it is assigned to choose color
        Integer centroidNum = centroidAssignments.get(p);
        Color col;
        if (centroidNum == 0){
          col = Color.ORANGE;
        }
        else if (centroidNum == 1){
          col = Color.MAGENTA;
        }
        else if (centroidNum == 2){
          col = Color.CYAN;
        }
        else if (centroidNum == 3){
          col = Color.GREEN;
        }
        else if (centroidNum == 4) {
          col = Color.PINK;
        }
        else {
          col = Color.BLUE;
        }

        int x = (int)Math.round(p.getX());
        int y = (int)Math.round(p.getY());
        plotter.addPoint(x,y,col);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    try {
      plotter.write("clusterdata-6.png");
    } catch (IOException e) { }

  }
}

