package expression;

/**
 * TODO add javadoc
 */
public interface TreeNode {

  /** Calculates the result of the current node. If it's an operator, then it has to solve
   * by using its own value to compute the children. If it's an operand, then it returns
   * itself as a double.
   *
   * @return result of evaluating current node arithmetically
   */
  double solve();


}
