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
  public CheckerBoard(int height, int width, int squareSize) {
    this.height = height;
    this.width = width;
    this.squareSize = squareSize;
    this.data = new Pixel[this.width][this.height];
    this.draw();
  }

  /**
   *
   */
  private void draw() {
    System.out.println("This.width " + this.width + " . divided by square size =  " + this.squareSize);
    int numHorizontal = this.width / this.squareSize;
    System.out.println("numHorozontal = " + numHorizontal);
    int numVertical = this.height / this.squareSize;
    int leftStart = 0;
    int topStart = 0;


    for (int i=0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        Pixel uninitPixel = new Pixel(255,255,0);
        this.data[j][i] = uninitPixel;
      }
    }



    for (int horizontal = 0; horizontal < numHorizontal; horizontal++) {
      System.out.println("\n NEW ROW!!!");
      topStart = 0;
      for (int vertical = 0; vertical < numVertical; vertical++) {
        drawWhiteSquare(this.squareSize, leftStart, topStart);
        System.out.println("After drawing white sq . topStart = " + topStart);
        topStart += this.squareSize;
        drawBlackSquare(this.squareSize, leftStart, topStart);
        System.out.println(" after draw black sq: topStart = " + topStart);
        topStart += this.squareSize;
        System.out.println("after topstart gets increased: topStart = " + topStart);
      }
      leftStart += this.squareSize;
    }
  }


  private void drawWhiteSquare(int size, int left, int top) {
    for (int x = left; x < size; x++)
      for (int y = top; y < size; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
  }

  private void drawBlackSquare(int size, int left, int top) {
    for (int x = left; x < size; x++)
      for (int y = top; y < size; y++) {
        Pixel newPixel = new Pixel(0, 0, 0);
        this.data[x][y] = newPixel;
      }
  }




  public int getHeight() {
    return 0;
  }

  public int getWidth() {
    return 0;
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
