package imageprocessing.model.Image;

/**
 * This class represents a pixel. A Pixel has red, green and blue values which can take integer
 * values between 0 and 255.
 */
public class Pixel {

  private int red;
  private int green;
  private int blue;
  final int MIN = 0;
  final int MAX = 255;

  /**
   * Constructs a pixel object. Takes three integers between 0 and 255 to represent it's red, green,
   * and blue values. Values less than 0 will be "clamped" to 0 and values greater than 255 will be
   * "clamped" to 255.
   *
   * @param red   Integer value between 0 and 255.
   * @param green Integer value between 0 and 255.
   * @param blue  Integer value between 0 and 255.
   */
  public Pixel(int red, int green, int blue) {


    this.red = red;
    this.green = green;
    this.blue = blue;

    //Clamp values between 0 and 255.
    if (red < MIN) {
      this.red = MIN;
    }
    if (blue < MIN) {
      this.blue = MIN;
    }
    if (green < MIN) {
      this.green = MIN;
    }
    if (red > MAX) {
      this.red = MAX;
    }
    if (blue > MAX) {
      this.blue = MAX;
    }
    if (green > MAX) {
      this.green = MAX;
    }

  }

  /**
   * Method to get this pixels red value.
   *
   * @return An int representing this pixel's red value.
   */
  public int getRed() {
    // Return a copy.
    int redCopy = this.red;
    return redCopy;
  }

  /**
   * Method to get this pixels green value.
   *
   * @return An int representing this pixel's green value.
   */
  public int getGreen() {
    // Return a copy.
    int greenCopy = this.green;
    return greenCopy;
  }

  /**
   * Method to get this pixels blue value.
   *
   * @return An int representing this pixel's blue value.
   */
  public int getBlue() {
    // Return a copy.
    int blueCopy = this.blue;
    return blueCopy;
  }

  /**
   * Returns the red value of this pixel, scaled by a coefficient.
   *
   * @param coefficient To scale the red value of this pixel by.
   * @return A double representing the red value of this pixel, scaled by a coefficient.
   */
  public double vectorRed(double coefficient) {
    return this.red * coefficient;
  }

  /**
   * Returns the blue value of this pixel, scaled by a coefficient.
   *
   * @param coefficient To scale the blue value of this pixel by.
   * @return A double representing the blue value of this pixel, scaled by a coefficient.
   */
  public double vectorBlue(double coefficient) {
    return this.blue * coefficient;
  }

  /**
   * Returns the green value of this pixel, scaled by a coefficient.
   *
   * @param coefficient To scale the green value of this pixel by.
   * @return A double representing the green value of this pixel, scaled by a coefficient.
   */
  public double vectorGreen(double coefficient) {
    return this.green * coefficient;
  }

  /**
   * Returns the red, green and blue values as a string, formatted: "[R: red, G: green, B: blue]".
   *
   * @return A string in the format: "[R: red, G: green, B: blue]".
   */
  public String toString() {
    String output = "[R:" + this.red + " G:" + this.green + " B:" + this.blue + "]";
    return output;
  }

  /**
   * Adds a number to every channel equally, changing the data.
   *
   * @return A string in the format: "[R: red, G: green, B: blue]".
   */
  public void add(double amount) {
    this.red += amount;
    this.blue += amount;
    this.green += amount;
  }



  //TODO never used?
    /**
     * Adds a number to the channel, changing the data.
     *
     * @return A string in the format: "[R: red, G: green, B: blue]".
     */
  public void addChannelSpecific(String channel, double amount) throws IllegalArgumentException {


    if (channel.equals("red")) {
      this.red += amount;

      if (this.red > 255 ) {
        this.red = 255;
      }

    }

    else if (channel.equals("green")) {
      this.green += amount;

      if (this.green > 255 ) {
        this.green = 255;
      }

    }

    else if (channel.equals("blue")) {
      this.blue += amount;

      if (this.blue > 255 ) {
        this.blue = 255;
      }

    }

    else {
      throw new IllegalArgumentException("Channel name not found, can not change color.");
    }

  }




}
