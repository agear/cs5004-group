package expression;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


/**
 * TODO add javadoc
 */
public class ExpressionTree implements Expression {

  // TODO make sure the fact that this is private doesnt fuck anything up
  private TreeNode rootNode;

  /**
   * There are four valid binary operators for this assignment, + - / *. This returns true if the
   * input is one of those, false otherwise.
   *
   * @param input the questionable operator
   * @return true if valid, false otherwise
   */
  private boolean isOperator(String input) {
    // TODO Can this be converted to: "return (input.equals("+") || input.equals("/") ||
    //            input.equals("*") || input.equals("-")"?
    if (input.equals("+") || input.equals("/") ||
            input.equals("*") || input.equals("-")) {
      return true;
    }
    return false;
  }


  /**
   * Constructs an Expression tree. The input is in postfix form.
   *
   * @param input Postfix format of an expression
   * @throws IllegalArgumentException When the input is invalid
   */
  public ExpressionTree(String input) throws IllegalArgumentException {

    // Initialize scanner object of input
    Scanner tokenList = new Scanner(input);


    // Initialize stack of data and useful variables for stack manipulation
    // Since the "data" field of all nodes is a string, that's why we're using strings here
    Stack<String> stackOfTokens = new Stack<>();
    String left;
    String right;

    // This has to be initialized or else an error is made
    // TODO should we have a dummy "uninitialized" rootNode? smth to think about....
    TreeNode rootNode = new Operand("Test");


    // While the scanner has more in it,
    while (tokenList.hasNext()) {
      String token = tokenList.next();

      // If it is an operand, push it onto the stack
      if (!isOperator(token)) {

        stackOfTokens.push(token);

      }

      // If it is an operator, create the node
      else {

        // Pops the two top-most operands which will be the children of the current operator.
        // Throw an error if those two operands never existed
        if (stackOfTokens.empty()) {
          throw new IllegalArgumentException("Failure: Not enough operands.");
        }
        right = stackOfTokens.pop();
        if (stackOfTokens.empty()) {
          throw new IllegalArgumentException("Failure: Not enough operands.");
        }
        left = stackOfTokens.pop();

        // Create the node using the items from the stack
        TreeNode rightNode = new Operand(right);
        TreeNode leftNode = new Operand(left);
        TreeNode newNode = new Operator(token, leftNode, rightNode);

        // TODO this is where I stopped....
        // TODO  I think the root node will end up being the very last thing on the stack
        // TODO but havent thought about how that will work in implementation (basically translating
        // TODO last assignment where last thing on stack was a double to be returned)
        rootNode = newNode;
        // TODO so that line ^ works for just one operator (e.g., "1 2 +")


      }


    }

    // TODO  I think the root node will end up being the very last thing on the stack
    this.rootNode = rootNode;


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
    return this.rootNode.solve();
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
