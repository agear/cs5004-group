package expression;

/**
 * TODO Add javadoc
 */
public class Operator implements TreeNode  {
  private TreeNode left;
  private TreeNode right;
  private String data;

  public Operator(String input, TreeNode left, TreeNode right){
    this.data = input;
    this.left = left;
    this.right = right;
  }


  /** Does math within the class - simple arithmetic.
   * @param a first operand
   * @param b second operand
   * @return result of operand's calculation on two inputs
   * @throws ArithmeticException If operand isn't +/- etc
   */
  private double evaluate(double a, double b) throws ArithmeticException {

    if (this.data.equals("+")){
      return a + b;
    }

    else if (this.data.equals("-")){
      return a - b;
    }

    else if (this.data.equals("*")){
      return a * b;
    }

    else if (this.data.equals("/")){
      return a / b;
    }

    throw new ArithmeticException("Illegal operator detected.");

  }

  //TODO decide how to make this private probably
  public double solve(){
    double leftSolved = this.left.solve();
    double rightSolved = this.right.solve();
    return this.evaluate(leftSolved,rightSolved);

  }

}
