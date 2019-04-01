package imageProcessing;

public class Flag extends ImageUtil implements IImage {
  private Pixel[][] data;
  private int height;
  private int width;
  private String country;

  public Flag(int width, String country) {
    this.width = width;
    this.country = country;

    // Flag proportions are different for Switzerland.
    if (this.country.equals("France") || this.country.equals("Greece")) { this.height = (int) (width*0.6); }
    else if (this.country.equals("Switzerland")) { this.height = width;}

    // Initialize array
    this.data = new Pixel[this.height][this.width];

    // Fill array with blank pixels
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        Pixel uninitPixel = new Pixel(0, 0, 255); //TODO Change this to white.
        this.data[j][i] = uninitPixel;
      }
    }

    if (this.country.equals("France")) { this.drawFrench();}
    else if (this.country.equals("Switzerland")) { this.drawSwiss();}
    else if (this.country.equals("Greece")) {this.drawGreek();}
  }




  private void drawFrench() {
    int stripeWidth = this.width/3;

    //draw blue stripe
    for (int x = 0; x < this.height; x++)
      for (int y = 0; y < stripeWidth; y++) {
              //System.out.println("Drawing red pixel at "+ x + ", " + y);
        Pixel newPixel = new Pixel(0, 35, 149);
        this.data[x][y] = newPixel;
      }
    //draw white stripe
    for (int x = 0; x < this.height; x++)
      for (int y = stripeWidth; y < stripeWidth*2; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
    //draw red stripe
    for (int x = 0; x < this.height; x++)
      for (int y = stripeWidth*2; y < stripeWidth*3; y++) {
        Pixel newPixel = new Pixel(237, 41, 57);
        this.data[x][y] = newPixel;
      }

  }

  private void drawGreek() {
    int stripeWidth = this.height/9;
//    System.out.println("stripeWidth = " + stripeWidth);
//    int lastStripe = this.height - (stripeWidth*6);
//    System.out.println("lastStripe = " + lastStripe);

    for (int x = 0; x < stripeWidth; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(13, 94, 175);
        this.data[x][y] = newPixel;
      }

    for (int x = stripeWidth; x < stripeWidth*2; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }

    for (int x = stripeWidth*2; x < stripeWidth*3; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(13, 94, 175);
        this.data[x][y] = newPixel;
      }

    for (int x = stripeWidth*3; x < stripeWidth*4; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }

    for (int x = stripeWidth*4; x < stripeWidth*5; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(13, 94, 175);
        this.data[x][y] = newPixel;
      }

    for (int x = stripeWidth*5; x < stripeWidth*6; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }

    for (int x = stripeWidth*6; x < stripeWidth*7; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(13, 94, 175);
        this.data[x][y] = newPixel;
      }

    for (int x = stripeWidth*7; x < stripeWidth*8; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }

    for (int x = stripeWidth*8; x < stripeWidth*9; x++)
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(13, 94, 175);
        this.data[x][y] = newPixel;
      }
    // draw blue corner square
    for (int x = 0; x < stripeWidth*5; x++ ) {
      for (int y = 0; y < stripeWidth*5; y++) {
        Pixel newPixel = new Pixel(13, 94, 175);
        this.data[x][y] = newPixel;
      }
    }
    // draw horizontal white cross
    for (int x = stripeWidth*2; x < stripeWidth*3; x++ ) {
      for (int y = 0; y < stripeWidth*5; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
    }
    //draw vertical white cross
    for (int x = 0; x < stripeWidth*5; x++ ) {
      for (int y = stripeWidth*2; y < stripeWidth*3; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
    }
  }

  private void drawSwiss() {
    int square = (int)(this.height*0.2);

    // Draw red background.
    for (int x = 0; x < this.height; x++) {
      for (int y = 0; y < this.width; y++) {
        Pixel newPixel = new Pixel(255, 0, 0);
        this.data[x][y] = newPixel;
      }
    }
    //Draw white cross horizontal
    for (int x = square*2; x < square*3; x++) {
      for (int y = square; y < square*4; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
    }

    //Draw white cross Vertical
    for (int x = square; x < square*4; x++) {
      for (int y = square*2; y < square*3; y++) {
        Pixel newPixel = new Pixel(255, 255, 255);
        this.data[x][y] = newPixel;
      }
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
