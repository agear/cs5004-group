package imageProcessing;

/**
 * This class represents a checkerboard image. It can create the checkerboard, and return
 * information about the object. It is a type of Image, which means it can have adjustments
 * applied to it.
 */
public class CheckerBoard extends ImageUtil implements IImage {
  public Pixel[][] data;
  private int height;
  private int width;
  private int squareSize;

  /**
   * Creates a Checkerboard based on a user-specified square size.
   * @param squareSize The width/height dimension of the square, in pixels
   */
  public CheckerBoard(int squareSize) {
    this.height = (squareSize * 8);
    this.width = (squareSize * 8);
    this.squareSize = squareSize;
    this.data = new Pixel[this.width][this.height];
    this.draw();
  }

  /**
   * Draws the checkerboard object - a helper method used by the constructor.
   */
  private void draw() {
    System.out.println("This.width " + this.width + " . divided by square size =  " + this.squareSize);
    int left = 0;
    int top = 0;


    // Initializes this.data by creating a pixel in each spot.
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        Pixel uninitPixel = new Pixel(0, 0, 255);
        this.data[j][i] = uninitPixel;
      }
    }

    // For each row,
    for (int horizontal = 0; horizontal < 8; horizontal++) {
      System.out.println("\n NEW ROW!!!");
      top = 0;

      // For each column,
      for (int vertical = 0; vertical < 4; vertical++) {
        System.out.println("Row = " + vertical + ", Column = " + horizontal);
        if (horizontal % 2 == 0) {
          drawWhiteSquare(left, top);
        } else {
          drawBlackSquare(left, top);
        }
        top += this.squareSize;
        if ((horizontal + 1) % 2 == 0) {
          drawWhiteSquare(left, top);
        } else {
          drawBlackSquare(left, top);
        }
        top += this.squareSize;
      }
      left += this.squareSize;
      System.out.println("NEW COLUMN " + left);
    }
  }


  /** Creates a white square object in this.data, - a helper method used by draw.
   * @param left The x-coordinate of the top left corner of the new square.
   * @param top The y-coordinate of the top left corner of the new square.
   */
  private void drawWhiteSquare(int left, int top) {
    System.out.println("White square at " + left + ", " + top);
    for (int x = left; x < left + this.squareSize; x++)
      for (int y = top; y < top + this.squareSize; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
  }

  /** Creates a black square object in this.data, - a helper method used by draw.
   * @param left The x-coordinate of the top left corner of the new square.
   * @param top The y-coordinate of the top left corner of the new square.
   */
  private void drawBlackSquare(int left, int top) {
    System.out.println("Black square at " + left + ", " + top);
    for (int x = left; x < left + this.squareSize; x++)
      for (int y = top; y < top + this.squareSize; y++) {
        Pixel newPixel = new Pixel(0, 0, 0);
        this.data[x][y] = newPixel;
      }
  }


  /** Returns the height, in Pixels, of this checkerboard image.
   * @return height in Pixels of image
   */
  public int getHeight() {
    int heightClone = this.height;
    return heightClone;
  }

  /** Returns the width, in Pixels, of this checkerboard image.
   * @return width in Pixels of image
   */
  public int getWidth() {
    int widthClone = this.width;
    return widthClone;
  }

  /** Returns the data of this checkerboard image, by converting a 2D array of Pixel objects
   * into a 3D array of int objects. The purpose of this method is to make the data readably
   * by the ImageUtil class, or any 'outsiders' who do not have Pixel objects.
   * @return A 3D array of values representing RGB values of this image
   */
  public int[][][] get3Ddata() {
    int[][][] output = new int[this.data.length][this.data[0].length][3];
    for (int i = 0; i < this.data.length; i++) {
      for (int j = 0; j < this.data[0].length; j++) {
        output[i][j][0] = this.data[i][j].getRed();
        output[i][j][1] = this.data[i][j].getGreen();
        output[i][j][2] = this.data[i][j].getBlue();
      }
    }
    return output;
  }

}
