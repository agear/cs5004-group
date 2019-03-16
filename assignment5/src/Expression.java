public interface Expression {

  /**
   * Evaluates and returns the result of an expression. It will throw an ArithmeticException
   * if the expression cannot be evaluated (e.g. if its operands are algebraic letters).
   *
   * @return a double representing the result of evaluating a expression.
   */
  double evaluate() throws ArithmeticException;

  /**
   * Returns a string representation of the expression. Each operand and operator isseparated by a
   * single space, with no leading or trailing spaces.
   *
   * @return a string representation of the expression.
   */
  String toString();
}
