package expression;
import  java.util.Map;


/**
 * TODO Add javadoc
 */
public interface Expression {


  /**
   * @return TODO add javadoc
   */
  String infix();


  /** Input parameter contains values of variables found in the expression tree.
   * This method returns the value of the expression, computed with the given value
   * of variables.
   *
   * @param variableValues values of variables found in the expression tree
   * @return The value of the expression
   * @throws ArithmeticException If the expression cannot be evaluated
   */
  double evaluate(Map<String,Double> variableValues) throws ArithmeticException;


  /** Turns the Expression into a String in the format of functional programming language
   * Scheme. In Scheme, and expression starts with an operator and then the operands
   * in that order, and is surrounded by parentheses.
   *
   * e.g., 1 - 3 * 2 becomes (- 1 (* 3 2))
   *
   * @return The String representation in Scheme of this expression
   */
  String schemeExpression();


}
