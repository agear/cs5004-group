package expression;

/**
 * TODO Add javadoc
 */
public class Operand implements TreeNode {
  private String data;

  /** Creates an Operand node.
   * @param operand
   */
  protected Operand(String operand){
    this.data = operand;
  }

  @Override
  public double solve() throws NumberFormatException{
    //TODO capture value from map eventually. for now we can just use literals (? real numbers)
    return Double.valueOf(this.data);

  }

  public String getData() { return this.data; }

}
