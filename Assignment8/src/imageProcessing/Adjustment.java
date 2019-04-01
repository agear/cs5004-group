package imageProcessing;

/**
 * This class represents an object that can morph an image, such as blurring, sharpening,
 * or greyscaling. Adjustments fall into two categories, filtering (which changes all color
 * channels equally), and transforming (which acts differently on different color channels).
 */
public interface Adjustment {


  /** Applies this object onto an image input without mutating it, and outputs a new
   * image object with the adjustment.
   * @param input
   * @return
   */
  Image apply(Image input);


}
