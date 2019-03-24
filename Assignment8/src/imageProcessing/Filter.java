package imageProcessing;

public class Filter {

  double kernel[][];


  public Filter(double kernel[][]){
    this.kernel = kernel;
  }

  public double[][] getData() {
    return this.kernel.clone();
  }

}
