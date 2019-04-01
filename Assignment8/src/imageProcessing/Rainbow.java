package imageProcessing;

public class Rainbow extends ImageUtil implements IImage {
  public Pixel[][] data;
  private int height;
  private int width;
  private String orientation;

  /** Creates an image of the rainbow with user-specified dimension and orientation. Does not
   * write to a file, but can.
   *
   * @param height The height, in px, of the desired rainbow image
   * @param width The width, in px, of the desired rainbow image
   * @param orientation The desired direction of the rainbow's stripes
   * @throws IllegalArgumentException If the orientation is not vertical or horizontal
   */
  public Rainbow(int height, int width, String orientation) throws IllegalArgumentException {
    this.height = height;
    this.width = width;
    this.orientation = orientation;
    this.data = new Pixel[this.height + 1][this.width + 1];
    if (this.orientation.equals("Horizontal")) {
      System.out.println("Drawing horizontal");
      this.drawHorizontal();
    }
    else if (this.orientation.equals("Vertical")){
      System.out.println("Drawing vertical");
      this.drawVertical();
    }

    else {
      throw new IllegalArgumentException("Orientation must be Vertical or Horizontal.");
    }
  }

  private void drawHorizontal() {
    int stripeWidth = this.height/7;

   // System.out.println("Initializing....");

    //initialization
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        Pixel uninitPixel = new Pixel(0, 0, 255);
      //  System.out.println("Creating new pixel at " + i +", "+ j);
        this.data[j][i] = uninitPixel;
      }
    }
 //   System.out.println("Done!");

  //  System.out.println("Drawing red stripe");
    for (int x = 0; x < stripeWidth; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 0, 0);
        this.data[x][y] = newPixel;
      }
   // System.out.println("Drawing orange stripe");

    for (int x = stripeWidth; x < stripeWidth*2; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 165, 0);
        this.data[x][y] = newPixel;
      }

   // System.out.println("Drawing yellow stripe");

    for (int x = stripeWidth*2; x < stripeWidth*3; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 255, 0);
        this.data[x][y] = newPixel;
      }

  //  System.out.println("Drawing green stripe");

    for (int x = stripeWidth*3; x < stripeWidth*4; x++)
      for (int y = 0; y < this.width; y++) {
  //      System.out.println("Drawing green pixel at " + x + ", " + y);
        Pixel newPixel = new Pixel(0, 128, 0);
        this.data[x][y] = newPixel;
      }

  //  System.out.println("Drawing blue stripe");

    for (int x = stripeWidth*4; x < stripeWidth*5; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(0, 0, 255);
        this.data[x][y] = newPixel;
      }

  //  System.out.println("Drawing indigo stripe");

    for (int x = stripeWidth*5; x < stripeWidth*6; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(75, 0, 130);
        this.data[x][y] = newPixel;
      }

  //  System.out.println("Drawing violet stripe");

    for (int x = stripeWidth*6; x < stripeWidth*7; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(238, 130, 238);
        this.data[x][y] = newPixel;
      }
  }

  private void drawVertical() {
    int stripeWidth = this.width/7;

    //initialize
    for (int x = 0; x < this.height; x++) {
      for (int y = 0; y < this.width; y++) {
  //      System.out.println("Initializing pixel at "+ x + ", " + y);
        Pixel uninitPixel = new Pixel(0, 0, 255);
        this.data[x][y] = uninitPixel;
      }
    }
  //  System.out.println("Done initializing");

    for (int x = 0; x < this.height; x++)
      for (int y = 0; y < stripeWidth; y++) {
  //      System.out.println("Drawing red pixel at "+ x + ", " + y);
        Pixel newPixel = new Pixel(255, 0, 0);
        this.data[x][y] = newPixel;
      }

    for (int x = 0; x < this.height; x++)
      for (int y = stripeWidth; y < stripeWidth*2; y++) {
        Pixel newPixel = new Pixel(255, 165, 0);
        this.data[x][y] = newPixel;
      }

    for (int x = 0; x < this.height; x++)
      for (int y = stripeWidth*2; y < stripeWidth*3; y++) {
        Pixel newPixel = new Pixel(255, 255, 0);
        this.data[x][y] = newPixel;
      }

    for (int x = 0; x < this.height; x++)
      for (int y = stripeWidth*3; y < stripeWidth*4; y++) {
        Pixel newPixel = new Pixel(0, 128, 0);
        this.data[x][y] = newPixel;
      }

    for (int x = 0; x < this.height; x++)
      for (int y = stripeWidth*4; y < stripeWidth*5; y++) {
        Pixel newPixel = new Pixel(0, 0, 255);
        this.data[x][y] = newPixel;
      }

    for (int x = 0; x < this.height; x++)
      for (int y = stripeWidth*5; y < stripeWidth*6; y++) {
        Pixel newPixel = new Pixel(75, 0, 130);
        this.data[x][y] = newPixel;
      }

    for (int x = 0; x < this.height; x++)
      for (int y = stripeWidth*6; y < stripeWidth*7; y++) {
  //      System.out.println("Drawing violet pixel at "+ x + ", " + y);
        Pixel newPixel = new Pixel(238, 130, 238);
        this.data[x][y] = newPixel;
      }
  //  System.out.println("Done drawing");

  }


  public int getHeight() {
    int heightClone = this.height;
    return heightClone;
  }

  public int getWidth() {
    int widthClone = this.width;
    return widthClone;
  }

  public int[][][] get3Ddata() {
    int[][][] output = new int[this.data.length][this.data[0].length][3];
    for (int i = 0; i < this.data.length - 1; i++) {
      for (int j = 0; j < this.data[0].length - 1; j++) {
       // System.out.println("get3DData at " + i + ", " + j);
        output[i][j][0] = this.data[i][j].getRed();
        output[i][j][1] = this.data[i][j].getGreen();
        output[i][j][2] = this.data[i][j].getBlue();
      }
    }
    return output;
  }
}
