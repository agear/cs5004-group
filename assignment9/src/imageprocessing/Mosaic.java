package imageprocessing;

import java.util.Random;


public class Mosaic implements Adjustment {


  /**
   * Applies this object onto an image input without mutating it, and outputs a new image object
   * with the adjustment.
   *
   * @param input Image to change
   * @return Altered cloned image
   */
  @Override
  public IImage apply(IImage input) {

    // If no seed number set, then do 1000 seeds
    return this.apply(input, 1000);

  }

  /**
   * Applies this object onto an image input without mutating it, and outputs a new image object
   * with the adjustment. Uses a specified number of seeds.
   *
   * @param input Image to change
   * @return Altered cloned image
   */
  public IImage apply(IImage input, int numSeeds) {

    // Choose a random set of points on the image, create a cluster for it
    for (int i = 0; i < numSeeds; i++) {



    }


    // Each pixel should be paired to the seed closest to it

    // The color of each pixel in the cluster is replaced with the average color

  }


}
