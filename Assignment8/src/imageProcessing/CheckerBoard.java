package imageProcessing;

/**
 *
 */
public class CheckerBoard implements IImage {
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
    this.draw();
  }

  /**
   *
   */
  private void draw() {
    int numHorizontal = this.width / this.squareSize;
    int numVertical = this.height / this.squareSize;
    int leftStart = 0;
    int topStart = 0;

    for (int horizontal = 0; horizontal < numHorizontal; horizontal++) {
      for (int vertical = 0; vertical < numVertical; vertical++) {
        drawWhiteSquare(this.squareSize, leftStart, topStart);
        topStart += this.squareSize;
        drawBlackSquare(this.squareSize, leftStart, topStart);
        topStart += this.squareSize;
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
}
