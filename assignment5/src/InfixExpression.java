import java.util.LinkedList;
import java.util.Scanner;

public class InfixExpression implements Expression {

  private String expression;
  private LinkedList deque;

  /**
   * Constructor that takes a infix expression as a string as its only parameter. The string has
   * operands and operators separated by spaces, with no leading or trailing spaces. It will throw
   * an IllegalArgumentException if the provided expression is invalid.
   */
  public InfixExpression(String expression) throws IllegalArgumentException {
    //TODO write this constructor.
    this.expression = expression;
    try {
      this.toPostfix();
      System.out.println("passed to postfix");
    }
    catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid Input");
    }
  }


  /**
   * Converts this expression to a postfix expression and returns it.
   *
   * @return a postfix expresion representation of this expression.
   */
  PostfixExpression toPostfix() {
    String postfixExpression = "";
    LinkedList stack = new LinkedList();

    // Scan the expression from left to right, one token at a time.
    Scanner s = new Scanner(this.expression);
    // If there are more tokens to read, read the next token, else go to step 8.
    while (s.hasNext()) {
      String token = s.next();

      // If the token is an operand, append to the result string.
      if (!("()+-/*".contains(token))) {
        postfixExpression = postfixExpression + token + " ";
        //System.out.println(postfixExpression);
      }
      // 6. If the token is an operator or parenthesis.
      else if ("(".contains(token)) {
        stack.push(token);
        //System.out.println("pushing " + token);
      }
      else if (")".contains(token)) {
        String topOfStack = (String) stack.peek();
        while ((stack.size() > 0) && (!(topOfStack.equals("(")))) {
          postfixExpression = postfixExpression + stack.pop() + " ";
          //System.out.println("Current: " + postfixExpression);
          topOfStack = (String) stack.peek();
          //System.out.println("top of stack:" + topOfStack);
        }
        //System.out.println("Discarding: " + stack.peek());
        stack.pop();
      } else if ("+-*/".contains(token)) {
        String topOfStack = (String) stack.peek();
        while ((stack.size() > 0) && (precedence(token) <= precedence(topOfStack))) {
          postfixExpression = postfixExpression + stack.pop() + " ";
        }
        // 6a. If the stack is empty, push it to the stack and go to step 3.
        stack.push(token);
      }
    }
    // If the stack is not empty, keep popping operators from it and appending to result string.
    while (stack.size() > 0) {
      postfixExpression = postfixExpression + stack.pop() + " ";
    }
    // 9. Return the result string as the answer.
    //System.out.println("Final postfix: " + postfixExpression);
    postfixExpression = postfixExpression.trim();
    PostfixExpression converted = new PostfixExpression(postfixExpression);
    return converted;
  }

  /**
   * Returns an integer corresponding to the precedence of the operator given to it. A greater
   * integer means a higher precedence.
   */
  private int precedence(String operator) {
    if ("*".contains(operator) || "/".contains(operator)) {
      return 3;
    } else if ("+".contains(operator) || "-".contains(operator)) {
      return 2;
    } else if ("(".contains(operator)) {
      return 1;
    } else {
      return 0;
    }
  }

  /**
   * Evaluates and returns the result of an infix expression. It will throw an ArithmeticException
   * if the expression cannot be evaluated (e.g. if its operands are algebraic letters).
   *
   * @return a double representing the result of evaluating an infix expression.
   */
  public double evaluate() throws ArithmeticException {
    PostfixExpression convert = this.toPostfix();
    return convert.evaluate();
  }

  /**
   * Returns a string representation of the expression. Each operand and operator is separated by a
   * single space, with no leading or trailing spaces.
   *
   * @return a string representation of the expression.
   */
  public String toString() {
    return this.expression;
  }
}
