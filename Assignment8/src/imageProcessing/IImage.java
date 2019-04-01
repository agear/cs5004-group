package imageProcessing;

public interface IImage {

  /** Returns the height, in pixels, of the flag.
   * @return the height, in pixels, of the flag
   */
  int getHeight();


  /** Returns the width, in pixels, of the flag.
   * @return the width, in pixels, of the flag
   */
  int getWidth();

  /**
   * TODO Write javadoc.
   * @return
   */
  int[][][] get3Ddata();
}
