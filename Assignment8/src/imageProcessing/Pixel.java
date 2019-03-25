package imageProcessing;

/**
 * TODO Javadoc.
 */
public class Pixel {

  int red;
  int green;
  int blue;
  int min = 0;
  int max = 255;

  /**
   * TODO Javadoc.
   * @param red
   * @param green
   * @param blue
   */
  public Pixel(int red, int green, int blue) {


    this.red = red;
    this.green = green;
    this.blue = blue;

    if (red < min) {
      this.red = min;
    }
    if (blue < min) {
      this.blue = min;
    }
    if (green < min) {
      this.green = min;
    }
    if (red > max) {
      this.red = max;
    }
    if (blue > max) {
      this.blue = max;
    }
    if (green > max) {
      this.green = max;
    }

  }


//  public void filterRed(double coefficient) {
//    this.red = (int) (this.red * coefficient);
//  }
//
//  public void filterGreen(double coefficient) {
//    this.green = (int) (this.green * coefficient);
//  }
//
//  public void filterBlue(double coefficient) {
//    this.blue = (int) (this.blue * coefficient);
//  }
//
//  public void filterAll(double coefficient) {
//    this.red = (int) (this.red * coefficient);
//    this.blue = (int) (this.blue * coefficient);
//    this.blue = (int) (this.blue * coefficient);
//  }

  /**
   * TODO Javadoc.
   * @param coefficient
   * @return
   */
  public double vectorRed(double coefficient) {
    return this.red * coefficient;
  }

  /**
   * TODO Javadoc.
   * @param coefficient
   * @return
   */
  public double vectorBlue(double coefficient) {
    return this.blue * coefficient;
  }

  /**
   * TODO Javadoc.
   * @param coefficient
   * @return
   */
  public double vectorGreen(double coefficient) {
    return this.green * coefficient;
  }

  /**
   * TODO Javadoc.
   * @return
   */
  public String toString() {
    String output = "[R:" + this.red + " G:" + this.green + " B:" + this.blue + "]";
    return output;
  }

}
