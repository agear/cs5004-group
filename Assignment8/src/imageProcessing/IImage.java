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


  /** Returns the data of this image, by converting a 2D array of Pixel objects
   * into a 3D array of int objects. The purpose of this method is to make the data readable
   * by the ImageUtil class, or any 'outsiders' who do not have Pixel objects.
   */
  int[][][] get3Ddata();
}
