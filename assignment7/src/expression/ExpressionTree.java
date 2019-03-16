package expression;

import java.util.Map;

/**
 * TODO add javadoc
 */
public class ExpressionTree implements Expression {


  /** Constructs an Expression tree. The input is in postfix form.
   *
   * @param input Postfix format of an expression
   * @throws IllegalArgumentException When the input is invalid
   */
  public ExpressionTree(String input) throws IllegalArgumentException{

  }


  /**
   * @return TODO add javadoc
   */
  @Override
  public String infix() {
    return null;
  }

  /**
   * Input parameter contains values of variables found in the expression tree. This method returns
   * the value of the expression, computed with the given value of variables.
   *
   * @param variableValues values of variables found in the expression tree
   * @return The value of the expression
   * @throws ArithmeticException If the expression cannot be evaluated
   */
  @Override
  public double evaluate(Map<String, Double> variableValues) throws ArithmeticException {
    return 0;
  }

  /**
   * Turns the Expression into a String in the format of functional programming language Scheme. In
   * Scheme, and expression starts with an operator and then the operands in that order, and is
   * surrounded by parentheses.
   *
   * e.g., 1 - 3 * 2 becomes (- 1 (* 3 2))
   *
   * @return The String representation in Scheme of this expression
   */
  @Override
  public String schemeExpression() {
    return null;
  }
}
