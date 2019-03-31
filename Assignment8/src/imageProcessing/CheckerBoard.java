package imageProcessing;

/**
 *
 */
public class CheckerBoard extends ImageUtil implements IImage {
  public Pixel[][] data;
  private int height;
  private int width;
  private int squareSize;

  /**
   * Constructor
   */
  public CheckerBoard(int squareSize) {
    this.height = (squareSize * 8);
    this.width = (squareSize * 8);
    this.squareSize = squareSize;
    this.data = new Pixel[this.width][this.height];
    this.draw();
  }

  /**
   *
   */
  private void draw() {
    System.out.println("This.width " + this.width + " . divided by square size =  " + this.squareSize);
    int left = 0;
    int top = 0;


    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        Pixel uninitPixel = new Pixel(0, 0, 255);
        this.data[j][i] = uninitPixel;
      }
    }

    for (int horizontal = 0; horizontal < 8; horizontal++) {
      System.out.println("\n NEW ROW!!!");
      top = 0;
      //left = 0;
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


  private void drawWhiteSquare(int left, int top) {
    System.out.println("White square at " + left + ", " + top);
    for (int x = left; x < left + this.squareSize; x++)
      for (int y = top; y < top + this.squareSize; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
  }

  private void drawBlackSquare(int left, int top) {
    System.out.println("Black square at " + left + ", " + top);
    for (int x = left; x < left + this.squareSize; x++)
      for (int y = top; y < top + this.squareSize; y++) {
        Pixel newPixel = new Pixel(0, 0, 0);
        this.data[x][y] = newPixel;
      }
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
