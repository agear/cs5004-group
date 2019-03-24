package imageProcessing;

public class Pixel {

  private int red;
  private int green;
  private int blue;

  public Pixel(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
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

  public double vectorRed(double coefficient) {
    return this.red * coefficient;
  }

  public double vectorBlue(double coefficient) {
    return this.blue * coefficient;
  }

  public double vectorGreen(double coefficient) {
    return this.green * coefficient;
  }

  public String toString() {
    String output = "[R:" + this.red + " G:" + this.green + " B:" + this.blue + "]";
    return output;
  }

}
