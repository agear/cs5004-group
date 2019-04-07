package imageprocessing;

import java.io.IOException;

/**
 * This class creates and represents a Rainbow image object, with 7 colored stripes.
 */
public class Rainbow extends ImageUtil implements IImage {
  private Pixel[][] data;
  private int height;
  private int width;

  /** Creates an image of the rainbow with user-specified dimension and orientation. Does not
   * write to a file, but can.
   *
   * @param height The height, in px, of the desired rainbow image
   * @param width The width, in px, of the desired rainbow image
   * @param orientation The desired direction of the rainbow's stripes
   */
  public Rainbow(int height, int width, Orientation orientation) {
    this.height = height;
    this.width = width;
    Orientation thisOrientation = orientation;
    this.data = new Pixel[this.height][this.width];

    //Initialize canvas.
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        Pixel uninitPixel = new Pixel(0, 0, 255);
        this.data[j][i] = uninitPixel;
      }
    }

    if (thisOrientation.equals(Orientation.HORIZONTAL)) {
      this.drawHorizontal();
    }
    else if (thisOrientation.equals(Orientation.VERTICAL)) {
      this.drawVertical();
    }

  }

  /**
   * Creates a horizontal rainbow object.
   */
  private void drawHorizontal() {
    double height = (double)this.height;
    int stripeWidth = (int)Math.ceil(height / 7.0);
    int lastStripe = this.height - (stripeWidth * 6);

    //Red Stripe
    for (int x = 0; x < stripeWidth; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 0, 0);
        this.data[x][y] = newPixel;
      }
    }
    //Orange Stripe
    for (int x = stripeWidth; x < stripeWidth * 2; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 165, 0);
        this.data[x][y] = newPixel;
      }
    }

    //Yellow Stripe
    for (int x = stripeWidth * 2; x < stripeWidth * 3; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 255, 0);
        this.data[x][y] = newPixel;
      }
    }

    //Green Stripe
    for (int x = stripeWidth * 3; x < stripeWidth * 4; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(0, 128, 0);
        this.data[x][y] = newPixel;
      }
    }

    //Blue Stripe
    for (int x = stripeWidth * 4; x < stripeWidth * 5; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(0, 0, 255);
        this.data[x][y] = newPixel;
      }
    }

    //Indigo Stripe
    for (int x = stripeWidth * 5; x < stripeWidth * 6; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(75, 0, 130);
        this.data[x][y] = newPixel;
      }
    }
    //Violet Stripe
    for (int x = stripeWidth * 6; x < stripeWidth * 6 + lastStripe; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(238, 130, 238);
        this.data[x][y] = newPixel;
      }
    }
  }

  /**
   * Creates a vertically-striped rainbow image object.
   */
  private void drawVertical() {
    double width = (double)this.width;
    int stripeWidth = (int)Math.ceil(width / 7.0);
    int lastStripe = this.width - (stripeWidth * 6);

    //Red Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = 0; y < stripeWidth; y++) {
        Pixel newPixel = new Pixel(255, 0, 0);
        this.data[x][y] = newPixel;
      }
    }
    //Orange Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = stripeWidth; y < stripeWidth * 2; y++) {
        Pixel newPixel = new Pixel(255, 165, 0);
        this.data[x][y] = newPixel;
      }
    }

    //Yellow Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = stripeWidth * 2; y < stripeWidth * 3; y++) {
        Pixel newPixel = new Pixel(255, 255, 0);
        this.data[x][y] = newPixel;
      }
    }

    //Green Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = stripeWidth * 3; y < stripeWidth * 4; y++) {
        Pixel newPixel = new Pixel(0, 128, 0);
        this.data[x][y] = newPixel;
      }
    }

    //Blue Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = stripeWidth * 4; y < stripeWidth * 5; y++) {
        Pixel newPixel = new Pixel(0, 0, 255);
        this.data[x][y] = newPixel;
      }
    }

    //Indigo Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = stripeWidth * 5; y < stripeWidth * 6; y++) {
        Pixel newPixel = new Pixel(75, 0, 130);
        this.data[x][y] = newPixel;
      }
    }

    //Violet Stripe
    for (int x = 0; x < this.height; x++) {
      for (int y = stripeWidth * 6; y < stripeWidth * 6 + lastStripe; y++) {
        Pixel newPixel = new Pixel(238, 130, 238);
        this.data[x][y] = newPixel;
      }
    }
  }

  /**
   * Returns the height in pixels of this rainbow image object.
   * @return the height in pixels of this rainbow image object
   */
  public int getHeight() {
    int heightClone = this.height;
    return heightClone;
  }

  /**
   * Returns the width in pixels of this rainbow image object.
   * @return the width in pixels of this rainbow image object
   */
  public int getWidth() {
    int widthClone = this.width;
    return widthClone;
  }

  /** Returns the data of this Flag image, by converting a 2D array of Pixel objects
   * into a 3D array of int objects. The purpose of this method is to make the data readable
   * by the ImageUtil class, or any 'outsiders' who do not have Pixel objects.
   * @return A 3D array of values representing RGB values of this image
   */
  public int[][][] get3Ddata() {
    int[][][] output = new int[this.data.length][this.data[0].length][3];
    for (int i = 0; i < this.data.length - 1; i++) {
      for (int j = 0; j < this.data[0].length - 1; j++) {
        output[i][j][0] = this.data[i][j].getRed();
        output[i][j][1] = this.data[i][j].getGreen();
        output[i][j][2] = this.data[i][j].getBlue();
      }
    }
    return output;
  }


  public Pixel[][] getData() {
    return this.data.clone();
  }

  /** Writes the image to a file.
   * @param filename The desired file path.
   * @throws IOException If there is an error creating a file with that path name.
   */
  public void writeToFile(String filename) throws IOException {
    this.writeImage(this.get3Ddata(), this.getWidth(), this.getHeight(), filename);
  }

}

